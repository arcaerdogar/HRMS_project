package hrms.hrms.entities.concretes.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import hrms.hrms.entities.absracts.User;

@Entity
@Table(name="system_users")
public class SystemUser extends User{

	public SystemUser(int id, String email, String password, String profilePhotoUrl, String firstName,
			String lastName) {
		super(id, email, password, profilePhotoUrl);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public SystemUser() {
	}
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
