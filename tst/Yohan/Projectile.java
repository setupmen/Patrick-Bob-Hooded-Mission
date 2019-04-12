package Yohan;

import java.awt.Color;
import java.awt.Graphics;

import com.setup_men.patrick_bob.view.figure.Figure;


public class Projectile extends Figure {

	public Projectile(int x, int y, int width, int height, int floor, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK); //Color
		g.fillOval( (int)x, (int)y, 50, 50); //Cabeza de la bala
		g.fillRect((int)(x+25), (int)y, 70, 50); // Cuerpo de la bala
		g.setColor(Color.WHITE); //Color para las lineas
		g.drawArc((int)(x+30), (int)y, 20, 50, 90, 180); // arco separador de cabeza 1
		g.drawArc((int)(x+25), (int)y, 20, 50, 90, 180); // arco separador de ca
		g.drawLine((int)(x+70), (int)y, (int)(x+70), 70); // Linea de cuerpo 1
		g.drawLine((int)(x+75), (int)y, (int)(x+75), 70); // Linea de cuerpo 2
		g.fillOval((int)(x+10), (int)(y+10), 10, 10); // Ojo
		g.setColor(Color.RED); // Color de pupila
		g.fillOval((int)(x+12), (int)(y+12), 5, 5); // pupila
		g.setColor(Color.WHITE); //Color de boca
		g.drawArc((int)(x+15), (int)(y+22), 15, 5, 270, 90); //labio superior
		g.fillArc((int)(x+15), (int)y+22, 15, 10, 270, 90); // boca
		g.setColor(Color.BLACK); //Color
		g.fillArc((int)(x+10), (int)(y+7), 10, 10, 25, 180); //Parapado
	}

}
