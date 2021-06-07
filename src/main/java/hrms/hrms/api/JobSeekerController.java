package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobSeekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
	JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("/register")
	public Result register(@RequestBody JobSeeker jobSeeker) {
		return jobSeekerService.register(jobSeeker); 		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll(){
		return jobSeekerService.getAll();
	}
	
	@PostMapping("/confirmEmail")
	public Result confirmEmail(@RequestBody JobSeeker jobSeeker) {
		return jobSeekerService.confirmEmail(jobSeeker); 		
	}
}
