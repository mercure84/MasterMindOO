import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * classe qui renvoie différentes méthodes menu pour choisir le jeu ou rejouer
 * méthode main qui constitue le point d'entrée du programme.
 * 
 * @author julie
 *
 */
public class Menu {

	// initiatilisation du logger
	static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
// affichage du menu pour choisir le jeu et le mode via le constructeur de la classe partie
		
		Partie partie = new Partie();
		
	
		
		
		partie.start();


		
		
	}
}