package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeeker;
import hrms.hrms.entities.concretes.verifications.JobSeekerVerification;

public interface JobSeekerVerificationService {
	Result verify(JobSeeker jobSeeker);
	DataResult<List<JobSeekerVerification>> getAll();
}
