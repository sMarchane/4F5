package modeles.monde_LightCycles2d;

import ca.ntro.app.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MondeLightCycles2d extends World2dFx<Objet2d, MondeLightCycles2d>{

	public static final double LARGEUR_MONDE = 640;
	public static final double HAUTEUR_MONDE = 320;
	
	private Moto2d moto;
	
	
	@Override
	protected void onMouseEventNotConsumed(MouseEvent evtFx, double worldX, double worldY) {
		
		
	}

	@Override
	protected void initialize() {
		setWidth(LARGEUR_MONDE);
		setHeight(HAUTEUR_MONDE);
		
		moto = new Moto2d();
		addObject2d(moto);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
		
		dessinerTerrain(gc);
		super.draw(gc);
	}

	private void dessinerTerrain(GraphicsContext gc) {
		gc.save();
		
		gc.setLineWidth(2);
		gc.setStroke(Color.LIGHTBLUE);
		
		
		gc.strokeRect(0, 0, getWidth(), getHeight());
		
		gc.restore();
	}
}
