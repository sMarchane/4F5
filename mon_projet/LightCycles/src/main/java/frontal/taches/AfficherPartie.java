package frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import frontal.vues.VueFileAttente;
import frontal.vues.donnees.DonneesVuePartie;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

public class AfficherPartie {

	
	public static void creerTaches(FrontendTasks tasks) {
		
		
		creerDonneesVuePartie(tasks);
		
		
		tasks.taskGroup("AfficherPartie")
		
			.waitsFor(created(DonneesVuePartie.class))
			.andContains(subTasks ->{
				prochaineImagePartie(subTasks);
			});
	}
	
	private static void prochaineImagePartie(FrontendTasks subTasks) {
		subTasks.task("prochaineImagePartie")
		
		.waitsFor(clock().nextTick())
		
		.thenExecutes(inputs -> {
			
			Tick tick = inputs.get(clock().nextTick());
			
			DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
			
			VueFileAttente vuePartie = inputs.get(created(VueFileAttente.class));
			
			donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());
			
			donneesVuePartie.afficherSur(vuePartie);
		});

		
	}

	private static void creerDonneesVuePartie(FrontendTasks tasks) {
		
		tasks.task(create(DonneesVuePartie.class))
		
			.waitsFor("Initialisation")
			
			.executesAndReturnsCreatedValue(inputs ->{
				return new DonneesVuePartie();
			});
	

	
	}
}