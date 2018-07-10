package Tools;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * classe qui permet de récupérer les paramètres du fichier config.properties
 * en cas d'échec de récupérer des variables, des valeurs par défaut sont assignées
 * @author julie
 *
 */
public class Parametres {
	static final Logger logger = LogManager.getLogger();
	boolean modeDev = false;
	int nbEssais = 5;
	int nbCasesCS = 5;
	int nbCouleursMM = 6;
	int nbCasesMM = 4;
	public List<Character> ensembleCouleurs;
	
	
/**
 * constructeur de la classe Paramètres
 */
	public Parametres() {

		try {
			File file = new File("./resources/config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);;
			fileInput.close();
			
			
			this.modeDev = Boolean.parseBoolean(properties.getProperty("modeDev"));
			this.nbEssais = Integer.parseInt(properties.getProperty("nbEssais"));
			this.nbCasesCS = Integer.parseInt(properties.getProperty("nbCasesCS"));
			this.nbCouleursMM = Integer.parseInt(properties.getProperty("nbCouleurs"));
			this.nbCasesMM = Integer.parseInt(properties.getProperty("nbCasesMM"));
			this.ensembleCouleurs = definirEnsembleCouleurs(this.nbCouleursMM);
			
			logger.info("les paramètres ont été chargés depuis config.properties");		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
					
		}

	/**
	 * méthode qui génère l'ensemble des couleurs possibles pour le MasterMind
	 * @param n
	 * @return
	 */
	List<Character> definirEnsembleCouleurs(int n) {

		// création du set de couleurs : on considère qu'il y a les 10 couleurs possibles au démarrage et en fonction du paramétrage on va retirer les couleurs superflues
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
	
	
	
// getters que l'on peut appeler pour récupérer les données dans les jeux

public boolean isModeDev() {
	return modeDev;
}


public int getNbEssais() {
	return nbEssais;
}


public int getNbCasesCS() {
	return nbCasesCS;
}


public int getNbCouleursMM() {
	return nbCouleursMM;
}


public int getNbCasesMM() {
	return nbCasesMM;
}

		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	


