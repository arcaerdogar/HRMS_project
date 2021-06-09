package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.CityService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CityDao;
import hrms.hrms.entities.concretes.City;

@Component
public class CityManager implements CityService{
	
	CityDao cityDao;

	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public Result Add(City city) {
		cityDao.save(city);
		return new SuccessResult("City added.");
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}
	
}
