package dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;
import ca.ntro.app.tasks.backend.BackendTasks;
import messages.MsgAjouterTouchePerso;
import modeles.ModeleTouche;

public class modifierVueAMoi {

	public static void creerTache(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierVueAMoi")
		
			.waitsFor("InitialiserModeles")
			
			.andContains(subTasks -> {
				
				ajouterTouchePerso(subTasks);
			});
		
	}
	
	private static void ajouterTouchePerso(BackendTasks tasks) {
		tasks.task("ajouterTouchePerso")
		
			.waitsFor(message(MsgAjouterTouchePerso.class))
			.thenExecutes(inputs -> {
				MsgAjouterTouchePerso msgAjouterTouchePerso = inputs.get(message(MsgAjouterTouchePerso.class));
				ModeleTouche touche = inputs.get(model(ModeleTouche.class));
				
				msgAjouterTouchePerso.ajouterA(touche);
			});
	}
}
