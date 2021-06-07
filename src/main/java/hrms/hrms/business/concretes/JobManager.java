package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.JobService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.error.ErrorResult;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobDao;
import hrms.hrms.entities.concretes.Job;

@Component
public class JobManager implements JobService{

	JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public Result add(Job job) {
		if(jobDao.findByJobTitle(job.getJobTitle())!=null) {
			return new ErrorResult("Job Title already exist.");
		}
		jobDao.save(job);
		return new SuccessResult("Job added");
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(jobDao.findAll());
	}

}
