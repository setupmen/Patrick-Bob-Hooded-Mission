package com.setup_men.patrick_bob.view.figure.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.setup_men.patrick_bob.view.ViewConstants;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 2/04/2019
 **/
public class ButtonFigure <T extends Enum<T>> extends GUIFigure {
	private T command;
	private boolean isFocused;

	public ButtonFigure(int x, int y, int width, int height) {
		super(x, y, width, height);
		ViewConstants.BUTTON_FIGURES.add(this);
	}

	public ButtonFigure(String text, int x, int y, int width, int height) {
		super(text, x, y, width, height);
		ViewConstants.BUTTON_FIGURES.add(this);
	}

	@Override
	public void draw(Graphics g) {
		if (color != null)
			g.setColor(color);
		else
			g.setColor(color = Color.black);
		if (image != null)
			g.drawImage(image, (int) x, (int) y, null);
		if (font != null)
			g.setFont(font);
		if (this.isFocused) {
			g.setColor(new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue()));
		}
		g.drawRect((int) x, (int) y, (int) width, (int) height);
		if (text != null) {
			g.drawString(text, (int) (x + width / 6), (int) (y + g.getFont().getSize() - height / 8));
		}
	}

	public boolean isCursorInButton(Point point) {
		if (point.x >= this.x && point.x <= this.x + this.width && point.y >= this.y && point.y <= this.y + this.height)
			return true;
		return false;
	}

	public void setCommand(T command) {
		this.command = command;
	}

	public Enum<T> getCommand() {
		return command;
	}

	public void setFocused(boolean isFocused) {
		this.isFocused = isFocused;
	}

}
