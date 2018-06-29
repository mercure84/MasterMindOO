import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * classe qui renvoie différentes méthodes menu pour choisir le jeu ou rejouer
 * 
 * @author julie
 *
 */
public class Menu {

	// initiatilisation du logger
	static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {

		Partie partie = new Partie();
		partie.start();


		
		
	}
}