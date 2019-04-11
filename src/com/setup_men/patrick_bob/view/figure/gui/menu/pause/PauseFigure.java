package com.setup_men.patrick_bob.view.figure.gui.menu.pause;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.setup_men.patrick_bob.view.figure.gui.MenuFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 2/04/2019
 **/
public class PauseFigure extends MenuFigure<PauseCommands> {
	public static final ImageIcon BG_BLUE_TRANSPARENT = new ImageIcon("./res/images/bg_blue_transparent.png");

	public PauseFigure(String text, int x, int y, int width, int height, Image image) {
		super(text, x, y, width, height, image, new String[] {"Continuar","Opciones","Salir"}, PauseCommands.values());
	}
}
