import java.lang.Object;

/**
 * A class that implements like a Connect4 game.
 *
 * ConnectN is a tile-based game played on a grid. Like Connect4, players
 *  try to get a run of tiles of a given length (N). However, unlike Connect4
 *  ConnectN does not check diagonal runs, although you can add this feature if you like.
 */
public class ConnectN {

    /** Class variable that we used to generate a unique ID for each newly created board. */
    private static int globalID = 0;
    /**
     * Maximum height for board.
     */
    public static final int MAX_HEIGHT = 16;
    /**
     * Maximum width for board.
     */
    public static final int MAX_WIDTH = 16;
    /**
     * Minimum height for board.
     */
    public static final int MIN_HEIGHT = 4;
    /**
     * Minimum width for board.
     */
    public static final int MIN_WIDTH = 4;
    /**
     * Minimum N value.
     */
    public static final int MIN_N = 4;
    /**
     * Public game title.
     */
    public String title;


    private int height;
    private int width;
    private int n;
    private static int totalGames;


    // All 4 types of constructors
    /**
     * A new ConnectN board with uninitialized width, height, and N value.
     */
    public ConnectN() {
        id = ConnectN.globalID++;
    }

    /**
     * A new ConnectN board with dimensions and N copied from another board.
     *
     * @param otherBoard The board in which we are copying
     */
    public ConnectN(final ConnectN otherBoard) {
        this.height = otherBoard.getHeight();
        this.width = otherBoard.getWidth();
        this.n = otherBoard.getN();
        id = ConnectN.globalID++;
    }
    /**
     * A new ConnectN board with given width and height and an uninitialized N value.
     *
     * @param setHeight the height of the ConnectN board
     * @param setWidth the width of the ConnectN board
     */
    public ConnectN(final int setWidth, final int setHeight) {
        height = setHeight;
        width = setWidth;
        id = ConnectN.globalID++;
    }
    /**
     * A new ConnectN board with given width, height and N value.
     *
     * @param setHeight the height of the ConnectN board
     * @param setWidth the width of the ConnectN board
     * @param setN the number of spots in a row needed to win
     */
    public ConnectN(final int setWidth, final int setHeight, final int setN) {
        height = setHeight;
        width = setWidth;
        n = setN;
        id = ConnectN.globalID++;
    }


    /**
     * Get the current board height.
     *
     * @return the height of the board
     */
    public int getHeight() {
        return height;
    }
    /**
     * Get the current board width.
     *
     * @return the current width of the board
     */
    public int getWidth() {
        return width;
    }
    /**
     * Get the current N value.
     *
     * @return the current N value
     */
    public int getN() {
        return n;
    }


    /**
     * Attempts to set the current board height.
     *
     * @param newHeight the attempted new height of the board.
     * @return true if the height has been reset to newHeight
     */
    public boolean setHeight(final int newHeight) {
        if (MIN_HEIGHT < newHeight && newHeight < MAX_HEIGHT) {
            height = newHeight;
            if (height < n + 1) {
                n = 0;
            }
            return true;
        } else {
            return false;
        }
    }
    /**
     * Attempts to set the current board width.
     *
     * @param newWidth the new width of the board
     * @return true if the width has been reset to newWidth
     */
    public boolean setWidth(final int newWidth) {
        if (MIN_WIDTH < newWidth && newWidth < MAX_WIDTH) {
            width = newWidth;
            if (width < n + 1) {
                n = 0;
            }
            return true;
        } else {
            return false;
        }
    }
    /**
     * Attempts to set the current N value for the board.
     *
     * @param newN the new N value for the board
     * @return true if N has been reset for the board
     */
    public boolean setN(final int newN) {
        n = newN;
        return false;
    }
    /**
     * Gets the total number of games.
     *
     * @return Returns the total number of games
     */
    public static int getTotalGames() {
        return totalGames;
    }


    /**
     * Creates a new ConnectN board.
     *
     * @param width the width of the new ConnectN board
     * @param height the height of the new ConnectN board
     * @param n the value of n for the new ConnectN board
     * @return the new ConnectN board or null
     */
    public static ConnectN create(final int width, final int height, final int n) {
        if (width < MIN_WIDTH || width > MAX_WIDTH) {
            return null;
        } else if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            return null;
        } else if (n < MIN_N) {
            return null;
        } else {
            ConnectN newBoard = new ConnectN(width, height, n);
            return newBoard;
        }
    }
    /**
     * Creates an array of ConnectN boards.
     *
     * @param number number of ConnectN boards in the array
     * @param width the width of the ConnectN boards
     * @param height the height of the ConnectN boards
     * @param n the n value of the ConnectN boards
     * @return an array of ConnectN boards
     */
    public static ConnectN[] createMany(final int number, final int width,
            final int height, final int n) {
        if (number <= 0) {
            return null;
        } else {
            ConnectN[] arrayBoards = new ConnectN[number];
            for (int i = 0; i < number; i++) {
                arrayBoards[i] = new ConnectN(width, height, n);
            }
            return arrayBoards;
        }
    }


    /**
     * Sets the board at a specific position.
     *
     * @param player the player attempting the move
     * @param setX the X coordinate that they are trying to place a tile at
     * @param setY the Y coordinate that they are trying to place a tile at
     * @return true if the move succeeds, false if error
     */
    public boolean setBoardAt(Player player, int setX, int setY) {
        Player[][] temp = this.getBoard();
        temp[setX][setY] = player;
        return null;
    }

    /**
     * Drops a tile in a particular column.
     *
     * @param player the player attempting to move
     * @param setX the X coordinate that the player is trying to place a tile at
     * @return
     */
    public boolean setBoardAt(Player player, int setX) {
        return null;
    }

    /** Unique id of a ConnectN board. */
    private int id;

    /**
     * Gets the current board's id.
     *
     * @return the current board's id
     */
    public int getID() {
        return id;
    }

    /**
     * Return a copy of the board.
     * Once the width and height are set, this function should not return null.
     * Until then, it should return null.
     *
     * @return a copy of the board
     */
    public Player[][] getBoard() {
        if (this.getHeight() > 0 && this.getWidth() > 0) {
            Player[][] hold = new Player[this.getHeight()][this.getWidth()];
            for (int i = 0; i < this.getHeight(); i++) {
                for (int k = 0; k < this.getWidth(); k++) {
                    hold[i][k] = new Player("blank");
                }
            }
            return hold;
        } else {
            return null;
        }
    }

    /**
     * Get the player at a specific board position.
     *
     * @param getX the X coordinate to get the player at
     * @param getY the Y coordinate to get the player at
     * @return the player whose at the position
     */
    public Player getBoard(int getX, int getY) {
        return null;
    }

    /**
     * Return the winner of the game, or null if the game has not ended.
     *
     * @return the winner of the game
     */
    public Player getWinner() {
        return null;
    }


    /**
     * Compares two ConnectN boards.
     *
     * @param firstBoard the first ConnectN board to compare
     * @param secondBoard the second ConnectN board to compare
     * @return true if both the boards are the same
     */
    public static boolean compareBoards(ConnectN firstBoard, ConnectN secondBoard) {
        return null;
    }

    /**
     * Compares any number of ConnectN boards.
     *
     * @param boards the array of ConnectN boards to compare
     * @return true if all passed boards are the same
     */
    public static boolean compareBoards(ConnectN...boards) {
        return null;
    }


}
