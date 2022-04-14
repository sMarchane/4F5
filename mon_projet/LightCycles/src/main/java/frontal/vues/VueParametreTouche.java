package frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import LightCycles.Session;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import frontal.evenements.EvtAfficherVuePartie;
import frontal.vues.fragments.FragmentPageTouche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import messages.MsgAjouterTouchePerso;
import modeles.ModeleTouche;
import modeles.valeurs.Touches;


public class VueParametreTouche extends ViewFx{

	@FXML
	private Button boutonJeu;

	@FXML
	private VBox conteneurRendezVous;
	
	@FXML
	private Button  boutonAjouterTouchePerso;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		Ntro.assertNotNull("boutonAjouterTouchePerso", boutonAjouterTouchePerso);
		installerMsgAjouterTouchePerso();
		installerEvtAfficherFileAttente();
		
	}
	private void installerEvtAfficherFileAttente() {
		EvtAfficherVuePartie evtNtro = NtroApp.newEvent(EvtAfficherVuePartie.class);
		
		boutonJeu.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
	}
	public void viderListeTouche() {
		conteneurRendezVous.getChildren().clear();
	}
	
	private Pane petitEspaceVertical() {
		
		Pane petitEspaceVertical = new Pane();
		
		petitEspaceVertical.getStyleClass().add("petit-espace-vertical");
		
		return petitEspaceVertical;
		
	}
	
	public void ajouterRendezVous(FragmentPageTouche fragmentPageTouche) {
		conteneurRendezVous.getChildren().add(fragmentPageTouche.rootNode());
		
		conteneurRendezVous.getChildren().add(petitEspaceVertical());
	}
	private void installerMsgAjouterTouchePerso() {
		MsgAjouterTouchePerso msgAjouterTouchePerso = NtroApp.newMessage(MsgAjouterTouchePerso.class);
		
		boutonAjouterTouchePerso.setOnAction(evtFx -> {
			
			
			msgAjouterTouchePerso.setToucheFront(Session.touche);
			msgAjouterTouchePerso.send();
		});
		
	}
	
	
	
	private String nomAleatoire() {
		List<String> choixDesPseudo = List.of("Touche specialite rapidite",
											  "Touche specialite efficacite",
											  "Touche specialite precision");
		return Ntro.random().choice(choixDesPseudo);
	}
	
}
