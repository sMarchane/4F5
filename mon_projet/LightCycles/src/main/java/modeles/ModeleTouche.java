package modeles;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.Value;
import frontal.vues.VueAMoi;
import frontal.vues.VueParametreTouche;
import frontal.vues.fragments.FragmentPageTouche;
import modeles.valeurs.Touches;

public class ModeleTouche implements Model{

	private long dateSauvegardeTouche = -1;
	private List<Touches> lesTouchesPerso = new ArrayList<>();
	

	public long getDateSauvegardeTouche() {
		return dateSauvegardeTouche;
	}

	public void setDateSauvegardeTouche(long dateSauvegardeTouche) {
		this.dateSauvegardeTouche = dateSauvegardeTouche;
	}
	
	public List<Touches> getLesTouchesPerso() {
		return lesTouchesPerso;
	}

	public void setLesTouchesPerso(List<Touches> lesTouchesPerso) {
		this.lesTouchesPerso = lesTouchesPerso;
	}

	public ModeleTouche() {
		
	}
	public void initialiser() {
		Date maintenant = new Date();
		dateSauvegardeTouche = maintenant.getTime();
		
		System.out.println("[ModeleTouche] " + new SimpleDateFormat("EEEE dd MMMM, HH:mm").format(maintenant));
	}
	public void ajouterTouchePerso(String pseudoPremierJoueur) {
		
		String idTouche = genererIdTouche();
		
		Touches touche = new Touches(idTouche, pseudoPremierJoueur);
		
		lesTouchesPerso.add(touche);
	}
	private String genererIdTouche() {
		String idTouche = String.valueOf(dateSauvegardeTouche);
		
		dateSauvegardeTouche++;
		
		return idTouche;
	}
	
	
	/*public void afficherSur(VueParametreTouche vueInterieur, ViewLoader<FragmentPageTouche> viewLoaderPageTouche) {
		
		vueInterieur.viderListeTouche();
		
		for(Touches touches : lesTouchesPerso) {
			FragmentPageTouche fragmentTouche = touches.creerFragment(viewLoaderPageTouche);
			
			touches.afficherSur(fragmentTouche);
			
			vueInterieur.ajouterRendezVous(fragmentTouche);
		}
	}*/
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		int numTouche = 1;
		
		for(Touches touche : lesTouchesPerso) {
			builder.append(numTouche);
			builder.append(". ");
			builder.append(touche.toString());
			builder.append("\n");
			
			numTouche++;
		}
		
		return builder.toString();
	}
	public void afficherSurA(VueAMoi vueAMoi) {
		vueAMoi.afficherMessage(this.toString());
	}
	
}
