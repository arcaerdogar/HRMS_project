package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.Validation.ValidationTool;
import hrms.hrms.business.abstracts.JobSeekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.error.ErrorResult;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.entities.concretes.JobSeeker;
import hrms.hrms.mernis.FakeMernisService;

@Component
public class JobSeekerManager implements JobSeekerService{
	
	JobSeekerDao jobSeekerDao;
	ValidationTool validationTool;
	JobSeekerVerificationManager jobSeekerVerificationManager;

	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,ValidationTool validationTool,JobSeekerVerificationManager jobSeekerVerificationManager) {
		this.jobSeekerDao = jobSeekerDao;
		this.validationTool=validationTool;
		this.jobSeekerVerificationManager=jobSeekerVerificationManager;
	}
	
	

	@Override
	public Result register(JobSeeker jobSeeker) {
		jobSeeker.deActivate();
		jobSeeker.getVerification().setEmailVerification(false);
		jobSeeker.getVerification().setMernisVerification(false);
		String mernisMsg="Mernis verification failed.";
		if(!ValidationTool.validateJobSeeker(jobSeeker)) {
			return new ErrorResult("All fields are required.");
		}
		if(validationTool.checkIfEmailExist(jobSeeker.getEmail())) {
			return new ErrorResult("Email already exist.");
		}
		if(validationTool.checkIfNationalIdExist(jobSeeker.getNationalId())) {
			return new ErrorResult("Nationality Id already exist.");
		}
		if(jobSeekerVerificationManager.verify(jobSeeker).isSuccess()) {
			jobSeeker.getVerification().setMernisVerification(true);
			mernisMsg="Mernis verification success.";
		}
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Job Seeker added."+mernisMsg+"Please confirm your email");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"Data Listed.");
	}

	

	@Override
	public Result activate(int id) {
		JobSeeker jobSeekerToActivate=jobSeekerDao.getOne(id);
		jobSeekerToActivate.activate();
		jobSeekerDao.deleteById(id);
		jobSeekerDao.save(jobSeekerToActivate);
		return new SuccessResult("JobSeeker activated");
	}



	@Override
	public Result confirmEmail(JobSeeker jobSeeker) {
		jobSeekerDao.delete(jobSeeker);
		jobSeeker.getVerification().setEmailVerification(true);
		if(jobSeeker.getVerification().isMernisVerification()) {
			jobSeeker.activate();
		}
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Email confirmed.");
	}



	@Override
	public Result verifyWithMernis(JobSeeker jobSeeker) {
		if(FakeMernisService.validate(jobSeeker.getEmail())) {
			jobSeekerDao.delete(jobSeeker);
			jobSeeker.getVerification().setMernisVerification(true);;
			if(jobSeeker.getVerification().isEmailVerification()) {
				jobSeeker.activate();
			}
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("User verified successly");
		}
		return new ErrorResult("User verify failed");
	}
	
}
