
/**
 *classe mère de nos différents jeux 
 * 
 * @author julie
 *
 */
public class Game {

	String nomGame = "";
	boolean IAGagne;
	boolean humainGagne;
	int nbTours = 0;
	int nbEssaisMax = 10;
	Parametres paramJeu ;
	boolean modeDev;
	
	Combinaison combiATrouver = null;
	
	
	
	//constructeur par défaut
	public Game() {
		
				
		this.paramJeu = new Parametres();
		this.nbEssaisMax = paramJeu.getNbEssais();
		this.modeDev = paramJeu.isModeDev();
		System.out.println("Un jeu est créé !");

			
	}



	

	
	
	
}