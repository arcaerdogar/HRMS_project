package hrms.hrms.entities.concretes;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hrms.hrms.entities.absracts.User;
import hrms.hrms.entities.concretes.verifications.EmployerVerification;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@NoArgsConstructor
public class Employer extends User{

	
	
	public Employer(int id, String email, String password, String companyName, String phoneNumber, boolean isActive,
			EmployerVerification verification) {
		super(id, email, password);
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.isActive = isActive;
		this.verification = verification;
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
