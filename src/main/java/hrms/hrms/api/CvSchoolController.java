package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.cvElementServices.CvSchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.cvElements.CvSchool;

@RestController
@RequestMapping("/api/cvSchools")
public class CvSchoolController {
	CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	
	@GetMapping("getAllByIdOrderByLeavingYear")
	public DataResult<List<CvSchool>> getAllByIdOrderByLeavingYear(int id){
		return cvSchoolService.getAllByIdOrderByGraduatingYear(id);
	}
}
