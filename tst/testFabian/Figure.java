package testFabian;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
	
	protected Graphics graphics;
	protected double x;
	protected double y;
	protected double size;
	
	public Figure(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
	
	public abstract void drawFigure();

	public Graphics getGraphics() {
		return graphics;
	}
}