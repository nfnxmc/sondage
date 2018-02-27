package sondage.models.user;

public interface UserDAO {

	public void createUser(User u) throws UserAlreadyExistException;
	public void updateUser(User u);
	public void deleteUser(User u);
	public User findUserByEmail(String email) throws UserNotFoundException;
}
