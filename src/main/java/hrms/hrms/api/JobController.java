package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.dataAccess.abstracts.JobDao;
import hrms.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	JobDao jobDao;
	
	@Autowired
	JobController(JobDao jobDao){
		this.jobDao=jobDao;
	}
	
	@GetMapping("/getall")
	public List<Job> getAll(){
		return this.jobDao.findAll();
	}

}
