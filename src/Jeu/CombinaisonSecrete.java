package Jeu;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;
import Tools.Comparaison;

public class CombinaisonSecrete extends Game {

	boolean gagne = false;
	int nbCases;


	public CombinaisonSecrete() {
		super();
		this.typeJeu = ChoixJeu.COMBINAISON_SECRETE;
		this.nbCases = paramJeu.getNbCasesCS();
		System.out.println("CS cr��");
	}

	/**
	 * m�thode pour jouer le mode challenger de CS
	 */
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA) {

		// l'IA g�n�re une combinaison !
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases);

		if (modeDev) {
			System.out.println(
					"le mode dev est activ�, la combinaison de l'IA est " + joueurIA.combinaisonJoueur.combinaisonCS);
		}

		System.out.println("Quelle est votre proposition ?");

		do {
			nbEssais++;
			String propositionJoueur = sc.nextLine();
			gagne = joueurIA.comparer(propositionJoueur, joueurIA.combinaisonJoueur.combinaisonCS);

		} while (!this.endGame(gagne, nbEssais, joueurIA.combinaisonJoueur.combinaisonCS));

	}

	/**
	 * m�thode pour jouer le mode d�fenseur de CS
	 */
	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA) {

		System.out.println(
				("Nous vous invitons � bien m�moriser votre combinaison, L'IA va tenter de la deviner avec un algorithme tr�s puissant !"));
		String propositionIA = "";

		// cr�ation de la comibinaison de d�part : on demande une combinaison al�atoire
		// et la vide !
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases, ModeJeu.DEFENSEUR);

		gagne = false;
		do {

			propositionIA = "";
			nbEssais++;
			for (int i = 0; i < joueurIA.combinaisonJoueur.combinaisonCS.size(); i++) {

				propositionIA += joueurIA.combinaisonJoueur.combinaisonCS.get(i) + " ";

			}
			System.out.println("L'IA propose : " + propositionIA);
			

			String indice = joueurH.joueurIndiqueCS(joueurIA.combinaisonJoueur.combinaisonCS);
			gagne = joueurIA.ajusterCombinaisonCS(indice, joueurIA.combinaisonJoueur.combinaisonCS);

		} while (!this.endGame(gagne, nbEssais, joueurIA.combinaisonJoueur.combinaisonCS));

	}




public void jouerDuel(JoueurHumain joueurH, JoueurIA joueurIA) {
	
	
	
	
	
	
	
}}
