package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.SchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SchoolDao;
import hrms.hrms.entities.concretes.School;

@Component
public class SchoolManager implements SchoolService{
	SchoolDao schoolDao;

	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		schoolDao.save(school);
		return new SuccessResult("School added.");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(schoolDao.findAll(),"Data Listed.");
	}

}
