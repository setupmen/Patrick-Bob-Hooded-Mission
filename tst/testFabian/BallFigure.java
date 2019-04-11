package testFabian;

import java.awt.Color;

public class BallFigure extends Figure{

	public BallFigure(double x, double y, double size) {
		super(x, y, size);
	}

	@Override
	public void drawFigure() {
		this.graphics.setColor(Color.CYAN);
		this.graphics.fillOval((int)(this.x + (this.size/2)), (int)(this.y + (this.size/2)), (int)this.size, (int)this.size);
	}
}