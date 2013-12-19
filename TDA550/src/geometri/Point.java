package geometri;

import java.awt.Color;

public class Point extends AbstractForm{

	/**Point constructor*/
	public Point(int x, int y, Color c) throws IllegalPositionException{
		super(x, y,0,0, c);
	}
	/**Point constructor*/
	public Point(GeometricalForm f, Color c){
		// Color left in constructor due to the set constructors in the task
		super(f);
	}
	
	public int getPerimeter(){return 0;}
	public int getArea(){return 0;}
}
