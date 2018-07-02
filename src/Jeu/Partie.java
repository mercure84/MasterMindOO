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

		// une fois le choix réalisé, on instance le jeu
		while (!choix) {
			int choixJeu = sc.nextInt();
			switch (choixJeu) {
			case 1:
				this.typeJeu = ChoixJeu.COMBINAISON_SECRETE;
				this.nouveauJeu = new CombinaisonSecrete();
				choix = true;
				break;
			case 2:
				this.typeJeu = ChoixJeu.MASTERMIND;
				this.nouveauJeu = new MasterMind();
				choix = true;
				break;
			case 3:
				this.typeJeu = ChoixJeu.MASTERMINDULTRA;
				this.nouveauJeu = new MasterMindUltra();
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
				
				
				// création des joueurs : 1 Humain et 1 IA
				
				this.humain = new JoueurHumain();
				this.IA = new JoueurIA(); 
				
				
				// création de la combinaison pour l'IA si le mode duel ou challenger ont été choisis :
				if (this.modeJeu != ModeJeu.DEFENSEUR) {
					if (this.typeJeu == ChoixJeu.COMBINAISON_SECRETE) {
					this.IA.combinaisonJoueur = new Combinaison(ChoixJeu.COMBINAISON_SECRETE, this.nouveauJeu.paramJeu.getNbCasesCS(), null );
				}
					
					else {
						
						this.IA.combinaisonJoueur = new Combinaison (ChoixJeu.COMBINAISON_SECRETE, this.nouveauJeu.paramJeu.getNbCasesMM(), this.nouveauJeu.paramJeu.ensembleCouleurs);
						
					}
					
					
					
				}
				
				
				}

	
	
	
	public void start() {
		System.out.println("Nous allons jouer au " + this.typeJeu + " en mode " + this.modeJeu + " !");
		
		switch(this.modeJeu) {
	
		
		
		
		}
		
		
		
		
		

		
	
	
}}
