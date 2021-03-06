package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class Job {
	
	public Job(int id, String jobTitle) {
		this.id = id;
		this.jobTitle = jobTitle;
	}
	public Job() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_gen")
	@Column(name="job_id")
	private int id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@OneToMany(mappedBy = "job")
	private List<JobAdvertisement> jobAdvertisements;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public List<JobAdvertisement> getJobAdvertisements() {
		return jobAdvertisements;
	}
	public void setJobAdvertisements(List<JobAdvertisement> jobAdvertisements) {
		this.jobAdvertisements = jobAdvertisements;
	}

}
