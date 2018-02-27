package sondage.models.user;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="User")
@NamedQueries({
	@NamedQuery(name="createUser", query="insert into User(name, email, password) values (:name, :email, :password)"),
	@NamedQuery(name="deleteUser", query="delete from User where email=:email and password=:password"),
	@NamedQuery(name="updateUser", query="update User set password=:password where email=:email"),
	@NamedQuery(name="findUserByEamil", query="select from User where email=:email"),
	@NamedQuery(name="findUserByName", query="select from User where name=:name")
})
public class User {
	private String name;
	private String email;
	private String password;
	
	public User(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
