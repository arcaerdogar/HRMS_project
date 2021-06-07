package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.EmployerVerificationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.EmployerVerificationDao;
import hrms.hrms.entities.concretes.verifications.EmployerVerification;

@Component
public class EmployerVerificationManager implements EmployerVerificationService{

	EmployerVerificationDao employerVerificationDao;
	
	
	
	public EmployerVerificationManager(EmployerVerificationDao employerVerificationDao) {
		super();
		this.employerVerificationDao = employerVerificationDao;
	}

	@Override
	public DataResult<List<EmployerVerification>> getAll() {
		return new SuccessDataResult<List<EmployerVerification>>(employerVerificationDao.findAll());
	}

	@Override
	public DataResult<EmployerVerification> getByVerificationId(int id) {
		return new SuccessDataResult<EmployerVerification>(employerVerificationDao.getByVerificationId(id));
	}

}
