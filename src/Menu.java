import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Jeu.Partie;

/**
 * classe qui renvoie diff�rentes m�thodes menu pour choisir le jeu ou rejouer
 * m�thode main qui constitue le point d'entr�e du programme.
 * 
 * @author julie
 *
 */
public class Menu {

	// initiatilisation du logger
	static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
// affichage du menu pour choisir le jeu et le mode via le constructeur de la classe partie + d�finitions de certains param�tres de la partie
		
		Partie partie = new Partie();
		
		partie.start();


		
		
	}
}