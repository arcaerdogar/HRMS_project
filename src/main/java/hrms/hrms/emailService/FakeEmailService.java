package hrms.hrms.emailService;

import org.springframework.stereotype.Component;

import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobSeeker;

@Component
public class FakeEmailService {
	
	public static boolean sendVerificationEmail(JobSeeker jobSeeker) {
		return true;
	}
	
	public static boolean sendVerificationEmail(Employer employer) {
		return true;
	}
}
