package com.setup_men.patrick_bob.view.figure.gui.menu.gameover;

import java.awt.Image;

import com.setup_men.patrick_bob.view.figure.gui.MenuFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 2/04/2019
 **/
public class GameOverFigure extends MenuFigure<GameOverCommands> {

	public GameOverFigure(String text, int x, int y, int width, int height, Image image) {
		super(text, x, y, width, height, image, new String[] {"Reiniciar", "Salir"}, GameOverCommands.values());
	}
}
