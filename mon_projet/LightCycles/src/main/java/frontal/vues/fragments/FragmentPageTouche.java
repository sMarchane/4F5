package frontal.vues.fragments;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import frontal.evenements.EvtAfficherVueParametreTouche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FragmentPageTouche extends ViewFx{

	@FXML
	private Button boutonOuvrirFileAttente;
	
	@FXML
	private Label labelNomTouche;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		Ntro.assertNotNull("boutonOuvrirFileAttente", boutonOuvrirFileAttente);
		Ntro.assertNotNull("labelNomPremierJoueur", labelNomTouche);
		
		installerEvtAfficherVueInterieur();
		
	}
	private void installerEvtAfficherVueInterieur() {
		
		EvtAfficherVueParametreTouche evtNtro = NtroApp.newEvent(EvtAfficherVueParametreTouche.class);
		
		
		boutonOuvrirFileAttente.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
		
	}
	
	public void afficherNomPremierJoueur(String nomTouche) {
		labelNomTouche.setText(nomTouche);
	}
}
