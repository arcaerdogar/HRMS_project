package hrms.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.cvElements.CvJobExperience;
import hrms.hrms.entities.concretes.cvElements.CvLanguage;
import hrms.hrms.entities.concretes.cvElements.CvLink;
import hrms.hrms.entities.concretes.cvElements.CvSchool;
import hrms.hrms.entities.concretes.cvElements.CvTechnology;

public interface JobSeekerCvService {
	Result addExperience(int cvId,CvJobExperience cvJobExperience);
	Result addLanguage(int cvId,CvLanguage cvLanguage);
	Result addTechnology(int cvId,CvTechnology cvTechnology);
	Result addSchool(int cvId,CvSchool cvSchool);
	Result addLink(int cvId,CvLink cvLink);
	Result addPhoto(int cvId,String Url) throws IOException;
	DataResult<List<JobSeekerCV>> getAll();
	Result addCv(int id,JobSeekerCV jobSeekerCV);
}
