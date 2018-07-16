package Joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JoueurIA extends Joueur {
	public boolean IAbug;

	public JoueurIA() {

	}

	/**
	 * m�thode qui ajuste la combinaison CS de l'IA en fonction des indices re�us !
	 * renvoie un boolean gagne pour dire si la combinaison a �t� devin�e ou non
	 * 
	 * @param indice
	 * @param derniereProposition
	 * @return
	 */
	public boolean ajusterCombinaisonCS(String indice, List<Integer> derniereProposition) {
		int chiffresOK = 0;
		boolean gagneCombi = false;

		for (int i = 0; i < indice.length(); i++) {
			int chiffreEnCours = this.combinaisonJoueur.combinaisonCS.get(i);
			int maxEnCours = this.combinaisonJoueur.combinaisonCSMax.get(i);
			int minEnCours = this.combinaisonJoueur.combinaisonCSMin.get(i);
			switch (indice.charAt(i)) {
			case '+':
				// c'est + donc la nouvelle proposition sera entre le chiffre propos� et le maxi
				// en cours
				this.combinaisonJoueur.combinaisonCS.set(i, (int) ((maxEnCours + chiffreEnCours) / 2));
				// mise � jour du chiffre mini en cours :
				this.combinaisonJoueur.combinaisonCSMin.set(i, (int) (chiffreEnCours));
				break;
			case '-':
				// c'est moins donc la nouvelle proposition sera entre le chiffre propos� et le
				// mini en cours
				this.combinaisonJoueur.combinaisonCS.set(i, (int) ((minEnCours + chiffreEnCours) / 2));
				// mise � jour du maxi en cours
				this.combinaisonJoueur.combinaisonCSMax.set(i, (int) (chiffreEnCours));
				break;
			case '=':
				// chiffre trouv� !
				this.combinaisonJoueur.combinaisonCSMax.set(i, (chiffreEnCours));
				this.combinaisonJoueur.combinaisonCSMin.set(i, (chiffreEnCours));
				chiffresOK++;
				break;

			}

		}

		if (chiffresOK == derniereProposition.size()) {

			gagneCombi = true;
			this.gagne = true;
		}

		return gagneCombi;

	}

	/**
	 * m�thode attribu�e � un joueur IA pour proposer une combinaison au MM
	 */
	public void proposerCombinaisonMM() {
		// on va prendre al�toirement une combinaison disponible dans l'ensemble restant

		List<Character> proposition = new ArrayList();
		int index = new Random().nextInt(this.combinaisonJoueur.ensembleCombinaisonMM.size());

		proposition = this.combinaisonJoueur.ensembleCombinaisonMM.get(index);
		System.out.println("L'IA vous propose la combinaison suivante : " + proposition
				+ " [Nb possibilit�s restantes : " + this.combinaisonJoueur.ensembleCombinaisonMM.size() + "]");
		this.combinaisonJoueur.combinaisonMMD = proposition;
	}

	/**
	 * m�thode IA qui permet de supprimer les mauvaises combinaisons du champs des
	 * possibles en fonction de l'indice recu
	 * 
	 * @param indice
	 */
	public void nettoyerCombinaisonsMM(int[] indice) {

		// si l'indice "pions bien plac�s" est �gal � la longueur de la proposition de
		// l'IA, c'est que c'est gagn� !

		if (indice[0] != this.combinaisonJoueur.combinaisonMMD.size()) {

			// on cherche les combinaisons � �liminer, cad celles qui n'obtiennent pas le
			// score pr�vu : on va tester toutes les combinaisons de l'ensemble restant par
			// rapport
			// � la derni�re proposition de l'IA
			List<List> combinaisonsAEliminer = new ArrayList();
			for (int i = 0; i < this.combinaisonJoueur.ensembleCombinaisonMM.size(); i++) {
				List<Character> combiATester = new ArrayList(this.combinaisonJoueur.ensembleCombinaisonMM.get(i));
				int[] scoreA = this.comparer(this.combinaisonJoueur.combinaisonMMD, combiATester);

				if (!((scoreA[0] == indice[0]) && (scoreA[1] == indice[1]))) {
					// si la combinaison � tester ne satisfait pas � l'indice, on l'ajoute dans la
					// liste des ind�sirables.
					combinaisonsAEliminer.add(combiATester);

				}

			}

			// on retire de la liste des combinaisons restantes, toutes les combinaisons
			// trouv�es pr�c�demment
			for (List list : combinaisonsAEliminer) {

				this.combinaisonJoueur.ensembleCombinaisonMM.remove(list);

			}
			combinaisonsAEliminer.clear();

			// si l'ensemble des combinaisons restantes est vide c'est qu'il y a une erreur
			// dans les indices donn�s par l'humain...
			if (this.combinaisonJoueur.ensembleCombinaisonMM.isEmpty()) {

				this.IAbug = true;

			} else {
				this.gagne = false;
			}

		} else {

			// l'IA a gagn�

			this.gagne = true;

		}

	}

}
