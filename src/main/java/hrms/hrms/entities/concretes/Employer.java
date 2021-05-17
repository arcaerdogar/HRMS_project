package hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import hrms.hrms.entities.abstracts.User;

@Entity
@Table(name="employers")
public class Employer extends User{

	public Employer(int id, String email, String password,String companyName,String phoneNumber,Date birthDate) {
		super(id, email, password);
		this.companyName=companyName;
		this.birthDate=birthDate;
		this.phoneNumber=phoneNumber;
	}
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="birth_date")
	private Date birthDate;
	
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
