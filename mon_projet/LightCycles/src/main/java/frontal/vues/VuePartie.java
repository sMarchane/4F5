package frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import frontal.evenements.EvtAfficherVueParametreTouche;
import frontal.vues.controles.CanvasPartie;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import modeles.monde_LightCycles2d.MondeLightCycles2d;

public class VuePartie extends ViewFx{

	@FXML
	private CanvasPartie canvasPartie;
	
	@FXML
	private Button boutonMaPage;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("boutonMaPage", boutonMaPage);
		installerEvtAfficherVueInterieur();
		Ntro.assertNotNull("canvasPartie", canvasPartie);
		
		initialiserCanvasPartie();
	}

	private void installerEvtAfficherVueInterieur() {
		
		
		EvtAfficherVueParametreTouche evtNtro = NtroApp.newEvent(EvtAfficherVueParametreTouche.class);
		
		boutonMaPage.setOnAction(evtFx -> {
			
			
			
			evtNtro.trigger();
			
			
		});
	}
	private void initialiserCanvasPartie() {
		
		canvasPartie.setWorldWidth(MondeLightCycles2d.LARGEUR_MONDE);
		canvasPartie.setWorldHeight(MondeLightCycles2d.HAUTEUR_MONDE);
		
		
	}

	public void viderCanvas() {
		canvasPartie.clearCanvas();
		
	}

	public void afficherImagesParSeconde(String fps) {
		canvasPartie.displayFps(fps);
		
	}

	public void afficherLightCycles2d(MondeLightCycles2d mondeLightCycles2d) {
		canvasPartie.displayWorld2d(mondeLightCycles2d);
		
	}
	
}
