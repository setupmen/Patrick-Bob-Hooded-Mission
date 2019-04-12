package Yohan;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ProjectileAnimationThread extends Projectile implements Runnable {
	private static final int TIME_POJECTILE = 3; //s
	private int timeOut;
	private long velocity;
	
	public ProjectileAnimationThread(int x, int y, int width, int height, int floor, Color color, 
			int timeOut, long velocity) {
		super(x, y, width, height, floor, color);
		this.timeOut = timeOut;
		this.velocity = velocity;
	}

	@Override
	public void run() {
		while (x > 0) {
			x--;
			try {
//				Thread.sleep(1000*TIME_POJECTILE);
				Thread.sleep(velocity);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
