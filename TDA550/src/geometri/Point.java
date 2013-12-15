package geometri;

import java.awt.Color;

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
		checkPos("Point/Line Constructor");
	}
	
	public int getPerimeter(){return 0;}
	public int getArea(){return 0;}
	
	@Override
	public int getHashCode() {
		return this.getArea()*this.getPerimeter()-1;
	}
}
