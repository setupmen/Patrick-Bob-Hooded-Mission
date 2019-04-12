package Yohan;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CanvasJPanel extends JPanel implements Runnable {
	
	ArrayList<ProjectileAnimationThread> bullets = new ArrayList<>();

	public CanvasJPanel(ArrayList<ProjectileAnimationThread> bullets) {
		this.bullets = bullets;
		
		for (ProjectileAnimationThread projectileAnimationThread : bullets) {
			new Thread(projectileAnimationThread).start();
		}
		
		this.activateThread();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (ProjectileAnimationThread projectileAnimationThread : bullets) {
			System.out.println("pa");
			projectileAnimationThread.draw(g);
		}
		
	}
	
	private void activateThread() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (!false) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}
