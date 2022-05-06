package frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import frontal.vues.VueAMoi;
import modeles.ModeleTouche;


public class AfficherVueAMoi {

	public static void creerTaches(FrontendTasks tasks) {
		
		
		tasks.taskGroup("AfficherVueAMoi")
		
			.waitsFor("Initialisation")
			.andContains(subTasks -> {
				affichervueamoi(subTasks);
				
			});
	}
	private static void affichervueamoi(FrontendTasks tasks) {
		
		tasks.task("affichervueamoi")
			.waitsFor(modified(ModeleTouche.class))
			.executes(inputs -> {
				
				VueAMoi vueAMoi = inputs.get(create(VueAMoi.class));
				
				Modified<ModeleTouche> aMoi = inputs.get(modified(ModeleTouche.class));
				
				ModeleTouche ancienneFile = aMoi.previousValue();
				ModeleTouche fileCourante = aMoi.currentValue();
				
				fileCourante.afficherSurA(vueAMoi);
			});
		
	}
}
