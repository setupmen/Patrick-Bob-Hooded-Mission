package testFabian;

import javax.swing.JFrame;

public class JFrameFigure extends JFrame{
	
	private JPanelFigure jPanelFigure;
	
	public JFrameFigure(double x, double y, double size) {
		super();
		this.jPanelFigure = new JPanelFigure(x, y, size);
		init();
	}

	private void init() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(jPanelFigure);
		this.setVisible(true);
	}
}