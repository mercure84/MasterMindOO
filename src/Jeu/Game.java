package Jeu;
import java.util.List;
import java.util.Scanner;
import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;
import Tools.Parametres;

/**
 *classe m�re de nos diff�rents jeux 
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
	
	@Override
	public void jouerDuel(JoueurHumain joueurH, JoueurIA joueurIA) {
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
	

	//constructeur par d�faut
	public Game() {
		// chargement des param�tres du fichier config.properties
		
		
		this.paramJeu = new Parametres();
		this.nbEssaisMax = paramJeu.getNbEssais();
		this.modeDev = paramJeu.isModeDev();

		//System.out.println("Un jeu est cr�� !");

			
	}
	
	/**
	 * m�thode qui d�finit si le jeu se finit en fonction des r�sultats des propositions VS Indice VS nb de tours maxi
	 * @param gagne
	 * @param nbTours
	 * @param proposition
	 * @return
	 */
	public boolean endGame(boolean gagne, int nbTours, List proposition) {
		
		
		if ((!gagne) && (nbEssais < this.nbEssaisMax)){
			
			return false;
			
		}


		
		if (gagne) {
			System.out.println("C'est gagn� ! Le nombre � trouver �tait bien de " + proposition + " vous y �tes arriv� en " + nbEssais + " essai(s) !");
			
			return true;

		}
		
		if (nbTours >= (this.nbEssaisMax-1)){
			System.out.println("Perdu ! Il n'y a plus d'essais disponibles");
			return true;
		}
		
			return gagne ;
			}
	


	
}