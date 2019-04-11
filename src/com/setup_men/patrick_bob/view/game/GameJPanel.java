package com.setup_men.patrick_bob.view.game;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.gui.LifeFigure;
import com.setup_men.patrick_bob.view.figure.gui.menu.gameover.GameOverFigure;
import com.setup_men.patrick_bob.view.figure.gui.menu.pause.PauseFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class GameJPanel extends JPanel {
	private final LifeFigure lifeFigure;
	private final PauseFigure pauseFigure;
	private final GameOverFigure gameOverFigure;

	public GameJPanel() {
		this.pauseFigure = new PauseFigure("PAUSA", 0, 0, 1000, 700, PauseFigure.BG_BLUE_TRANSPARENT.getImage());
		this.gameOverFigure = new GameOverFigure("GAME OVER", 0, 0, 1000, 700, PauseFigure.BG_BLUE_TRANSPARENT.getImage());
		this.lifeFigure = new LifeFigure(10, 10, 100, 50, ViewConstants.FUTURA_FONT);
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
		}
	}

}
