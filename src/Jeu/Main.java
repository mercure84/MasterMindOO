package Jeu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Point d'entr�e du programme
 * 
 * @author julie
 *
 */
public class Main {

	// initiatilisation du logger
	static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {

		// test du mode d�veloppeur au lancement du programme
		// instanciation des param�tres
		Parametres param = new Parametres();
// si l'argument lanc� dans la ligne de commande est dev ==> on active le mode dev, sinon c'est le fichier config.properties qui le d�terminera 
		try {
			if (args[0].equals("dev")) {

				param.modeDev = true;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (param.modeDev) {

			System.out.println("*** *** *** Le programme est lanc� en mode d�veloppeur*** *** ***");

		}

		// affichage du menu pour choisir le jeu et le mode via le constructeur de la
		// classe partie + d�finitions de certains param�tres de la partie
		while (true) {

			Partie partie = new Partie(param);

			partie.start();

			partie = null;

		}

	}
}