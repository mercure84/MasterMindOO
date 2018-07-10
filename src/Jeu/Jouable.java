package Jeu;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;


/**
 * interface qui permet de valider que chaque jeu est jouable avec les 3 modes
 * @author julie
 *
 */
public interface Jouable {

	
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA);
	
	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA);
	
	public void jouerDuel(JoueurHumain joueurH, JoueurIA joueurIA);
	
	//méthode pour MasterMind Ultra
	public void startAlgo(JoueurIA ia1, JoueurIA ia2);
	
}
