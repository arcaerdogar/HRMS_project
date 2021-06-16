package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.users.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
