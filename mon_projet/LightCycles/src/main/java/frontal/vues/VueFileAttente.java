package frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import frontal.evenements.EvtAfficherFileAttente;
import frontal.evenements.EvtAfficherVueInterieur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VueFileAttente extends ViewFx{

	@FXML
	private Button boutonParametre;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("boutonParametre", boutonParametre);
		installerEvtAfficherVueInterieur();		
	}

	private void installerEvtAfficherVueInterieur() {
		
		
		EvtAfficherVueInterieur evtNtro = NtroApp.newEvent(EvtAfficherVueInterieur.class);
		
		boutonParametre.setOnAction(evtFx -> {
			
			//System.out.println("[VueFileAttente] clic:" + evtFx.getEventType());
			
			evtNtro.trigger();
			
			
		});
	}
	
}
