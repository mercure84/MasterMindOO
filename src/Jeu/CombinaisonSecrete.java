package Jeu;

import java.util.ArrayList;
import java.util.List;

import Joueur.Combinaison;
import Joueur.JoueurHumain;
import Joueur.JoueurIA;


class CombinaisonSecrete extends Game {

	
	int nbCases;
	public CombinaisonSecrete(Parametres param) {
		super(param);
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
			joueurIA.comparer(propositionJoueur, joueurIA.combinaisonJoueur.combinaisonCSD, joueurH);
			

		} while (!this.endGame(nbEssais, false, joueurIA, joueurH));

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

		} while (!this.endGame(nbEssais, joueurIA.IAbug, joueurIA, joueurH));

	}




public void jouerDuel(JoueurHumain joueurH, JoueurIA joueurIA) {
	
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
		System.out.println("Quelle est VOTRE proposition de combinaison ?");
		String propositionJoueur = sc.nextLine();
		joueurIA.comparer(propositionJoueur, joueurIA.combinaisonJoueur.combinaisonCSD, joueurH);
		
		// joueur IA joue
		String propositionIA = "";
		
		for (int i = 0; i < joueurIA.combinaisonJoueur.combinaisonCS.size(); i++) {

			propositionIA += joueurIA.combinaisonJoueur.combinaisonCS.get(i) + " ";

		}
		System.out.println("L'IA propose : " + propositionIA);
		

		String indice = joueurH.joueurIndiqueCS(joueurIA.combinaisonJoueur.combinaisonCS);
		joueurIA.ajusterCombinaisonCS(indice, joueurIA.combinaisonJoueur.combinaisonCS);

		

	} while (!this.endGame(nbEssais, joueurIA.IAbug, joueurIA, joueurH));
	
	
	
	
	

}
	
	
	
}
