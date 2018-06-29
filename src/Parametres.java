import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
			this.nbCouleursMM = Integer.parseInt(properties.getProperty("nbCouleurs"));
			this.nbCasesMM = Integer.parseInt(properties.getProperty("nbCasesMM"));
			
			logger.info("les paramètres ont été chargés depuis config.properties");		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
					
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
	
	
	
	
	
	
	
	


