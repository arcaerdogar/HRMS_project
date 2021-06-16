package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.cvElements.CvLanguage;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer>{

}
