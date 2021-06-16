package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.cvElementServices.CvJobExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.cvElements.CvJobExperience;

@RestController
@RequestMapping("/api/cvJobExperience")
public class CvJobExperienceController {
	CvJobExperienceService cvJobExperienceService;

	@Autowired
	public CvJobExperienceController(CvJobExperienceService cvJobExperienceService) {
		super();
		this.cvJobExperienceService = cvJobExperienceService;
	}
	
	@GetMapping("getAllByIdOrderByLeavingYear")
	public DataResult<List<CvJobExperience>> getAllByIdOrderByLeavingYear(int id){
		return cvJobExperienceService.getAllByIdOrderByLeavingYear(id);
	}
	
}
