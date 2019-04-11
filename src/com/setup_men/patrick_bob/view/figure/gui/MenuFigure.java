package com.setup_men.patrick_bob.view.figure.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.setup_men.patrick_bob.view.figure.gui.ButtonFigure;
import com.setup_men.patrick_bob.view.figure.gui.GUIFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 2/04/2019
 **/
public abstract class MenuFigure<T extends Enum<T>> extends GUIFigure {
	public static final ImageIcon BG_BLUE_TRANSPARENT = new ImageIcon("./res/images/bg_blue_transparent.png");
	private String[] names;
	private T[] commands;
	private final ButtonFigure<T>[] buttonFigures;

	@SuppressWarnings("unchecked")
	public MenuFigure(String text, int x, int y, int width, int height, Image image, String[] names, T[] commands) {
		super(text, x, y, width, height);
		this.image = image;
		this.commands = commands;
		this.names = names;
		this.buttonFigures = new ButtonFigure[this.names.length];
		this.initButtonFigure();
	}

	public void initButtonFigure() {
		int v = 5;
		for (int i = 0; i < buttonFigures.length; i++) {
			this.buttonFigures[i] = new ButtonFigure<>(names[i], (int) (x + width / 3),
					(int) (v * i + y + height / 3 + height * i / 16), (int) width / 3, (int) height / 16);
			this.buttonFigures[i].setCommand(commands[i]);
		}
	}

	@Override
	public void draw(Graphics g) {
		if (color != null)
			g.setColor(color);
		else
			g.setColor(Color.BLACK);

		g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
		g.drawString(text, (int) (x + width * 13 / 32), (int) (y + height / 4));
		for (ButtonFigure<T> buttonFigure : buttonFigures) {
			buttonFigure.draw(g);
		}
	}
}
