package Jeu;

import java.util.ArrayList;
import java.util.List;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;


public class CombinaisonSecrete extends Game {

	
	int nbCases;
	public CombinaisonSecrete() {
		super();
		this.typeJeu = ChoixJeu.COMBINAISON_SECRETE;
		this.nbCases = paramJeu.getNbCasesCS();

	}

	/**
	 * m�thode pour jouer le mode challenger de CS
	 */
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA) {

		// l'IA g�n�re une combinaison � trouver par le joueur
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases);
		if (modeDev) {
			System.out.println(
					"le mode dev est activ�, la combinaison de l'IA est " + joueurIA.combinaisonJoueur.combinaisonCSD);
		}

		System.out.println("Quelle est votre proposition ?");

		do {
			nbEssais++;
			String propositionJoueur = sc.nextLine();
			this.partieFinie = joueurIA.comparer(propositionJoueur, joueurIA.combinaisonJoueur.combinaisonCSD);

		} while (!this.endGame(this.partieFinie, nbEssais, joueurIA.combinaisonJoueur.combinaisonCSD, false));

	}

	/**
	 * m�thode pour jouer le mode d�fenseur de CS
	 */
	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA) {

		System.out.println(
				("Nous vous invitons � bien m�moriser votre combinaison, L'IA va tenter de la deviner avec un algorithme tr�s puissant !"));
		String propositionIA = "";

		// cr�ation de la combinaison de d�part : on demande une combinaison al�atoire
		
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases);

		
		do {

			propositionIA = "";
			nbEssais++;
			// formatage en string de la proposition de l'IA
			for (int i = 0; i < joueurIA.combinaisonJoueur.combinaisonCS.size(); i++) {

				propositionIA += joueurIA.combinaisonJoueur.combinaisonCS.get(i) + " ";

			}
			System.out.println("L'IA propose : " + propositionIA);
			

			String indice = joueurH.joueurIndiqueCS(joueurIA.combinaisonJoueur.combinaisonCS);
			this.partieFinie = joueurIA.ajusterCombinaisonCS(indice, joueurIA.combinaisonJoueur.combinaisonCS);

		} while (!this.endGame(this.partieFinie, nbEssais, joueurIA.combinaisonJoueur.combinaisonCS, false));

	}




public void jouerDuel(JoueurHumain joueurH, JoueurIA joueurIA) {
	
	boolean gagneIA = false;
	boolean gagneJ = false;
	List <Integer> winProposition = new ArrayList();
	// l'IA g�n�re une combinaison � trouver par le joueur
	joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases);
	
	System.out.println("L'IA a d�termin� sa combinaison personnelle, � vous de m�moriser la v�tre !");
	if (modeDev) {
		System.out.println(
				"le mode dev est activ�, la combinaison de l'IA est " + joueurIA.combinaisonJoueur.combinaisonCSD);
	}

	do {
		
		
		
		// joueur humain joue
		nbEssais++;
		System.out.println("Quelle est votre proposition ?");
		String propositionJoueur = sc.nextLine();
		gagneJ = joueurIA.comparer(propositionJoueur, joueurIA.combinaisonJoueur.combinaisonCSD);
		
		// joueur IA joue
		String propositionIA = "";
		nbEssais++;
		for (int i = 0; i < joueurIA.combinaisonJoueur.combinaisonCS.size(); i++) {

			propositionIA += joueurIA.combinaisonJoueur.combinaisonCS.get(i) + " ";

		}
		System.out.println("L'IA propose : " + propositionIA);
		

		String indice = joueurH.joueurIndiqueCS(joueurIA.combinaisonJoueur.combinaisonCS);
		gagneIA = joueurIA.ajusterCombinaisonCS(indice, joueurIA.combinaisonJoueur.combinaisonCS);
		
		if (gagneIA || gagneJ) {
			if (gagneIA) {System.out.println("L'IA a gagn� !");
			winProposition = joueurIA.combinaisonJoueur.combinaisonCS;
			
			} 
			if (gagneJ) {System.out.println("Vous avez gagn� !");
			winProposition = joueurIA.combinaisonJoueur.combinaisonCSD;}
			this.partieFinie = true;
		}
		

	} while (!this.endGame(this.partieFinie, nbEssais, winProposition, false));
	
	
	
	
	

}
	
	
	
}
