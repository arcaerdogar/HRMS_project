package hrms.hrms.business.concretes.cvElementManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.cvElementServices.CvTechnologyService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CvTechnologyDao;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvTechnology;

@Component
public class CvTechnologyManager implements CvTechnologyService{
	
	CvTechnologyDao cvTechnologyDao;

	@Autowired
	public CvTechnologyManager(CvTechnologyDao cvTechnologyDao) {
		super();
		this.cvTechnologyDao = cvTechnologyDao;
	}

	@Override
	public Result add(int cvId, CvTechnology cvTechnology) {
		JobSeekerCV jobSeekerCV=new JobSeekerCV();
		jobSeekerCV.setCvId(cvId);
		cvTechnology.setJobSeekerCv(jobSeekerCV);
		cvTechnologyDao.save(cvTechnology);
		return new SuccessResult("Technology added to CV.");
	}

	@Override
	public DataResult<List<CvTechnology>> getAll() {
		return new SuccessDataResult<List<CvTechnology>>(cvTechnologyDao.findAll(), "Data Listed");
	}

}
