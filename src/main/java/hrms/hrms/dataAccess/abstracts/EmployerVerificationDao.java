package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.verifications.EmployerVerification;

public interface EmployerVerificationDao extends JpaRepository<EmployerVerification, Integer>{

	EmployerVerification getByVerificationId(int id);
}
