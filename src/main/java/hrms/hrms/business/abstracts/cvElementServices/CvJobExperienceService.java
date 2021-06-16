package hrms.hrms.business.abstracts.cvElementServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.cvElements.CvJobExperience;

public interface CvJobExperienceService {
	
	Result add(int cvId,CvJobExperience cvJobExperience);
	DataResult<List<CvJobExperience>> getAll();
	DataResult<List<CvJobExperience>> getAllByIdOrderByLeavingYear(int id);
}
