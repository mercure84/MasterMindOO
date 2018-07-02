package Jeu;
import Tools.Parametres;

/**
 *classe mère de nos différents jeux 
 * 
 * @author julie
 *
 */
public class Game implements Challenger, Defenseur, Duel {

	String nomGame = "";
	boolean IAGagne;
	boolean humainGagne;
	Parametres paramJeu ;
	int nbEssaisMax = 10;
	boolean modeDev;	
	

	//constructeur par défaut
	public Game() {
		// chargement des paramètres du fichier config.properties
		
		
		this.paramJeu = new Parametres();
		this.nbEssaisMax = paramJeu.getNbEssais();
		this.modeDev = paramJeu.isModeDev();

		System.out.println("Un jeu est créé !");

			
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
	public void jouerChallenger() {


		
		
		
	}



	

	
	
	
}