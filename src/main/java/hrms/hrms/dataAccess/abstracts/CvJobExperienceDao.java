package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.cvElements.CvJobExperience;

public interface CvJobExperienceDao extends JpaRepository<CvJobExperience, Integer>{
	List<CvJobExperience> findAllByJobSeekerCv_cvIdOrderByLeavingYearAsc(int id);
}
