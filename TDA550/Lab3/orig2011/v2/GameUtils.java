package orig2011.v2;

import java.awt.Dimension;
import orig2011.v0.Constants;
import orig2011.v0.GameTile;
import orig2011.v0.Position;

public abstract class GameUtils{

	/**
	 * Set the tile on a specified position in the gameboard.
	 * 
	 * @param pos
	 *            The position in the gameboard matrix.
	 * @param tile
	 *            The type of tile to paint in specified position
	 */
	public static void setGameboardState(final GameTile[][] t, final Position pos, final GameTile tile) {
		setGameboardState(t, pos.getX(), pos.getY(), tile);
	}

	/**
	 * Set the tile on a specified position in the gameboard.
	 * 
	 * @param x
	 *            Coordinate in the gameboard matrix.
	 * @param y
	 *            Coordinate in the gameboard matrix.
	 * @param tile
	 *            The type of tile to paint in specified position
	 */
	public static void setGameboardState(final GameTile[][] t, final int x, final int y,
			final GameTile tile) {
		t[x][y] = tile;
	}

	/**
	 * Returns the size of the gameboard.
	 */
	public Dimension getGameboardSize() {
		return new Dimension(Constants.getGameSize().width, Constants.getGameSize().height);
	}
}
