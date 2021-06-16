package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.School;

public interface SchoolService {
	
	Result add(School school);
	DataResult<List<School>> getAll();
}
