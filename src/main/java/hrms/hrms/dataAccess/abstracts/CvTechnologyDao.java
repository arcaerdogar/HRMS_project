package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.cvElements.CvTechnology;

public interface CvTechnologyDao extends JpaRepository<CvTechnology, Integer>{

}
