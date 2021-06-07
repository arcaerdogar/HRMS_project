package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.business.abstracts.SystemUserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SystemUserDao;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.SystemUser;

@Component
public class SystemUserManager implements SystemUserService{

	SystemUserDao systemUserDao;
	EmployerService employerService;
	
	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao,EmployerService employerService) {
		this.systemUserDao = systemUserDao;
		this.employerService=employerService;
	}

	@Override
	public Result register(SystemUser systemUser) {
		systemUserDao.save(systemUser);
		return new SuccessResult("System User added.");
	}

	@Override
	public DataResult<List<SystemUser>> getAll() {
		return new SuccessDataResult<List<SystemUser>>(systemUserDao.findAll(),"System Users Listed.");
	}

	@Override
	public Result verifyEmployer(Employer employer) {
		return employerService.verifyBySystemPersonnel(employer);
	}

}
