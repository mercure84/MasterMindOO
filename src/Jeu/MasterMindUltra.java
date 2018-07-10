package Jeu;

import java.util.ArrayList;
import java.util.List;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;

public class MasterMindUltra extends MasterMind {

	int nbParties = 1;
	int nbEssais = 0;

	public MasterMindUltra() {
		super();
		this.typeJeu = ChoixJeu.MASTERMINDULTRA;
		System.out.println("Combien de parties souhaitez vous lancer ?");
		this.nbParties = sc.nextInt();
		sc.nextLine();

	}

	/**
	 * algorithme qui permet de faire jouer l'ordinateur tout seul sur un nombres de parties donn�es (mastermind)
	 */
	public void startAlgo(JoueurIA IA, JoueurIA IA2) {
		System.out.println("Les couleurs disponibles sont : " + this.paramJeu.ensembleCouleurs + ", nous jouons sur "
				+ this.paramJeu.getNbCasesMM() + " cases");

		int nbTour = 0;
		
		int nbEssaisTot = 0;
		float tourMoyen;

		do {

			IA = new JoueurIA();
			IA2 = new JoueurIA();
			this.nbEssais = 0;

			boolean gagneIA1 = false;

			// l'IA g�n�re l'ensemble des combinaisons possibles
			IA.combinaisonJoueur = new Combinaison(ChoixJeu.MASTERMIND, this.nbCases, this.paramJeu.ensembleCouleurs,
					ModeJeu.DUEL);

			// l'IA2 g�n�re une combinaison al�atoire
			IA2.combinaisonJoueur = new Combinaison(ChoixJeu.MASTERMIND, this.nbCases, this.paramJeu.ensembleCouleurs);
			System.out.println("� trouver = " + IA2.combinaisonJoueur.combinaisonMM);

			do {

				this.nbEssais++;

				IA.proposerCombinaisonMM();
				int[] retour = new int[2];
				retour = IA.comparer(IA.combinaisonJoueur.combinaisonMMD, IA2.combinaisonJoueur.combinaisonMM);
				System.out.println(" --> Pions bien plac�s : " + retour[0] + ", Pions mal plac�s : " + retour[1]);
				IA.nettoyerCombinaisonsMM(retour);

			} while (!this.endGame(this.nbEssais, IA.IAbug, IA2, IA));

			nbTour++;
			nbEssaisTot += nbEssais;

		} while (nbTour < nbParties);

		tourMoyen = (float) nbEssaisTot / (float) this.nbParties;

		System.out.println("Nous avons jou� " + this.nbParties + " parties qui ont �t� r�solues en " + nbEssaisTot
				+ " tours, soit " + tourMoyen + " essais par partie !");

	}

}
