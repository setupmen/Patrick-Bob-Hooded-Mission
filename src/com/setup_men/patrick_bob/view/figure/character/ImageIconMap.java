package com.setup_men.patrick_bob.view.figure.character;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 3/04/2019
 **/
public class ImageIconMap {
	private String path;
	private ImageIcon imageIcon;

	public ImageIconMap(String path) {
		this.path = path;
		imageIcon = new ImageIcon(path);
	}

	public String getPath() {
		return path;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public Image getImage() {
		return imageIcon.getImage();
	}
}
