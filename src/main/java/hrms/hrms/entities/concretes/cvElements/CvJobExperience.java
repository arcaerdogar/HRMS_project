package hrms.hrms.entities.concretes.cvElements;

import java.time.LocalDate;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="CvJobExperiences")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCv"})
public class CvJobExperience {

	
	public CvJobExperience(int jobExperienceId, String companyName, String position, LocalDate startingYear,
			LocalDate leavingYear, JobSeekerCV jobSeekerCv) {
		this.jobExperienceId = jobExperienceId;
		this.companyName = companyName;
		this.position = position;
		this.startingYear = startingYear;
		this.leavingYear = leavingYear;
		this.jobSeekerCv = jobSeekerCv;
	}

	public CvJobExperience() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_experience_id")
	private int jobExperienceId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="starting_year")
	private LocalDate startingYear;
	
	@Column(name="leaving_year",nullable = true)
	private LocalDate leavingYear;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private JobSeekerCV jobSeekerCv;

	public int getJobExperienceId() {
		return jobExperienceId;
	}

	public void setJobExperienceId(int jobExperienceId) {
		this.jobExperienceId = jobExperienceId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDate getStartingYear() {
		return startingYear;
	}

	public void setStartingYear(LocalDate startingYear) {
		this.startingYear = startingYear;
	}

	public LocalDate getLeavingYear() {
		return leavingYear;
	}

	public void setLeavingYear(LocalDate leavingYear) {
		this.leavingYear = leavingYear;
	}

	public JobSeekerCV getJobSeekerCv() {
		return jobSeekerCv;
	}

	public void setJobSeekerCv(JobSeekerCV jobSeekerCv) {
		this.jobSeekerCv = jobSeekerCv;
	}

	
	
}
