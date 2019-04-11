package com.setup_men.patrick_bob.view.figure.character;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;


import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.stage.Platform;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class PatrickBobFigure extends Character {

	public PatrickBobFigure() {
	}

	public PatrickBobFigure(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public PatrickBobFigure(float x, float y, float width, float height, Image image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}

	@Override
	public void draw(Graphics g) {
		PatrickBobAttributes.status.draw((int) x, (int) y, (int) width, (int) height, g);
		g.setColor(Color.red);
		g.drawRect((int) x, (int) y, (int) width, (int) height);
		g.drawLine((int) (this.x + this.width / 2), (int) this.y, (int) (this.x + this.width / 2),
				(int) (this.y + this.height));

		g.drawLine((int) (this.x + this.width / 3), (int) this.y, (int) (this.x + this.width / 3),
				(int) (this.y + this.height));
		g.drawLine((int) (this.x + this.width * 2 / 3), (int) this.y, (int) (this.x + this.width * 2 / 3),
				(int) (this.y + this.height));
		g.drawLine((int) (this.x + this.width / 4), (int) this.y, (int) (this.x + this.width / 4),
				(int) (this.y + this.height));

		g.drawLine((int) (this.x + this.width * 3 / 4), (int) this.y, (int) (this.x + this.width * 3 / 4),
				(int) (this.y + this.height));
	}

	@Override
	public synchronized void detectFloor() {
		if (this.y + this.height <= this.currentFloor) {
			ArrayList<Platform> aux = new ArrayList<>();
			ArrayList<Platform> platforms = ViewConstants.levelFigure.getPlatforms();
			for (Platform platform : platforms) {
				if (this.x + this.width * 3 / 4 >= platform.getX()
						&& this.x + this.width / 4 <= platform.getX() + platform.getWidth()) {
					aux.add(platform);
				}
			}

			float m = ViewConstants.DEAD_FLOOR;

			float v = 0;
			for (Platform platform : aux) {
				if (this.y + this.height <= platform.getY())
					if (platform.getY() - (this.y + this.height) < m) {
						v = platform.getY();
						m = platform.getY() - (this.y + this.height);
					}
			}
			if (v != 0)
				this.currentFloor = v;
			else
				this.currentFloor = ViewConstants.DEAD_FLOOR;
		}

	}

	public void setSize(int size) {
		this.setWidth(size * 4);
		this.setHeight(size * 5);
	}

}
