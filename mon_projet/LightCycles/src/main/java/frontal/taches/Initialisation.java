package frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.viewLoader;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import frontal.vues.VueRacine;
import frontal.vues.VueFileAttente;



public class Initialisation {
	
	private static void installerVueRacine(FrontendTasks tasks) {
		tasks.task("installerVueRacine")
		
			.waitsFor(window())
			
			.waitsFor(created(VueRacine.class))
			
			.thenExecutes(inputs -> {
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				Window window = inputs.get(window());
				
				window.installRootView(vueRacine);
			});
	}
	
	public static void creerVueRacine(FrontendTasks tasks) {
		tasks.task(create(VueRacine.class))
		
			.waitsFor(viewLoader(VueRacine.class))
			
			.thenExecutesAndReturnsValue(inputs -> {
				
				ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));
				
				VueRacine vueRacine = viewLoader.createView();
				
				return vueRacine;
			});
	}
	public static void creerTaches(FrontendTasks tasks) {
		
		tasks.taskGroup("Initialisation")
			.contains(subTasks -> {
				
				afficherFenetre(subTasks);
				
				creerVueRacine(subTasks);
				creerVueFileAttente(subTasks);
				
				installerVueRacine(subTasks);
				installerVueFileAttente(subTasks);
			});
		
	}	
	
	private static void afficherFenetre(FrontendTasks tasks) {
		
		tasks.task("afficherFenetre")
		
			.waitsFor(window())
			
			.thenExecutes(inputs -> {
				
				Window window = inputs.get(window());
				
				window.show();
			});	
		
	}
	private static void installerVueFileAttente(FrontendTasks tasks) {
		tasks.task("installerVueFileAttente")
		
			.waitsFor(created(VueRacine.class))
			
			
			.waitsFor(created(VueFileAttente.class))
			
			.thenExecutes(inputs ->{
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
				
				vueRacine.afficherSousVue(vueFileAttente);
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
	
	
}