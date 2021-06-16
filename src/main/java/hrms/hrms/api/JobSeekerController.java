package hrms.hrms.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.userServices.JobSeekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.users.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
	JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
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
	
	@GetMapping("/getCvsByJobseekerId")
	public DataResult<List<JobSeekerCV>> getCvsByJobSeekerId(int id){
		return jobSeekerService.getCvsByJobSeekerId(id);
	}
	
	@PostMapping("/changeProfilPhoto")
	public Result changeProfilePhoto(String Url,int jobSeekerId) throws IOException {
		return jobSeekerService.changeProfilePhoto(Url, jobSeekerId);
	}
	
}
