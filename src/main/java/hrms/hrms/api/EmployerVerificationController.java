package hrms.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.verificationServices.EmployerVerificationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.verifications.EmployerVerification;

@RestController
@RequestMapping("/api/employerverifications")
public class EmployerVerificationController {
	EmployerVerificationService employerVerificationService;

	public EmployerVerificationController(EmployerVerificationService employerVerificationService) {
		this.employerVerificationService = employerVerificationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployerVerification>> getAll(){
		return employerVerificationService.getAll();
	}
	
	@GetMapping("/getbyverificationid")
	public DataResult<EmployerVerification> getByVerificationId(int id){
		return employerVerificationService.getByVerificationId(id);
	}
	
}
