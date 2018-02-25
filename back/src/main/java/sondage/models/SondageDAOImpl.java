package sondage.models;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SondageDAOImpl implements SondageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public int modifier(Sondage sondage) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Sondage> query = (TypedQuery<Sondage>) session.getNamedQuery("modifierSondage");
		query.setParameter("titre", sondage.getTitre());
		query.setParameter("question", sondage.getQuestion());
		query.setParameter("choix", sondage.getChoix());
		int total = query.getMaxResults();
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int creer(Sondage sondage) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Sondage> query = (TypedQuery<Sondage>) session.getNamedQuery("creerSondage");
		query.setParameter("titre", sondage.getTitre());
		query.setParameter("question", sondage.getQuestion());
		query.setParameter("choix", sondage.getChoix());
		int total = query.getMaxResults();
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int supprimer(Sondage sondage) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Sondage> query = (TypedQuery<Sondage>) session.getNamedQuery("supprimerSondage");
		query.setParameter("titre", sondage.getTitre());
		
		int total = query.getMaxResults();
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Sondage chercher(String titre) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<Sondage> query = (TypedQuery<Sondage>) session.getNamedQuery("supprimerSondage");
		query.setParameter("titre", titre);
		
		Sondage sondage = query.getSingleResult();
		
		return sondage;
	}

}
