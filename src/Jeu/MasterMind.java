package Jeu;
import java.util.ArrayList;
import java.util.List;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;

public class MasterMind extends Game {
	int nbCouleurs ;
	int nbCases;
	

	
	public MasterMind() {
		super();
		this.typeJeu = ChoixJeu.MASTERMIND;
		this.nbCouleurs = paramJeu.getNbCouleursMM();
		this.nbCases = paramJeu.getNbCasesMM();
		System.out.println("MM créé");
		
		
	}
	
	
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA) {
		
	}
	
	

}
