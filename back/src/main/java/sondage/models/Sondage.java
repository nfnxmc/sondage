package sondage.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Sondage")
@Table(name = "SONDAGE")
@NamedQueries({
	@NamedQuery(name="creeSondage", query="insert into Sondage(titre,question) values(:titre, :question)"),
	@NamedQuery(name="modifierSondage", query="update sondage set titre = :titre, question =: question where titre =:titre"),
	@NamedQuery(name="supprimerSondage", query="delete from Sondage where titre = :titre"),
	@NamedQuery(name="chercherSondage", query="select from Sondage where titre = :titre")
})
public class Sondage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String titre;
	
	@Column
	private String question;
	
	@OneToMany(mappedBy="Sondage", cascade =CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Choix> choix;
	
	public Sondage() {}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Choix> getChoix() {
		return choix;
	}

	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
}
