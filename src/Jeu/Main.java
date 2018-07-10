package Jeu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Point d'entrée du programme
 * 
 * @author julie
 *
 */
public class Main {

	// initiatilisation du logger
	static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
// affichage du menu pour choisir le jeu et le mode via le constructeur de la classe partie + définitions de certains paramètres de la partie
		
		while(true) {
		
		
		Partie partie = new Partie();
		
		partie.start();
		
		partie = null;
		


		}
		
	}
}