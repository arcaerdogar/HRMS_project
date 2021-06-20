package hrms.hrms.business.concretes.userManagers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.Validation.ValidationTool;
import hrms.hrms.business.abstracts.userServices.JobSeekerService;
import hrms.hrms.business.abstracts.verificationServices.JobSeekerVerificationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.error.ErrorResult;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.users.JobSeeker;
import hrms.hrms.services.cloudinary.CloudinaryService;
import hrms.hrms.services.mernis.FakeMernisService;

@Component
public class JobSeekerManager implements JobSeekerService{
	
	JobSeekerDao jobSeekerDao;
	ValidationTool validationTool;
	JobSeekerVerificationService jobSeekerVerificationService;

	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,ValidationTool validationTool,JobSeekerVerificationService jobSeekerVerificationService) {
		this.jobSeekerDao = jobSeekerDao;
		this.validationTool=validationTool;
		this.jobSeekerVerificationService=jobSeekerVerificationService;
	}
	
	

	@Override
	public Result register(JobSeeker jobSeeker) {
		jobSeeker.deActivate();
		jobSeeker.getVerification().setEmailVerification(false);
		jobSeeker.getVerification().setMernisVerification(false);
		if(jobSeeker.getProfilePhotoUrl()==null) {
			jobSeeker.setProfilePhotoUrl("defaultpp.jpg");
		}
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
		if(jobSeekerVerificationService.verify(jobSeeker).isSuccess()) {
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
		jobSeekerDao.save(jobSeekerToActivate);
		return new SuccessResult("JobSeeker activated");
	}



	@Override
	public Result confirmEmail(int jobSeekerId) {
		JobSeeker jobSeeker=jobSeekerDao.getOne(jobSeekerId);
		jobSeeker.getVerification().setEmailVerification(true);
		if(jobSeeker.getVerification().isMernisVerification()) {
			jobSeeker.activate();
		}
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Email confirmed.");
	}



	@Override
	public Result verifyWithMernis(int jobSeekerId) {
		JobSeeker jobSeeker=jobSeekerDao.getOne(jobSeekerId);
		if(FakeMernisService.validate(jobSeeker.getEmail())) {
			jobSeeker.getVerification().setMernisVerification(true);;
			if(jobSeeker.getVerification().isEmailVerification()) {
				jobSeeker.activate();
			}
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("User verified successly");
		}
		return new ErrorResult("User verify failed");
	}



	@Override
	public DataResult<List<JobSeekerCV>> getCvsByJobSeekerId(int id) {
		return new SuccessDataResult<List<JobSeekerCV>>(jobSeekerDao.getOne(id).getCv(),"Data Listed.");
	}

	@Override
	public Result changeProfilePhoto(String Url, int jobSeekerId) throws IOException {
		JobSeeker jobSeeker=jobSeekerDao.getOne(jobSeekerId);
		jobSeeker.setProfilePhotoUrl(CloudinaryService.uploadImage(Url));
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Profile photo changed.");
	}

}
