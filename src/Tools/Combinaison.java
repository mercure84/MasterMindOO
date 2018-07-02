package Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Jeu.ChoixJeu;
import Jeu.ModeJeu;

/**
 * classe qui permet de générer un objet de type combinaison :
 * 
 * X chiffres pour le jeu de la combinaison secrètes X boules sur Y couleurs
 * pour le MasterMind
 * 
 * 
 * @author julie
 *
 */
public class Combinaison {

	public List<Integer> combinaisonCS = new ArrayList();
	public List<Integer> combinaisonCSMin = new ArrayList();
	public List<Integer> combinaisonCSMax = new ArrayList();

	public List<Character> combinaisonMM = new ArrayList();;

	public List<List> ensembleCombinaisonMM = new ArrayList();;

	// constructeur d'une combinaison aléatoire pour CS avec en paramètre le type de
	// jeu, le nb de Cases et l'ensemble des couleurs dispo
	public Combinaison(ChoixJeu typeJeu, int nbCases) {

		if (typeJeu == ChoixJeu.COMBINAISON_SECRETE) {
			List<Integer> combinaisonInventee = new ArrayList();
			for (int i = 0; i < nbCases; i++) {
				int k = (int) (Math.random() * 10);
				combinaisonInventee.add(k);

			}
			this.combinaisonCS = combinaisonInventee;

		}

	}

	// construction d'une combinaison de départ en mode défenseur pour l'IA -- création des bornes Maxi et mini via 2 autres combinaisons
	public Combinaison(ChoixJeu typeJeu, int nbCases, ModeJeu modeJeu) {

		if (modeJeu == ModeJeu.DEFENSEUR) {

			for (int i = 0; i < nbCases; i++) {
				this.combinaisonCS.add(5);
				this.combinaisonCSMax.add(10);
				this.combinaisonCSMin.add(0);

			}

		}
	}

	// construction d'une combinaison de départ en mode challenger MM
	public Combinaison(ChoixJeu typeJeu, int nbCases, List<Character> ensembleCouleurs) {
		if (typeJeu == ChoixJeu.MASTERMIND) {

			List<Character> combinaisonInventee = new ArrayList();

			// calcul de la combinaison à nbCases positions

			for (int i = 0; i < nbCases; i++) {

				int k = new Random().nextInt(ensembleCouleurs.size());
				char couleur = ensembleCouleurs.get(k);
				combinaisonInventee.add(couleur);

			}
			this.combinaisonMM = combinaisonInventee;
		}

	}

}
