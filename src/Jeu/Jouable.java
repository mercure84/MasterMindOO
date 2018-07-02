package Jeu;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;

public interface Jouable {

	
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA);
	
	public void jouerDefenseur();
	
	//m�thode o� l'humain est invit� � donner un indice � l'IA
	public void joueurIndique();

	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA);
	
}
