package com.setup_men.patrick_bob.persistence;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.setup_men.patrick_bob.view.figure.Figure;
import com.setup_men.patrick_bob.view.figure.character.Character;
import com.setup_men.patrick_bob.view.figure.stage.LevelFigure;
import com.setup_men.patrick_bob.view.figure.stage.Platform;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 3/04/2019
 **/
public class XMLLevels {
	private static XMLLevels xmlLevels;
	private Document document;
	private Element levels;
	private File is;
	private ArrayList<LevelFigure> levelFigures;

	private XMLLevels() {
		levelFigures = new ArrayList<>();
		is = new File(PersistenceConstants.PATH_LEVELS);

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			if (is.exists()) {
				document = db.parse(is);
				levels = (Element) document.getElementsByTagName("levels").item(0);
				read();
			} else {
				document = db.newDocument();
				levels = document.createElement("levels");
				document.appendChild(levels);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
		}
	}

	private void read() {
		document.getDocumentElement().normalize();
		NodeList list = document.getElementsByTagName("level");
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			this.levelFigures.add(this.readLevelFigure(element));
		}
	}

	private LevelFigure readLevelFigure(Element e) {
		LevelFigure lf = new LevelFigure(readFigures(e));
		lf.setId(Long.parseLong(e.getAttribute("id")));
		lf.setX(Float.parseFloat(e.getAttribute("x")));
		lf.setY(Float.parseFloat(e.getAttribute("y")));
		lf.setWidth(Float.parseFloat(e.getAttribute("width")));
		lf.setHeight(Float.parseFloat(e.getAttribute("height")));
		return lf;
	}

	private Platform readPlatform(Element e) {
		Color c = null;
		if (!e.getAttribute("color").equals("")) {
			c = new Color(Integer.parseInt(e.getAttribute("color")));
		}
		return new Platform(Long.parseLong(e.getAttribute("id")), (int) Float.parseFloat(e.getAttribute("x")),
				(int) Float.parseFloat(e.getAttribute("y")), (int) Float.parseFloat(e.getAttribute("width")),
				(int) Float.parseFloat(e.getAttribute("height")), c);
	}

	private Character readCharacter(Element e) {
		e.getAttribute("");
		return null;
	}

	private ArrayList<Figure> readFigures(Element e) {
		NodeList list = e.getElementsByTagName("platform");
		ArrayList<Figure> figures = new ArrayList<>();

		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			figures.add(readPlatform(element));
		}

		list = e.getElementsByTagName("character");
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			figures.add(readCharacter(element));
		}
		return figures;
	}

	public ArrayList<LevelFigure> getLevelFigures() {
		return levelFigures;
	}

	public void addLevel(LevelFigure levelFigure) {

		Element level = this.addChild("level", levelFigure);
		for (Figure figure : levelFigure.getFigures()) {
			if (figure instanceof Platform) {
				level.appendChild(this.addChild("platform", figure));
			} else if (figure instanceof Character) {
				level.appendChild(this.addChild("character", (Character) figure));
			}
		}
		levels.appendChild(level);
		this.saveFile();
	}

	private Element addChild(String childLabel, Figure figure) {
		Element child = document.createElement(childLabel);
		child.setAttributeNode(this.addAttribute("id", String.valueOf(figure.getId())));
		child.setAttributeNode(this.addAttribute("x", String.valueOf(figure.getX())));
		child.setAttributeNode(this.addAttribute("y", String.valueOf(figure.getY())));
		child.setAttributeNode(this.addAttribute("width", String.valueOf(figure.getWidth())));
		child.setAttributeNode(this.addAttribute("height", String.valueOf(figure.getHeight())));
		if (figure.getColor() != null)
			child.setAttributeNode(this.addAttribute("color", String.valueOf(figure.getColor().getRGB())));
		return child;
	}

	private Element addChild(String childLabel, Character character) {
		Element child = this.addChild(childLabel, character);
		return child;
	}

	private Attr addAttribute(String attribute, String value) {
		Attr aux = document.createAttribute(attribute);
		aux.setValue(value);
		return aux;
	}

	private void saveFile() {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult sr = new StreamResult(is);
			transformer.transform(source, sr);
		} catch (TransformerException e) {
		}
	}

	public static XMLLevels getInstance() {
		if (xmlLevels == null)
			xmlLevels = new XMLLevels();
		return xmlLevels;
	}
}
