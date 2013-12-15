package geometri;
import java.awt.Color;

public class Square extends Rectangle{

	public Square(int x, int y, int side, Color c) throws IllegalPositionException{
		super(x, y, side, side, c);

	}
	public Square(GeometricalForm f, int side, Color c){
		super(f, side, side, c);
	}
	
	@Override
	public int getHashCode() {
		return this.getArea()*this.getPerimeter()*11;
	}

}
