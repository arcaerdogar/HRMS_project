package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.absracts.User;

public interface UserService {
	Result register(User user);
	DataResult<List<User>> getAll();
}
