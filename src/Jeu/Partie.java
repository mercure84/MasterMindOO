package Jeu;
import java.util.Scanner;
import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;
import Tools.Parametres;

/**
 * classe qui permet d'instancier une partie avec la création d'un jeu (type de jeu + mode) et des joueurs (1 IA et 1 Humain)
 * @author julie
 * @param <jeuFini>
 *
 */

public class Partie{

	ChoixJeu typeJeu;
	ModeJeu modeJeu; // utilisation d'une ENUM
	JoueurHumain humain = null ;
	JoueurIA IA = null ;
	boolean jeuFini = false;
	Scanner sc = new Scanner(System.in);
	Game nouveauJeu;
	


	/**
	 * initiatilisation du jeu : le constructeur affiche un menu qui permet de
	 * demander à l'utilisateur quel est le jeu auquel il souhaite jouer (typeJeu)
	 * puis quel mode il souhaite lancer (Challenger, Défenseur, Duel ==> modeJeu)
	 */
	public Partie() {
		
		

		

		// 1er menu qui demande le type de Jeu souhaité

		System.out.println("Bienvenu(e) dans les jeux de Julien !");
		System.out.println("A quoi souhaitez-vous jouer aujourd'hui ? voici les choix disponibles :");
		System.out.println("1 - Combinaison secrète");
		System.out.println("2 - MASTERMIND !");
		System.out.println("3 - MasterMind Ultra : testons les algorithmes !");
		boolean choix = false;

		// une fois le choix réalisé, on instancie le jeu
		while (!choix) {
			int choixJeu = sc.nextInt();
			switch (choixJeu) {
			case 1:
				this.typeJeu = ChoixJeu.COMBINAISON_SECRETE;
				
				choix = true;
				break;
			case 2:
				this.typeJeu = ChoixJeu.MASTERMIND;
				
				choix = true;
				break;
			case 3:
				this.typeJeu = ChoixJeu.MASTERMINDULTRA;
				choix = true;
				break;

			default:
				System.out.println(
						"Ce choix n'est pas dans la liste, un jour peut être... En attendant retentez votre chance !");
				sc.nextLine();

			}}

			// 2nd menu qui demande le mode de Jeu souhaité
			choix = false;

			System.out.println("Choisissez maintenant le mode jeu :");
			System.out.println("1 - Challenger : vous devez trouver le code généré par l'IA");
			System.out.println("2 - Défenseur : l'IA cherchera votre code");
			System.out.println("3 - Duel : le premier qui trouve le code de son adversaire gagne !");

			while (!choix) {

				int choixMode = sc.nextInt();
				sc.nextLine();

				switch (choixMode) {
				case 1:
					this.modeJeu = ModeJeu.CHALLENGER;
					choix = true;
					break;

				case 2:
					this.modeJeu = ModeJeu.DEFENSEUR;
					choix = true;
					break;

				case 3:
					this.modeJeu = ModeJeu.DUEL;
					choix = true;
					break;

				default:
					System.out.println("ce choix n'est pas dans la liste !");

				}}
				
				


				
				}

	
	
	
	public void start() {
		boolean rejouer = true;
		
		
		do {
			//création du jeu 
			
			switch (this.typeJeu) {
			
			case COMBINAISON_SECRETE:
				this.nouveauJeu = new CombinaisonSecrete();
				break;
			case MASTERMIND:
				this.nouveauJeu = new MasterMind();
				break;
			case MASTERMINDULTRA:
				this.nouveauJeu = new MasterMindUltra();
				break;
			default:
				break;
			
			
			
			
			}
			
			
			// création des joueurs : 1 Humain et 1 IA
			
			this.humain = new JoueurHumain();
			this.IA = new JoueurIA(); 
			
			
		
		System.out.println("Nous allons jouer à " + this.typeJeu + " en mode " + this.modeJeu + " !");
		
		
		switch (this.modeJeu) {
		case CHALLENGER :
			this.nouveauJeu.jouerChallenger(humain, IA);
			break;
		case DEFENSEUR :
			this.nouveauJeu.jouerDefenseur(humain, IA);
			break;
		case DUEL :
			this.nouveauJeu.jouerDefenseur();
			break;
				
		}

		
		
		} while (rejouer(this.typeJeu));
		

		}




	private boolean rejouer(ChoixJeu typeJeu) {
		while (true) {
			System.out.println("Voulez vous rejouer à " + typeJeu + " ? O / N");
			String reponse = sc.nextLine();
			reponse = reponse.toUpperCase();
			switch (reponse) {
			case "O":
				return true;
			case "N":
				return false;
			default:
				System.out.println("Mauvaise réponse...");
				continue;
			}

		}
		
	}
		
		
		
		
		

		
	
	
}
