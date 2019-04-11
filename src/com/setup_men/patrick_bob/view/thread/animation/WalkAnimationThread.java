package com.setup_men.patrick_bob.view.thread.animation;

import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobAttributes;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobFigure;
import com.setup_men.patrick_bob.view.figure.character.Status;
import com.setup_men.patrick_bob.view.main.MainJFrame;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 31/03/2019
 **/
public class WalkAnimationThread extends Thread {
	private final int animationValue = 3;

	@Override
	public void run() {
		final PatrickBobFigure patrickBobFigure = ViewConstants.PATRICK_BOB_FIGURE;
		while (ViewConstants.isPlaying) {
			while (patrickBobFigure.isRightWalking()) {
				synchronized (this) {
					if (ViewConstants.isPaused || ViewConstants.isGameOvered)
						break;
				}
				if (!patrickBobFigure.isJumping()) {
					if (PatrickBobAttributes.status.equals(Status.WALK_RIGHT_2)) {
						PatrickBobAttributes.status = Status.WALK_RIGHT_1;
					} else if (PatrickBobAttributes.status.equals(Status.WALK_RIGHT_1)) {
						PatrickBobAttributes.status = Status.WALK_RIGHT_2;
					} else {
						PatrickBobAttributes.status = Status.WALK_RIGHT_1;
					}
					MainJFrame.getInstance().getMainJPanel().repaint();
					try {
						Thread.sleep((long) (ViewConstants.TIME_PERIOD * 1000 * animationValue));
					} catch (InterruptedException e) {
					}
					if (!patrickBobFigure.isRightWalking()) {
						PatrickBobAttributes.status = Status.STAND_RIGHT;
						MainJFrame.getInstance().getMainJPanel().repaint();
					}
				}
			}
			while (patrickBobFigure.isLeftWalking()) {
				synchronized (this) {
					if (ViewConstants.isPaused)
						break;
				}
				if (!patrickBobFigure.isJumping()) {
					if (PatrickBobAttributes.status.equals(Status.WALK_LEFT_2)) {
						PatrickBobAttributes.status = Status.WALK_LEFT_1;

					} else if (PatrickBobAttributes.status.equals(Status.WALK_LEFT_1)) {
						PatrickBobAttributes.status = Status.WALK_LEFT_2;
					} else {
						PatrickBobAttributes.status = Status.WALK_LEFT_1;
					}
					MainJFrame.getInstance().getMainJPanel().repaint();
					try {
						Thread.sleep((long) (ViewConstants.TIME_PERIOD * 1000 * animationValue));
					} catch (InterruptedException e) {
					}
					if (!patrickBobFigure.isLeftWalking()) {
						PatrickBobAttributes.status = Status.STAND_LEFT;
						MainJFrame.getInstance().getMainJPanel().repaint();
					}
				}
			}
		}
	}
}
