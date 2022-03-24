package frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import frontal.evenements.EvtAfficherFileAttente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import messages.MsgAjouterTouchePerso;
import modeles.ModeleTouche;
import modeles.valeurs.Touches;


public class VueInterieur extends ViewFx{

	@FXML
	private Button boutonFileAttente;

	@FXML
	private Button  boutonAjouterTouchePerso;

	@FXML
	private Label labelMessage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("boutonFileAttente", boutonFileAttente);
		
		
		installerEvtAfficherFileAttente();
		
		Ntro.assertNotNull("boutonAjouterTouchePerso", boutonAjouterTouchePerso);
		installerMsgAjouterTouchePerso();
		
		Ntro.assertNotNull("labelMessage", labelMessage);
	}
	private void installerEvtAfficherFileAttente() {
		
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
		
		boutonFileAttente.setOnAction(evtFx -> {
			
			//System.out.println("[VueFileAttente] clic: " + evtFx.getEventType());
			
			evtNtro.trigger();
		});
	}
	
	private void installerMsgAjouterTouchePerso() {
		MsgAjouterTouchePerso msgAjouterTouchePerso = NtroApp.newMessage(MsgAjouterTouchePerso.class);
		
		boutonAjouterTouchePerso.setOnAction(evtFx -> {
			
			
			msgAjouterTouchePerso.setPseudoPremierJoueur(nomAleatoire());
			msgAjouterTouchePerso.send();
		});
		
	}
	
	
	
	private String nomAleatoire() {
		List<String> choixDesPseudo = List.of("Srocma17",
											  "GamingBoy2002",
											  "Gregpower",
											  "Drazox1999",
											  "SavageBlood",
											  "Kruxx",
											  "Zeyrox123",
											  "Raven2020");
		return Ntro.random().choice(choixDesPseudo);
	}
	
	public void afficherMessage(String message) {
		labelMessage.setText(message);
	}
}
