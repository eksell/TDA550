package orig2011.v4;

import java.awt.Dimension;
import java.awt.Graphics;

/**
 * Draws a Blank tile
 */
public class BlankTile implements GameTile {

	public void draw(Graphics g, int x, int y, Dimension d) {
		// BlankTile is transparent,
		// therefore no drawing is performed.
	}
}
