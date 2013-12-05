package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends AbstractForm{

	/**Point constructor*/
	public Point(int x, int y, Color c) throws IllegalPositionException{
		super(x, y, c);
		setValues();
	}
	/**Point constructor*/
	public Point(GeometricalForm f, Color c){
		super(f, c);
		setValues();
	}
	
	/**Calculate and set the values for this geometric shape.*/
	private void setValues(){
		this.height = 0;
		this.width = 0;
		this.area = 0;
		this.perimeter = 0;
	}
}
