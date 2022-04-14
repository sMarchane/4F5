package frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.viewLoader;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import frontal.vues.VueRacine;
import frontal.vues.VuePartie;
import frontal.vues.VueParametreTouche;
import frontal.vues.VuePartie;



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
				creerVueInterieur(subTasks);
				
				installerVueRacine(subTasks);
				installerVueInterieur(subTasks);
				
				creerVueFileAttente(subTasks);
				
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
	
	private static void afficherFenetre(FrontendTasks tasks) {
		
		tasks.task("afficherFenetre")
		
			.waitsFor(window())
			
			.thenExecutes(inputs -> {
				
				Window window = inputs.get(window());
				
				window.show();
			});	
		
	}
	private static void installerVueInterieur(FrontendTasks tasks) {
		tasks.task("installerVueInterieur")
		
			.waitsFor(created(VueRacine.class))
			
			
			.waitsFor(created(VueParametreTouche.class))
			
			.thenExecutes(inputs ->{
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueParametreTouche vueInterieur = inputs.get(created(VueParametreTouche.class));
				
				vueRacine.afficherSousVue(vueInterieur);
			});
	}
	private static void creerVueInterieur(FrontendTasks tasks) {
		tasks.task(create(VueParametreTouche.class))
		
			.waitsFor(viewLoader(VueParametreTouche.class))
			
			.thenExecutesAndReturnsValue(inputs -> {
				
				ViewLoader<VueParametreTouche> viewLoader = inputs.get(viewLoader(VueParametreTouche.class));
				
				VueParametreTouche vueInterieur = viewLoader.createView();
				
				return vueInterieur;
			});
	}
	
	
}