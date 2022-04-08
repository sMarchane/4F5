package modeles.monde_LightCycles2d;

import ca.ntro.core.initialization.Ntro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;

public class Moto2d extends Objet2d{

	
	private static final double EPSILON = 1;
	
	@Override
	protected boolean onMouseEvent(MouseEvent evtFx, double worldX, double worldY) {
		
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.fillArc(getTopLeftX(), getTopLeftY(), getWidth(), getHeight(), 0, 360, ArcType.CHORD);
		
	}

	@Override
	public void initialize() {
		setTopLeftX(100);
		setTopLeftX(100);
		setWidth(10);
		setHeight(10);
		
		setSpeedX(100 + Ntro.random().nextInt(100));
		setSpeedY(100 + Ntro.random().nextInt(100));
	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);
		
		
		
		if(motoFrappeMurGauche()) {
			motoRebondiSurMurGauche();
		}else if(motoFrappeMurDroit()) {
			motoRebondiSurMurDroit();
		}else if(motoFrappePlafond()) {
			motoRebondiSurPlafond();
		}else if(motoFrappePlancher()) {
			motoRebondiSurPlancher();
		}
	}

	private void motoRebondiSurPlancher() {
		setTopLeftY(getWorld().getHeight() - this.getHeight() - EPSILON);
		setSpeedY(-getSpeedY());
	}

	private boolean motoFrappePlancher() {
		
		return collidesWith(0, getWorld().getHeight(), getWorld().getWidth(), 1);
	}

	private void motoRebondiSurPlafond() {
		setTopLeftY(0 + EPSILON);
		setSpeedY(-getSpeedY());
	}

	private boolean motoFrappePlafond() {
		
		return collidesWith(0,  0, getWorld().getWidth(), 1);
	}

	private void motoRebondiSurMurDroit() {
		setTopLeftX(getWorld().getWidth() - this.getWidth() - EPSILON);
		setSpeedX(-getSpeedX());
	}

	private boolean motoFrappeMurDroit() {
		
		return collidesWith(getWorld().getWidth(), 0, 1, getWorld().getHeight());
	}

	private void motoRebondiSurMurGauche() {
		setTopLeftX(0 + EPSILON);
		setSpeedX(-getSpeedX());
	}

	private boolean motoFrappeMurGauche() {
		
		return collidesWith(0, 0, 1, getWorld().getHeight());
	}
}
