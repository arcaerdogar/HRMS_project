package hrms.hrms.entities.absracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verifications")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Verification {
	public Verification(int verificationId, boolean emailVerification) {
		this.verificationId = verificationId;
		this.emailVerification = emailVerification;
	}
	public Verification() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="verification_id")
	private int verificationId;
	
	@Column(name="email_verification")
	private boolean emailVerification;

	
	public int getVerificationId() {
		return verificationId;
	}
	public void setVerificationId(int verificationId) {
		this.verificationId = verificationId;
	}
	public boolean isEmailVerification() {
		return emailVerification;
	}
	public void setEmailVerification(boolean emailVerification) {
		this.emailVerification = emailVerification;
	}
}
