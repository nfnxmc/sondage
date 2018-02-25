package sondage.models;

public interface ChoixDAO {

	public Choix modifier(Choix choix);
	public Choix creer(Choix choix);
	public Choix supprimer(Choix choix);
	public Choix chercher(String titre);
}
