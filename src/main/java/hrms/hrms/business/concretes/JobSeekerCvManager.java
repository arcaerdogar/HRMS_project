package hrms.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.JobSeekerCvService;
import hrms.hrms.business.abstracts.cvElementServices.CvJobExperienceService;
import hrms.hrms.business.abstracts.cvElementServices.CvLanguageService;
import hrms.hrms.business.abstracts.cvElementServices.CvLinkService;
import hrms.hrms.business.abstracts.cvElementServices.CvPhotoService;
import hrms.hrms.business.abstracts.cvElementServices.CvSchoolService;
import hrms.hrms.business.abstracts.cvElementServices.CvTechnologyService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.success.SuccessDataResult;
import hrms.hrms.core.utilities.results.success.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerCvDao;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvJobExperience;
import hrms.hrms.entities.concretes.cvElements.CvLanguage;
import hrms.hrms.entities.concretes.cvElements.CvLink;
import hrms.hrms.entities.concretes.cvElements.CvSchool;
import hrms.hrms.entities.concretes.cvElements.CvTechnology;
import hrms.hrms.entities.concretes.users.JobSeeker;

@Component
public class JobSeekerCvManager implements JobSeekerCvService{
	
	JobSeekerCvDao jobSeekerCvDao;
	CvJobExperienceService cvJobExperienceService;
	CvLanguageService cvLanguageService;
	CvTechnologyService cvTechnologyService;
	CvSchoolService cvSchoolService;
	CvLinkService cvLinkService;
	CvPhotoService cvPhotoService;
	
	@Autowired
	public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao,CvJobExperienceService cvJobExperienceService,CvLanguageService cvLanguageService,
			CvSchoolService cvSchoolService,CvTechnologyService cvTechnologyService,CvLinkService cvLinkService,CvPhotoService cvPhotoService) {
		this.jobSeekerCvDao = jobSeekerCvDao;
		this.cvJobExperienceService=cvJobExperienceService;
		this.cvLanguageService=cvLanguageService;
		this.cvTechnologyService=cvTechnologyService;
		this.cvSchoolService=cvSchoolService;
		this.cvLinkService=cvLinkService;
		this.cvPhotoService=cvPhotoService;
	}

	
	@Override
	public Result addExperience(int cvId, CvJobExperience cvJobExperience) {
		return cvJobExperienceService.add(cvId, cvJobExperience);
	}

	@Override
	public Result addLanguage(int cvId, CvLanguage cvLanguage) {
		return cvLanguageService.add(cvId, cvLanguage);
	}

	@Override
	public Result addTechnology(int cvId, CvTechnology cvTechnology) {
		return cvTechnologyService.add(cvId, cvTechnology);
	}

	@Override
	public Result addSchool(int cvId, CvSchool cvSchool) {
		return cvSchoolService.add(cvId, cvSchool);
	}

	@Override
	public Result addLink(int cvId, CvLink cvLink) {
		return cvLinkService.add(cvId, cvLink);
	}
	
	@Override
	public DataResult<List<JobSeekerCV>> getAll() {
		return new SuccessDataResult<List<JobSeekerCV>>(jobSeekerCvDao.findAll(), "Data Listed");
	}
	
	@Override
	public Result addCv(int jobSeekerId, JobSeekerCV jobSeekerCV) {
		JobSeeker cvJobSeeker=new JobSeeker();
		cvJobSeeker.setId(jobSeekerId);
		jobSeekerCV.setJobSeeker(cvJobSeeker);
		jobSeekerCvDao.save(jobSeekerCV);
		return new SuccessResult("Cv added to Job Seeker.");
	}


	@Override
	public Result addPhoto(int cvId, String Url) throws IOException {
		return cvPhotoService.add(cvId, Url);
	}

}
