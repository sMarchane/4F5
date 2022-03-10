package dorsal.taches;


import static ca.ntro.app.tasks.backend.BackendTasks.*;
import ca.ntro.app.tasks.backend.BackendTasks;
import modeles.ModeleTouche;

public class InitialiserModeles {

	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("InitialiserModeles")
		
		.contains(subTasks -> {
			InitialiserModeleTouche(subTasks);
		});
	}
	
	private static void InitialiserModeleTouche(BackendTasks tasks) {
		
		tasks.task("initialiserModeleTouche")
		
			.waitsFor(model(ModeleTouche.class))
			
			.thenExecutes(inputs -> {
				
				
				ModeleTouche touche = inputs.get(model(ModeleTouche.class));
				
				touche.initialiser();
			});
		
		
	}
}
