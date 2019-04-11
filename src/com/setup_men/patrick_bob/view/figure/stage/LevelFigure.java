package com.setup_men.patrick_bob.view.figure.stage;

import java.awt.Graphics;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.ohmiosmega.persistence.bin.DataUtilities;
import com.setup_men.patrick_bob.view.figure.Figure;
import com.setup_men.patrick_bob.view.figure.character.Character;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 31/03/2019
 **/
public class LevelFigure extends Figure {
	private ArrayList<Figure> figures;

	public LevelFigure() {
		this.figures = new ArrayList<>();
		this.id = figureId++;
		this.x = 0;
		this.y = 0;
	}

	public LevelFigure(ArrayList<Figure> figures) {
		this.id = figureId++;
		this.x = 0;
		this.y = 0;
		this.figures = figures;
		this.detectSize();
	}

	private void detectSize() {
		float widthValue = 0;
		for (Platform platform : getPlatforms()) {
			if (widthValue < platform.getX() + platform.getWidth())
				widthValue = platform.getX() + platform.getWidth();
		}
		this.setWidth(widthValue);
	}

	@Override
	public void draw(Graphics g) {
		for (Figure figure : figures) {
			figure.draw(g);
		}
	}

	public ArrayList<Figure> getFigures() {
		return figures;
	}

	public synchronized void increaseX(float increaseValue) {
		this.setX(this.getX() + increaseValue);
		for (Figure figure : figures) {
			figure.setX(figure.getX() + increaseValue);
		}
	}

	public synchronized void increaseY(float increaseValue) {
		this.setY(this.getY() + increaseValue);
		for (Figure figure : figures) {
			figure.setY(figure.getY() + increaseValue);
		}
	}

	public ArrayList<Platform> getPlatforms() {
		ArrayList<Platform> platforms = new ArrayList<>();
		for (Figure figure : figures) {
			if (figure instanceof Platform)
				platforms.add((Platform) figure);
		}
		return platforms;
	}

	public void addFigure(Figure figure) {
		this.figures.add(figure);
		this.detectSize();
	}

	@Override
	public byte[] getBytes() {
		synchronized (this) {
			byte[] bytes = new byte[0];
			for (Figure figure : figures) {
				bytes = DataUtilities.joinBytes(bytes, figure.getBytes());
			}
			return DataUtilities.joinBytes(super.getBytes(), DataUtilities.toBytes(this.figures.size()), bytes);
		}
	}

	@Override
	public LevelFigure getData(byte[] data) {
		synchronized (this) {
			super.getData(data);
			DataUtilities du = new DataUtilities(data);
			du.seek(36);
			return this;
		}
	}

	@Override
	public LevelFigure getData(Element element) {
		super.getData(element);
		NodeList list = element.getElementsByTagName("platform");
		for (int i = 0; i < list.getLength(); i++) {
			this.figures.add(new Platform().getData((Element) list.item(i)));
		}
		list = element.getElementsByTagName("character");
		for (int i = 0; i < list.getLength(); i++) {
//			this.figures.add(new Character().getData((Element) list.item(i)));
		}

		return this;
	}

	@Override
	public Element getElement(String elementId, Document document) {
		Element element = super.getElement(elementId, document);
		for (Figure figure : figures) {
			if (figure instanceof Platform) {
				element.appendChild(figure.getElement("platform", document));
			} else if (figure instanceof Character) {
				element.appendChild(figure.getElement("character", document));
			}
		}
		return element;
	}
}
