package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Job;

public interface JobService {
	Result add(Job job);
	DataResult<List<Job>> getAll();
}
