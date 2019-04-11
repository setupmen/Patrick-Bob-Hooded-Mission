package com.setup_men.patrick_bob.view.thread;

import com.setup_men.patrick_bob.utilities.Utilities;
import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class WalkThread extends Thread {

	@Override
	public void run() {
		final PatrickBobFigure patrickBobFigure = ViewConstants.PATRICK_BOB_FIGURE;
		while (ViewConstants.isPlaying) {
			while (patrickBobFigure.isLeftWalking()) {
				synchronized (this) {
					if (ViewConstants.isPaused || ViewConstants.isGameOvered)
						break;
				}
				if (patrickBobFigure.getX() > 500 || ViewConstants.levelFigure.getX() >= ViewConstants.MIN_WALL) {
					if (patrickBobFigure.getX() <= ViewConstants.MIN_WALL) {
						patrickBobFigure.setX(ViewConstants.MIN_WALL);

					} else
						patrickBobFigure.setX(patrickBobFigure.getX() + ViewConstants.speedX);
				} else if (ViewConstants.levelFigure.getX() < ViewConstants.MIN_WALL) {
					ViewConstants.levelFigure.increaseX(-ViewConstants.speedX);
				}

				patrickBobFigure.detectFloor();
				patrickBobFigure.detectWall();

				if (patrickBobFigure.getY() + patrickBobFigure.getHeight() < patrickBobFigure.getCurrentFloor()) {
					patrickBobFigure.setJumping(true);
				}
				Utilities.refreshCanvas();
				try {
					Thread.sleep((long) (ViewConstants.TIME_PERIOD * 1000));
				} catch (InterruptedException e) {
				}
			}
			while (patrickBobFigure.isRightWalking()) {
				synchronized (this) {
					if (ViewConstants.isPaused || ViewConstants.isGameOvered)
						break;
				}
				if (patrickBobFigure.getX() < 500 - patrickBobFigure.getWidth() || ViewConstants.levelFigure.getX()
						+ ViewConstants.levelFigure.getWidth() <= ViewConstants.MAX_WALL) {
					patrickBobFigure.detectWall();
					if (patrickBobFigure.getX() + patrickBobFigure.getWidth() >= ViewConstants.MAX_WALL) {
						patrickBobFigure.setX(ViewConstants.MAX_WALL - patrickBobFigure.getWidth());
						ViewConstants.levelFigure.setX(ViewConstants.MAX_WALL - ViewConstants.levelFigure.getWidth());
					} else
						patrickBobFigure.setX(patrickBobFigure.getX() + ViewConstants.speedX);
				} else if (ViewConstants.levelFigure.getX()
						+ ViewConstants.levelFigure.getWidth() > ViewConstants.MAX_WALL) {
					ViewConstants.levelFigure.increaseX(-ViewConstants.speedX);
				}

				patrickBobFigure.detectFloor();
				patrickBobFigure.detectWall();

				if (patrickBobFigure.getY() + patrickBobFigure.getHeight() < patrickBobFigure.getCurrentFloor()) {
					patrickBobFigure.setJumping(true);
				}

				Utilities.refreshCanvas();
				try {
					Thread.sleep((long) (ViewConstants.TIME_PERIOD * 1000));
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
