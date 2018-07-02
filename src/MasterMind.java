import java.util.ArrayList;
import java.util.List;

public class MasterMind extends Game {
	int nbCouleurs ;
	int nbCases;
	

	
	public MasterMind() {
		super();
		this.nomGame = "MasterMind";
		this.nbCouleurs = paramJeu.getNbCouleursMM();
		this.nbCases = paramJeu.getNbCasesMM();
		System.out.println("MM");
		
		
	}
	
	

}
