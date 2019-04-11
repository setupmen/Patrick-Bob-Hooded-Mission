package felipe;
/**
* @author Andrés Felipe Chaparro Rosas
* @date 3/04/2019
**/

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.setup_men.patrick_bob.view.figure.character.Eye;
import com.setup_men.patrick_bob.view.figure.character.Hair;
import com.setup_men.patrick_bob.view.figure.character.Lenght;
import com.setup_men.patrick_bob.view.figure.character.Mouth;
import com.setup_men.patrick_bob.view.figure.character.PatrickBobAttributes;
import com.setup_men.patrick_bob.view.figure.character.Skin;
import com.setup_men.patrick_bob.view.figure.character.Status;
import com.setup_men.patrick_bob.view.figure.character.Type;
import com.setup_men.patrick_bob.view.figure.character.Vestment;

public class PersnalizePatrickBobTest {

	public static void main(String[] args) {
		PatrickBobAttributes.eye = Eye.BLUE;
		PatrickBobAttributes.mouth = Mouth.SMILE;

		PatrickBobAttributes.hair = Hair.BLACK;
		PatrickBobAttributes.hair.setLenght(Lenght.HOOD);

		PatrickBobAttributes.skin = Skin.CAUCASIAN;

		PatrickBobAttributes.vestment = Vestment.FULL_SUIT;

		PatrickBobAttributes.status = Status.STAND_FRONT;

		int fWidth = 1000, fHeight = 600;
		JPanel drawjPanel = new JPanel() {

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				int w = 400, h = w * 5 / 4, x = ((fWidth - (fWidth / 3)) / 2) - (w / 2), y = (fHeight / 2) - (h / 2);
				PatrickBobAttributes.status.draw(x, y, w, h, g);
			}
		};

		JPanel mainPanel = new JPanel(new BorderLayout());

		class ComboboxLister implements ActionListener {
			protected JComboBox<Eye> eyebox;
			protected JComboBox<Hair> hairbox;
			protected JComboBox<Mouth> mouthbox;
			protected JComboBox<Lenght> lenghtbox;
			protected JComboBox<Type> typebox;
			protected JComboBox<Skin> skinbox;
			protected JComboBox<Vestment> vestmentbox;
			protected JComboBox<Status> statusbox;

			@Override
			public void actionPerformed(ActionEvent e) {
				PatrickBobAttributes.eye = (Eye) eyebox.getSelectedItem();
				PatrickBobAttributes.mouth = (Mouth) mouthbox.getSelectedItem();
				PatrickBobAttributes.hair = (Hair) hairbox.getSelectedItem();
				PatrickBobAttributes.hair.setLenght((Lenght) lenghtbox.getSelectedItem());
				PatrickBobAttributes.hair.setType((Type) typebox.getSelectedItem());
				PatrickBobAttributes.skin = (Skin) skinbox.getSelectedItem();
				PatrickBobAttributes.vestment = (Vestment) vestmentbox.getSelectedItem();
				PatrickBobAttributes.status = (Status) statusbox.getSelectedItem();

				drawjPanel.repaint();
			}
		}

		ComboboxLister cl = new ComboboxLister();

		JComboBox<Eye> eyesComboBox = new JComboBox<>(Eye.values());
		eyesComboBox.setPreferredSize(new Dimension(150, 25));
		cl.eyebox = eyesComboBox;
		eyesComboBox.addActionListener(cl);

		JComboBox<Mouth> mouthComboBox = new JComboBox<>(Mouth.values());
		mouthComboBox.setPreferredSize(new Dimension(150, 25));
		cl.mouthbox = mouthComboBox;
		mouthComboBox.addActionListener(cl);

		JComboBox<Hair> hairComboBox = new JComboBox<>(Hair.values());
		hairComboBox.setPreferredSize(new Dimension(150, 25));
		cl.hairbox = hairComboBox;
		hairComboBox.addActionListener(cl);

		JComboBox<Lenght> lenghtComboBox = new JComboBox<>(Lenght.values());
		lenghtComboBox.setPreferredSize(new Dimension(150, 25));
		cl.lenghtbox = lenghtComboBox;
		lenghtComboBox.addActionListener(cl);

		JComboBox<Type> typeComboBox = new JComboBox<>(Type.values());
		typeComboBox.setPreferredSize(new Dimension(150, 25));
		cl.typebox = typeComboBox;
		typeComboBox.addActionListener(cl);
//
		JComboBox<Skin> skinComboBox = new JComboBox<>(Skin.values());
		skinComboBox.setPreferredSize(new Dimension(150, 25));
		cl.skinbox = skinComboBox;
		skinComboBox.addActionListener(cl);

		JComboBox<Vestment> vestmentComboBox = new JComboBox<>(Vestment.values());
		vestmentComboBox.setPreferredSize(new Dimension(150, 25));
		cl.vestmentbox = vestmentComboBox;
		vestmentComboBox.addActionListener(cl);

		JComboBox<Status> statusComboBox = new JComboBox<>(Status.values());
		statusComboBox.setPreferredSize(new Dimension(150, 25));
		cl.statusbox = statusComboBox;
		statusComboBox.addActionListener(cl);

		JButton okButton = new JButton("OK");

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		controlPanel.add(eyesComboBox);
		controlPanel.add(mouthComboBox);
		controlPanel.add(hairComboBox);
		controlPanel.add(lenghtComboBox);
		controlPanel.add(typeComboBox);
		controlPanel.add(skinComboBox);
		controlPanel.add(vestmentComboBox);
		controlPanel.add(statusComboBox);

		controlPanel.add(okButton);

		mainPanel.add(drawjPanel, BorderLayout.CENTER);
		mainPanel.add(controlPanel, BorderLayout.EAST);

		JFrame f = new JFrame("Test Custom");
		f.add(mainPanel);
		f.setSize(fWidth, fHeight);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
