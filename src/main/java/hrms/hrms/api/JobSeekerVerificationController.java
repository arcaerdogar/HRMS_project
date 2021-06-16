package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.verificationServices.JobSeekerVerificationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.verifications.JobSeekerVerification;

@RestController
@RequestMapping("/api/jobSeekerVerifications")
public class JobSeekerVerificationController {
	JobSeekerVerificationService jobSeekerVerificationService;
	
	@Autowired
	public JobSeekerVerificationController(JobSeekerVerificationService jobSeekerVerificationService) {
		super();
		this.jobSeekerVerificationService = jobSeekerVerificationService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeekerVerification>> getAll(){
		return jobSeekerVerificationService.getAll();
	}
}
