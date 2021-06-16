package hrms.hrms.business.abstracts.userServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvertisement;
import hrms.hrms.entities.concretes.users.Employer;

public interface EmployerService {
	Result register(Employer employer);
	DataResult<List<Employer>> getAll();
	Result confirmEmail(Employer employer);
	Result verifyBySystemPersonnel(Employer employer);
	DataResult<List<JobAdvertisement>> getJobAdvertisements(int employerId);
	Result addAdvertisement(int employerId,int jobId,int cityId,JobAdvertisement jobAdvertisement);
	Result closeJobAdvertisement(int advertId);
}
