package hrms.hrms.business.concretes.userManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.Validation.ValidationTool;
import hrms.hrms.business.abstracts.JobAdvertisementService;
import hrms.hrms.business.abstracts.userServices.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.error.ErrorResult;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.JobAdvertisement;
import hrms.hrms.entities.concretes.users.Employer;

@Component
public class EmployerManager implements EmployerService{

	EmployerDao employerDao;
	ValidationTool validationTool;
	JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,ValidationTool validationTool,JobAdvertisementService jobAdvertisementService) {
		this.employerDao=employerDao;
		this.validationTool=validationTool;
		this.jobAdvertisementService=jobAdvertisementService;
	}
	
	@Override
	public Result register(Employer employer) {
		
		if(!ValidationTool.validateEmployer(employer)) {
			return new ErrorResult("All fields are required");
		}
		if(validationTool.checkIfEmailExist(employer.getEmail())) {
			return new ErrorResult("Email already exist.");
		}
		employer.deActivate();
		employer.getVerification().setEmailVerification(false);
		employer.getVerification().setSystemPersonnelVerification(false);
		employerDao.save(employer);
		return new SuccessResult("Employer saved");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result confirmEmail(Employer employer) {
		employerDao.delete(employer);
		employer.getVerification().setEmailVerification(true);
		if(employer.getVerification().isSystemPersonnelVerification()) {
			employer.activate();
		}
		employerDao.save(employer);
		return new SuccessResult("Email confirmed.");
	}

	@Override
	public Result verifyBySystemPersonnel(Employer employer) {
		employerDao.delete(employer);
		employer.getVerification().setSystemPersonnelVerification(true);
		if(employer.getVerification().isEmailVerification()) {
			employer.activate();
		}
		employerDao.save(employer);
		return new SuccessResult("Employer account verified by system personnel.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getJobAdvertisements(int employerId) {
		return jobAdvertisementService.getByEmployerId(employerId);
	}

	@Override
	public Result addAdvertisement(int employerId,int jobId,int cityId, JobAdvertisement jobAdvertisement) {
		jobAdvertisement.getEmployer().setId(employerId);
		jobAdvertisement.getJob().setId(jobId);
		jobAdvertisement.getCity().setId(cityId);
		return jobAdvertisementService.add(jobAdvertisement);
	}

	@Override
	public Result closeJobAdvertisement(int advertId) {
		
		return null;
	}
	
}
