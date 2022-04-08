package frontal.vues.donnees;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;
import frontal.vues.VueFileAttente;
import modeles.monde_LightCycles2d.MondeLightCycles2d;

public class DonneesVuePartie implements ViewData{

	
	private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;
	
	
	private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
	private long imagesAfficheesDepuisDernierCalculFps = 0;
	
	private MondeLightCycles2d mondeLightCycles2d = new MondeLightCycles2d();
	private String fpsCourant = "0";
	
	
	
	public void afficherSur(VueFileAttente vuePartie) {
		
		calculerFpsNecessaire();
		
		vuePartie.viderCanvas();
		vuePartie.afficherImagesParSeconde("FPS " + fpsCourant);
		vuePartie.afficherLightCycles2d(mondeLightCycles2d);
		
		imagesAfficheesDepuisDernierCalculFps++;
	}



	private void calculerFpsNecessaire() {
		long horodatageMaintenant = Ntro.time().nowMilliseconds();
		long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;
		
		
		if(millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
			calculerFpsMaintenant(millisecondesEcoulees);
			
			
			imagesAfficheesDepuisDernierCalculFps = 0;
			horodatageDernierCalculFps = horodatageMaintenant;
		}
		
	}



	private void calculerFpsMaintenant(long millisecondesEcoulees) {
		double secondesEcoulees = millisecondesEcoulees / 1E3;
		double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
		
		fpsCourant = String.valueOf(Math.round(fps));
	}



	public void reagirTempsQuiPasse(double elapsedTime) {
		mondeLightCycles2d.onTimePasses(elapsedTime);
		
	}
}
