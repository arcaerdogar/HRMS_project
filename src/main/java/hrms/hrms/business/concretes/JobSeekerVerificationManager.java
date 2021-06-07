package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.JobSeekerVerificationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.error.ErrorResult;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerVerificationDao;
import hrms.hrms.entities.concretes.JobSeeker;
import hrms.hrms.entities.concretes.verifications.JobSeekerVerification;
import hrms.hrms.mernis.FakeMernisService;

@Component
public class JobSeekerVerificationManager implements JobSeekerVerificationService{

	JobSeekerVerificationDao jobSeekerVerificationDao;
	
	@Autowired
	public JobSeekerVerificationManager(JobSeekerVerificationDao jobSeekerVerificationDao) {
		this.jobSeekerVerificationDao = jobSeekerVerificationDao;
	}

	@Override
	public Result verify(JobSeeker jobSeeker) {
		return FakeMernisService.validate(jobSeeker.getNationalId()) ? new SuccessResult("User verified"):new ErrorResult("Verify failed");
	}

	@Override
	public DataResult<List<JobSeekerVerification>> getAll() {
		return new SuccessDataResult<List<JobSeekerVerification>>(jobSeekerVerificationDao.findAll());
	}

}
