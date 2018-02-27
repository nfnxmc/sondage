package sondage.models.user;

public interface UserService {

	public void createUser(User user);
	public boolean doesUserExists(String email);
	public User findUser(String email);
	public void updateUser(User user);
	public boolean authenticateUser(User user);
}
