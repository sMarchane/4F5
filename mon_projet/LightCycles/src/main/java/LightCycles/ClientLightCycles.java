package LightCycles;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import dorsal.DorsalLightCycles;
import dorsal.DorsalLightCyclesDistant;
import frontal.FrontalLightCycles;
import modeles.enums.Cadran;

public class ClientLightCycles implements NtroClientFx {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			Session.touche = args[0];
		}
		
		if(args.length > 1) {
			Session.cadran = Cadran.valueOf(args[1]);
		}

		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		registrar.registerBackend(new DorsalLightCyclesDistant());
		
		
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(new FrontalLightCycles());
		
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		Declarations.declarerMessages(registrar);
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		
		Declarations.declarerModeles(registrar);
	}

}
