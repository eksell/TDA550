package geometri;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractForm implements GeometricalForm{
	
	int x,y,perimeter,width,height,area;
	Color color = null;
	
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
		//EXTEND
	}
	
	/**Compare the areas and return an int describing their difference*/
	public int compareTo(GeometricalForm f){return this.getArea() - f.getArea();}
}
