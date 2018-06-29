import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
			this.nbCouleursMM = Integer.parseInt(properties.getProperty("nbCouleurs"));
			this.nbCasesMM = Integer.parseInt(properties.getProperty("nbCasesMM"));
			
			logger.info("les param�tres ont �t� charg�s depuis config.properties");		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
					
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
	
	
	
	
	
	
	
	


