package sondage.models;

public interface ChoixDAO {

	public int modifier(Choix choix);
	public int creer(Choix choix);
	public int supprimer(Choix choix);
	public Choix chercher(String titre);
}
