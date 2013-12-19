package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Point{

	private boolean [] tilt = {true,true};

	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
		super(x1,y1,c);
		setSquareSize(x2,y2);
	}

	public Line(GeometricalForm f1, GeometricalForm f2, Color c) throws IllegalPositionException{
		super(f1,c);
		setSquareSize(f2.getX(),f2.getY());
	}

	/**Calculate and set the values for this geometric shape.
	 * @throws IllegalPositionException */
	private void setSquareSize(int x2, int y2) throws IllegalPositionException{
		this.height = Math.abs(super.x-x2);
		this.width = Math.abs(super.y-y2);
		
		int transfer;
		if(x2 < super.x){
			transfer = super.x;
			super.x = x2;
			x2 = transfer;
			tilt[0] = false;
		}
		
		if(y2 < super.y){
			transfer = super.y;
			super.y = y2;
			y2 = transfer;
			tilt[1] = false;
		}	
	}
	
	public int getPerimeter(){return (int) Math.sqrt((this.width^2+this.height^2));}
	public int getArea(){ return 0;}
	
	/**Returns a boolean array describing the tilt [x,y]*/
	public boolean[] getTilt(){		
		return tilt;
	}
	
	public void fill(Graphics g){
		int x = this.x;
		int x2 = this.x + this.height;
		int y = this.y;
		int y2 = this.y + this.width;
		
		if(!tilt[0]){
			x2 = this.x;
			x = this.x + this.height;
		}
		
		if(!tilt[1]){
			y2 = this.y;
			y = this.y + this.width;
		}

		g.setColor(color);
		g.drawLine(x,y,x2,y2);
	}

	
	@Override
	public boolean equals(Object o){
		if( super.equals(this) && this.getTilt() == ((Line) o).getTilt()){
				return true; 
		}
		return false;
	}	
}
