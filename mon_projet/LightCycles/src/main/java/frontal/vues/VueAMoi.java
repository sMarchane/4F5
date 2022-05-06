package frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import frontal.evenements.EvtAfficherVueParametreTouche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import messages.MsgAjouterTouchePerso;



public class VueAMoi extends ViewFx{


	@FXML
	private TextField Pseudo;


	@FXML
	private TextField Front;

	@FXML
	private TextField Gauche;

	@FXML
	private TextField Droite;

	@FXML
	private TextField Boost;

	
	@FXML
	private Button boutonEnregistrer;

	@FXML
	private Button boutonRetour;
	
	@FXML
	private Label labelMessage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("boutonEnregistrer", boutonEnregistrer);
		Ntro.assertNotNull("labelMessage", labelMessage);
		Ntro.assertNotNull("pseudo", Pseudo);
		installerEvtAfficherVueParametreTouche();
		installerMsgAjouterTouchePerso();
	}
	
	
	private void installerEvtAfficherVueParametreTouche() {
		EvtAfficherVueParametreTouche evtNtro = NtroApp.newEvent(EvtAfficherVueParametreTouche.class);
		
		boutonRetour.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
	}
	
	private void installerMsgAjouterTouchePerso() {
		MsgAjouterTouchePerso msgAjouterTouchePerso = NtroApp.newMessage(MsgAjouterTouchePerso.class);
		
		boutonEnregistrer.setOnAction(evtFx -> {
			
			msgAjouterTouchePerso.setPseudo(Pseudo.getText());
			msgAjouterTouchePerso.send();
			
			
			
		});
	}

	public void afficherMessage(String message) {
		labelMessage.setText(message);
	}
}
