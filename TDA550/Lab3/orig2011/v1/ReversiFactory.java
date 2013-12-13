package orig2011.v1;

import orig2011.v0.GameModel;
import orig2011.v0.GoldModel;
import orig2011.v0.IGameFactory;
import orig2011.v0.ReversiModel;

/**
 * Factory class for available games.
 */
public class ReversiFactory implements IGameFactory {

	/**
	 * Returns an array with names of games this factory can create. Used by GUI
	 * list availible games.
	 */
	@Override
	public String[] getGameNames() {
		return new String[] { "Gold","Reversi"};
	}

	/**
	 * Returns a new model object for the game corresponding to its Name.
	 * 
	 * @param gameName
	 *            The name of the game as given by getGameNames()
	 * @throws IllegalArgumentException
	 *             if no such game
	 */
	@Override
	public GameModel createGame(final String gameName) {
		if (gameName.equals("Gold")) {
			return new GoldModel();
		}
		else if (gameName.equals("Reversi")) {
			return new ReversiModel();
		}
		else
			throw new IllegalArgumentException("No such game: " + gameName);
	}
}
