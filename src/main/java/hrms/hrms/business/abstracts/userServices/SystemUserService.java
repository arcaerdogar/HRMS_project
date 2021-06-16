package hrms.hrms.business.abstracts.userServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.users.Employer;
import hrms.hrms.entities.concretes.users.SystemUser;

public interface SystemUserService {
	Result register(SystemUser systemUser);
	DataResult<List<SystemUser>> getAll();
	Result verifyEmployer(Employer employer);
}
