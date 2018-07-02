package Joueur;

import java.util.List;

import Tools.Combinaison;

public class JoueurIA extends Joueur {

	public JoueurIA() {

		this.nomJoueur = "IA";

	}

	public boolean ajusterCombinaisonCS(String indice, List<Integer> derniereProposition) {
		int chiffresOK = 0;
		boolean gagne = false;

		for (int i = 0; i < indice.length(); i++) {
			int chiffreEnCours = this.combinaisonJoueur.combinaisonCS.get(i);
			int maxEnCours = this.combinaisonJoueur.combinaisonCSMax.get(i);
			int minEnCours = this.combinaisonJoueur.combinaisonCSMin.get(i);
			switch (indice.charAt(i)) {
			case '+':
				// c'est + donc la nouvelle proposition sera entre le chiffre proposé et le maxi
				// en cours
				this.combinaisonJoueur.combinaisonCS.set(i, (int)((maxEnCours + chiffreEnCours) / 2));
				// mise à jour du chiffre mini en cours :
				this.combinaisonJoueur.combinaisonCSMin.set(i, (int)(chiffreEnCours));
				break;
			case '-':
				// c'est moins donc la nouvelle proposition sera entre le chiffre proposé et le
				// mini en cours
				this.combinaisonJoueur.combinaisonCS.set(i, (int)((minEnCours + chiffreEnCours) / 2));
				// mise à jour du maxi en cours
				this.combinaisonJoueur.combinaisonCSMax.set(i, (int)(chiffreEnCours));
				break;
			case '=':
				// chiffre trouvé !
				this.combinaisonJoueur.combinaisonCSMax.set(i, (chiffreEnCours));
				this.combinaisonJoueur.combinaisonCSMin.set(i, (chiffreEnCours));
				chiffresOK++;
				break;

			}

		}

		if (chiffresOK == derniereProposition.size()) {
			gagne = true;
		}

		return gagne;

	}
}
