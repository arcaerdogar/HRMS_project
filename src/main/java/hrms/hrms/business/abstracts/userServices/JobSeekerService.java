package hrms.hrms.business.abstracts.userServices;

import java.io.IOException;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.users.JobSeeker;

public interface JobSeekerService {
	Result register(JobSeeker jobSeeker);
	DataResult<List<JobSeeker>> getAll();
	Result activate(int id);
	Result confirmEmail(int jobSeekerId);
	Result verifyWithMernis(int jobSeekerId);
	Result changeProfilePhoto(String Url,int jobSeekerId) throws IOException;
	DataResult<List<JobSeekerCV>> getCvsByJobSeekerId(int id);
}
