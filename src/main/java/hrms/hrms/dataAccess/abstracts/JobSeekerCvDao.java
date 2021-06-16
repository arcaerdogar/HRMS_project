package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobSeekerCV;

public interface JobSeekerCvDao extends JpaRepository<JobSeekerCV, Integer>{

}
