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
 * classe qui permet de r�cup�rer les param�tres du fichier config.properties
 * en cas d'�chec de r�cup�rer des variables, des valeurs par d�faut sont assign�es
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
 * constructeur de la classe Param�tres
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
			
			logger.info("les param�tres ont �t� charg�s depuis config.properties");		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
					
		}

	/**
	 * m�thode qui g�n�re l'ensemble des couleurs possibles pour le MasterMind
	 * @param n
	 * @return
	 */
	List<Character> definirEnsembleCouleurs(int n) {

		// cr�ation du set de couleurs : on consid�re qu'il y a les 10 couleurs possibles au d�marrage et en fonction du param�trage on va retirer les couleurs superflues
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
	
	
	
// getters que l'on peut appeler pour r�cup�rer les donn�es dans les jeux

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
	
	
	
	
	
	
	
	


