package sondage.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="Choix")
@Table(name="TABLE")
@NamedQueries({
	@NamedQuery(name="chercherChoix",query = "from Choix c where c.title = : title"),
	@NamedQuery(name="modifierChoix", query="update Choix set score = :score where titre =:titre"),
	@NamedQuery(name="supprimerChoix", query="delete from Choix where titre:=titre"),
	@NamedQuery(name="creerChoix", query="insert into Choix(titre, score) values(:titre, :score)")
})
public class Choix implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private Long score;
	@Column
	private String  titre;
	
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public Choix() {}
	
}
