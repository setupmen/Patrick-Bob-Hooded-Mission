package com.setup_men.patrick_bob.view.figure.stage;

import java.awt.Color;
import java.awt.Graphics;

import com.setup_men.patrick_bob.view.figure.Figure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 31/03/2019
 **/
public class Platform extends Figure {
	
	public Platform() {
		
	}

	public Platform(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public Platform(long id, int x, int y, int width, int height, Color color) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect((int) this.x, (int) this.y, (int) this.width, (int) this.height);
		g.setColor(Color.black);
		g.drawRect((int) this.x, (int) this.y, (int) this.width, (int) this.height);
	}
}
