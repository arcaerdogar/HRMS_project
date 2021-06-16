package hrms.hrms.entities.concretes.verifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hrms.hrms.entities.absracts.Verification;
import hrms.hrms.entities.concretes.users.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seeker_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerVerification extends Verification{

	public JobSeekerVerification(int id, boolean emailVerification, boolean mernisVerification) {
		super(id, emailVerification);
		this.mernisVerification = mernisVerification;
	}
	
	public JobSeekerVerification() {
		
	}

	@Column(name="mernis_verification")
	private boolean mernisVerification;
	
	@OneToOne(mappedBy ="verification")
	private JobSeeker jobSeeker;

	public boolean isMernisVerification() {
		return mernisVerification;
	}

	public void setMernisVerification(boolean mernisVerification) {
		this.mernisVerification = mernisVerification;
	}
}
