package sondage.models.choice;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ChoiceDAOImpl implements ChoiceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public void createChoice(Choice c) {
		Session session = this.sessionFactory.getCurrentSession();
		
		TypedQuery<Choice> query = (TypedQuery<Choice>) session.getNamedQuery("createChoice");
		query.setParameter("name", c.getName());
		query.setParameter("pollId", c.getPollId());
		query.setParameter("question", c.getQuestion());
		query.setParameter("score", c.getScore());
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteChoice(Choice c) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Choice> query = (TypedQuery<Choice>) session.getNamedQuery("deleteChoice");
		query.setParameter("name", c.getName());
		query.setParameter("pollId", c.getPollId());
		
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateChoice(Choice c) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Choice> query = (TypedQuery<Choice>) session.getNamedQuery("updateChoice");
		query.setParameter("name", c.getName());
		query.setParameter("pollId", c.getPollId());
		query.setParameter("score", c.getScore());
		
		query.executeUpdate();
		

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Choice findChoice(Long pollId, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Choice> query = (TypedQuery<Choice>) session.getNamedQuery("deleteChoice");
		query.setParameter("name", name);
		query.setParameter("pollId", pollId);
		
		Choice choice = (Choice) query.getSingleResult();

		return choice;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteChoices(Long pollId) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Choice> query = (TypedQuery<Choice>) session.getNamedQuery("deletePoll");
	
		query.setParameter("pollId", pollId);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Choice> getChoices(Long pollId) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Choice> query = (TypedQuery<Choice>) session.getNamedQuery("findPollById");
		
		query.setParameter("pollId", pollId);
		
		List<Choice> choices = (List<Choice>) query.getResultList();
		return choices;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Choice> getChoices(String question) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Choice> query = (TypedQuery<Choice>) session.getNamedQuery("findPollByQuestion");
		
		query.setParameter("question", question);
		
		List<Choice> choices = (List<Choice>) query.getResultList();
		return choices;
	}

}
