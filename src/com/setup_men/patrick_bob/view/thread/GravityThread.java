package com.setup_men.patrick_bob.view.thread;

import com.setup_men.patrick_bob.utilities.Utilities;
import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class GravityThread extends Thread {

	@Override
	public void run() {
		PatrickBobFigure figure = ViewConstants.PATRICK_BOB_FIGURE;
		float time = ViewConstants.TIME_PERIOD;

		while (ViewConstants.isPlaying) {
			while (figure.isJumping()) {
				synchronized (this) {
					if (ViewConstants.isPaused || ViewConstants.isGameOvered)
						break;
				}
				figure.setY(
						Utilities.calculateHeight(figure.getY(), ViewConstants.speedY, ViewConstants.GRAVITY, time));
				ViewConstants.speedY = Utilities.finalSpeed(ViewConstants.speedY, ViewConstants.GRAVITY,
						ViewConstants.TIME_PERIOD);
				time += ViewConstants.TIME_PERIOD;
				if (figure.getY() + figure.getHeight() >= figure.getCurrentFloor()) {
					if (figure.getCurrentFloor() == ViewConstants.DEAD_FLOOR) {
						if (ViewConstants.lifes > 1) {
							ViewConstants.lifes--;
							figure.setY(-figure.getHeight());
							figure.setX(10);
						} else if(ViewConstants.lifes == 1) {
							ViewConstants.lifes--;
							ViewConstants.isGameOvered = true;
							break;
						}
					} else {
						figure.setY(figure.getCurrentFloor() - figure.getHeight());
						figure.setJumping(false);
					}
					time = ViewConstants.TIME_PERIOD;
				}
				figure.detectFloor();
				if (!(figure.isLeftWalking() || figure.isRightWalking()))
					Utilities.refreshCanvas();
				try {
					Thread.sleep((long) (ViewConstants.TIME_PERIOD * 1000));
				} catch (InterruptedException e) {
				}
			}
		}
	}

}
