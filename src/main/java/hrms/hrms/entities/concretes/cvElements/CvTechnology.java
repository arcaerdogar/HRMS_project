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
import hrms.hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="CvTechnologies")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCv"})
public class CvTechnology {

	public CvTechnology(int id, JobSeekerCV jobSeekerCv, Technology technology) {
		super();
		this.id = id;
		this.jobSeekerCv = jobSeekerCv;
		this.technology = technology;
	}
	public CvTechnology() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_technology_id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private JobSeekerCV jobSeekerCv;
	
	@ManyToOne()
	@JoinColumn(name="technology_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvTechnology"})
	private Technology technology;

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
	public Technology getTechnology() {
		return technology;
	}
	public void setTechnology(Technology technology) {
		this.technology = technology;
	} 
	
	
}
