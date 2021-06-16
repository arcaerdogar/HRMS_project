package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.userServices.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvertisement;
import hrms.hrms.entities.concretes.users.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	
	@PostMapping("/register")
	
	public Result register(@RequestBody Employer employer)
	{
		
		return this.employerService.register(employer);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return employerService.getAll();
	}
	
	@PostMapping("/confirmemail")
	public Result confirmEmail(@RequestBody Employer employer)
	{
		return employerService.confirmEmail(employer);
	}
	
	@PostMapping("/verifyBySystemPersonnel")
	public Result verifyBySystemPersonnel(@RequestBody Employer employer)
	{
		return employerService.verifyBySystemPersonnel(employer);
	}
	
	@GetMapping("/getAdvertisements")
	public DataResult<List<JobAdvertisement>> getAdvertisements(int employerId){
		return employerService.getJobAdvertisements(employerId);
	}
	
	@PostMapping("/addAdvertisement")
	public Result addAdvertisement(int employerId,int jobId,int cityId, @RequestBody JobAdvertisement jobAdvertisement)
	{
		return employerService.addAdvertisement(employerId,jobId,cityId, jobAdvertisement);
	}
	
}
