package sondage.models.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="User", uniqueConstraints=@UniqueConstraint(columnNames={"Email"}))
@NamedQueries({
	@NamedQuery(name="createUser", query="insert into User(name, email, password) values (:name, :email, :password)"),
	@NamedQuery(name="deleteUser", query="delete from User where email=:email and password=:password"),
	@NamedQuery(name="updateUser", query="update User set password=:password where email=:email"),
	@NamedQuery(name="findUserByEamil", query="select from User where email=:email"),
	@NamedQuery(name="findUserByName", query="select from User where name=:name")
})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column
	private String name;
	@Column(name="Email")
	private String email;
	@Column
	private String password;
	
	public User(){}

	public User(String _name, String _email, String _password) {
		this.name = _name;
		this.email = _email;
		this.password = _password;
	}

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
