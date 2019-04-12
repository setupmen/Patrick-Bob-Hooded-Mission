package testFabian;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelFigure extends JPanel implements Runnable {

	private BallFigure ballFigure;
	private TriangleFigure triangleFigure;
	private boolean isActivated;
	private boolean move2D;

	public JPanelFigure(double x, double y, double size) {
		this.ballFigure = new BallFigure(x, 0, size);
		this.triangleFigure = new TriangleFigure(x, y, size);
		this.isActivated = true;
		this.move2D = false;
		new Thread(this).start();
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		this.ballFigure.setGraphics(graphics);
		this.ballFigure.drawFigure();
		this.triangleFigure.setGraphics(graphics);
		this.triangleFigure.drawFigure();
	}

	@Override
	public void run() {
		while (isActivated) {
			evaluatePoint();
			this.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void evaluatePoint() {
		if (move2D) {
			this.ballFigure.x++;
			this.ballFigure.y = (this.triangleFigure.calculatePending() * (this.ballFigure.x - this.triangleFigure.x)
					+ triangleFigure.y) - this.ballFigure.size/2;
		} else {
			if (ballFigure.y + ballFigure.size / 2 >= triangleFigure.y) {
				move2D=true;
				isActivated=false;
			} else {
				this.ballFigure.y += 1;
			}
		}
	}
}