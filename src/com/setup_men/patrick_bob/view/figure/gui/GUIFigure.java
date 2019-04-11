package com.setup_men.patrick_bob.view.figure.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import com.setup_men.patrick_bob.view.figure.Figure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 1/04/2019
 **/
public abstract class GUIFigure extends Figure {
	protected String text;
	protected Font font;
	protected Image image;

	public GUIFigure() {
	}

	public GUIFigure(String text, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.text = text;
	}

	public GUIFigure(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public GUIFigure(String text, int x, int y, int width, int height, Image image) {
		super(x, y, width, height, null);
		this.image = image;
		this.text = text;
	}

	public GUIFigure(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, null);
		this.image = image;
	}

	public GUIFigure(String text, int x, int y, int width, int height, Font font) {
		super(x, y, width, height, null);
		this.font = font;
		this.text = text;
	}

	public GUIFigure(int x, int y, int width, int height, Font font) {
		super(x, y, width, height, null);
		this.font = font;
	}

	public GUIFigure(String text, int x, int y, int width, int height, Image image, Font font) {
		super(x, y, width, height, null);
		this.font = font;
		this.image = image;
		this.text = text;
	}

	public GUIFigure(int x, int y, int width, int height, Image image, Font font) {
		super(x, y, width, height, null);
		this.font = font;
		this.image = image;
	}

	public GUIFigure(String text, int x, int y, int width, int height, Color color, Image image, Font font) {
		super(x, y, width, height, color);
		this.font = font;
		this.image = image;
		this.text = text;
	}

	public GUIFigure(int x, int y, int width, int height, Color color, Image image, Font font) {
		super(x, y, width, height, color);
		this.font = font;
		this.image = image;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
