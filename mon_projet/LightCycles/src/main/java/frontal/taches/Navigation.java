package frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import frontal.evenements.EvtAfficherVueParametreTouche;
import frontal.evenements.EvtAfficherVuePartie;
import frontal.vues.VuePartie;
import frontal.vues.VueParametreTouche;
import frontal.vues.VuePartie;
import frontal.vues.VueRacine;

public class Navigation {

	public static void creerTaches(FrontendTasks tasks) {
		
		tasks.taskGroup("Navigation")
		
			.waitsFor("Initialisation")
			.andContains(subTasks -> {
				
				
				  afficherVueInterieur(subTasks);
				  
				  afficherVueFileAttente(subTasks);
				  
				 
			});
	}
	private static void creerVueFileAttente(FrontendTasks tasks) {
		tasks.task(create(VuePartie.class))
		
			.waitsFor(viewLoader(VuePartie.class))
			
			.thenExecutesAndReturnsValue(inputs -> {
				
				ViewLoader<VuePartie> viewLoader = inputs.get(viewLoader(VuePartie.class));
				
				VuePartie vueFileAttente = viewLoader.createView();
				
				return vueFileAttente;
			});
	}	
	private static void afficherVueFileAttente(FrontendTasks tasks) {
		tasks.task("afficherVueFileAttente")
		
			
			
			
			.waitsFor(event(EvtAfficherVuePartie.class))
			
			.thenExecutes(inputs ->{
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VuePartie vueFileAttente = inputs.get(created(VuePartie.class));
				
				vueRacine.afficherSousVue(vueFileAttente);
			});
	}
	private static void afficherVueInterieur(FrontendTasks tasks) {
		tasks.task("afficherVueInterieur")
		
		.waitsFor(event(EvtAfficherVueParametreTouche.class))
			
			
			.thenExecutes(inputs ->{
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueParametreTouche vueInterieur = inputs.get(created(VueParametreTouche.class));
				
				vueRacine.afficherSousVue(vueInterieur);
			});
	}

}
