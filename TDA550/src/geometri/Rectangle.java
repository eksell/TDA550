package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AbstractForm{

	public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		super(x, y, c);
		setValues(width, height);
		if((width < 0)|| (height < 0)){
			throw new IllegalPositionException("Rect throw");
		}
	}
	
	public Rectangle(GeometricalForm f, int width, int height, Color c){
		super(f, c);
		setValues(width, height);
	}
	
	private void setValues(int width, int height){
		this.width = width;
		this.height = height;
		checkPos("Rect/Square Constructor");
	}
	
	public int getPerimeter(){return 2*this.width*this.height;}
	public int getArea(){return this.width*this.height;}
	
	public void fill(Graphics g){
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	@Override
	public int getHashCode() {
		return this.getArea()*this.getPerimeter()*5;
	}
}
