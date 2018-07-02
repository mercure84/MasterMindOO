package Jeu;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;

public interface Jouable {

	
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA);
	
	public void jouerDefenseur();
	
	//méthode où l'humain est invité à donner un indice à l'IA
	public void joueurIndique();

	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA);
	
}
