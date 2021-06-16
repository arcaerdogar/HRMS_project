package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.LanguageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.LanguageDao;
import hrms.hrms.entities.concretes.Language;

@Component
public class LanguageManager implements LanguageService{
	
	LanguageDao languageDao;

	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		languageDao.save(language);
		return new SuccessResult("Language added.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(languageDao.findAll(),"Data Listed.");
	}

}
