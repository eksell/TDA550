package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends AbstractForm{

	public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		super(x,y,c);
		this.height = height;
		this.width = width;
		setValues();
	}

	public Oval(GeometricalForm f, int width, int height, Color c){
		super(f,c);
		this.height = height;
		this.width = width;
		setValues();
	}
	
	private void setValues(){
		this.area = (int) Math.PI*(this.height/2)*(this.width/2);
		this.perimeter = (int) (Math.PI*2*Math.sqrt(((this.height/2)^2)+((this.width/2)^2)));
	}

	public void fill(Graphics g){
		g.drawOval(x, y, width, height);
	}

}



