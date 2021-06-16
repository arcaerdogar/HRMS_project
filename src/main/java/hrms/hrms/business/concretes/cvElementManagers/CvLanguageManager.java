package hrms.hrms.business.concretes.cvElementManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.cvElementServices.CvLanguageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CvLanguageDao;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvLanguage;

@Component
public class CvLanguageManager implements CvLanguageService{

	CvLanguageDao cvLanguageDao;

	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(int cvId, CvLanguage cvLanguage) {
		JobSeekerCV jobSeekerCV=new JobSeekerCV();
		jobSeekerCV.setCvId(cvId);
		cvLanguage.setJobSeekerCv(jobSeekerCV);
		cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Language added to CV.");
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {
		return new SuccessDataResult<List<CvLanguage>>(cvLanguageDao.findAll(), "Data Listed");
	}
	
}
