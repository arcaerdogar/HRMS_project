package hrms.hrms.services.email;

import org.springframework.stereotype.Component;

import hrms.hrms.entities.concretes.users.Employer;
import hrms.hrms.entities.concretes.users.JobSeeker;

@Component
public class FakeEmailService {
	
	public static boolean sendVerificationEmail(JobSeeker jobSeeker) {
		return true;
	}
	
	public static boolean sendVerificationEmail(Employer employer) {
		return true;
	}
}
