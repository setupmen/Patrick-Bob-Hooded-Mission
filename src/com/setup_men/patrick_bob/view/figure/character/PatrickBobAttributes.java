package com.setup_men.patrick_bob.view.figure.character;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 3/04/2019
 **/
public class PatrickBobAttributes {

	public static Status status;

	public static Skin skin;
	public static Eye eye;
	public static Vestment vestment;
	public static Hair hair;
	public static Mouth mouth;

	public static ArrayList<ImageIconMap> imageMaps = new ArrayList<>();

	public static ImageIcon getImageIcon(String path) {
		ImageIcon imageIcon = null;
		for (int i = 0; i < imageMaps.size(); i++) {
			if (imageMaps.get(i).getPath().equals(path))
				imageIcon = imageMaps.get(i).getImageIcon();
		}
		if (imageIcon == null) {
			ImageIconMap imageIconMap = new ImageIconMap(path);
			imageMaps.add(imageIconMap);
			imageIcon = imageIconMap.getImageIcon();
		}
		return imageIcon;
	}
}
