package com.setup_men.patrick_bob.view.figure.character;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 3/04/2019
 **/
public enum Vestment {
	FULL_SUIT("full_suit"), NAKED("naked");

	private String path;

	private Vestment(String path) {
		this.path = "./res/images/pb/clothes/" + path + "/";
	}

	public ImageIcon getImageIcon(String name) {
		return PatrickBobAttributes.getImageIcon(getPath() + name + ".png");
	}

	public String getPath() {
		return path;
	}

	public Image getImage(String name) {
		return getImageIcon(name).getImage();
	}
}
