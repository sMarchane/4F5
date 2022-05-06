package frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import frontal.vues.VueParametreTouche;
import frontal.vues.fragments.FragmentPageTouche;
import modeles.ModeleTouche;


public class AfficherVueParametreTouche {

	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("AfficherVueInterieur")
			
			.waitsFor("Initialisation")
			
			.andContains(subTasks -> {
				afficherTouche(subTasks);
			});
	}
	
	private static void afficherTouche(FrontendTasks tasks) {
		
		tasks.task("afficherTouche")
		
			.waitsFor(modified(ModeleTouche.class))
			.waitsFor(viewLoader(FragmentPageTouche.class))
		
			.executes(inputs -> {
				
				VueParametreTouche vueInterieur = inputs.get(created(VueParametreTouche.class));
				Modified<ModeleTouche> touche = inputs.get(modified(ModeleTouche.class));
				
				ViewLoader<FragmentPageTouche> viewLoaderPageTouche = inputs.get(viewLoader(FragmentPageTouche.class));
				
				ModeleTouche ancienFile = touche.previousValue();
				ModeleTouche fileCourante = touche.currentValue();
				
				//touche.currentValue().afficherSur(vueInterieur, viewLoaderPageTouche);
			});
	}
	
}
