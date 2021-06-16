package hrms.hrms.business.abstracts.cvElementServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.cvElements.CvSchool;

public interface CvSchoolService {
	Result add(int cvId,CvSchool cvSchool);
	DataResult<List<CvSchool>> getAll();
	DataResult<List<CvSchool>> getAllByIdOrderByGraduatingYear(int id);
}
