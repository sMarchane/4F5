package frontal;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import frontal.taches.Initialisation;
import frontal.vues.VueInterieur;
import frontal.vues.VueRacine;

public class FrontalLightCycles implements FrontendFx{


	@Override
	public void createTasks(FrontendTasks tasks) {

		Initialisation.creerTaches(tasks);
	}

	@Override
	public void execute() {
		
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
		
		registrar.registerView(VueRacine.class, "/racine.xml");
		
		registrar.registerView(VueInterieur.class, "/Vue_interieur.xml");
		
		registrar.registerStylesheet("/LightCycles.css");
		
		registrar.registerDefaultResources("/chaines_fr.properties");
		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
	}

}
