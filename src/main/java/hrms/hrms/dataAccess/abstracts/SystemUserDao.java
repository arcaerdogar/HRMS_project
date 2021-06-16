package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.users.SystemUser;

public interface SystemUserDao extends JpaRepository<SystemUser, Integer>{

}
