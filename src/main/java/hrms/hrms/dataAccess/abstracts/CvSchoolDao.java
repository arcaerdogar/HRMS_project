package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.cvElements.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool, Integer>{
	List<CvSchool> findAllByJobSeekerCv_cvIdOrderByGraduatingYearAsc(int id);
}
