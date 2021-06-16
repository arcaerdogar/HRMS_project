package hrms.hrms.business.abstracts.cvElementServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.cvElements.CvLink;

public interface CvLinkService {
	Result add(int cvId,CvLink cvLink);
	DataResult<List<CvLink>> getAll();
}
