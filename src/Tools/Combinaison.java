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

	// différentes variables stockant les combinaison nécessaire aux jeux et aux
	// différents modes
	public List<Integer> combinaisonCSD = new ArrayList();
	public List<Integer> combinaisonCS = new ArrayList();
	public List<Integer> combinaisonCSMin = new ArrayList();
	public List<Integer> combinaisonCSMax = new ArrayList();

	//MM = pour le mode challengeur
	public List<Character> combinaisonMM = new ArrayList();

	public List<List> ensembleCombinaisonMM = new ArrayList();
	
	//MMD = pour le mode défenseur
	public List<Character> combinaisonMMD = new ArrayList();

	// constructeur d'une combinaison aléatoire pour CS avec en paramètre le type de
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

	// génération d'un ensemble de combinaison pour les modes défenseurs / duels

	public Combinaison(ChoixJeu typeJeu, int nbCases, List<Character> ensembleCouleurs, ModeJeu modeJeu) {
		List<List> listeCombinaisons = new ArrayList();
		if (typeJeu == ChoixJeu.MASTERMIND) {

			int n = ensembleCouleurs.size();
			int nbCombinaisonsPossibles = (int) Math.pow(n, nbCases);
			// création de l'ensemble des combinaisons pour une combinaison de 4 à 10 cases

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						for (int l = 0; l < n; l++) {

							if (nbCases == 4) {
								List<Character> uneCombinaison = new ArrayList();
								uneCombinaison.add(ensembleCouleurs.get(i));
								uneCombinaison.add(ensembleCouleurs.get(j));
								uneCombinaison.add(ensembleCouleurs.get(k));
								uneCombinaison.add(ensembleCouleurs.get(l));
								listeCombinaisons.add(uneCombinaison);

							} else {
								for (int m = 0; m < n; m++) {
									if (nbCases == 5) {
										List<Character> uneCombinaison = new ArrayList();
										uneCombinaison.add(ensembleCouleurs.get(i));
										uneCombinaison.add(ensembleCouleurs.get(j));
										uneCombinaison.add(ensembleCouleurs.get(k));
										uneCombinaison.add(ensembleCouleurs.get(l));
										uneCombinaison.add(ensembleCouleurs.get(m));
										listeCombinaisons.add(uneCombinaison);

									} else {
										for (int o = 0; o < n; o++) {
											if (nbCases == 6) {
												List<Character> uneCombinaison = new ArrayList();
												uneCombinaison.add(ensembleCouleurs.get(i));
												uneCombinaison.add(ensembleCouleurs.get(j));
												uneCombinaison.add(ensembleCouleurs.get(k));
												uneCombinaison.add(ensembleCouleurs.get(l));
												uneCombinaison.add(ensembleCouleurs.get(m));
												uneCombinaison.add(ensembleCouleurs.get(o));
												listeCombinaisons.add(uneCombinaison);
											} else {

												for (int p = 0; p < n; p++) {
													if (nbCases == 7) {
														List<Character> uneCombinaison = new ArrayList();
														uneCombinaison.add(ensembleCouleurs.get(i));
														uneCombinaison.add(ensembleCouleurs.get(j));
														uneCombinaison.add(ensembleCouleurs.get(k));
														uneCombinaison.add(ensembleCouleurs.get(l));
														uneCombinaison.add(ensembleCouleurs.get(m));
														uneCombinaison.add(ensembleCouleurs.get(o));
														uneCombinaison.add(ensembleCouleurs.get(p));
														listeCombinaisons.add(uneCombinaison);
													} else {
														for (int q = 0; q < n; q++) {
															if (nbCases == 8) {
																List<Character> uneCombinaison = new ArrayList();
																uneCombinaison.add(ensembleCouleurs.get(i));
																uneCombinaison.add(ensembleCouleurs.get(j));
																uneCombinaison.add(ensembleCouleurs.get(k));
																uneCombinaison.add(ensembleCouleurs.get(l));
																uneCombinaison.add(ensembleCouleurs.get(m));
																uneCombinaison.add(ensembleCouleurs.get(o));
																uneCombinaison.add(ensembleCouleurs.get(p));
																uneCombinaison.add(ensembleCouleurs.get(q));
																listeCombinaisons.add(uneCombinaison);
															} else {
																for (int r = 0; r < n; r++) {
																	if (nbCases == 9) {
																		List<Character> uneCombinaison = new ArrayList();
																		uneCombinaison.add(ensembleCouleurs.get(i));
																		uneCombinaison.add(ensembleCouleurs.get(j));
																		uneCombinaison.add(ensembleCouleurs.get(k));
																		uneCombinaison.add(ensembleCouleurs.get(l));
																		uneCombinaison.add(ensembleCouleurs.get(m));
																		uneCombinaison.add(ensembleCouleurs.get(o));
																		uneCombinaison.add(ensembleCouleurs.get(p));
																		uneCombinaison.add(ensembleCouleurs.get(q));
																		uneCombinaison.add(ensembleCouleurs.get(r));
																		listeCombinaisons.add(uneCombinaison);
																	} else {

																		for (int s = 0; s < n; s++) {
																			if (nbCases == 10) {

																				List<Character> uneCombinaison = new ArrayList();
																				uneCombinaison
																						.add(ensembleCouleurs.get(i));
																				uneCombinaison
																						.add(ensembleCouleurs.get(j));
																				uneCombinaison
																						.add(ensembleCouleurs.get(k));
																				uneCombinaison
																						.add(ensembleCouleurs.get(l));
																				uneCombinaison
																						.add(ensembleCouleurs.get(m));
																				uneCombinaison
																						.add(ensembleCouleurs.get(o));
																				uneCombinaison
																						.add(ensembleCouleurs.get(p));
																				uneCombinaison
																						.add(ensembleCouleurs.get(q));
																				uneCombinaison
																						.add(ensembleCouleurs.get(r));
																				uneCombinaison
																						.add(ensembleCouleurs.get(s));
																				listeCombinaisons.add(uneCombinaison);
																			}

																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

			this.ensembleCombinaisonMM = listeCombinaisons;
			
			// si on est en mode duel il faut générer aussi une combinaison que l'humain devra chercher !
			if(modeJeu == ModeJeu.DUEL) {
			
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

}
