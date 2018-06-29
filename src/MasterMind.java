import java.util.ArrayList;
import java.util.List;

public class MasterMind extends Game {
	int nbCouleurs ;
	int nbCases;
	List<Character> ensembleCouleurs;

	
	public MasterMind() {
		super();
		this.nomGame = "MasterMind";
		this.nbCouleurs = paramJeu.getNbCouleursMM();
		this.nbCases = paramJeu.getNbCasesMM();
		this.ensembleCouleurs = definirEnsembleCouleurs(this.nbCouleurs);
		System.out.println("MM");
		
		
	}
	
	
	
	/**
	 * méthode qui permet de définir l'ensemble des couleurs disponibles pour le mastermind
	 * @param n
	 * @return
	 */
	
	List<Character> definirEnsembleCouleurs(int n) {

		// création du set de couleurs :
		List<Character> ensembleCouleurs = new ArrayList();
		ensembleCouleurs.add('J'); // jaune
		ensembleCouleurs.add('B'); // bleu
		ensembleCouleurs.add('R'); // rouge
		ensembleCouleurs.add('V'); // vert
		ensembleCouleurs.add('I'); // Ivoire
		ensembleCouleurs.add('N'); // Noir
		ensembleCouleurs.add('M'); // Mauve
		ensembleCouleurs.add('K'); // Kaki
		ensembleCouleurs.add('A'); // Argent
		ensembleCouleurs.add('O'); // Or

		switch (n) {
		case 4:
			ensembleCouleurs.remove(Character.valueOf('I'));
		case 5:
			ensembleCouleurs.remove(Character.valueOf('N'));
		case 6:
			ensembleCouleurs.remove(Character.valueOf('M'));
		case 7:
			ensembleCouleurs.remove(Character.valueOf('K'));
		case 8:
			ensembleCouleurs.remove(Character.valueOf('A'));
		case 9:
			ensembleCouleurs.remove(Character.valueOf('O'));
			break;
		default:
			break;

		}

		return ensembleCouleurs;

	}

}
