package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobAdvertisementService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

	JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getallorderedbylastrecoursedate")
	public DataResult<List<JobAdvertisement>> getAllOrderedByLastRecourseDate(){
		return jobAdvertisementService.getAllOrderByLastRecourseDate();
	}
	
	@PostMapping("/closeadvert")
	public Result closeAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.closeAdvertisement(jobAdvertisement.getId());
	}
	
	@GetMapping("/getOpenAdverts")
	public DataResult<List<JobAdvertisement>> getOpenAdverts(){
		return jobAdvertisementService.getOpenAdverts();
	}
	
	@GetMapping("/getCloseAdverts")
	public DataResult<List<JobAdvertisement>> getCloseAdverts(){
		return jobAdvertisementService.getCloseAdverts();
	}
}
