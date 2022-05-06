package frontal;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import frontal.evenements.EvtAfficherVueAMoi;
import frontal.evenements.EvtAfficherVueParametreTouche;
import frontal.evenements.EvtAfficherVuePartie;
import frontal.taches.AfficherPartie;
import frontal.taches.AfficherVueAMoi;
import frontal.taches.AfficherVueParametreTouche;
import frontal.taches.Initialisation;
import frontal.taches.Navigation;
import frontal.vues.VuePartie;
import frontal.vues.VueAMoi;
import frontal.vues.VueParametreTouche;
import frontal.vues.VuePartie;
import frontal.vues.VueRacine;
import frontal.vues.donnees.DonneesVuePartie;
import frontal.vues.fragments.FragmentPageTouche;

public class FrontalLightCycles implements FrontendFx{


	@Override
	public void createTasks(FrontendTasks tasks) {

		Initialisation.creerTaches(tasks);
		Navigation.creerTaches(tasks);
		
		AfficherVueParametreTouche.creerTaches(tasks);
		
		AfficherPartie.creerTaches(tasks);
		
		AfficherVueAMoi.creerTaches(tasks);
	}

	@Override
	public void execute() {
		
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		
		
		registrar.registerEvent(EvtAfficherVueParametreTouche.class);
		registrar.registerEvent(EvtAfficherVuePartie.class);
		registrar.registerEvent(EvtAfficherVueAMoi.class);
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
		
		registrar.registerView(VueRacine.class, "/racine.xml");
		
		registrar.registerView(VueParametreTouche.class, "/Vue_interieur.xml");
		
		registrar.registerView(VuePartie.class, "/file_attente.xml");
		
		registrar.registerView(VueAMoi.class, "/VueAMoi.xml");
		
		registrar.registerStylesheet("/LightCycles.css");
		
		registrar.registerDefaultResources("/chaines_fr.properties");
		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
		
		registrar.registerView(FragmentPageTouche.class, "/fragments/page_touche.xml");
		
		registrar.registerViewData(DonneesVuePartie.class);
		
	}

}
