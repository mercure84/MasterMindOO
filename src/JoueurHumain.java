import java.util.Scanner;

public class JoueurHumain extends Joueur {

	public JoueurHumain() {
		
		super();
		
		System.out.println("Quel est votre nom ?");
		Scanner sc = new Scanner(System.in);
		this.nomJoueur = sc.nextLine();
		
		
		
	}

}
