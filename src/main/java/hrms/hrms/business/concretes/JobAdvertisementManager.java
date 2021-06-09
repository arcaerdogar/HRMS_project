package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.JobAdvertisementService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.error.ErrorResult;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrms.hrms.entities.concretes.JobAdvertisement;

@Component
public class JobAdvertisementManager implements JobAdvertisementService{

	JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"Data Listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAllByEmployerId(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOrderByLastRecourseDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAllByOrderByLastRecourseDate());
	}

	@Override
	public Result closeAdvertisement(int advertId) {
		JobAdvertisement advertToClose= jobAdvertisementDao.getOne(advertId);
		if(advertToClose.isActive()==false) {
			return new ErrorResult("Advertisement already closed");
		}
		jobAdvertisementDao.delete(advertToClose);
		advertToClose.setActive(false);
		jobAdvertisementDao.save(advertToClose);
		return new SuccessResult("Advertisement closed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getOpenAdverts() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAllByIsActiveEquals(true));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getCloseAdverts() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAllByIsActiveEquals(false));
	}

}
