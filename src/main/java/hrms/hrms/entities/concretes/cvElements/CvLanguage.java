package hrms.hrms.entities.concretes.cvElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.hrms.entities.concretes.JobSeekerCV;
import hrms.hrms.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="CvLanguages")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCv"})
public class CvLanguage {

	
	public CvLanguage(int id, JobSeekerCV jobSeekerCv, Language language, int languageLevel) {
		this.id = id;
		this.jobSeekerCv = jobSeekerCv;
		this.language = language;
		this.languageLevel = languageLevel;
	}

	public CvLanguage() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_language_id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private JobSeekerCV jobSeekerCv;
	
	@ManyToOne()
	@JoinColumn(name="language_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvLanguage"})
	private Language language;
	
	@Column(name="language_level")
	private int languageLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobSeekerCV getJobSeekerCv() {
		return jobSeekerCv;
	}

	public void setJobSeekerCv(JobSeekerCV jobSeekerCv) {
		this.jobSeekerCv = jobSeekerCv;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getLanguageLevel() {
		return languageLevel;
	}

	public void setLanguageLevel(int languageLevel) {
		this.languageLevel = languageLevel;
	}
	
	
}
