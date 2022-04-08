package frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import frontal.evenements.EvtAfficherFileAttente;
import frontal.vues.fragments.FragmentPageTouche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import messages.MsgAjouterTouchePerso;
import modeles.ModeleTouche;
import modeles.valeurs.Touches;


public class VueInterieur extends ViewFx{

	@FXML
	private Button boutonMaPage;

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
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
		
		boutonMaPage.setOnAction(evtFx -> {
			
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
			
			
			msgAjouterTouchePerso.setToucheFront(nomAleatoire());
			msgAjouterTouchePerso.send();
		});
		
	}
	
	
	
	private String nomAleatoire() {
		List<String> choixDesPseudo = List.of("Touche spécialité rapiditié",
											  "Touche spécialité efficacité",
											  "Touche spécialité précision");
		return Ntro.random().choice(choixDesPseudo);
	}
	
}
