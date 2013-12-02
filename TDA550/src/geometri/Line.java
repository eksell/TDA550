package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Point{

	int x2,y2;

	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
		super(x1, y1, c);
		setValues(x2, y2);
	}

	public Line(GeometricalForm f1, GeometricalForm f2, Color c) throws IllegalPositionException{
		super(f1.getX(), f1.getY(), c);
		setValues(f2.getX(), f2.getY());
	}
	
	private void setValues(int x2, int y2){
		this.x2 = x2;
		this.y2 = y2;
		this.height = Math.abs(this.x2-this.x);
		this.width = Math.abs(this.y2-this.y);
		this.perimeter = (int) Math.sqrt((this.getWidth()^2+this.getHeight()^2));
	}
	
	/**Returns true if the line is going straight or upwards*/
	public boolean getTilt(){		
		if(-1<(this.y2-this.y)) return true;
		else return false;}

	/**Move the positions of the line with respect to it's current position.*/
	public void move(int dx, int dy,int dx2, int dy2){
		super.move(dx,dy);
		this.x2 = this.x2 + dx2;
		this.y2 = this.y2 + dy2;
	}

	/**Move the positions of the line to given values.*/
	public void place(int x, int y, int x2, int y2){ 
		super.place(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}

	public void fill(Graphics g){
		//EXTEND, vad är annorlunda mot point? Inget-> ta bort
	}

}
