package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.hrms.entities.concretes.cvElements.CvJobExperience;
import hrms.hrms.entities.concretes.cvElements.CvLanguage;
import hrms.hrms.entities.concretes.cvElements.CvLink;
import hrms.hrms.entities.concretes.cvElements.CvPhoto;
import hrms.hrms.entities.concretes.cvElements.CvSchool;
import hrms.hrms.entities.concretes.cvElements.CvTechnology;
import hrms.hrms.entities.concretes.users.JobSeeker;
import lombok.NoArgsConstructor;


@Entity
@Table(name="job_seeker_cvs")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeeker"})
public class JobSeekerCV {


	public JobSeekerCV(int cvId, String coverLetter, List<CvTechnology> technologies, List<CvPhoto> photos,
			List<CvSchool> schools, List<CvLanguage> languages, List<CvJobExperience> jobExperiences,
			List<CvLink> cvLinks, JobSeeker jobSeeker) {
		super();
		this.cvId = cvId;
		this.coverLetter = coverLetter;
		this.technologies = technologies;
		this.photos = photos;
		this.schools = schools;
		this.languages = languages;
		this.jobExperiences = jobExperiences;
		this.cvLinks = cvLinks;
		this.jobSeeker = jobSeeker;
	}
	public JobSeekerCV() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "jobSeekerCv")
	private List<CvTechnology> technologies;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "jobSeekerCv")
	private List<CvPhoto> photos;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "jobSeekerCv")
	private List<CvSchool> schools;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "jobSeekerCv")
	private List<CvLanguage> languages;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "jobSeekerCv")
	private List<CvJobExperience> jobExperiences;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "jobSeekerCv")
	private List<CvLink> cvLinks;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id",referencedColumnName ="id")
	private JobSeeker jobSeeker;

	public int getCvId() {
		return cvId;
	}
	public void setCvId(int cvId) {
		this.cvId = cvId;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	public List<CvTechnology> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<CvTechnology> technologies) {
		this.technologies = technologies;
	}
	public List<CvSchool> getSchools() {
		return schools;
	}
	public void setSchools(List<CvSchool> schools) {
		this.schools = schools;
	}
	public List<CvLanguage> getLanguages() {
		return languages;
	}
	public void setLanguages(List<CvLanguage> languages) {
		this.languages = languages;
	}
	public List<CvJobExperience> getJobExperiences() {
		return jobExperiences;
	}
	public void setJobExperiences(List<CvJobExperience> jobExperiences) {
		this.jobExperiences = jobExperiences;
	}
	public JobSeeker getJobSeeker() {
		return this.jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	public List<CvLink> getCvLinks() {
		return cvLinks;
	}
	public void setCvLinks(List<CvLink> cvLinks) {
		this.cvLinks = cvLinks;
	}
	public List<CvPhoto> getPhotos() {
		return photos;
	}
	public void setPhotos(List<CvPhoto> photos) {
		this.photos = photos;
	}

}
