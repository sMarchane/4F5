package modeles;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.Value;
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
	
	public class Touches implements Value {
		private String idTouche;
		private String pseudoPremierJoueur;
		
		
		public Touches() {
			
		}
		
		public Touches(String idTouche, String pseudoPremierJoueur) {
			setIdTouche(idTouche);
			setPseudoPremierJoueur(pseudoPremierJoueur);
			
		}
	}

	public void setIdTouche(String idTouche) {
		// TODO Auto-generated method stub
		
	}

	public void setPseudoPremierJoueur(String pseudoPremierJoueur) {
		// TODO Auto-generated method stub
		
	}
}
