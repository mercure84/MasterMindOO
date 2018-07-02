package Jeu;
import java.util.Scanner;

import Joueur.JoueurHumain;
import Joueur.JoueurIA;
import Tools.Combinaison;

/**
 * classe qui permet d'instancier une partie avec la création d'un jeu (type de jeu + mode) et des joueurs (1 IA et 1 Humain)
 * @author julie
 * @param <jeuFini>
 *
 */

public class Partie<jeuFini> {

	Game typeJeu = null;
	String modeJeu = null; // 1 = challenger, 2 = défenseur, 3 = duel
	JoueurHumain humain = null ;
	JoueurIA IA = null ;
	boolean jeuFini = false;
	Scanner sc = new Scanner(System.in);

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

		
		while (!choix) {
			int choixJeu = sc.nextInt();
			switch (choixJeu) {
			case 1:
				this.typeJeu = new CombinaisonSecrete();
				choix = true;
				break;
			case 2:
				this.typeJeu = new MasterMind();
				choix = true;
				break;
			case 3:
				this.typeJeu = new MasterMindUltra();
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
					this.modeJeu = "challenger";
					choix = true;
					break;

				case 2:
					this.modeJeu = "défenseur";
					choix = true;
					break;

				case 3:
					this.modeJeu = "duel";
					choix = true;
					break;

				default:
					System.out.println("ce choix n'est pas dans la liste !");

				}}
				
				
				// création des joueurs : 1 Humain et 1 IA
				
				this.humain = new JoueurHumain();
				this.IA = new JoueurIA(); 
				
				
				// création de la combinaison pour l'IA si le mode duel ou challenger ont été choisis :
				if (this.modeJeu != "defenseur") {
					if (this.typeJeu.nomGame == "Combinaison Secrète") {
					this.IA.combinaisonJoueur = new Combinaison (this.typeJeu.nomGame, this.typeJeu.paramJeu.getNbCasesCS(), null);
				}
					
					if (this.typeJeu.nomGame == "MasterMind") {
						
						this.IA.combinaisonJoueur = new Combinaison (this.typeJeu.nomGame, this.typeJeu.paramJeu.getNbCasesMM(), this.typeJeu.paramJeu.ensembleCouleurs);
						
					}
					
					
					
				}
				
				
				}

	
	
	
	public void start() {
		boolean reJouer = false;
	
		System.out.println("Nous allons jouer au " + this.typeJeu.nomGame + " en mode " + this.modeJeu + " !");
		
		
		
		
		
		
	
	
}}
