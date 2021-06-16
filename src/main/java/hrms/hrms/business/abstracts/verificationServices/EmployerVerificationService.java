package hrms.hrms.business.abstracts.verificationServices;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.verifications.EmployerVerification;

public interface EmployerVerificationService {
	DataResult<List<EmployerVerification>> getAll();
	DataResult<EmployerVerification> getByVerificationId(int id);
}
