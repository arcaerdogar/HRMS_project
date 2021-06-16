package hrms.hrms.business.concretes.cvElementManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.cvElementServices.CvJobExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CvJobExperienceDao;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvJobExperience;

@Component
public class CvJobExperienceManager implements CvJobExperienceService{
	
	CvJobExperienceDao cvJobExperiencesDao;
	
	@Autowired
	public CvJobExperienceManager(CvJobExperienceDao cvJobExperiencesDao) {
		super();
		this.cvJobExperiencesDao = cvJobExperiencesDao;
	}

	@Override
	public Result add(int cvId, CvJobExperience cvJobExperience) {
		JobSeekerCV jobSeekerCV=new JobSeekerCV();
		jobSeekerCV.setCvId(cvId);
		cvJobExperience.setJobSeekerCv(jobSeekerCV);
		cvJobExperiencesDao.save(cvJobExperience);
		return new SuccessResult("Job Experience added to CV.");
	}

	@Override
	public DataResult<List<CvJobExperience>> getAll() {
		return new SuccessDataResult<List<CvJobExperience>>(cvJobExperiencesDao.findAll(),"Data Listed");
	}

	@Override
	public DataResult<List<CvJobExperience>> getAllByIdOrderByLeavingYear(int id) {
		return new SuccessDataResult<List<CvJobExperience>>(cvJobExperiencesDao.findAllByJobSeekerCv_cvIdOrderByLeavingYearAsc(id),"Data Listed");
	}
	

}
