package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.SystemUser;

public interface SystemUserService {
	Result register(SystemUser systemUser);
	DataResult<List<SystemUser>> getAll();
	Result verifyEmployer(Employer employer);
}
