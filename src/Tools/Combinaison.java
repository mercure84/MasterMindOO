package Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Jeu.ChoixJeu;
import Jeu.ModeJeu;

/**
 * classe qui permet de g�n�rer un objet de type combinaison :
 * 
 * X chiffres pour le jeu de la combinaison secr�tes X boules sur Y couleurs
 * pour le MasterMind
 * 
 * 
 * @author julie
 *
 */
public class Combinaison {

	// diff�rentes variables stockant les combinaison n�cessaire aux jeux et aux
	// diff�rents modes
	public List<Integer> combinaisonCSD = new ArrayList();
	public List<Integer> combinaisonCS = new ArrayList();
	public List<Integer> combinaisonCSMin = new ArrayList();
	public List<Integer> combinaisonCSMax = new ArrayList();

	public List<Character> combinaisonMM = new ArrayList();

	public List<List> ensembleCombinaisonMM = new ArrayList();
	public List<Character> combinaisonMMD = new ArrayList();

	// constructeur d'une combinaison al�atoire pour CS avec en param�tre le type de
	// jeu, le nb de Cases
	public Combinaison(ChoixJeu typeJeu, int nbCases) {

		if (typeJeu == ChoixJeu.COMBINAISON_SECRETE) {
			List<Integer> combinaisonInventee = new ArrayList();
			for (int i = 0; i < nbCases; i++) {
				int k = (int) (Math.random() * 10);
				combinaisonInventee.add(k);

			}

			this.combinaisonCSD = combinaisonInventee;

			for (int i = 0; i < nbCases; i++) {
				this.combinaisonCS.add(5);
				this.combinaisonCSMax.add(10);
				this.combinaisonCSMin.add(0);

			}
		}

	}

	// construction d'une combinaison de d�part en mode challenger MM
	public Combinaison(ChoixJeu typeJeu, int nbCases, List<Character> ensembleCouleurs) {
		if (typeJeu == ChoixJeu.MASTERMIND) {

			List<Character> combinaisonInventee = new ArrayList();

			// calcul de la combinaison � nbCases positions

			for (int i = 0; i < nbCases; i++) {

				int k = new Random().nextInt(ensembleCouleurs.size());
				char couleur = ensembleCouleurs.get(k);
				combinaisonInventee.add(couleur);

			}
			this.combinaisonMMD = combinaisonInventee;
		}

	}

	// g�n�ration d'un ensemble de combinaison pour les modes d�fenseurs / duels

	public Combinaison(ChoixJeu typeJeu, int nbCases, List<Character> ensembleCouleurs, ModeJeu modeJeu) {
		List<List> listeCombinaisons = new ArrayList();
		if (typeJeu == ChoixJeu.MASTERMIND) {
			
			int n = ensembleCouleurs.size();
			int nbCombinaisonsPossibles = (int) Math.pow(n, nbCases);
			System.out.println("nb combinaisons possibles pour l'IA = " + nbCombinaisonsPossibles);
			// cr�ation de l'ensemble des combinaisons pour une combinaison de 4 � 10 cases

			for (int i = 0; i < n; i++) {
				List<Character> uneCombinaison = new ArrayList();
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						for (int l = 0; l < n; l++) {
							if (nbCases <= 4) {
								break;
							}

							for (int m = 0; m < n; m++) {
								if (nbCases <= 5) {
									break;
								}

								for (int o = 0; o < n; o++) {
									if (nbCases <= 6) {
										break;
									}

									for (int p = 0; p < n; p++) {
										if (nbCases <= 7) {
											break;
										}

										for (int q = 0; q < n; q++) {
											if (nbCases <= 8) {
												break;
											}

											for (int r = 0; r < n; r++) {
												if (nbCases <= 9) {
													break;
												}

												for (int s = 0; s < n; s++) {

													uneCombinaison.add(ensembleCouleurs.get(s));
												}
												uneCombinaison.add(ensembleCouleurs.get(r));
											}
											uneCombinaison.add(ensembleCouleurs.get(q));
										}
										uneCombinaison.add(ensembleCouleurs.get(p));
									}
									uneCombinaison.add(ensembleCouleurs.get(o));
								}
								uneCombinaison.add(ensembleCouleurs.get(m));
							}
							uneCombinaison.add(ensembleCouleurs.get(l));
						}
						uneCombinaison.add(ensembleCouleurs.get(k));
					}
					uneCombinaison.add(ensembleCouleurs.get(j));
				}
				uneCombinaison.add(ensembleCouleurs.get(i));

				listeCombinaisons.add(uneCombinaison);
				
			}

			this.ensembleCombinaisonMM = listeCombinaisons;
		}

		System.out.println("L'ordi vient de g�n�rer " + listeCombinaisons.size() + " combinaisons !!!");
	}

}
