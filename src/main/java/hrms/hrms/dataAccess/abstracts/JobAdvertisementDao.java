package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> findAllByEmployerId(int id);
	List<JobAdvertisement> findAllByOrderByLastRecourseDate();
	List<JobAdvertisement> findAllByIsActiveEquals(boolean active);
}
