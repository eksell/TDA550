package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Point{

	private Point p2;
	private boolean [] tilt = {true,true};

	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
		super(x1,y1,c);
		this.p2 = new Point(x2, y2, c);
		setValues();
	}

	public Line(GeometricalForm f1, GeometricalForm f2, Color c) throws IllegalPositionException{
		super(f1,c);
		this.p2 = new Point(f2.getX(),f2.getY(), c);
		setValues();
	}
	
	/**Calculate and set the values for this geometric shape.*/
	private void setValues(){
		this.height = Math.abs(super.x-this.p2.x);
		this.width = Math.abs(super.y-this.p2.y);
//		System.out.println("Line height: "+this.height+" Width: "+this.width);
		
		int transfer;
		if(p2.x < super.x){
			transfer = super.x;
			super.x = p2.x;
			p2.x = transfer;
			tilt[0] = false;
		}
		
		if(p2.y < super.y){
			transfer = super.y;
			super.y = p2.y;
			p2.y = transfer;
			tilt[1] = false;
		}
		checkPos("Line Constructor");
	}
	
	public int getPerimeter(){return (int) Math.sqrt((this.width^2+this.height^2));}
	public int getArea(){ return 0;}
	
	/**Returns a boolean array describing the tilt [x,y]*/
	public boolean[] getTilt(){		
		return tilt;
	}

	/**Move the positions of the line with respect to it's current position.*/
	@Override
	public void move(int dx, int dy){
		super.x = super.x + dx;
		this.p2.x = super.x+this.height;
		super.y = super.y + dy;
		this.p2.y = super.y + this.width;
	}

	
	/**Move the positions of the line to given values.*/
	@Override
	public void place(int x, int y){ 
		super.x = x;
		this.p2.x = x+this.height;
		super.y = y;
		this.p2.y = y+this.width;
	}
	
	public void fill(Graphics g){
		g.setColor(color);
		g.drawLine(super.x, super.y, this.p2.x, this.p2.y);
	}
	
	@Override
	public boolean equals(Object o){
		//System.out.println("Equals Line height: "+this.height+" Width: "+this.width+ " Tilt: " + this.getTilt());
		if( super.equals(this) && this.getTilt() == ((Line) o).getTilt()){
				return true; 
		}
		return false;
	}
	
	@Override
	public int getHashCode() {
		return this.getArea()*this.getPerimeter()*2;
	}
}
