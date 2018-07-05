package Jeu;

import java.util.ArrayList;
import java.util.List;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;

public class MasterMind extends Game {
	int nbCouleurs;
	int nbCases;
	
	public MasterMind() {
		super();
		this.typeJeu = ChoixJeu.MASTERMIND;
		this.nbCouleurs = paramJeu.getNbCouleursMM();
		this.nbCases = paramJeu.getNbCasesMM();

	}

	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA) {

		// l'IA génère une combinaison à trouver par le joueur
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases, this.paramJeu.ensembleCouleurs);
		System.out.println("Les couleurs disponibles sont : " + this.paramJeu.ensembleCouleurs + ", nous jouons sur "
				+ this.paramJeu.getNbCasesMM() + " cases");
		if (modeDev) {
			System.out.println(
					"le mode dev est activé, la combinaison de l'IA est " + joueurIA.combinaisonJoueur.combinaisonMMD);
		}

		System.out.println("Quelle est votre proposition ?");

		do {
			nbEssais++;
			String propositionJoueur = sc.nextLine();
			propositionJoueur = propositionJoueur.toUpperCase();
			int[] retour = new int[2];
			// je convertis mon string en ArrayList
			List<Character> propositionJ = new ArrayList();

			for (int k = 0; k < propositionJoueur.length(); k++) {
				propositionJ.add(propositionJoueur.charAt(k));
			}

			retour = joueurH.comparer(propositionJ, joueurIA.combinaisonJoueur.combinaisonMMD);
			System.out.println(" --> Pions bien placés : " + retour[0] + ", Pions mal placés : " + retour[1]);

			if (joueurH.gagne) {
				System.out.println("Vous avez gagné !");
				this.partieFinie = true;
			}


		} while (!this.endGame(partieFinie, nbEssais, joueurIA.combinaisonJoueur.combinaisonMMD, false));

	}

	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA) {

		// l'IA génère l'ensemble des combinaisons possibles
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases, this.paramJeu.ensembleCouleurs,
				ModeJeu.DEFENSEUR);
		System.out.println("Les couleurs disponibles sont : " + this.paramJeu.ensembleCouleurs + ", nous jouons sur "
				+ this.paramJeu.getNbCasesMM() + " cases");
		System.out.println("Mémorisez bien une combinaison ! l'IA va tenter de la deviner");
		partieFinie = false;

		do {
			nbEssais++;
			joueurIA.proposerCombinaisonMM();
			int[] indice = joueurH.joueurIndiqueMM();
			joueurIA.nettoyerCombinaisonsMM(indice);
			if (joueurIA.gagne) {
				System.out.println("l'IA a gagné !");
				this.partieFinie = true;
				
			}
			
			if (joueurIA.IAbug) {
				this.partieFinie = true;
			}

		} while (!this.endGame(partieFinie, nbEssais, joueurIA.combinaisonJoueur.combinaisonMMD, joueurIA.IAbug));

	}
}
