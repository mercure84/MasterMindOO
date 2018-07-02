package Tools;

import java.util.ArrayList;
import java.util.List;

public  class Comparaison {
	
	// m�thode de comparaison pour le mastermind
	public static int[] comparer (List <Character> propositionJ,  List<Character> propositionCible) {

		int bienPlaces = 0;
		int nbMalPlaces = 0;
		List<Character> codeTest = new ArrayList<>(propositionCible);
		int[] resultat = new int[2];

		// si ma proposition n'est pas de la bonne taille, je finis le test et je fais
		// perdre un essai au joueur...
		if (propositionJ.size() != codeTest.size()) {
			System.out.println(
					"Malheureusement vous n'avez pas combin� le bon nombre de boules... Vous perdez un essai !");
		}

		else {
			List<Character> malPlaces = new ArrayList();
			List<Character> proposition = new ArrayList(propositionJ);
			malPlaces.add('!');

			for (int i = 0; i < proposition.size(); i++) {

				char pion = proposition.get(i);
				// on teste si le pion est bien dans la combinaison

				if (codeTest.contains(pion)) {
					// on teste s'il est bien plac�
					if (pion == codeTest.get(i)) {
						// j'incr�mente mon compteur des biens plac�s et je neutralise cette position
						// dans ma proposition et dans ma combinaison
						// j'inscris le char "Z" aux positions correspondantes
						bienPlaces++;
						codeTest.set(i, 'Z');
						proposition.set(i, 'Z');
					}

					else {
						// s'il est mal plac� on stock ce pion dans une List sp�cifique aux mals plac�s
						malPlaces.add(pion);
					}
				}

			}

			// je traite mes pions mal plac�s : apr�s remplacements des pions biens plac�s
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
	
// m�thode de comparaison pour le jeu CS
	public static boolean comparer (String propositionJ, List <Integer> code) {
		String retourVerification = "";
		boolean gagne = true ;
			

		// si la longueur de la combinaison est diff�rent on renvoie imm�diatement false
		if (propositionJ.length() != code.size()) {

			System.out.println(
					"Il fallait proposer une combinaison � " + code.size() + " ! Vous perdez un essai !");
			return false;
		}

		for (int i = 0; i < code.size(); i++) {

			if (code.get(i) < Character.getNumericValue(propositionJ.charAt(i))) {
				retourVerification += "-";
				gagne = false;
			} else if (code.get(i) > Character.getNumericValue(propositionJ.charAt(i))) {
				retourVerification += "+";
				gagne = false;
			} else {
				retourVerification += "=";

			}

		}
		System.out.println("Proposition :" + propositionJ + " -> r�ponse : " + retourVerification);
		return gagne;

	}
	
	
	

}
