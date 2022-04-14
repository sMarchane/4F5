package dorsal;

import LightCycles.Declarations;
import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;

public class DorsalLightCyclesDistant extends RemoteBackendNtro{

	@Override
	public void registerServer(ServerRegistrar registrar) {
		Declarations.declarerServeur(registrar);
		
	}

}
