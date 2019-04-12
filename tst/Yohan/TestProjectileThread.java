package Yohan;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class TestProjectileThread {

	public static void main(String[] args) {
		
		ArrayList<ProjectileAnimationThread> list = new ArrayList<>();
		Random rnd = new Random();
		
		for (int i = 0; i < 10; i++) {
			list.add(new  ProjectileAnimationThread(600, rnd.nextInt(500)+ 100, 
					100, 70, 0, null, rnd.nextInt(10)+3, rnd.nextInt(20)+8));
		}
		
		JFrame frame = new JFrame("Test Projectile");
		frame.setSize(800, 700);
		frame.setLocationRelativeTo(null);
		frame.add(new CanvasJPanel(list));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}

}
