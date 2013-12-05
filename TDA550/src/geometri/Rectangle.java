package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AbstractForm{
	
	int x2,y2;

	public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		super(x, y, c);
		setValues(width, height);
	}
	
	public Rectangle(GeometricalForm f, int width, int height, Color c){
		super(f, c);
		setValues(width, height);
	}
	
	private void setValues(int width, int height){
		this.width = width;
		this.height = height;
		this.area = width*height;
		this.perimeter = 2*width*height;
		this.x2 = x+width;
		this.y2 = y+height;
		this.hashCode = hashCode();
	}

	public void fill(Graphics g){
		g.fillRect(x, y, width, height);
		g.setColor(color); //Fix?
	}
}
