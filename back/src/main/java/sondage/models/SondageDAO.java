package sondage.models;

public interface SondageDAO {

	public int modifier(Sondage sondage);
	public int creer(Sondage sondage);
	public int supprimer(Sondage sondage);
	public Sondage chercher(String titre);
}
