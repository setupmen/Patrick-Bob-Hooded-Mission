package com.setup_men.patrick_bob.view.main;

import javax.swing.JFrame;

import com.setup_men.patrick_bob.controller.KeyboardListener;
import com.setup_men.patrick_bob.controller.MousepadListener;
import com.setup_men.patrick_bob.view.game.GameJPanel;
import com.setup_men.patrick_bob.view.thread.GravityThread;
import com.setup_men.patrick_bob.view.thread.WalkThread;
import com.setup_men.patrick_bob.view.thread.animation.JumpAnimationThread;
import com.setup_men.patrick_bob.view.thread.animation.WalkAnimationThread;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class MainJFrame extends JFrame {
	private GravityThread gt;
	private WalkThread wt;
	private WalkAnimationThread wat;
	private JumpAnimationThread jat;

	private static MainJFrame mainJFrame;
	private GameJPanel mainJPanel;

	private MainJFrame() {
		this.mainJPanel = new GameJPanel();
		this.gt = new GravityThread();
		this.wt = new WalkThread();
		this.wat = new WalkAnimationThread();
		this.jat = new JumpAnimationThread();
		this.init();
		this.initThreads();
	}

	private void initThreads() {
		gt.start();
		wt.start();
		wat.start();
		jat.start();
	}

	private void init() {
		this.setUndecorated(true);
		this.add(mainJPanel);
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.addKeyListener(KeyboardListener.getInstance());
		this.addMouseListener(new MousepadListener());
	}

	private static void createInstance() {
		if (mainJFrame == null) {
			synchronized (MainJFrame.class) {
				if (mainJFrame == null) {
					mainJFrame = new MainJFrame();
				}
			}
		}
	}

	public static MainJFrame getInstance() {
		if (mainJFrame == null)
			createInstance();
		return mainJFrame;
	}

	public synchronized GameJPanel getMainJPanel() {
		return mainJPanel;
	}
}
