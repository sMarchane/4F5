package messages;

import ca.ntro.app.messages.MessageNtro;
import modeles.ModeleTouche;

public class MsgAjouterTouchePerso extends MessageNtro{

	private String pseudoPremierJoueur;
	
	public MsgAjouterTouchePerso() {
		
	}

	public String getPseudoPremierJoueur() {
		return pseudoPremierJoueur;
	}

	public void setPseudoPremierJoueur(String pseudoPremierJoueur) {
		this.pseudoPremierJoueur = pseudoPremierJoueur;
	}
	
	public void ajouterA(ModeleTouche touche) {
		
		touche.ajouterTouchePerso(pseudoPremierJoueur);
	}
}
