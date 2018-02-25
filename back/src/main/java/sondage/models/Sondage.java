package sondage.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Sondage")
@Table(name = "SONDAGE")
public class Sondage {
	private String titre;
	private String question;
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
