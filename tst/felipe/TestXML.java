package felipe;

import java.awt.Color;
import java.util.ArrayList;

import com.setup_men.patrick_bob.persistence.XMLLevels;
import com.setup_men.patrick_bob.view.figure.Figure;
import com.setup_men.patrick_bob.view.figure.stage.LevelFigure;
import com.setup_men.patrick_bob.view.figure.stage.Platform;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 3/04/2019
 **/
public class TestXML {
	public static void main(String[] args) {
		ArrayList<Figure> platforms = new ArrayList<>();
		platforms.add(new Platform(0, 600, 2000, 20, Color.BLACK));
		platforms.add(new Platform(1000, 570, 2000, 20, Color.blue));
		LevelFigure figure = new LevelFigure(platforms);
		XMLLevels.getInstance().addLevel(figure);

		ArrayList<LevelFigure> levelFigures = XMLLevels.getInstance().getLevelFigures();
		for (LevelFigure lf : levelFigures) {
			System.out.println(lf.getId());
			for (Figure f : lf.getFigures()) {
				System.out.println("\t" + " " + f.getX() + " " + f.getY() + " " + f.getWidth() + " " + f.getHeight()
						+ " " + f.getColor());
			}
		}
	}
}
