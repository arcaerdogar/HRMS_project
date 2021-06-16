package hrms.hrms.business.abstracts.cvElementServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.cvElements.CvLanguage;

public interface CvLanguageService {
	
	Result add(int cvId,CvLanguage cvLanguage);
	DataResult<List<CvLanguage>> getAll();
}
