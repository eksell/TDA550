package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Point{

	Point p2;

	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
		super(x1,y1,c);
		this.p2 = new Point(x2, y2, c);

		setValues();

//		if(x2 > 700 || y2 > 700){
//			throw new IllegalPositionException();
//		}
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
	}
	
	public int getPerimeter(){return (int) Math.sqrt((this.width^2+this.height^2));}
	public int getArea(){ return 0;}
	
	/**Returns true if the line is going straight or upwards*/
	public boolean getTilt(){		
		if(-1<(this.p2.y-super.y)) return true;
		else return false;
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
		if( this.getClass() == o.getClass()){
			if( this.width == ((Line) o).getWidth()&&
					this.height ==((Line) o).getHeight()&&
					this.color ==  ((Line) o).getColor()&&
					this.getTilt() == ((Line) o).getTilt()){
				return true;
			} 
		}
		return false;
	}
}
