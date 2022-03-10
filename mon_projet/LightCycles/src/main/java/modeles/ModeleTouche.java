package modeles;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.ntro.app.models.Model;
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
}
