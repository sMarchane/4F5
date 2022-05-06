package dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import dorsal.taches.InitialiserModeles;
import dorsal.taches.modifierVueAMoi;
import dorsal.taches.modifierVueParametreTouche;

public class DorsalLightCycles extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {
		
		InitialiserModeles.creerTaches(tasks);
		modifierVueParametreTouche.creerTaches(tasks);
		modifierVueAMoi.creerTache(tasks);
	}

	@Override
	public void execute() {
		
		
	}

}
