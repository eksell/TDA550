package lab_1_task;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Initially 1 gold coin is randomly placed in the matrix. The green snake 
 * aims to eat coins to grow. Once collected there will appear a new coin to eat.
 * The game is the snake cover the screen. The game is lost when
 * snake leaves game board or tries to eat itself.
 */

public class SnakeModel extends GameModel {
	public enum Directions {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, -1),
		SOUTH(0, 1),
		NONE(0, 0);

		private final int xDelta;
		private final int yDelta;

		Directions(final int xDelta, final int yDelta) {
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		public int getXDelta() {
			return this.xDelta;
		}

		public int getYDelta() {
			return this.yDelta;
		}
	}

	private static final int COIN_START_AMOUNT = 1;

	/*
	 * The following GameTile objects are used only
	 * to describe how to paint the specified item.
	 * 
	 * This means that they should only be used in
	 * conjunction with the get/setGameboardState()
	 * methods.
	 */

	/** Graphical representation of a coin. */
	private static final GameTile COIN_TILE 		= new RoundTile(Color.ORANGE,Color.YELLOW, 2.0);
	/** Graphical representation of the collector */
	private static final GameTile SNAKE_TILE 		= new RoundTile(Color.BLACK,Color.GREEN, 2.0);
	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE 		= new GameTile();

	/*
	 * The declaration and object creation below uses the new language feature
	 * 'generic types'. It can be declared in the old way like this:
	 * private java.util.List coins = new ArrayList();
	 * This will however result in a warning at compilation
	 * "Position" in this case is the type of the objects that are going
	 * to be used in the List
	 */

	/** A list containing the positions of all coins. */
	private final List<Position> coins 	= new ArrayList<Position>();
	/** A list containing the positions of the snake parts that together (in the List) form the snake. */
	private final List<Position> snake = new ArrayList<Position>();

	/** The direction of the collector. */
	private Directions direction = Directions.NORTH;

	/** The number of coins found. */
	private int score;

	/**
	 * Create a new model for the gold game.
	 */
	public SnakeModel() {
		Dimension size = getGameboardSize();

		// Blank out the whole gameboard
		for (int i = 0; i < size.width; i++) {
			for (int j = 0; j < size.height; j++) {
				setGameboardState(i, j, BLANK_TILE);
			}
		}

		// Insert the collector in the middle of the gameboard.
		this.snake.add(new Position(size.width / 2, size.height / 2));
		this.snake.add(new Position(size.width / 2, (size.height / 2)+1));
		System.out.println("1.Snake size " + snake.size());
		setGameboardState(getHead(), SNAKE_TILE);

		// Insert coins into the gameboard.
		for (int i = 0; i < COIN_START_AMOUNT; i++) {
			addCoin();
		}
	}

	/**
	 * Insert another coin into the gameboard.
	 */
	private void addCoin() {
		Position newCoinPos;
		Dimension size = getGameboardSize();
		// Loop until a blank position is found and ...
		do {
			newCoinPos = new Position((int) (Math.random() * size.width),
					(int) (Math.random() * size.height));
		} while (!isPositionEmpty(newCoinPos));

		// ... add a new coin to the empty tile.
		setGameboardState(newCoinPos, COIN_TILE);
		this.coins.add(newCoinPos);
	}

	/**
	 * Return whether the specified position is empty.
	 * 
	 * @param pos
	 *            The position to test.
	 * @return true if position is empty.
	 */
	private boolean isPositionEmpty(final Position pos) {
		return (getGameboardState(pos) == BLANK_TILE);
	}

	/**
	 * Update the direction of the ctor
	 * according to the user's keypress.
	 */
	private void updateDirection(final int key) {
		switch (key) {
		case KeyEvent.VK_LEFT:
			this.direction = Directions.WEST;
			break;
		case KeyEvent.VK_UP:
			this.direction = Directions.NORTH;
			break;
		case KeyEvent.VK_RIGHT:
			this.direction = Directions.EAST;
			break;
		case KeyEvent.VK_DOWN:
			this.direction = Directions.SOUTH;
			break;
		default:
			// Don't change direction if another key is pressed
			break;
		}
	}

	/**
	 * Get position of the collector.
	 */
	private Position getPos() {

		Position thisPos = new Position(
				getHead().getX(),
				getHead().getY());

		return thisPos;
	}

	/**
	 * Get next position of the collector.
	 */
	private Position getNextPos() {

		Position nextPos = new Position(
				getHead().getX() + this.direction.getXDelta(),
				getHead().getY() + this.direction.getYDelta());

		return nextPos;
	}

	/**
	 * This method is called repeatedly so that the
	 * game can update its state.
	 * 
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	@Override
	public void gameUpdate(final int lastKey) throws GameOverException {
		updateDirection(lastKey);

		this.snake.set(0, getNextPos());

		if (collide(getNextPos())) {
			throw new GameOverException(this.score);
		}

		/**Snake eat a coin*/
		if (this.coins.remove(getHead())) {
			this.score++;
			growSnake(getPos());
			addCoin();
		}

		snakeBodyUpdate();
	}

	/** Returns current position of the snake head*/
	public Position getHead(){return this.snake.get(snake.size()-1);}

	/** Returns current position of the snake tail*/
	public Position getTail(){return this.snake.get(0);}

	public void growSnake(Position pos){
		this.snake.add(pos);
		//System.out.println("Size: " + snake.size());
	}

	public void snakeBodyUpdate(){
		/**Collect your tail*/
		this.snake.remove(getTail());
		setGameboardState(getTail(), BLANK_TILE);

		/**Take a step forward*/
		this.snake.add(getNextPos());
		setGameboardState(getHead(),SNAKE_TILE);

		//System.out.println("Get tail: " + getTail().getX()+ ", "+ getTail().getY());
		//System.out.println("Size: " + snake.size());
	}

	/**
	 * @param pos The position to test.
	 * @return <code>false</code> if the position is outside the playing field, <code>true</code> otherwise.
	 */
	private boolean collide(Position pos) {
		boolean collision = false;
		if( 	pos.getX() < 0 || 
				pos.getX() >= getGameboardSize().width|| 
				pos.getY() < 0 || 
				pos.getY() >= getGameboardSize().height){
			collision = true;
			System.out.println("There has been a collision with a wall!");
		}
		else if(snake.indexOf(pos)!=snake.lastIndexOf(pos)){
			collision = true;
			System.out.println("You've tried to eat yourself!");
		}
		return collision;			
	}

	/**
	 *  @param pos The position to test.
	 * @return <code>false</code> if the position is not the snake, <code>true</code> otherwise.
	 */
	private boolean isCannibal(Position pos) {		//EXPAND
		boolean self = false;
		return self;
	}

}
