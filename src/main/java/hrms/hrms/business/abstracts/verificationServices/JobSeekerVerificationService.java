package hrms.hrms.business.abstracts.verificationServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.users.JobSeeker;
import hrms.hrms.entities.concretes.verifications.JobSeekerVerification;

public interface JobSeekerVerificationService {
	Result verify(JobSeeker jobSeeker);
	DataResult<List<JobSeekerVerification>> getAll();
}
