package frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import frontal.evenements.EvtAfficherFileAttente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VueInterieur extends ViewFx{

	@FXML
	private Button boutonQuitterPartie;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
		
		
		installerEvtAfficherFileAttente();
	}
	private void installerEvtAfficherFileAttente() {
		
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
		
		boutonQuitterPartie.setOnAction(evtFx -> {
			
			//System.out.println("[VueFileAttente] clic: " + evtFx.getEventType());
			
			evtNtro.trigger();
		});
	}
	
}
