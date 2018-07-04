package Joueur;

import java.util.List;
import java.util.Scanner;

import Tools.Combinaison;

public class JoueurHumain extends Joueur {
	Scanner sc = new Scanner(System.in);

	public JoueurHumain() {

		super();

	}

	public String joueurIndiqueCS(List<Integer> proposition) {
		String indiceJoueur = "";
		boolean attenteJoueur = true;
		int verifIndice = 0;
		System.out.println("Quels indices proposez vous ? (+), (-), (=)");
		// on fait saisir au joueur son indice, mais on lui demandera autant de fois
		// que n�cessaire, jusqu'� ce que le format soit bon
		do {
			indiceJoueur = sc.nextLine();
			String erreur = "le format de votre indice est incorrect... recommencez !";
			int verifCombinaison = 0;
			int chiffresOk = 0;
			// on v�rifie la taille de l'indice...
			
			//System.out.println("taille indice = " + indiceJoueur.length() + " taille proposition " + proposition.size());
			if (indiceJoueur.length() != proposition.size()) {
				System.out.println(erreur);
			} else {// on v�rifie que l'indice comporte bien des + ou des - ou =
				for (int i = 0; i < indiceJoueur.length(); i++) {
					if (indiceJoueur.charAt(i) != '-' && indiceJoueur.charAt(i) != '+'
							&& indiceJoueur.charAt(i) != '=') {

						System.out.println(erreur);
					} else {
						verifIndice++;
					}
				}

				if (verifIndice == proposition.size()) {

					attenteJoueur = false;

				}

			}

		} while (attenteJoueur);
		return indiceJoueur;

	}

	public int[] joueurIndiqueMM() {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[2];

		System.out.println("Combien de pions bien plac�s ?");
		int pionsBiensPlaces = sc.nextInt();
		sc.nextLine();
		System.out.println("Combien de pions mal plac�s ?");
		int pionsMalplaces = sc.nextInt();
		score[0] = pionsBiensPlaces;
		score[1] = pionsMalplaces;

		return score;
		
	}
}
