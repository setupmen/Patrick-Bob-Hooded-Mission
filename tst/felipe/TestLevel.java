package felipe;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 11/04/2019
 **/
public class TestLevel extends JFrame {
	static ImageIcon cloudsImage = new ImageIcon("./res/images/level/clouds.jpg");
	static ImageIcon mountainsImage = new ImageIcon("./res/images/level/mountains.png");
	static ImageIcon floorImage = new ImageIcon("./res/images/level/floor.png");
	float xm = 0;
	float xf = 0;

	public TestLevel() {
		JPanel jPanel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.drawImage(cloudsImage.getImage(), 0, 0, 1000, 500, null);
				g.drawImage(mountainsImage.getImage(), (int) xm, -130, 1000, 600, null);
				g.drawImage(mountainsImage.getImage(), (int) xm + 1000, -130, 1000, 600, null);
				g.drawImage(floorImage.getImage(), (int) xf, 0, 1000, 600, null);
				g.drawImage(floorImage.getImage(), (int) xf + 1000, 0, 1000, 600, null);
			}
		};

		add(jPanel);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		new Timer(30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xm -= 0.5f;
				xf -= 1f;
				jPanel.repaint();
			}
		}).start();
		;
	}

	public static void main(String[] args) {
		new TestLevel();
	}
}
