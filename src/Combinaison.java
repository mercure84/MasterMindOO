import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * classe qui permet de générer un objet de type combinaison :
 * 
 * X chiffres pour le jeu de la combinaison secrètes
 * X boules sur Y couleurs pour le MasterMind
 * 
 * 
 * @author julie
 *
 */
public class Combinaison {

	List<Integer> combinaisonCS;
	List<Character> combinaisonMM;
	List<List> ensembleCombinaisonMM;
	
	public Combinaison(String typeJeu, int nbCases, List<Character> ensembleCouleurs) {
		
		if (typeJeu == "Combinaison Secrète") {
				List<Integer> combinaisonInventee = new ArrayList();
				for (int i = 0; i < nbCases; i++) {
					int k = (int) (Math.random() * 10);
					combinaisonInventee.add(k);

				}
				combinaisonCS = combinaisonInventee;

			}
		
		if (typeJeu == "MasterMind") {
			
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
	
	
	
