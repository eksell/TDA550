package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Point {
	
	int x2,y2;
	
	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
		super(x1, y1, c);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) throws IllegalPositionException{
		super(f1.getX(), f1.getY(), c);
		this.x2 = f2.getX();
		this.y2 = f2.getY();
	}
	
	

	public Color getColor(){	return color;}
	public int getX(int pos){
		if(pos == 1)return this.x;
		if(pos == 2)return this.x2;
		else return 0;
	}

	public int getY(int pos){
		if(pos == 1)return this.y;
		if(pos == 2)return this.y2;
		else return 0;
	}
	
	public int getArea(){		return 0;}
	public int getHeight(){		return 0;}
	public int getWidth(){		return 0;};
	public int getPerimeter(){	return 0;}
	
	public void move(int dx, int dy,int dx2, int dy2){
		super.move(dx,dy);
		this.x2 = this.x2 + dx2;
		this.y2 = this.y2 + dy2;
	}
	
	public void place(int x, int y, int x2, int y2){ 
		super.place(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}

	public void fill(Graphics g){
		//EXTEND
	}
	
	public int compareTo(GeometricalForm f){return this.getArea() - f.getArea();}

}
