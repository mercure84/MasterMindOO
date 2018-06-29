import java.util.Scanner;

public class Partie {

	Game typeJeu = null;
	String modeJeu = null; // 1 = challenger, 2 = d�fenseur, 3 = duel

	/**
	 * initiatilisation du jeu : le constructeur affiche un menu qui permet de
	 * demander � l'utilisateur quel est le jeu auquel il souhaite jouer (typeJeu)
	 * puis quel mode il souhaite lancer (Challenger, D�fenseur, Duel ==> modeJeu)
	 */
	public Partie() {

		// 1er menu qui demande le type de Jeu souhait�

		System.out.println("Bienvenu(e) dans les jeux de Julien !");
		System.out.println("A quoi souhaitez-vous jouer aujourd'hui ? voici les choix disponibles :");
		System.out.println("1 - Combinaison secr�te");
		System.out.println("2 - MASTERMIND !");
		System.out.println("3 - MasterMind Ultra : testons les algorithmes !");
		boolean choix = false;

		Scanner sc = new Scanner(System.in);
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
						"Ce choix n'est pas dans la liste, un jour peut �tre... En attendant retentez votre chance !");
				sc.nextLine();

			}}

			// 2nd menu qui demande le mode de Jeu souhait�
			choix = false;

			System.out.println("Choisissez maintenant le mode jeu :");
			System.out.println("1 - Challenger : vous devez trouver le code g�n�r� par l'IA");
			System.out.println("2 - D�fenseur : l'IA cherchera votre code");
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
					this.modeJeu = "d�fenseur";
					choix = true;
					break;

				case 3:
					this.modeJeu = "duel";
					choix = true;
					break;

				default:
					System.out.println("ce choix n'est pas dans la liste !");

				}
			}

		}

	
	
	
	public void start() {
		// TODO Auto-generated method stub
		
	}
	}

