package sondage.models;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ChoixDAOImpl implements ChoixDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int modifier(Choix choix) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		TypedQuery<Choix> query = (TypedQuery<Choix>) session.getNamedQuery("modifierChoix");
		query.setParameter("titre", choix.getTitre());
		return query.getMaxResults();
	}

	@Override
	public int creer(Choix choix) {
		Session session = this.sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		TypedQuery<Choix> query = (TypedQuery<Choix>) session.getNamedQuery("creerChoix");
		query.setParameter("titre", choix.getTitre());
		query.setParameter("score", choix.getScore());
		
		return  query.getMaxResults();
	}

	@Override
	public int supprimer(Choix choix) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		TypedQuery<Choix> query = (TypedQuery<Choix>) session.getNamedQuery("supprimerChoix");
		query.setParameter("titre", choix.getTitre());
		
		return query.getMaxResults();

	}

	@Override
	public Choix chercher(String titre) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		TypedQuery<Choix> query = (TypedQuery<Choix>) session.getNamedQuery("chercherChoix");
		query.setParameter("titre", titre);
		Choix _choix = query.getSingleResult();
		return _choix;
	}

}
