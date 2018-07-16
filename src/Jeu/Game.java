package Jeu;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Joueur.Combinaison;
import Joueur.Joueur;
import Joueur.JoueurHumain;
import Joueur.JoueurIA;

/**
 *classe mère de nos différents jeux 
 * 
 * @author julie
 *
 */
public abstract class Game implements Jouable {
	static final Logger logger = LogManager.getLogger();
	protected ChoixJeu typeJeu;
	protected boolean partieFinie = false;
	protected Parametres paramJeu ;
	protected int nbEssaisMax = 10;
	protected int nbEssais = 0;
	protected boolean modeDev;
	protected Scanner sc = new Scanner(System.in);
	

	//constructeur par défaut
	protected Game() {
		// chargement des paramètres du fichier config.properties
		
		
		this.paramJeu = new Parametres();
		this.nbEssaisMax = paramJeu.getNbEssais();
		this.modeDev = paramJeu.isModeDev();

		//System.out.println("Un jeu est créé !");

			
	}
	
	/**
	 * méthode qui définit si le jeu se finit en fonction des résultats des propositions VS Indice VS nb de tours maxi
	 * @param gagne
	 * @param nbTours
	 * @param proposition
	 * @param iAbug 
	 * @return un boolean qui nous dit si la partie est finie ou non
	 */
	protected boolean endGame(int nbEssais, boolean IAbug, Joueur joueurIA, Joueur joueurH) {
		
		boolean partieFinie = false;
		
		if (IAbug) {
			
			System.out.println("Il y a malheureusement un problème quelque part... Etes vous certains de ne pas avoir donné de mauvais indices à l'IA ?");
			logger.error("Une erreur dans le script du solver IA a été manifestement détectée");
			partieFinie = true;
			
		}
		
		
		else if (nbEssais > this.nbEssaisMax){
			
			System.out.println("Perdu ! Il n'y a plus d'essais disponibles");	
			partieFinie= true;	
	

		}
		
		else {

			if (joueurIA.gagne && joueurH.gagne) {
				System.out.println(("Egalité ! Vous avez gagné mais l'IA aussi !"));
				System.out.println("La partie est finie ! Il y a eu " + nbEssais + " essai(s) !");
				partieFinie= true;
			}
			else if (joueurIA.gagne) {
				System.out.println("L'IA a gagné !");
				System.out.println("La partie est finie ! Il y a eu " + nbEssais + " essai(s) !");
				partieFinie= true;
			}
					
			else if (joueurH.gagne) {
				System.out.println("VOUS avez gagné");
				System.out.println("La partie est finie ! Il y a eu " + nbEssais + " essai(s) !");
				partieFinie= true;
				
			}
			else {
			
				partieFinie= false;

		}}
		return partieFinie;
		

			}
	
	@Override
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void jouerDuel(JoueurHumain joueurH, JoueurIA joueurIA) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startAlgo(JoueurIA joueurH, JoueurIA joueurIA) {
		// TODO Auto-generated method stub
		
	}
	
}