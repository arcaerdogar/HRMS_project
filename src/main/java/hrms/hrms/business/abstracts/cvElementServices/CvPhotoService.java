package hrms.hrms.business.abstracts.cvElementServices;

import java.io.IOException;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.cvElements.CvPhoto;

public interface CvPhotoService {
	
	Result add(int cvId,String Url) throws IOException;
	DataResult<List<CvPhoto>> getAll();
}
