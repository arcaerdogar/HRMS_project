package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.hrms.entities.concretes.cvElements.CvSchool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="schools")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCvs"})
public class School {
	

	public School(int schoolId, String schoolName, List<CvSchool> cvSchool) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.cvSchool = cvSchool;
	}
	public School() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	
	@Column(name="school_name")
	private String schoolName;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "school")
	private List<CvSchool> cvSchool;

	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public List<CvSchool> getCvSchool() {
		return cvSchool;
	}
	public void setCvSchool(List<CvSchool> cvSchool) {
		this.cvSchool = cvSchool;
	}
	
}
