package dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import messages.MsgAjouterTouchePerso;
import modeles.ModeleTouche;

public class modifierVueInterieur {

	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("ModifierVueInterieur")
		
			.waitsFor("InitialiserModeles")
			
			.andContains(subTasks -> {
				ajouterPseudo(subTasks);
			});
	}
	
	private static void ajouterPseudo(BackendTasks tasks) {
		tasks.task("ajouterPseudo")
		
			.waitsFor(message(MsgAjouterTouchePerso.class))
			.thenExecutes(inputs -> {
				
				MsgAjouterTouchePerso msgAjouterTouchePerso = inputs.get(message(MsgAjouterTouchePerso.class));
				ModeleTouche touche = inputs.get(model(ModeleTouche.class));
				
				msgAjouterTouchePerso.ajouterA(touche);
			});
	}
}
