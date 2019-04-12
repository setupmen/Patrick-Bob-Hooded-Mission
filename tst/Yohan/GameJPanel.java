package Yohan;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.gui.LifeFigure;
import com.setup_men.patrick_bob.view.figure.gui.menu.gameover.GameOverFigure;
import com.setup_men.patrick_bob.view.figure.gui.menu.pause.PauseFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class GameJPanel extends JPanel implements Runnable {
	private final LifeFigure lifeFigure;
	private final PauseFigure pauseFigure;
	private final GameOverFigure gameOverFigure;
	private ArrayList<ProjectileAnimationThread> projectiles;

	public GameJPanel() {
		this.pauseFigure = new PauseFigure("PAUSA", 0, 0, 1000, 700, PauseFigure.BG_BLUE_TRANSPARENT.getImage());
		this.gameOverFigure = new GameOverFigure("GAME OVER", 0, 0, 1000, 700, PauseFigure.BG_BLUE_TRANSPARENT.getImage());
		this.lifeFigure = new LifeFigure(10, 10, 100, 50, ViewConstants.FUTURA_FONT);
		
		this.createProjectiles(5);
		
		for (ProjectileAnimationThread projectileAnimationThread : projectiles) {
			new Thread(projectileAnimationThread).start();
		}
		
		this.activateThread();
	}
	
	private void createProjectiles(int size) {
		this.projectiles = new ArrayList<>();
		Random rnd = new Random();
		
		for (int i = 0; i < size; i++) {
			this.projectiles.add(new  ProjectileAnimationThread(1000, rnd.nextInt(500)+ 100, 
					100, 70, 1, null, rnd.nextInt(20)+3, rnd.nextInt(20)+8));
		}
	}

	@Override
	public void paint(Graphics g) {
		synchronized (this) {
			super.paint(g);
			ViewConstants.levelFigure.draw(g);
			ViewConstants.PATRICK_BOB_FIGURE.draw(g);
			
			this.lifeFigure.draw(g);
			if (ViewConstants.isPaused)
				this.pauseFigure.draw(g);
			if(ViewConstants.isGameOvered)
				this.gameOverFigure.draw(g);
			
			for (ProjectileAnimationThread projectileAnimationThread : projectiles) {
				projectileAnimationThread.draw(g);
			}
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
