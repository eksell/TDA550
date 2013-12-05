package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AbstractForm{
	
	int x2,y2;

	public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		super(x, y, c);
		setValues(width, height);
		
		if(this.x2 > 700|| this.y2 > 700){
			throw new IllegalPositionException();
		}
	}
	
	public Rectangle(GeometricalForm f, int width, int height, Color c){
		super(f, c);
		setValues(width, height);
	}
	
	private void setValues(int width, int height){
		this.width = width;
		this.height = height;
		this.x2 = x+width;
		this.y2 = y+height;
	}
	
	public int getPerimeter(){return 2*this.width*this.height;}
	public int getArea(){return this.width*this.height;}
	
	public void fill(Graphics g){
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
}
