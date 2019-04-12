package testFabian;

import java.awt.Color;

public class TriangleFigure extends Figure{
	
	protected int[] xPoint = {(int) this.x, 100, 500};
	protected int[] yPoint = {(int) this.y, 300, 300};

	public TriangleFigure(double x, double y, double size) {
		super(x, y, size);
	}

	@Override
	public void drawFigure() {
		this.graphics.setColor(Color.RED);
		this.graphics.drawPolygon(xPoint, yPoint, 3);
	}
	
	public double calculatePending() {
		return ((double)(yPoint[0]-yPoint[2])/(double)(xPoint[0]-xPoint[2]));
	}
}