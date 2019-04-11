package com.setup_men.patrick_bob.view.figure.character;

import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 3/04/2019
 **/
public enum Skin {
	CAUCASIAN("caucasian"), AFRO("afro");
	private String path;

	private Skin(String path) {
		this.path = "./res/images/pb/skin/" + path + "/";
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
