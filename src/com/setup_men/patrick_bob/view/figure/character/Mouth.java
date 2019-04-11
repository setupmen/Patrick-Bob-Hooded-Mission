package com.setup_men.patrick_bob.view.figure.character;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
* @author Andrés Felipe Chaparro Rosas
* @date 4/04/2019
**/
public enum Mouth {
	SMILE("smile");
	
	private String path;

	private Mouth(String path) {
		this.path = "./res/images/pb/mouth/" + path + "/";
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
