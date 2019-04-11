package com.setup_men.patrick_bob.view.figure.character;

import java.awt.Image;
import java.util.ArrayList;

import com.ohmiosmega.persistence.bin.DataUtilities;
import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.Figure;
import com.setup_men.patrick_bob.view.figure.stage.Platform;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public abstract class Character extends Figure {
	protected float currentFloor, currentMinWall, currentMaxWall;
	protected boolean isJumping, isLeftWalking, isRightWalking;
	protected Image image;

	public synchronized void detectFloor() {
		ArrayList<Platform> aux = new ArrayList<>();
		ArrayList<Platform> platforms = ViewConstants.levelFigure.getPlatforms();
		for (Platform platform : platforms) {
			if (this.x + this.width >= platform.getX() && this.x < platform.getX() + platform.getWidth()) {
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

	public synchronized void detectWall() {
		this.currentMinWall = ViewConstants.MIN_WALL;
		this.currentMaxWall = ViewConstants.MAX_WALL;

	}

	@Override
	public byte[] getBytes() {
		synchronized (this) {
			return DataUtilities.joinBytes(super.getBytes(), DataUtilities.toBytes((byte) -1));
		}
	}

	@Override
	public Character getData(byte[] data) {
		synchronized (this) {
			super.getData(data);
			DataUtilities du = new DataUtilities(data);
			du.seek(36);
			if (du.getLong() == -1)
				this.image = null;
			return this;
		}
	}

	public synchronized boolean isJumping() {
		return isJumping;
	}

	public synchronized void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	public synchronized void setLeftWalking(boolean isLeftWalking) {
		this.isLeftWalking = isLeftWalking;
	}

	public synchronized void setRightWalking(boolean isRightWalking) {
		this.isRightWalking = isRightWalking;
	}

	public synchronized boolean isLeftWalking() {
		return isLeftWalking;
	}

	public synchronized boolean isRightWalking() {
		return isRightWalking;
	}

	public synchronized float getCurrentFloor() {
		return currentFloor;
	}

	public synchronized void setCurrentFloor(float currentFloor) {
		this.currentFloor = currentFloor;
	}

	public synchronized void setCurrentMinWall(float currentMinWall) {
		this.currentMinWall = currentMinWall;
	}

	public synchronized float getCurrentMinWall() {
		return currentMinWall;
	}

	public synchronized void setCurrentMaxWall(float currentMaxWall) {
		this.currentMaxWall = currentMaxWall;
	}

	public synchronized float getCurrentMaxWall() {
		return currentMaxWall;
	}

	public synchronized Image getImage() {
		return image;
	}

	public synchronized void setImage(Image image) {
		this.image = image;
	}
}
