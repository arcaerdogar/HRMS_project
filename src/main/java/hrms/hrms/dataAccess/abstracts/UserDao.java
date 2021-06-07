package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.absracts.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
