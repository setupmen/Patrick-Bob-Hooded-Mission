package Yohan;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import com.setup_men.patrick_bob.view.ViewConstants;
import com.setup_men.patrick_bob.view.figure.character.Eye;
import com.setup_men.patrick_bob.view.figure.character.Hair;
import com.setup_men.patrick_bob.view.figure.character.Lenght;
import com.setup_men.patrick_bob.view.figure.character.Mouth;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobAttributes;
import com.setup_men.patrick_bob.view.figure.character.Skin;
import com.setup_men.patrick_bob.view.figure.character.Status;
import com.setup_men.patrick_bob.view.figure.character.Vestment;
//import com.setup_men.patrick_bob.view.main.MainJFrame;

public class TestRunner {

	public static void main(String[] args) {
		ViewConstants.PATRICK_BOB_FIGURE.setCurrentFloor(ViewConstants.DEAD_FLOOR);
		ViewConstants.PATRICK_BOB_FIGURE.setSize(ViewConstants.size);
		ViewConstants.PATRICK_BOB_FIGURE.setX(10);
		ViewConstants.PATRICK_BOB_FIGURE.setY(-ViewConstants.PATRICK_BOB_FIGURE.getHeight());
		
		PatrickBobAttributes.eye = Eye.BLUE;
		PatrickBobAttributes.mouth = Mouth.SMILE;

		PatrickBobAttributes.hair = Hair.BLACK;
		PatrickBobAttributes.hair.setLenght(Lenght.HOOD);

		PatrickBobAttributes.skin = Skin.CAUCASIAN;

		PatrickBobAttributes.vestment = Vestment.NAKED;

		PatrickBobAttributes.status = Status.STAND_FRONT;
		try {
			ViewConstants.levelFigure = ViewConstants.LEVEL_FIGURES.get(ViewConstants.actualLevel);
			ViewConstants.FUTURA_FONT = Font.createFont(Font.TRUETYPE_FONT, new File("./res/fonts/futura.ttf"));
		} catch (FontFormatException | IOException e) {
		}
		MainJFrame.getInstance().setVisible(true);
	}

}
