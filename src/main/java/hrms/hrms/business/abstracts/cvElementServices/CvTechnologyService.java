package hrms.hrms.business.abstracts.cvElementServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.cvElements.CvTechnology;

public interface CvTechnologyService {
	Result add(int cvId,CvTechnology cvTechnology);
	DataResult<List<CvTechnology>> getAll();
}
