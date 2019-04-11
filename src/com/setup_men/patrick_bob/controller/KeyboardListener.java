package com.setup_men.patrick_bob.controller;

import com.ohmiosmega.customlistener.MultiKeyListener;
import com.setup_men.patrick_bob.utilities.Utilities;
import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class KeyboardListener extends MultiKeyListener {
	private static KeyboardListener keyboardListener;
	private final PatrickBobFigure patrickBobFigure;

	private KeyboardListener() {
		this.patrickBobFigure = ViewConstants.PATRICK_BOB_FIGURE;
	}

	public static KeyboardListener getInstance() {
		if (keyboardListener == null)
			keyboardListener = new KeyboardListener();
		return keyboardListener;
	}

	@Override
	protected void keyDirector() {
		for (int key : keys) {
			KeyConstants kc = null;
			try {
				kc = KeyConstants.valueOf(key);
			} catch (NullPointerException e) {
			}
			if (kc != null)
				switch (kc) {
				case SPEED_UP:
					ViewConstants.xValue = ViewConstants.HIGH_X_VALUE;
					ViewConstants.jumpSpeed = ViewConstants.HIGH_JUMP_VALUE;
					break;
				case JUMP:
					if (!patrickBobFigure.isJumping() && !ViewConstants.isPaused) {
						ViewConstants.speedY = ViewConstants.jumpSpeed;
						patrickBobFigure.setJumping(true);
					}
					break;
				case LEFT:
					if (!keys.contains(KeyConstants.RIGHT.getKey())) {
						ViewConstants.speedX = -ViewConstants.xValue;
						if (patrickBobFigure.isRightWalking())
							patrickBobFigure.setRightWalking(false);
						patrickBobFigure.setLeftWalking(true);
					}
					break;
				case RIGHT:
					if (!keys.contains(KeyConstants.LEFT.getKey())) {
						ViewConstants.speedX = ViewConstants.xValue;
						if (patrickBobFigure.isLeftWalking())
							patrickBobFigure.setLeftWalking(false);
						patrickBobFigure.setRightWalking(true);
					}
					break;
				case PAUSE:
					ViewConstants.isPaused = ViewConstants.isPaused ? false : true;
					Utilities.refreshCanvas();
					break;
				case ESCAPE:
					ViewConstants.isPaused = ViewConstants.isPaused ? false : true;
					Utilities.refreshCanvas();
					break;
				default:
					break;
				}
		}
	}

	@Override
	protected void removeKey(int e) {
		KeyConstants kc = null;
		try {
			kc = KeyConstants.valueOf(e);
		} catch (NullPointerException e1) {
		}
		if (kc != null)
			switch (kc) {
			case LEFT:
				patrickBobFigure.setLeftWalking(false);
				break;
			case RIGHT:
				patrickBobFigure.setRightWalking(false);
				break;
			case SPEED_UP:
				ViewConstants.xValue = ViewConstants.NORMAL_X_VALUE;
				ViewConstants.jumpSpeed = ViewConstants.NORMAL_JUMP_VALUE;
				break;
			default:
				break;
			}
		this.keys.remove(new Integer(e));
	}

}
