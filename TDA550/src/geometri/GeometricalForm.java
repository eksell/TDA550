package geometri;

import java.awt.*;

/**
 * This interface describes drawable geometrical forms.
 * Each form contains of: A rectangle surrounding the form as narrow as
 * possible defined by its width, height and the position,
 * the upper left corner of the rectangle,
 * and a colour given as an object of <tt>java.awt.Color</tt>.
 *.<p>
 * Furthermore the forms may be compared. First the areas of the
 * forms are compared and if the areas are equal then the
 * the perimeters are compared.
 * The area and the perimeter of a <tt>Point</tt> are 0. 
 * The area of a
 * <tt>Line</tt> is 0 and its perimeter is the length of
 * the line.
 * <p>
 * The forms may be moved, but may not be modyfied in any other way.
 * Only positive x och y coordinates are allowed for the position.
 * Negative values for the coordinates gives an
 * <tt>IllegalPositionException</tt>, which is declared
 * in this package.
 * <p>
 * Finally, the forms may be compared for equality,
 * where all components except the positions of the forms
 * are compared for equality.
 *
 * @author (Bror Bjerner)
 * @version (nov 2012)
 */
public interface GeometricalForm
       extends   Comparable<GeometricalForm> {

   /**
    * Get the area of this form rounded
    * to closest integer.
    *
    * @return the computed area.
    */
   public int getArea();

    /** 
     * The method <tt>compareTo</tt> compares the area of the forms
     * to decide if the given geometrical form is less or greater
     * than this object. If they have the same area, the
     * perimeter decides.
     *  
     * @param f The geometrical form to compare with.
     * @return An integer smaller than 0 if this form 
               is smaller than the form given as argument,
     *         0 if the sizes are equal, and a positive integer
               otherwise.
    */
    public int compareTo( GeometricalForm f );

    /** 
     * Fill the forms area at the forms position
     * with the forms color.
     *
     * @param g A graphic pen to draw with. 
     */
   public void fill( Graphics g );

   /**
    * Get the colour of this form.
    *
    * @return the colour of this form.
    */

   public Color getColor();

   /**
    * Get the width of this forms surrounding rectangle.
    *
    * @return the width.
    */
   public int getWidth();

   /**
    * Get the height of this forms surrounding rectangle.
    *
    * @return the x coordinate.
    */
   public int getHeight();

   /**
    * Get the x coordinate of this forms position.
    *
    * @return the x coordinate.
    */
   public int getX();

   /**
    * Give the y coordinate of this forms position.
    *
    * @return the y coordinate.
    */
   public int getY();

   /**
    * Move the form the given distances. 
    * Check if the new coordinates are legal and
    * if they are, set the position to the new coordinates.
    * Otherwise an <tt>IllegalPositionException</tt> is thrown.
    * Origo is (0,0) and only positive coordinates are legal.
    *
    * @param dx move the form dx points to the right.
    * @param dy move the form dy points down.
    * @throws IllegalPositionException if any coordinate
    *                                  becomes negative.
    */
   public void move( int dx, int dy )
          throws IllegalPositionException;

   /**
    * Get the perimeter of this form rounded
    * to closest integer.
    *
    * @return the computed perimeter.
    */
   public int getPerimeter();

   /**
    * Place the form on given coordinates.
    * Check if the coordinates are legal.
    * Origo is (0,0) and only positive
    * coordinates are legal.
    * If they are legal, update the position with the new coordinates.
    * Otherwise an <tt>IllegalPositionException</tt> is thrown.
    *
    * @param x Distance right from origo.
    * @param y Distance down from origo.
    * @throws <tt>IllegalPositionException</tt> if any coordinate
    *                                           is negative.
    */
   public void place( int x, int y )
          throws IllegalPositionException;   


} // interface GeometricalForm
    