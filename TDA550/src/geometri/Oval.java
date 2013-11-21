package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends AbstractForm implements GeometricalForm{

	public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		 super(x,y,c);
		 this.height = height;
		 this.width = width;
	}
	 
	public Oval(GeometricalForm f, int width, int height, Color c){
		 super(f,c);
		 this.height = height;
		 this.width = width;
	}

    public void fill(Graphics g){}
    public int getHeight(){}
    public int getPerimeter(){}
    public void move(int dx, int dy){}
    public void place(int x, int y){}
}
	
	
	
}
