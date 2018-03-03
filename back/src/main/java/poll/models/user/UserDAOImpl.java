package poll.models.user;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public void createUser(User u) throws UserAlreadyExistException {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<User> query = (TypedQuery<User>) session.getNamedQuery("createUser");
		query.setParameter("name", u.getName());
		query.setParameter("email", u.getEmail());
		query.setParameter("password", u.getPassword());
		
		try {
			query.executeUpdate();
		} catch(Exception e){
			throw new UserAlreadyExistException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<User> query = (TypedQuery<User>) session.getNamedQuery("updateUser");
		query.setParameter("email", u.getEmail());
		query.setParameter("password", u.getPassword());
		
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<User> query = (TypedQuery<User>) session.getNamedQuery("deleteUser");
		query.setParameter("email", u.getEmail());
		query.setParameter("password", u.getPassword());
		
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByEmail(String email) throws UserNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<User> query = (TypedQuery<User>) session.getNamedQuery("updateUser");
		query.setParameter("email", email);
		
		User user = query.getSingleResult();
	
		return user;
	}

}
