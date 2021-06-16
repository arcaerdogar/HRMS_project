package hrms.hrms.entities.concretes.verifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hrms.hrms.entities.absracts.Verification;
import hrms.hrms.entities.concretes.users.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employer_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerVerification extends Verification{
	
	public EmployerVerification(int id, boolean emailVerification, boolean systemPersonnelVerification) {
		super(id, emailVerification);
		this.systemPersonnelVerification = systemPersonnelVerification;
	}
	
	public EmployerVerification() {

	}

	@Column(name="system_personnel_verification")
	private boolean systemPersonnelVerification;
	
	@OneToOne(mappedBy = "verification")
	private Employer employer;

	public boolean isSystemPersonnelVerification() {
		return systemPersonnelVerification;
	}
	
	public void setSystemPersonnelVerification(boolean systemPersonnelVerification) {
		this.systemPersonnelVerification = systemPersonnelVerification;
	}
	
}
