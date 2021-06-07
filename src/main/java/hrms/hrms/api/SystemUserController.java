package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.SystemUserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemusers")
public class SystemUserController {
	
	SystemUserService systemUserService;

	@Autowired
	public SystemUserController(SystemUserService systemUserService) {
		this.systemUserService = systemUserService;
	}
	
	@PostMapping("/register")
	public Result register(SystemUser systemUser) {
		return systemUserService.register(systemUser);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SystemUser>> getAll(){
		return systemUserService.getAll();
	}
}
