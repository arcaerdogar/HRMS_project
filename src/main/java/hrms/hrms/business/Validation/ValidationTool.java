package hrms.hrms.business.Validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.dataAccess.abstracts.UserDao;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobSeeker;

@Component
public class ValidationTool {
	
	UserDao userDao;
	JobSeekerDao jobSeekerDao;
	
	@Autowired
	public ValidationTool(UserDao userDao, JobSeekerDao jobSeekerDao) {
		super();
		this.userDao = userDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	public static boolean validateJobSeeker(JobSeeker jobSeeker) {
		if(jobSeeker.getBirthDate()==null || jobSeeker.getEmail()==null || jobSeeker.getFirstName()==null || jobSeeker.getLastName()==null ||
				jobSeeker.getNationalId()==null || jobSeeker.getPassword()==null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateEmployer(Employer employer) {
		if(employer.getEmail()==null || employer.getPassword()==null || employer.getPhoneNumber()==null || employer.getCompanyName()==null) {
			return false;
		}
		return true;
	}
	
	
	public boolean checkIfEmailExist(String email) {
		if(userDao.findByEmail(email)!=null) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfNationalIdExist(String nationalId) {
		if(jobSeekerDao.findByNationalId(nationalId)!=null) {
			return true;
		}
		return false;
	}
}
