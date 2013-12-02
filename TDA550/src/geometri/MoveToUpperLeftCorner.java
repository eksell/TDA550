package geometri;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * A small animation of constructing different geometrical forms,
 * where color and postion are random.
 * Theerafter it is possible to move all forms to the upper
 * left corner of the drawing area, i.e. moving them
 * pixel by pixel to origo. All forms are drawn in order of
 * their size, with the biggest form first and smallest last. 
 * <P>
 * <tt>Point</tt> have been  increased to 2 pixels in diameter
 * and leaves a trace on its way to origo.
 * When a <tt>Point</tt> is choosen, each second time it become black,
 * which will be checked in a <tt>HashSet</tt>,
 * in order to  test the methods of <tt>equals</tt> and
 * <tt>hashCode</tt>.
 *
 * @author (Bror Bjerner)
 * @version (nov 2012)
 */
public class MoveToUpperLeftCorner 
extends JFrame
implements ActionListener {

	// Forms that are choosen, ThickPoint and BigFirst further down in this file
	private List<ThickPoint>           points      = new LinkedList<ThickPoint>();
	private Set<ThickPoint>            pointSet    = new HashSet<ThickPoint>();
	private List<TracePoint>           tracePoints = new LinkedList<TracePoint>();
	private SortedSet<GeometricalForm> forms       = new TreeSet<GeometricalForm>(new BigFirst());
	private boolean                    nextBlack   = false;

	// Buttons for each form that can be choosen, a button to start the moving and a
	// button to restart the whole animation
	private JButton point     = new JButton("Thick point");
	private JButton line      = new JButton("Line");
	private JButton square    = new JButton("Square");
	private JButton rectangle = new JButton("Rectangle");
	private JButton circle    = new JButton("Circle");
	private JButton oval      = new JButton("Oval");
	private JButton startMove = new JButton("Start moving");
	private JButton restart   = new JButton("Restart");

	// Create a new drawing area. Class DrawingArea defined further down in this file.
	// Must be an instance field, since it contains a Timer.
	private DrawingArea drawingArea = new DrawingArea();

	/**
	 * The whole basic picture is constructed in the constructor.
	 */
	public MoveToUpperLeftCorner() {

		// Make all listeners active.
		point.addActionListener(this);    
		line.addActionListener(this);    
		square.addActionListener(this);    
		rectangle.addActionListener(this);    
		circle.addActionListener(this);    
		oval.addActionListener(this);    
		startMove.addActionListener(this);
		restart.addActionListener(this);

		// Colour the buttons 
		point.setBackground( Color.yellow ); 
		line.setBackground( Color.yellow ); 
		square.setBackground( Color.yellow ); 
		rectangle.setBackground( Color.yellow ); 
		circle.setBackground( Color.yellow ); 
		oval.setBackground( Color.yellow ); 
		startMove.setBackground( Color.magenta ); 
		restart.setBackground( Color.orange ); 


		// Place the buttons      
		JPanel buttons = new JPanel();
		buttons.add( point );
		buttons.add( line );
		buttons.add( square );
		buttons.add( rectangle );
		buttons.add( circle );
		buttons.add( oval );
		buttons.add( startMove );
		buttons.add( restart );

		// Place buttons and drawingArea into the frame
		Container content = getContentPane();
		content.add( drawingArea,    BorderLayout.CENTER );
		content.add( buttons, BorderLayout.SOUTH  );
		setSize(760,780);

		/*  Use this if you want to check vertical and horisontal lines
    try {  Use this to check
       forms.add( new Line( 10, 10, 10, 60, new Color(50,75,200)));
       forms.add( new Line( 20, 20, 60, 20, new Color(50,200,100)));
    } 
    catch ( IllegalPositionException ipe ) {
          System.out.println("Something is rotten in Denmark.");
    }
		 */

		// Fix the frames close button
		setDefaultCloseOperation( EXIT_ON_CLOSE );

		// Show the frame at start.
		setVisible(true);

	}  //  contructor MoveToUpperLeftCorner

	/**
	 * All actions performed when a button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {

		//  Coordinates and colour are choosed at random.
		int   x = (int)Math.round( Math.random()*600);
		int   y = (int)Math.round( Math.random()*600);
		Color c = new Color( (int)Math.round(Math.random()*255),
				(int)Math.round(Math.random()*255),
				(int)Math.round(Math.random()*255) );

		try { if ( e.getSource() == point ) {
			ThickPoint p;
			if (nextBlack)
				p = new ThickPoint( x, y, new Color(0,0,0));
			else
				p = new ThickPoint( x, y, c );
			nextBlack = ! nextBlack;
			if ( pointSet.contains( p ) )
				JOptionPane.showMessageDialog( this,  "Point with this colour already exists, try again." );
						else {
							pointSet.add(p); // just in order to check hashCode !!
							points.add( p );
							tracePoints.add( new TracePoint(p, p.getColor()) );
							JOptionPane.showMessageDialog( this,  "A new random thick point is created" );
						}
		}
		else if ( e.getSource() == line ) {
			if ( forms.add( new Line( x,
					y,
					(int)Math.round( Math.random()*720),
					(int)Math.round( Math.random()*720),
					c                                   )) )
				JOptionPane.showMessageDialog( this,  "A new random line is created." );
			else
				JOptionPane.showMessageDialog( this,  "Line this size and colour already exists, try again" );
		}
		else if ( e.getSource() == square ) {
			int length = Integer.parseInt(
					JOptionPane.showInputDialog("Choose side length (1-500):")); 
			if ( ! forms.add( new Square( x, y, length, c )) )
				JOptionPane.showMessageDialog( this,  "Square this size and colour already exists, try again" );
		}
		else if ( e.getSource() == rectangle ) {
			int width  = Integer.parseInt(
					JOptionPane.showInputDialog("Choose width (1-500)")); 
			int heigth = Integer.parseInt(
					JOptionPane.showInputDialog("Choose heigth (1-500)")); 
			if ( ! forms.add( new Rectangle( x, y, width, heigth, c )) )
				JOptionPane.showMessageDialog( this,  "Rectangle this size and coulour already exists, try again" );

		}
		else if ( e.getSource() == circle ) {
			int radius = Integer.parseInt(
					JOptionPane.showInputDialog("Choose diameter (1-500)"));
			if ( ! forms.add( new Circle( x, y, radius, c )  ) )
				JOptionPane.showMessageDialog( this,  "Circle this size and coulour already exists, try again" );
		}
		else if ( e.getSource() == oval ) {
			int width  = Integer.parseInt(
					JOptionPane.showInputDialog("Choose width (1-500)")); 
			int heigth = Integer.parseInt(
					JOptionPane.showInputDialog("Choose heigth (1-500)")); 
			if ( ! forms.add( new Oval( x, y, width, heigth, c )) )
				JOptionPane.showMessageDialog( this,  "Oval this size and colour already exists, try again" );

		}
		else if ( e.getSource() == startMove ) {
			// Start the timer of the drawing area
			drawingArea.start();
		}
		else if ( e.getSource() == restart ) {
			// Remove all geometrical forms from the drawing area
			points.clear();
			pointSet.clear();
			forms.clear();
			tracePoints.clear();
		}
		}
		catch( IllegalPositionException ipe ) {
			JOptionPane.showMessageDialog( 
					this, "Illegal position, try again.");  
		}
		catch( NumberFormatException nfe ) {
			JOptionPane.showMessageDialog( 
					this, "Only positive integers allowed, try again.");  
		}
		repaint();

	}  // actionPerformed

	// Move the position one pixle closer to origo, both x and y coordinates. 
	// The boolean value returned indicates if the position has changed,
	// i.e. if the position differed from (0,0) !!
	private boolean moveForm( GeometricalForm f ) {
		int x = f.getX();
		int y = f.getY();
		if ( x == 0 && y == 0 )
			return false;
		else 
			try { f.place( Math.max( x-1, 0 ), Math.max( y-1, 0 ));
			}
		catch( IllegalPositionException ipe ) {}  //  Can not happen !!
		return true;
	} // moveForm

	// make a drawing area containg a timer, which is used to move
	// all forms i the drawing arean is moved step by step to origo. 
	private class DrawingArea extends JPanel
	implements ActionListener {

		//    private List<ThickPoint> tracePoints = new LinkedList<ThickPoint>();
		private boolean notInPlace;
		private javax.swing.Timer tim = new javax.swing.Timer( 20, this);

		public DrawingArea() {
			setSize(700,700);
			setBackground( Color.white );
		}  // kostruktor DrawingArea

		public void start() {
			notInPlace = true;
			for ( ThickPoint p : points )
				tracePoints.add( new TracePoint(p,p.getColor()) );
			tim.start();
		} // start

		public void stop() {
			tracePoints.clear();
			tim.stop();
		}  // stop

		public void paint( Graphics g ) {
			super.paint(g);
			for( GeometricalForm f : forms )
				f.fill(g);
			for( ThickPoint p : points )
				p.fill(g);
			for( TracePoint p : tracePoints )
				p.fill(g);
		} // paint  

		public void actionPerformed(ActionEvent ae) {
			if ( notInPlace ) {
				notInPlace = false;
				for ( ThickPoint p : points )
					if ( moveForm( p ) )
						notInPlace = true; 
				for ( ThickPoint p : points )
					tracePoints.add( new TracePoint(p,p.getColor()) ); 
				for ( GeometricalForm f : forms )
					if ( moveForm( f ) )
						notInPlace = true;
				repaint();
			}
			else 
				stop();  
		}     
	}  // class DrawingArea

	// A comparator who change the order in the sorted set of
	// geometrical forms, i.e. den biggest form
	// first and the smallest form last.
	private class BigFirst implements Comparator<GeometricalForm> {

		public int compare( GeometricalForm f1, 
				GeometricalForm f2  ) {
			return f2.compareTo( f1 );
		}
	}

	/**
	 *  Start the animation.
	 */
	public static void main( String[] args ) {
		new MoveToUpperLeftCorner();
	}

}  //  class MoveToUpperLeftCorner

//  In order to make points more visible in the drawing area
class ThickPoint extends Point {

	public ThickPoint( int x, int y, Color c )
			throws IllegalPositionException {
		super( x, y, c);
	}  // constructor Point

	public ThickPoint( Point p, Color c ) {
		super( p, c);
	}  // constructor Point

	//  Dubbles the thickness of the point.
	public void fill(  Graphics g ) {
		g.setColor( getColor() );
		g.fillOval( getX(), getY(), 4, 4);
	} // fill  


} // class ThickPoint

//  In order to show the trace of the points in the drawing area
class TracePoint extends Point {

	public TracePoint( int x, int y, Color c )
			throws IllegalPositionException {
		super( x, y, c);
	}  // constructor Point

	public TracePoint( Point p, Color c ) {
		super( p, c);
	}  // constructor Point

	//  Dubbles the thickness of the point.
	public void fill(  Graphics g ) {
		g.setColor( getColor() );
		g.fillOval( getX(), getY(), 2, 2);
	} // fill  


} // class TracePoint