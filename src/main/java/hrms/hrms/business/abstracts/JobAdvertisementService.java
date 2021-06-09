package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	DataResult<List<JobAdvertisement>> getAllOrderByLastRecourseDate();
	Result closeAdvertisement(int advertId);
	DataResult<List<JobAdvertisement>> getOpenAdverts();
	DataResult<List<JobAdvertisement>> getCloseAdverts();
}
