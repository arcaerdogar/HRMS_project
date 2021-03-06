package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return jobService.add(job);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Job>> getAll(){
		return jobService.getAll();
	}

}
