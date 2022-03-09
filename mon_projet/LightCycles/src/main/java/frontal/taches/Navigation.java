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
				
				
				  afficherVueFileAttente(subTasks);
				  creerVueInterieur(subTasks);
				  afficherVueInterieur(subTasks);
				 
				 
			});
	}
	private static void creerVueInterieur(FrontendTasks tasks) {
		tasks.task(create(VueInterieur.class))
		
			.waitsFor(viewLoader(VueInterieur.class))
			
			.thenExecutesAndReturnsValue(inputs -> {
				
				ViewLoader<VueInterieur> viewLoader = inputs.get(viewLoader(VueInterieur.class));
				
				VueInterieur vueInterieur = viewLoader.createView();
				
				return vueInterieur;
			});
	}	
	private static void afficherVueInterieur(FrontendTasks tasks) {
		tasks.task("afficherVueInterieur")
		
			.waitsFor(created(VueInterieur.class))
			
			
			.waitsFor(event(EvtAfficherVueInterieur.class))
			
			.thenExecutes(inputs ->{
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueInterieur vueInterieur = inputs.get(created(VueInterieur.class));
				
				vueRacine.afficherSousVue(vueInterieur);
			});
	}
	private static void afficherVueFileAttente(FrontendTasks tasks) {
		tasks.task("afficherVueFileAttente")
		
		.waitsFor(event(EvtAfficherFileAttente.class))
			
			
			.thenExecutes(inputs ->{
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
				
				vueRacine.afficherSousVue(vueFileAttente);
			});
	}

}
