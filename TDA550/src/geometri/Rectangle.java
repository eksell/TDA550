package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AbstractForm{

	public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		super(x, y, width, height, c);

		if((width < 0)|| (height < 0)){
			throw new IllegalPositionException("Rect throw");
		}
	}
	
	public Rectangle(GeometricalForm f, int width, int height, Color c){
		// width, height and color left in constructor due to the set constructors in the task
		super(f);
	}
	
	public int getPerimeter(){return 2*this.width*this.height;}
	public int getArea(){return this.width*this.height;}
	
	public void fill(Graphics g){
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

}
