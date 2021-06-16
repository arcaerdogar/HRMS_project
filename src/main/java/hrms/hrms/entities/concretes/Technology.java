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

import hrms.hrms.entities.concretes.cvElements.CvTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="technologies")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCvs"})
public class Technology {
	
	public Technology(int technologyId, String technologyName, List<CvTechnology> cvTechnology) {
		super();
		this.technologyId = technologyId;
		this.technologyName = technologyName;
		this.cvTechnology = cvTechnology;
	}
	public Technology() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="technology_id")
	private int technologyId;
	
	@Column(name="technology_name")
	private String technologyName;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "technology")
	private List<CvTechnology> cvTechnology;

	public int getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}
	public String getTechnologyName() {
		return technologyName;
	}
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	public List<CvTechnology> getCvTechnology() {
		return cvTechnology;
	}
	public void setCvTechnology(List<CvTechnology> cvTechnology) {
		this.cvTechnology = cvTechnology;
	}

}
