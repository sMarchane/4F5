package LightCycles;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.app.world2d.Object2d;
import messages.MsgAjouterTouchePerso;
import modeles.ModeleTouche;
import modeles.monde_LightCycles2d.MondeLightCycles2d;
import modeles.monde_LightCycles2d.Moto2d;
import modeles.valeurs.Touches;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterTouchePerso.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleTouche.class);
		
		registrar.registerValue(Touches.class);
		registrar.registerValue(MondeLightCycles2d.class);
		registrar.registerValue(Moto2d.class);
		registrar.registerValue(Object2d.class);
	}



	public static void declarerServeur(ServerRegistrar registrar) {
		registrar.registerName("localhost");
		registrar.registerPort(8002);

		
	}

}
