package orig2011.v6;

import java.awt.Dimension;

public class GameUtils{

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
	 * @param gameTile
	 *            The type of tile to paint in specified position
	 */
	public static void setGameboardState(final GameTile[][] gameboardState, final int x, final int y,
			final GameTile gameTile) {
		gameboardState[x][y] = gameTile;
	}

	/**
	 * Returns the size of the gameboard.
	 */
	public static Dimension getGameboardSize() {
		return new Dimension(Constants.getGameSize().width, Constants.getGameSize().height);
	}
}
