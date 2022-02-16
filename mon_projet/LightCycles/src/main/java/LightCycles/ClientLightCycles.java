package LightCycles;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import frontal.FrontalLightCycles;

public class ClientLightCycles implements NtroClientFx {

	public static void main(String[] args) {
		NtroClientFx.launch(args);

	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		
		
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(new FrontalLightCycles());
		
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		
		
	}

}
