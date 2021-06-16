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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="CvLinks")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCv"})
public class CvLink {
	
	public CvLink(int linkId, String linkTitle, String linkUrl, JobSeekerCV jobSeekerCv) {
		this.linkId = linkId;
		this.linkTitle = linkTitle;
		this.linkUrl = linkUrl;
		this.jobSeekerCv = jobSeekerCv;
	}

	public CvLink() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="link_id")
	private int linkId;
	
	@Column(name="link_title")
	private String linkTitle;
	
	@Column(name="link_url")
	private String linkUrl;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private JobSeekerCV jobSeekerCv;

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public JobSeekerCV getJobSeekerCv() {
		return jobSeekerCv;
	}

	public void setJobSeekerCv(JobSeekerCV jobSeekerCv) {
		this.jobSeekerCv = jobSeekerCv;
	}
}
