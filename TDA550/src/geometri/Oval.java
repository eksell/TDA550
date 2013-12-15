package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends AbstractForm{

	public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		super(x,y,c);
		setValues(width, height);
	}

	public Oval(GeometricalForm f, int width, int height, Color c){
		super(f,c);
		setValues(width, height);
	}
	
	/**Calculate and set the values for this geometric shape.*/
	private void setValues(int width, int height){
		this.height = height;
		this.width = width;
		checkPos("Oval/Circle Constructor");
	}
	
	public int getPerimeter(){return (int) (Math.PI*2*Math.sqrt(((this.height/2)^2)+((this.width/2)^2)));}
	public int getArea(){return (int) Math.PI*(this.height/2)*(this.width/2);}

	public void fill(Graphics g){
		g.setColor(this.color);
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	@Override
	public int getHashCode() {
		return this.getArea()*this.getPerimeter()*3;
	}
	
	

}



