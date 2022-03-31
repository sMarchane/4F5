package modeles.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Value;
import frontal.vues.fragments.FragmentPageTouche;

public class Touches implements Value{

	private String idTouchePerso;
	private String pseudoJoueur;
	private String toucheFront;
	private String toucheLeft;
	private String toucheRight;
	private String toucheBoost;
		
	
	public Touches() {
		
	}
	public Touches(String idTouche, String pseudoPremierJoueur) {
		setIdTouchePerso(idTouche);
		setPseudoJoueur(pseudoPremierJoueur);
			
	}
	
	public String toString() {
		return pseudoJoueur;
	}
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
	public FragmentPageTouche creerFragment(ViewLoader<FragmentPageTouche> viewLoaderPageTouche) {
		
		return viewLoaderPageTouche.createView();
	}
	public void afficherSur(FragmentPageTouche fragmentTouche) {
		
		fragmentTouche.afficherNomPremierJoueur(pseudoJoueur);
	}
		
}
