package hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hrms.hrms.entities.absracts.User;
import hrms.hrms.entities.concretes.verifications.JobSeekerVerification;

@Entity
@Table(name="job_seekers")
public class JobSeeker extends User{

	
	
	public JobSeeker(int id, String email, String password, String firstName, String lastName, String nationalId,
			LocalDate birthDate, boolean isActive, JobSeekerVerification verification) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.birthDate = birthDate;
		this.isActive = isActive;
		this.verification = verification;
	}
	public JobSeeker() {
		
	}
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_id")
	private String nationalId;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verification_id")
	private JobSeekerVerification verification;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void activate() {
		this.isActive = true;
	}
	public void deActivate() {
		this.isActive = false;
	}

	public JobSeekerVerification getVerification() {
		return verification;
	}

	public void setVerification(JobSeekerVerification verification) {
		this.verification = verification;
	}
}
