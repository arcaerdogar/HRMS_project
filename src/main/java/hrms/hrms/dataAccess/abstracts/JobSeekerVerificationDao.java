package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.verifications.JobSeekerVerification;

public interface JobSeekerVerificationDao extends JpaRepository<JobSeekerVerification, Integer>{
	JobSeekerVerification getByVerificationId(int id);
}
