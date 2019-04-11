package testFabian;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelFigure extends JPanel implements Runnable{
	
	private BallFigure ballFigure;
	private TriangleFigure triangleFigure;
	
	public JPanelFigure(double x, double y, double size) {
		this.ballFigure = new BallFigure(x, 0, size);
		this.triangleFigure = new TriangleFigure(x, y, size);
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
		while(true) {
			this.ballFigure.y+=4;
			this.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void evaluatePoint() {
		//to do
	}
}