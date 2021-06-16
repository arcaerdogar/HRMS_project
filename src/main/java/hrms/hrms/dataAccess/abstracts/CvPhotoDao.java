package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.cvElements.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer>{

}
