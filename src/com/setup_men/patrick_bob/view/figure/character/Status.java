package com.setup_men.patrick_bob.view.figure.character;

import java.awt.Graphics;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 4/04/2019
 **/
public enum Status {
	STAND_FRONT("stand", "front"), STAND_LEFT("stand", "left"), STAND_RIGHT("stand", "right"),
	WALK_LEFT_1("walk", "left_01"), WALK_LEFT_2("walk", "left_02"), WALK_RIGHT_1("walk", "right_01"),
	WALK_RIGHT_2("walk", "right_02");

	private String direction, position;

	private Status(String position, String direction) {
		this.position = position;
		this.direction = direction;
	}

	public void draw(int x, int y, int width, int height, Graphics g) {
		if (PatrickBobAttributes.skin != null)
			g.drawImage(PatrickBobAttributes.skin.getImage(position + "_" + direction), x, y, width, height, null);
		if (PatrickBobAttributes.vestment != null)
			g.drawImage(PatrickBobAttributes.vestment.getImage(position + "_" + direction), x, y, width, height, null);
		if (PatrickBobAttributes.eye != null)
			g.drawImage(PatrickBobAttributes.eye.getImage(direction.split("_")[0]), x, y, width, height, null);
		if (PatrickBobAttributes.mouth != null)
			g.drawImage(PatrickBobAttributes.mouth.getImage(direction.split("_")[0]), x, y, width, height, null);
		if (PatrickBobAttributes.hair != null) {
			g.drawImage(PatrickBobAttributes.hair.getEyebrowImage(direction.split("_")[0]), x, y, width, height, null);
			g.drawImage(PatrickBobAttributes.hair.getImage(direction.split("_")[0]), x, y, width, height, null);
		}
	}

}
