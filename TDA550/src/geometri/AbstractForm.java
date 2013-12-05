package geometri;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.io.ObjectInputStream.GetField;

public abstract class AbstractForm implements GeometricalForm{

	int x,y,width,height;
	boolean equality;
	Color color;

	public AbstractForm (int x, int y, Color c) throws IllegalPositionException{
		if(x > Container.WIDTH || y > Container.HEIGHT)throw new IllegalPositionException();
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

	public int compareTo(GeometricalForm f){return this.getArea() - f.getArea();}

	public boolean equals(Object o){
		if( this.getClass() == o.getClass()){
			if( this.width == ((AbstractForm) o).getWidth()&&
					this.height ==((AbstractForm) o).getHeight()&&
					this.color ==  ((AbstractForm) o).getColor()){
				this.equality = true; 
			} else this.equality = false;
		}
		return this.equality;
	}
}

