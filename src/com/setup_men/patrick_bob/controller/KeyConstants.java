package com.setup_men.patrick_bob.controller;

import java.awt.event.KeyEvent;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 1/04/2019
 **/
public enum KeyConstants {
	JUMP(KeyEvent.VK_X), LEFT(KeyEvent.VK_LEFT), RIGHT(KeyEvent.VK_RIGHT), UP(KeyEvent.VK_UP), DOWN(KeyEvent.VK_DOWN),
	SPEED_UP(KeyEvent.VK_Z), PAUSE(KeyEvent.VK_P), ESCAPE(KeyEvent.VK_ESCAPE);

	private int key;

	private KeyConstants(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public static KeyConstants valueOf(int key) {
		for (KeyConstants keyConstant : values()) {
			if (keyConstant.getKey() == key)
				return keyConstant;
		}
		return null;
	}

}
