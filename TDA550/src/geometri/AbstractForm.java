package geometri;

import java.awt.*;

public abstract class AbstractForm implements GeometricalForm{

	int x,y;
	int width = 0;
	int height = 0;
	Color color;

	public AbstractForm (int x, int y, Color c) throws IllegalPositionException{
		checkPos("AbstractForm Constructor");
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
	public abstract int getHashCode();
	public abstract int getArea();
	public abstract int getPerimeter();

	public void fill(Graphics g){
		g.setColor(this.color);
	}

	public void move(int dx, int dy){ 
		this.x = this.x + dx;
		this.y = this.y + dy;
		checkPos("Move");
	}

	public void place(int x, int y){ 
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
		if( this.getClass() == o.getClass()){
			if( this.width == ((AbstractForm) o).getWidth()&&
					this.height ==((AbstractForm) o).getHeight()&&
					this.color ==  ((AbstractForm) o).getColor()){
				return true;
			} 
		}
		return false;
	}

	protected void checkPos(String msg){
		try{
		if(this.x < 0
				||this.y < 0
				||this.width < 0
				||this.height < 0 
				||this.getArea() < 0 
				||this.getPerimeter() < 0){
			throw new IllegalPositionException(msg);
			}
		}catch(IllegalPositionException e){
			System.out.println(e);
			System.exit(0);	
		}
	}
}

