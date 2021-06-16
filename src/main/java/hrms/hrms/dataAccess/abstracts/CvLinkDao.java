package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.cvElements.CvLink;

public interface CvLinkDao extends JpaRepository<CvLink, Integer>{

}
