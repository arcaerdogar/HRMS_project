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
@Table(name="CvPhotos")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCv"})
public class CvPhoto {

	public CvPhoto(int cvPhotoId, String photoUrl, JobSeekerCV jobSeekerCv) {
		super();
		this.cvPhotoId = cvPhotoId;
		this.photoUrl = photoUrl;
		this.jobSeekerCv = jobSeekerCv;
	}
	public CvPhoto() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_photo_id")
	private int cvPhotoId;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private JobSeekerCV jobSeekerCv;

	public int getCvPhotoId() {
		return cvPhotoId;
	}

	public void setCvPhotoId(int cvPhotoId) {
		this.cvPhotoId = cvPhotoId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public JobSeekerCV getJobSeekerCv() {
		return jobSeekerCv;
	}

	public void setJobSeekerCv(JobSeekerCV jobSeekerCv) {
		this.jobSeekerCv = jobSeekerCv;
	}
}
