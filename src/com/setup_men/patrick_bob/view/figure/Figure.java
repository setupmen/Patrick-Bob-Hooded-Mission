package com.setup_men.patrick_bob.view.figure;

import java.awt.Color;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ohmiosmega.figure.AbstractFigure;
import com.ohmiosmega.persistence.xml.DataXMLRecorder;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public abstract class Figure extends AbstractFigure implements DataXMLRecorder<AbstractFigure> {
	public static long figureId = 0;

	public Figure() {
	}

	public Figure(int x, int y, int width, int height) {
		this(x, y, width, height, null);
	}

	public Figure(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		this.id = figureId++;
	}

	@Override
	public Element getElement(String elementId, Document document) {
		Element element = document.createElement(elementId);
		element.setAttribute("id", String.valueOf(this.id));
		element.setAttribute("x", String.valueOf(this.id));
		element.setAttribute("y", String.valueOf(this.x));
		element.setAttribute("width", String.valueOf(this.width));
		element.setAttribute("height", String.valueOf(this.height));
		element.setAttribute("color", String.valueOf(this.color.getRGB()));
		return element;
	}

	@Override
	public Figure getData(Element element) {
		this.id = Long.parseLong(element.getAttribute("id"));
		this.x = Float.parseFloat(element.getAttribute("x"));
		this.y = Float.parseFloat(element.getAttribute("y"));
		this.width = Float.parseFloat(element.getAttribute("width"));
		this.height = Float.parseFloat(element.getAttribute("height"));
		this.color = new Color(Integer.parseInt(element.getAttribute("color")));
		return this;
	}
}
