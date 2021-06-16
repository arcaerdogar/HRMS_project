package hrms.hrms.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobSeekerCvService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvJobExperience;
import hrms.hrms.entities.concretes.cvElements.CvLanguage;
import hrms.hrms.entities.concretes.cvElements.CvLink;
import hrms.hrms.entities.concretes.cvElements.CvSchool;
import hrms.hrms.entities.concretes.cvElements.CvTechnology;

@RestController
@RequestMapping("/api/jobseekercvs")
public class JobSeekerCvController {
	JobSeekerCvService jobSeekerCvService;

	@Autowired
	public JobSeekerCvController(JobSeekerCvService jobSeekerCvService) {
		super();
		this.jobSeekerCvService = jobSeekerCvService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeekerCV>> getAll(){
		return jobSeekerCvService.getAll();
	}
	
	@PostMapping("/addLanguage")
	public Result addLanguage(int cvId,@RequestBody CvLanguage cvLanguage) {
		return jobSeekerCvService.addLanguage(cvId, cvLanguage);
	}
	
	@PostMapping("/addJobExperience")
	public Result addTechnology(int cvId,@RequestBody CvJobExperience cvJobExperience) {
		return jobSeekerCvService.addExperience(cvId, cvJobExperience);
	}
	
	@PostMapping("/addTechnology")
	public Result addTechnology(int cvId,@RequestBody CvTechnology cvTechnology) {
		return jobSeekerCvService.addTechnology(cvId, cvTechnology);
	}
	
	@PostMapping("/addLink")
	public Result addLink(int cvId,@RequestBody CvLink cvLink) {
		return jobSeekerCvService.addLink(cvId, cvLink);
	}
	
	@PostMapping("/addSchool")
	public Result addSchool(int cvId,@RequestBody CvSchool cvSchool) {
		return jobSeekerCvService.addSchool(cvId, cvSchool);
	}
	
	@PostMapping("/addPhoto")
	public Result addSPhoto(int cvId,String Url) throws IOException {
		return jobSeekerCvService.addPhoto(cvId, Url);
	}
	
	@PostMapping("/addCv")
	public Result addCv(int id,@RequestBody JobSeekerCV jobSeekerCv) {
		return jobSeekerCvService.addCv(id, jobSeekerCv);
	}
	
}
