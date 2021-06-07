package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result register(JobSeeker jobSeeker);
	DataResult<List<JobSeeker>> getAll();
	Result activate(int id);
	Result confirmEmail(JobSeeker jobSeeker);
	Result verifyWithMernis(JobSeeker jobSeeker);
}
