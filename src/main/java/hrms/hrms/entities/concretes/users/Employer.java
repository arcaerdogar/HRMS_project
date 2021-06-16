package hrms.hrms.entities.concretes.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.hrms.entities.absracts.User;
import hrms.hrms.entities.concretes.JobAdvertisement;
import hrms.hrms.entities.concretes.verifications.EmployerVerification;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class Employer extends User{

	public Employer(int id, String email, String password, String profilePhotoUrl, String companyName,
			String phoneNumber, boolean isActive, EmployerVerification verification,
			List<JobAdvertisement> jobAdvertisements) {
		super(id, email, password, profilePhotoUrl);
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.isActive = isActive;
		this.verification = verification;
		this.jobAdvertisements = jobAdvertisements;
	}
	public Employer() {
		
	}
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="verification_id")
	private EmployerVerification verification;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employer",orphanRemoval = true)
	private List<JobAdvertisement> jobAdvertisements;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isActive() {
		return isActive;
	}
	public void activate() {
		this.isActive = true;
	}
	public void deActivate() {
		this.isActive=false;
	}
	public EmployerVerification getVerification() {
		return verification;
	}
	public void setVerification(EmployerVerification verification) {
		this.verification = verification;
	}
}
