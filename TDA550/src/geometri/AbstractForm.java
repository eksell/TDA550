package geometri;

import java.awt.*;

public abstract class AbstractForm implements GeometricalForm{

	protected int x,y,width,height;
	protected Color color;

	public AbstractForm (int x, int y, int width, int height, Color c) throws IllegalPositionException{
		setValues(x, y, width, height, c);
		checkPos("AbstractForm Constructor");
	}	

	public AbstractForm(GeometricalForm f){
		setValues(f.getX(), f.getY(), f.getWidth(), f.getWidth(), f.getColor());
	}
	
	//A setValues method to reduce duplicated code in the two constructors 
	private void setValues(int x, int y, int width, int height, Color c){
		this.color = c;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;		
	}

	public Color getColor(){	return color;}
	public int getX(){			return this.x;}
	public int getY(){			return this.y;}
	public int getHeight(){		return this.height;}
	public int getWidth(){		return this.width;}

	@Override
	public int hashCode() {
		return this.getWidth()*this.getHeight()*this.getColor().hashCode();
	}

	public void fill(Graphics g){
		g.setColor(this.color);
	}

	public void move(int dx, int dy) throws IllegalPositionException{ 
		this.x = this.x + dx;
		this.y = this.y + dy;
		checkPos("Move");
	}

	public void place(int x, int y) throws IllegalPositionException{ 
		this.x = x;
		this.y = y;
		checkPos("Place");
	}

	public int compareTo(GeometricalForm f){
		int difference; 
		if(this.getArea() != f.getArea())
			difference = this.getArea() - f.getArea();
		else difference = this.getPerimeter() - f.getPerimeter();
		return difference;
	}

	@Override
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if( this.getClass() == o.getClass()){
			if( this.width == ((AbstractForm) o).getWidth()&&
					this.height ==((AbstractForm) o).getHeight()&&
					this.color ==  ((AbstractForm) o).getColor()){
				return true;
			} 
		}
		return false;
	}

	protected void checkPos(String msg) throws IllegalPositionException{
		if(this.x < 0
				||this.y < 0
				||this.width < 0
				||this.height < 0 
				||this.getArea() < 0 
				||this.getPerimeter() < 0){
			throw new IllegalPositionException();
			}
	}
}
