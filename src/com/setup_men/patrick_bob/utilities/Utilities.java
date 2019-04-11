package com.setup_men.patrick_bob.utilities;

import com.setup_men.patrick_bob.view.main.MainJFrame;

/**
 * Clase Utilities
 * 
 * @author Andrés Felipe Chaparro Rosas
 * @version 1.0 9/02/2019
 */
public class Utilities {
	public synchronized static double time(float height, float gravity) {
		return Math.sqrt(2 * (height * -1) / gravity);
	}

	public synchronized static float calculateHeight(float initHeight, float initSpeed, float gravity, float time) {
		return initHeight + (initSpeed * time) + ((time * time * gravity) / 2);
	}

	public synchronized static float finalSpeed(float initSpeed, float gravity, float time) {
		return initSpeed + gravity * time;
	}

	public synchronized static void refreshCanvas() {
		MainJFrame.getInstance().getMainJPanel().repaint();
	}
}
