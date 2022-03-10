package modeles.valeurs;

import ca.ntro.app.models.Value;

public class Touches implements Value{

	private String idTouchePerso;
	private String pseudoJoueur;
	private String toucheFront;
	private String toucheLeft;
	private String toucheRight;
	private String toucheBoost;
	
	public String getToucheFront() {
		return toucheFront;
	}


	public void setToucheFront(String toucheFront) {
		this.toucheFront = toucheFront;
	}


	public String getToucheLeft() {
		return toucheLeft;
	}


	public void setToucheLeft(String toucheLeft) {
		this.toucheLeft = toucheLeft;
	}


	public String getToucheRight() {
		return toucheRight;
	}


	public void setToucheRight(String toucheRight) {
		this.toucheRight = toucheRight;
	}


	public String getToucheBoost() {
		return toucheBoost;
	}


	public void setToucheBoost(String toucheBoost) {
		this.toucheBoost = toucheBoost;
	}


	public String getIdTouchePerso() {
		return idTouchePerso;
	}


	public void setIdTouchePerso(String idTouchePerso) {
		this.idTouchePerso = idTouchePerso;
	}


	public String getPseudoJoueur() {
		return pseudoJoueur;
	}


	public void setPseudoJoueur(String pseudoJoueur) {
		this.pseudoJoueur = pseudoJoueur;
	}


	public Touches() {
		
		
	}
	
	
}