package geometri;

import java.awt.*;

public abstract class AbstractForm implements GeometricalForm{

	int x,y,width,height;
	Color color;

	public AbstractForm (int x, int y, Color c) throws IllegalPositionException{
		if((x < 0)|| (y < 0)){
			System.out.println("AbstractForm throw");
			throw new IllegalPositionException();
		}
		this.color = c;
		this.x = x;
		this.y = y;
	}	

	public AbstractForm(GeometricalForm f, Color c){
		this.color = c;
		this.x = f.getX();
		this.y = f.getY();
	}

	public Color getColor(){	return color;}
	public int getX(){			return this.x;}
	public int getY(){			return this.y;}
	public int getHeight(){		return this.height;}
	public int getWidth(){		return this.width;}
	public int getHashCode(){return this.hashCode();}
	public abstract int getArea();
	public abstract int getPerimeter();

	public void fill(Graphics g){
		g.setColor(this.color);
	}

	public void move(int dx, int dy){ 
		this.x = this.x + dx;
		this.y = this.y + dy;
	}

	public void place(int x, int y){ 
		this.x = x;
		this.y = y;
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
		if( this.getClass() == o.getClass()){
			if( this.width == ((AbstractForm) o).getWidth()&&
					this.height ==((AbstractForm) o).getHeight()&&
					this.color ==  ((AbstractForm) o).getColor()){
				return true;
			} 
		}
		return false;
	}	
}

