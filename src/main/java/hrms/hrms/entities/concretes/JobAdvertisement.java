package hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hrms.hrms.entities.concretes.users.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	
	
	public JobAdvertisement(int id, Job job, City city, String jobExplanation, int maxSalary, int minSalary,
			int openJobPositions, LocalDate lastRecourseDate, Employer employer) {
		this.id = id;
		this.job = job;
		this.city = city;
		this.jobExplanation = jobExplanation;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.openJobPositions = openJobPositions;
		this.lastRecourseDate = lastRecourseDate;
		this.employer = employer;
	}
	public JobAdvertisement() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advertisement_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="job_explanation")
	private String jobExplanation;
	
	@Column(name="max_salary",nullable = true)
	private int maxSalary;
	
	@Column(name="min_salary",nullable = true)
	private int minSalary;
	
	@Column(name="open_job_positions")
	private int openJobPositions;
	
	@Column(name="last_recourse_date")
	private LocalDate lastRecourseDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employer_id",referencedColumnName = "id")
	private Employer employer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getJobExplanation() {
		return jobExplanation;
	}

	public void setJobExplanation(String jobExplanation) {
		this.jobExplanation = jobExplanation;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getOpenJobPositions() {
		return openJobPositions;
	}

	public void setOpenJobPositions(int openJobPositions) {
		this.openJobPositions = openJobPositions;
	}

	public LocalDate getLastRecourseDate() {
		return lastRecourseDate;
	}

	public void setLastRecourseDate(LocalDate lastRecourseDate) {
		this.lastRecourseDate = lastRecourseDate;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
