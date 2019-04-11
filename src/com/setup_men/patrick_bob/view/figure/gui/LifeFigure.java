package com.setup_men.patrick_bob.view.figure.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.character.Status;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 1/04/2019
 **/
public class LifeFigure extends GUIFigure {

	public LifeFigure(int x, int y, int width, int height, Font font) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.font = font;
	}

	@Override
	public void draw(Graphics g) {
		g.setFont(font.deriveFont(Font.PLAIN, (int) (height * 7 / 8)));
		Status.STAND_FRONT.draw((int) (x + width / 8), (int) (y + height / 8),
				(int) (width / 3), (int) (5 * width / 12), g);
		g.setColor(Color.black);
		g.drawRect((int) x, (int) y, (int) width, (int) height);
		g.drawString("" + ViewConstants.lifes, (int) (x + width / 2), (int) (y + height * 7 / 8));
	}
}
