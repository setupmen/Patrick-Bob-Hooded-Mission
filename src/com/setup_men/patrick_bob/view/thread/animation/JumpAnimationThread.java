package com.setup_men.patrick_bob.view.thread.animation;

import java.awt.Color;

import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobFigure;
import com.setup_men.patrick_bob.view.main.MainJFrame;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 31/03/2019
 **/
public class JumpAnimationThread extends Thread {

	@Override
	public void run() {
		final PatrickBobFigure patrickBobFigure = ViewConstants.PATRICK_BOB_FIGURE;
		while (!ViewConstants.isPaused)
			while (patrickBobFigure.isJumping()) {
				synchronized (this) {
					if (ViewConstants.isPaused || ViewConstants.isGameOvered)
						break;
				}
				patrickBobFigure.setColor(Color.blue);
				MainJFrame.getInstance().getMainJPanel().repaint();
				try {
					Thread.sleep((long) (ViewConstants.TIME_PERIOD * 1000));
				} catch (InterruptedException e) {
				}
			}
	}

}
