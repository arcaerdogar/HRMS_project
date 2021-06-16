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
import hrms.hrms.entities.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="CvSchools")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCv"})
public class CvSchool {	

	public CvSchool(int id, JobSeekerCV jobSeekerCv, School school, String department, LocalDate startingYear,
			LocalDate graduatingYear) {
		super();
		this.id = id;
		this.jobSeekerCv = jobSeekerCv;
		this.school = school;
		this.department = department;
		this.startingYear = startingYear;
		this.graduatingYear = graduatingYear;
	}
	public CvSchool() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_school_id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private JobSeekerCV jobSeekerCv;
	
	@ManyToOne()
	@JoinColumn(name="school_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvSchool"})
	private School school;
	
	@Column(name="department")
	private String department;
	
	@Column(name="starting_year")
	private LocalDate startingYear;
	
	@Column(name="graduating_year",nullable = true)
	private LocalDate graduatingYear;

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
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getStartingYear() {
		return startingYear;
	}
	public void setStartingYear(LocalDate startingYear) {
		this.startingYear = startingYear;
	}
	public LocalDate getGraduatingYear() {
		return graduatingYear;
	}
	public void setGraduatingYear(LocalDate graduatingYear) {
		this.graduatingYear = graduatingYear;
	} 
	
	
}
