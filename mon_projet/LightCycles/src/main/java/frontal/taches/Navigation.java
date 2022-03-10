package frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import frontal.evenements.EvtAfficherFileAttente;
import frontal.evenements.EvtAfficherVueInterieur;
import frontal.vues.VueFileAttente;
import frontal.vues.VueInterieur;
import frontal.vues.VueRacine;

public class Navigation {

	public static void creerTaches(FrontendTasks tasks) {
		
		tasks.taskGroup("Navigation")
		
			.waitsFor("Initialisation")
			.andContains(subTasks -> {
				
				
				  afficherVueInterieur(subTasks);
				  creerVueFileAttente(subTasks);
				  afficherVueFileAttente(subTasks);
				 
				 
			});
	}
	private static void creerVueFileAttente(FrontendTasks tasks) {
		tasks.task(create(VueFileAttente.class))
		
			.waitsFor(viewLoader(VueFileAttente.class))
			
			.thenExecutesAndReturnsValue(inputs -> {
				
				ViewLoader<VueFileAttente> viewLoader = inputs.get(viewLoader(VueFileAttente.class));
				
				VueFileAttente vueFileAttente = viewLoader.createView();
				
				return vueFileAttente;
			});
	}	
	private static void afficherVueFileAttente(FrontendTasks tasks) {
		tasks.task("afficherVueFileAttente")
		
			.waitsFor(created(VueFileAttente.class))
			
			
			.waitsFor(event(EvtAfficherFileAttente.class))
			
			.thenExecutes(inputs ->{
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
				
				vueRacine.afficherSousVue(vueFileAttente);
			});
	}
	private static void afficherVueInterieur(FrontendTasks tasks) {
		tasks.task("afficherVueInterieur")
		
		.waitsFor(event(EvtAfficherVueInterieur.class))
			
			
			.thenExecutes(inputs ->{
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueInterieur vueInterieur = inputs.get(created(VueInterieur.class));
				
				vueRacine.afficherSousVue(vueInterieur);
			});
	}

}
