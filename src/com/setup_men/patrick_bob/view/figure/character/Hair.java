package com.setup_men.patrick_bob.view.figure.character;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 3/04/2019
 **/
public enum Hair {
	BLACK("black"), BLOND("blond");

	private String path;
	private Lenght lenght;

	private Hair(String path) {
		this.path = path;
	}

	public void setLenght(Lenght lenght) {
		this.lenght = lenght;
	}

	public void setType(Type type) {
		lenght.setType(type);
	}

	public ImageIcon getEyebrowImageIcon(String name) {
		return PatrickBobAttributes.getImageIcon("./res/images/pb/hair/eyebrow/" + path + "/" + name + ".png");
	}

	public ImageIcon getImageIcon(String name) {
		return PatrickBobAttributes.getImageIcon(getPath() + name + ".png");
	}

	public Image getImage(String name) {
		return getImageIcon(name).getImage();
	}

	public Image getEyebrowImage(String name) {
		return getEyebrowImageIcon(name).getImage();
	}

	public String getPath() {
		if (lenght != null)
			return "./res/images/pb/hair/hair/" + path + "/" + lenght.getPath();
		return null;
	}
}