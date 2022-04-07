package messages;

import ca.ntro.app.messages.MessageNtro;
import modeles.ModeleTouche;

public class MsgAjouterTouchePerso extends MessageNtro{

	private String toucheFront;
	
	public MsgAjouterTouchePerso() {
		
	}

	
	public String getToucheFront() {
		return toucheFront;
	}


	public void setToucheFront(String toucheFront) {
		this.toucheFront = toucheFront;
	}


	public void ajouterA(ModeleTouche touche) {
		
		touche.ajouterTouchePerso(toucheFront);
	}
}
