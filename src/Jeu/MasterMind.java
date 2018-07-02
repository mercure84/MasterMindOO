package Jeu;
import java.util.ArrayList;
import java.util.List;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;

public class MasterMind extends Game {
	int nbCouleurs ;
	int nbCases;
	boolean gagne = false;

	
	public MasterMind() {
		super();
		this.typeJeu = ChoixJeu.MASTERMIND;
		this.nbCouleurs = paramJeu.getNbCouleursMM();
		this.nbCases = paramJeu.getNbCasesMM();
				
		
	}
	
	
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA) {
		
		// l'IA g�n�re une combinaison � trouver par le joueur
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases, this.paramJeu.ensembleCouleurs );
		System.out.println("Les couleurs disponibles sont : " + this.paramJeu.ensembleCouleurs + ", nous jouons sur " + this.paramJeu.getNbCasesMM() + " cases");
		if (modeDev) {
			System.out.println(
					"le mode dev est activ�, la combinaison de l'IA est " + joueurIA.combinaisonJoueur.combinaisonMMD);
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
			
			retour = joueurIA.comparer(propositionJ, joueurIA.combinaisonJoueur.combinaisonMMD);
			System.out.println(" --> Pions bien plac�s : " + retour[0] + ", Pions mal plac�s : " + retour[1]);

			// si le nombre de pions bien plac�s = taille de la combinaison, c'est gagn� !
			if (retour[0] == propositionJ.size()) {
				System.out.println("Vous avez gagn� !");
				gagne = true;
			}

		} while (!this.endGame(gagne, nbEssais, joueurIA.combinaisonJoueur.combinaisonMMD));

		
		
	}
	
	
	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA) {
		
		// l'IA g�n�re l'ensemble des combinaisons possibles
		joueurIA.combinaisonJoueur = new Combinaison(this.typeJeu, this.nbCases, this.paramJeu.ensembleCouleurs, ModeJeu.DEFENSEUR );
		System.out.println("Les couleurs disponibles sont : " + this.paramJeu.ensembleCouleurs + ", nous jouons sur " + this.paramJeu.getNbCasesMM() + " cases");

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
			
			retour = joueurIA.comparer(propositionJ, joueurIA.combinaisonJoueur.combinaisonMMD);
			System.out.println(" --> Pions bien plac�s : " + retour[0] + ", Pions mal plac�s : " + retour[1]);

			// si le nombre de pions bien plac�s = taille de la combinaison, c'est gagn� !
			if (retour[0] == propositionJ.size()) {
				System.out.println("Vous avez gagn� !");
				gagne = true;
			}

		} while (!this.endGame(gagne, nbEssais, joueurIA.combinaisonJoueur.combinaisonMMD));
	
	

}}
