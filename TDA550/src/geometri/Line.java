package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Point {
	
	public Point(int x, int y, Color c) throws IllegalPositionException{
		this.color = c;
		this.x = x;
		this.y = y;
	}

	public Point(GeometricalForm f, Color c){
		//EXTEND	
	}

	public Color getColor(){	return color;}
	public int getX(){			return this.x;}
	public int getY(){			return this.y;}
	
	public int getArea(){		return 0;}
	public int getHeight(){		return 0;}
	public int getWidth(){		return 0;};
	public int getPerimeter(){	return 0;}
	
	public void move(int dx, int dy){ 
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
	
	public void place(int x, int y){ 
		this.x = x;
		this.y = y;
	}

	public void fill(Graphics g){
		//EXTEND
	}
	
	public int compareTo(GeometricalForm f){return this.getArea() - f.getArea();}

}
