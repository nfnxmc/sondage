package sondage.models;

public interface SondageDAO {

	public Sondage modifier(Sondage sondage);
	public Sondage creer(Sondage sondage);
	public Sondage supprimer(Sondage sondage);
	public Sondage chercher(String titre);
}
