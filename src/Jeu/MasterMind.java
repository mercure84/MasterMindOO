package Jeu;

import java.util.ArrayList;
import java.util.List;

import Joueur.Combinaison;
import Joueur.Joueur;
import Joueur.JoueurIA;
import Joueur.JoueurHumain;

public class MasterMind extends Game {
	protected int nbCouleurs;
	protected int nbCases;

	/**
	 * constructeur du MasterMind
	 */
	public MasterMind(Parametres param) {
		super(param);
		this.typeJeu = ChoixJeu.MASTERMIND;
		this.nbCouleurs = paramJeu.getNbCouleursMM();
		this.nbCases = paramJeu.getNbCasesMM();

	}

	/**
	 * m�thode pour lancer le mode challenger
	 */
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA) {

		// l'IA g�n�re une combinaison � trouver par le joueur
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases, this.paramJeu.ensembleCouleurs);
		System.out.println("Les couleurs disponibles sont : " + this.paramJeu.ensembleCouleurs + ", nous jouons sur "
				+ this.paramJeu.getNbCasesMM() + " cases");
		if (modeDev) {
			System.out.println(
					"le mode dev est activ�, la combinaison de l'IA est " + joueurIA.combinaisonJoueur.combinaisonMM);
		}

		System.out.println("Quelle est votre proposition ?");

		do {
			this.nbEssais++;
			String propositionJoueur = sc.nextLine();
			propositionJoueur = propositionJoueur.toUpperCase();
			int[] retour = new int[2];
			// je convertis mon string en ArrayList
			List<Character> propositionJ = new ArrayList();

			for (int k = 0; k < propositionJoueur.length(); k++) {
				propositionJ.add(propositionJoueur.charAt(k));
			}

			retour = joueurH.comparer(propositionJ, joueurIA.combinaisonJoueur.combinaisonMM);
			System.out.println(" --> Pions bien plac�s : " + retour[0] + ", Pions mal plac�s : " + retour[1]);

			if (joueurH.gagne) {

				this.partieFinie = true;
			}

		} while (!this.endGame(this.nbEssais, joueurIA.IAbug, joueurIA, joueurH));

	}

	/**
	 * m�thode pour lancer le mode d�fenseur
	 */
	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA) {

		// l'IA g�n�re l'ensemble des combinaisons possibles
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases, this.paramJeu.ensembleCouleurs,
				ModeJeu.DEFENSEUR);
		System.out.println("Les couleurs disponibles sont : " + this.paramJeu.ensembleCouleurs + ", nous jouons sur "
				+ this.paramJeu.getNbCasesMM() + " cases");
		System.out.println("M�morisez bien une combinaison ! l'IA va tenter de la deviner");
		partieFinie = false;

		do {
			nbEssais++;
			joueurIA.proposerCombinaisonMM();
			int[] indice = joueurH.joueurIndiqueMM();
			joueurIA.nettoyerCombinaisonsMM(indice);
			if (joueurIA.gagne) {

				this.partieFinie = true;

			}

			if (joueurIA.IAbug) {
				this.partieFinie = true;
			}

		} while (!this.endGame(nbEssais, joueurIA.IAbug, joueurIA, joueurH));

	}

	/**
	 * m�thode pour lancer le mode duel
	 */
	public void jouerDuel(JoueurHumain joueurH, JoueurIA joueurIA) {

		boolean gagneIA = false;
		boolean gagneJ = false;

		// l'IA g�n�re l'ensemble des combinaisons possibles
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases, this.paramJeu.ensembleCouleurs,
				ModeJeu.DUEL);
		System.out.println("Les couleurs disponibles sont : " + this.paramJeu.ensembleCouleurs + ", nous jouons sur "
				+ this.paramJeu.getNbCasesMM() + " cases");

		System.out.println("L'IA a d�termin� sa combinaison personnelle, � vous de m�moriser la v�tre !");
		if (modeDev) {
			System.out.println(
					"le mode dev est activ�, la combinaison de l'IA est " + joueurIA.combinaisonJoueur.combinaisonMM);
		}

		do {

			nbEssais++;

			// humain joue
			System.out.println("Quelle combinaison proposez vous � l'IA ?");
			String propositionJoueur = sc.nextLine();
			propositionJoueur = propositionJoueur.toUpperCase();
			int[] retour = new int[2];
			// je convertis mon string en ArrayList
			List<Character> propositionJ = new ArrayList();

			for (int k = 0; k < propositionJoueur.length(); k++) {
				propositionJ.add(propositionJoueur.charAt(k));
			}

			retour = joueurH.comparer(propositionJ, joueurIA.combinaisonJoueur.combinaisonMM);
			System.out.println(" --> Pions bien plac�s : " + retour[0] + ", Pions mal plac�s : " + retour[1]);

			// joueur IA joue

			String propositionIA = "";
			for (int i = 0; i < joueurIA.combinaisonJoueur.combinaisonCS.size(); i++) {

				propositionIA += joueurIA.combinaisonJoueur.combinaisonCS.get(i) + " ";

			}

			joueurIA.proposerCombinaisonMM();
			int[] indice = joueurH.joueurIndiqueMM();
			joueurIA.nettoyerCombinaisonsMM(indice);

		} while (!this.endGame(nbEssais, joueurIA.IAbug, joueurIA, joueurH));

	}

}
