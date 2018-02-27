package sondage.models.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.amdelamar.jhash.Hash;
import com.amdelamar.jhash.exception.InvalidHashException;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void createUser(User user) {
		try {
			String pwd = encrypt(user.getPassword());
			this.userDAO.createUser(new User(user.getName(), user.getEmail(), pwd));
		} catch (UserAlreadyExistException e){
			// No creation is needed
		}
	}

	@Override
	public boolean doesUserExists(String email) {
		boolean isFound = false;
		try {
			this.userDAO.findUserByEmail(email);
			isFound = true;
		} catch (UserNotFoundException e){
			isFound = false;
		}
		return isFound;
	}

	@Override
	public User findUser(String email) {
		User user = null;
		try {
			user = this.userDAO.findUserByEmail(email);
		} catch (UserNotFoundException e){ 
			user = null;
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		this.userDAO.updateUser(new User(user.getName(), user.getEmail(), encrypt(user.getPassword())));

	}

	@Override
	public boolean authenticateUser(User user) {
		User storedUser = this.findUser(user.getEmail());
		if(storedUser == null){
			return false;
		} else {
			try {
				return Hash.password(user.getPassword().toCharArray()).verify(storedUser.getPassword());
			} catch (InvalidHashException e) {
				return false;
			}
		}
	}
	
	private String encrypt(String password){
		char[] pwd = password.toCharArray();
		
		return Hash.password(pwd).create();
	}

}
