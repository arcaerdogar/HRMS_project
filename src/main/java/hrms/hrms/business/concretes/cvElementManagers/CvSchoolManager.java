package hrms.hrms.business.concretes.cvElementManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.cvElementServices.CvSchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CvSchoolDao;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvSchool;

@Component
public class CvSchoolManager implements CvSchoolService{

	CvSchoolDao cvSchoolDao;

	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao) {
		super();
		this.cvSchoolDao = cvSchoolDao;
	}

	@Override
	public Result add(int cvId, CvSchool cvSchool) {
		JobSeekerCV jobSeekerCV=new JobSeekerCV();
		jobSeekerCV.setCvId(cvId);
		cvSchool.setJobSeekerCv(jobSeekerCV);
		cvSchoolDao.save(cvSchool);
		return new SuccessResult("School added to CV.");
	}

	@Override
	public DataResult<List<CvSchool>> getAll() {
		return new SuccessDataResult<List<CvSchool>>(cvSchoolDao.findAll(), "Data Listed.");
	}

	@Override
	public DataResult<List<CvSchool>> getAllByIdOrderByGraduatingYear(int id) {
		return new SuccessDataResult<List<CvSchool>>(cvSchoolDao.findAllByJobSeekerCv_cvIdOrderByGraduatingYearAsc(id), "Data Listed.");
	}
	
}
