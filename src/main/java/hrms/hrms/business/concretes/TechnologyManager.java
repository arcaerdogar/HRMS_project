package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.TechnologyService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.TechnologyDao;
import hrms.hrms.entities.concretes.Technology;

@Component
public class TechnologyManager implements TechnologyService{
	
	TechnologyDao technologyDao;
	
	public TechnologyManager(TechnologyDao technologyDao) {
		this.technologyDao = technologyDao;
	}

	@Override
	public Result add(Technology technology) {
		technologyDao.save(technology);
		return new SuccessResult("Technology added.");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(technologyDao.findAll(),"Data Listed.");
	}

}
