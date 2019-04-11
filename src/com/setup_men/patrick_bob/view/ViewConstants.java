package com.setup_men.patrick_bob.view;

import java.awt.Font;
import java.util.ArrayList;

import com.setup_men.patrick_bob.persistence.XMLLevels;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobFigure;
import com.setup_men.patrick_bob.view.figure.gui.ButtonFigure;
import com.setup_men.patrick_bob.view.figure.stage.LevelFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class ViewConstants {

	/**
	 * pixels
	 */
	public static final int DEAD_FLOOR = 1000;

	/**
	 * pixels
	 */
	public static final int MIN_WALL = 0;
	public static final int MAX_WALL = 1000;

	/**
	 * pixels over square seconds px/s^2
	 */
	public static final float GRAVITY = 100f;

	/**
	 * miliseconds
	 */
	public static final float TIME_PERIOD = 0.042f;

	/**
	 * pixels over seconds px/s
	 */
	public static final float NORMAL_JUMP_VALUE = -80;
	public static final float HIGH_JUMP_VALUE = -100;
	public static float jumpSpeed = NORMAL_JUMP_VALUE;

	/**
	 * pixel rate pixels/42 ms
	 */
	public static final float NORMAL_X_VALUE = 10;
	public static final float HIGH_X_VALUE = 20;
	public static float xValue = NORMAL_X_VALUE;

	/**
	 * pixels
	 */
	public static int size = 25;

	/**
	 * Fig
	 */
	public static final PatrickBobFigure PATRICK_BOB_FIGURE = new PatrickBobFigure();

	@SuppressWarnings("rawtypes")
	public static final ArrayList<ButtonFigure> BUTTON_FIGURES = new ArrayList<>();

	public static final ArrayList<LevelFigure> LEVEL_FIGURES = XMLLevels.getInstance().getLevelFigures();

	/**
	 * pixels over seconds px/s
	 */
	public static float speedX = 0;
	public static float speedY = 0;

	public static int lifes = 10;

	public static boolean isPlaying = true;
	public static boolean isPaused = false;
	public static boolean isGameOvered = false;

	public static int actualLevel = 0;

	public static Font FUTURA_FONT = null;

	public static LevelFigure levelFigure;
}
