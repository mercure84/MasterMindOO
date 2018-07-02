package Jeu;
import java.util.Scanner;
import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;
import Tools.Parametres;

/**
 *classe mère de nos différents jeux 
 * 
 * @author julie
 *
 */
public class Game implements Jouable {

	@Override
	public void jouerChallenger(JoueurHumain joueurH, JoueurIA joueurIA) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void jouerDefenseur() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void joueurIndique() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void jouerDefenseur(JoueurHumain joueurH, JoueurIA joueurIA) {
		// TODO Auto-generated method stub
		
	}


	ChoixJeu typeJeu;
	boolean IAGagne;
	boolean humainGagne;
	Parametres paramJeu ;
	int nbEssaisMax = 10;
	int nbEssais = 0;
	boolean modeDev;
	Scanner sc = new Scanner(System.in);
	

	//constructeur par défaut
	public Game() {
		// chargement des paramètres du fichier config.properties
		
		
		this.paramJeu = new Parametres();
		this.nbEssaisMax = paramJeu.getNbEssais();
		this.modeDev = paramJeu.isModeDev();

		//System.out.println("Un jeu est créé !");

			
	}
	


	
}