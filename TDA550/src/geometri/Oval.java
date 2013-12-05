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
		this.area = (int) Math.PI*(this.height/2)*(this.width/2);
		this.perimeter = (int) (Math.PI*2*Math.sqrt(((this.height/2)^2)+((this.width/2)^2)));
	}

	public void fill(Graphics g){
		g.fillOval(x, y, width, height);
		g.setColor(color);
	}

}



