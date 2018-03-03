package poll.models.poll;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PollDAOImpl implements PollDAO {

	@Autowired 
	SessionFactory sessionFactory;
	
	@Autowired
	ChoiceDAO choiceDAO;
	
	@Override
	public void createPoll(String question, List<Choice> choices, Long ownerId) {
		Session session = this.sessionFactory.getCurrentSession();
		Poll p = new Poll(question, choices, ownerId);
		session.save(p);
		

	}

	@Override
	public void updatePoll(Poll p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);

	}

	@Override
	public void deletePoll(Long pollId) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		TypedQuery<Poll> query = (TypedQuery<Poll>) session.getNamedQuery("deletePoll");
		query.setParameter("pollId", pollId);
		query.executeUpdate();

	}

	@Override
	public Poll findPollById(Long pollId) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		TypedQuery<Poll> query = (TypedQuery<Poll>) session.getNamedQuery("findPollById");
		query.setParameter("pollId", pollId);
		
		return query.getSingleResult();
	}
	
	@Override
	public List<Poll> findPollByOwernId(Long ownerId){
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		TypedQuery<Poll> query = (TypedQuery<Poll>) session.getNamedQuery("findPollByOwnerId");
		query.setParameter("pollId", ownerId);
		
		return query.getResultList();
	}

}
