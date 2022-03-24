package dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import dorsal.taches.InitialiserModeles;
import dorsal.taches.modifierVueInterieur;

public class DorsalLightCycles extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {
		
		InitialiserModeles.creerTaches(tasks);
		modifierVueInterieur.creerTaches(tasks);
	}

	@Override
	public void execute() {
		
		
	}

}
