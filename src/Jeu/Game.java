package Jeu;
import Tools.Parametres;

/**
 *classe m�re de nos diff�rents jeux 
 * 
 * @author julie
 *
 */
public class Game implements Challenger, Defenseur, Duel {

	String nomGame = "";
	boolean IAGagne;
	boolean humainGagne;
	int nbTours = 0;
	int nbEssaisMax = 10;
	Parametres paramJeu ;
	boolean modeDev;
	

	//constructeur par d�faut
	public Game() {
		
				
		this.paramJeu = new Parametres();
		this.nbEssaisMax = paramJeu.getNbEssais();
		this.modeDev = paramJeu.isModeDev();
		System.out.println("Un jeu est cr�� !");

			
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
		// TODO Auto-generated method stub
		
	}



	

	
	
	
}