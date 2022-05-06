package messages;

import ca.ntro.app.messages.MessageNtro;
import modeles.ModeleTouche;

public class MsgAjouterTouchePerso extends MessageNtro{

	private String pseudo;
	
	private String toucheFront;
	
	
	public MsgAjouterTouchePerso() {
		
	}

	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getToucheFront() {
		return toucheFront;
	}


	public void setToucheFront(String toucheFront) {
		this.toucheFront = toucheFront;
	}


	public void ajouterA(ModeleTouche touche) {
		
		touche.ajouterTouchePerso(pseudo);
	}


}
