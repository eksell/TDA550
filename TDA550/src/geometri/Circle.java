package geometri;

import java.awt.Color;

public class Circle extends Oval{

	public Circle(int x, int y, int radius, Color c) throws IllegalPositionException{
		super(x, y, radius, radius, c);
	}
	public Circle(GeometricalForm f, int radius, Color c){
		super(f, radius, radius, c);
	}
}
