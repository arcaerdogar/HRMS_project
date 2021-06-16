package hrms.hrms.business.concretes.cvElementManagers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.cvElementServices.CvPhotoService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CvPhotoDao;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvPhoto;
import hrms.hrms.services.cloudinary.CloudinaryService;

@Component
public class CvPhotoManager implements CvPhotoService{

	CvPhotoDao cvPhotoDao;
	
	@Autowired
	public CvPhotoManager(CvPhotoDao cvPhotoDao) {
		this.cvPhotoDao = cvPhotoDao;
	}

	@Override
	public Result add(int cvId, String Url) throws IOException {
		CvPhoto cvPhoto=new CvPhoto();
		JobSeekerCV jobSeekerCV=new JobSeekerCV();
		jobSeekerCV.setCvId(cvId);
		cvPhoto.setJobSeekerCv(jobSeekerCV);
		cvPhoto.setPhotoUrl(CloudinaryService.uploadImage(Url));
		cvPhotoDao.save(cvPhoto);
		return new SuccessResult("Photo added to CV");
	}

	@Override
	public DataResult<List<CvPhoto>> getAll() {
		return new SuccessDataResult<List<CvPhoto>>(cvPhotoDao.findAll(), "Data Listed");
	}

}
