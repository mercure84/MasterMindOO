package Tools;

import java.util.ArrayList;
import java.util.List;

public  class Comparaison {
	
	// méthode de comparaison pour le mastermind
	public static int[] comparer (List <Character> propositionJ,  List<Character> propositionCible) {

		int bienPlaces = 0;
		int nbMalPlaces = 0;
		List<Character> codeTest = new ArrayList<>(propositionCible);
		int[] resultat = new int[2];

		// si ma proposition n'est pas de la bonne taille, je finis le test et je fais
		// perdre un essai au joueur...
		if (propositionJ.size() != codeTest.size()) {
			System.out.println(
					"Malheureusement vous n'avez pas combiné le bon nombre de boules... Vous perdez un essai !");
		}

		else {
			List<Character> malPlaces = new ArrayList();
			List<Character> proposition = new ArrayList(propositionJ);
			malPlaces.add('!');

			for (int i = 0; i < proposition.size(); i++) {

				char pion = proposition.get(i);
				// on teste si le pion est bien dans la combinaison

				if (codeTest.contains(pion)) {
					// on teste s'il est bien placé
					if (pion == codeTest.get(i)) {
						// j'incrémente mon compteur des biens placés et je neutralise cette position
						// dans ma proposition et dans ma combinaison
						// j'inscris le char "Z" aux positions correspondantes
						bienPlaces++;
						codeTest.set(i, 'Z');
						proposition.set(i, 'Z');
					}

					else {
						// s'il est mal placé on stock ce pion dans une List spécifique aux mals placés
						malPlaces.add(pion);
					}
				}

			}

			// je traite mes pions mal placés : après remplacements des pions biens placés
			// par Z
			// dans la combinaison, existent-ils toujours ?

			for (int j = 0; j < malPlaces.size(); j++) {
				char pionMP = malPlaces.get(j);
				if (codeTest.contains(pionMP)) {
					nbMalPlaces++;
					for (int m = 0; m < codeTest.size(); m++) {
						if (pionMP == codeTest.get(m)) {
							codeTest.set(m, 'Z');
						}
					}
				}
			}

			resultat[0] = bienPlaces;
			resultat[1] = nbMalPlaces;

		}
		// System.out.println("proposition = " + proposition + " combi = "+ code);
		return resultat;

		
	
	}
	

	
	
	

}
