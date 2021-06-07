package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobs")
@AllArgsConstructor
@NoArgsConstructor
public class Job {
	public Job(int id, String jobTitle) {
		this.id = id;
		this.jobTitle = jobTitle;
	}
	public Job() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_gen")
	@Column(name="id")
	private int id;
	
	@Column(name="job_title")
	private String jobTitle;

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

}
