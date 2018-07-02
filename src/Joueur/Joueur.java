package Joueur;

import java.util.List;

import Tools.Combinaison;

// classe qui permet de cr�er un joueur humain ou IA et de lui associer sa combinaison

public class Joueur {

	String nomJoueur = ""; // soit IA soit Humain
	public Combinaison combinaisonJoueur;

	// m�thode de comparaison pour le jeu CS
	public boolean comparer(String propositionJ, List<Integer> code) {
		String retourVerification = "";
		boolean gagne = true;

		// si la longueur de la combinaison est diff�rent on renvoie imm�diatement false
		if (propositionJ.length() != code.size()) {

			System.out.println("Il fallait proposer une combinaison � " + code.size() + " chiffres ! Vous perdez un essai !");
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