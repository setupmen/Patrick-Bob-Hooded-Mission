package com.setup_men.patrick_bob.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.setup_men.patrick_bob.utilities.Utilities;
import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.gui.ButtonFigure;
import com.setup_men.patrick_bob.view.figure.gui.menu.gameover.GameOverCommands;
import com.setup_men.patrick_bob.view.figure.gui.menu.pause.PauseCommands;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 2/04/2019
 **/
public class MousepadListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	private <T extends Enum<T>> void clickDirector(T command) {
		if (ViewConstants.isPaused && command instanceof PauseCommands) {
			PauseCommands pauseCommand = (PauseCommands) command;
			switch (pauseCommand) {
			case RESUME:
				ViewConstants.isPaused = false;
				break;
			case OPTIONS:
				break;
			case EXIT:
				System.exit(0);
				break;
			}
		} else if (ViewConstants.isGameOvered && command instanceof GameOverCommands) {
			GameOverCommands gameOverCommand = (GameOverCommands) command;
			switch (gameOverCommand) {
			case RESUME:
				ViewConstants.isGameOvered = false;
				ViewConstants.lifes = 10;
				ViewConstants.PATRICK_BOB_FIGURE.setY(-ViewConstants.PATRICK_BOB_FIGURE.getHeight());
				ViewConstants.PATRICK_BOB_FIGURE.setX(10);
				ViewConstants.PATRICK_BOB_FIGURE.detectFloor();
				break;
			case EXIT:
				System.exit(0);
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mousePressed(MouseEvent e) {
		if ((ViewConstants.isPaused || ViewConstants.isGameOvered) && ViewConstants.isPlaying) {
			for (int i = 0; i < ViewConstants.BUTTON_FIGURES.size(); i++) {
				@SuppressWarnings("rawtypes")
				ButtonFigure bf = ViewConstants.BUTTON_FIGURES.get(i);
				if (bf.isCursorInButton(e.getPoint())) {
					bf.setFocused(true);
					if (bf.getCommand() != null)
						clickDirector(bf.getCommand());
				}
			}
			Utilities.refreshCanvas();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for (int i = 0; i < ViewConstants.BUTTON_FIGURES.size(); i++) {
			ViewConstants.BUTTON_FIGURES.get(i).setFocused(false);
		}
		Utilities.refreshCanvas();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
