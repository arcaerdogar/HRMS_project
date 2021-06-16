package hrms.hrms.business.concretes.cvElementManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.cvElementServices.CvLinkService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CvLinkDao;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvLink;

@Component
public class CvLinkManager implements CvLinkService{

	CvLinkDao cvLinkDao;
	
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(int cvId, CvLink cvLink) {
		JobSeekerCV jobSeekerCV=new JobSeekerCV();
		jobSeekerCV.setCvId(cvId);
		cvLink.setJobSeekerCv(jobSeekerCV);
		cvLinkDao.save(cvLink);
		return new SuccessResult("Link added to CV.");
	}

	@Override
	public DataResult<List<CvLink>> getAll() {
		return new SuccessDataResult<List<CvLink>>(cvLinkDao.findAll(),"Data Listed.");
	}
	
}
