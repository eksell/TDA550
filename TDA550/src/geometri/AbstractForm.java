package geometri;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractForm implements GeometricalForm{
	
	int x,y,perimeter,width,height,area, hashCode;
	boolean equality;
	Color color;
	
	public AbstractForm (int x, int y, Color c) throws IllegalPositionException{
		this.color = c;
		this.x = x;
		this.y = y;
	}

	public AbstractForm(GeometricalForm f, Color c){
		this.color = c;
		this.x = f.getX();
		this.y = f.getY();
	}
	
	public Color getColor(){	return color;}
	public int getX(){			return this.x;}
	public int getY(){			return this.y;}
	public int getHeight(){		return this.height;}
	public int getWidth(){		return this.width;}
	public int getArea(){		return this.area;}
	 public int getPerimeter(){	return this.perimeter;}
	
	public void fill(Graphics g){
		g.setColor(color);
	}
	
	public void move(int dx, int dy){ 
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
	
	public void place(int x, int y){ 
		this.x = x;
		this.y = y;
	}

	public int compareTo(GeometricalForm f){return this.getArea() - f.getArea();}
	
	public abstract boolean equals();
	
}
