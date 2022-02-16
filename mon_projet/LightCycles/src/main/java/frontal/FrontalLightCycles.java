package frontal;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class FrontalLightCycles implements FrontendFx{


	@Override
	public void createTasks(FrontendTasks tasks) {
		tasks.task("afficherFenetre")
		.waitsFor(window())
		.thenExecutes(inputs ->{
			Window window = inputs.get(window());
			window.show();
		});
		
	}

	@Override
	public void execute() {
		
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
		
	}

}
