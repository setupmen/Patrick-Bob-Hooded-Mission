package Yohan;

import java.awt.Color;

import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobFigure;

public class ProjectileAnimationThread extends Projectile implements Runnable {
	private static final int TIME_POJECTILE = 3; //s
	private int timeOut;
	private long velocity;
	private PatrickBobFigure patrick;
	
	public ProjectileAnimationThread(int x, int y, int width, int height, int floor, Color color, 
			int timeOut, long velocity) {
		super(x, y, width, height, floor, color);
		this.timeOut = timeOut;
		this.velocity = velocity;
		this.patrick = ViewConstants.PATRICK_BOB_FIGURE;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000*timeOut);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (x > -100) {
			x--;
			
			if (isX() && isY()) {
				break;
			}
			
			try {
				Thread.sleep(velocity);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isX() {
		return (x > patrick.getX() && x < patrick.getX()+patrick.getWidth());
	}
	
	public boolean isY() {
		return (y > patrick.getY() && x < patrick.getY()+patrick.getHeight());
	}
	
}
