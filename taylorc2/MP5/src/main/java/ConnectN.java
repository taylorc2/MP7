import java.lang.Object;

/**
 * A class that implements like a Connect4 game.
 *
 * ConnectN is a tile-based game played on a grid. Like Connect4, players
 *  try to get a run of tiles of a given length (N). However, unlike Connect4
 *  ConnectN does not check diagonal runs, although you can add this feature if you like.
 */
public class ConnectN {

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
    @SuppressWarnings(“checkstyle:visibilitymodifier”);
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
            if (width < n +1) {
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
     * Creates a new ConnectN board
     *
     * @param width the width of the new ConnectN board
     * @param height the height of the new ConnectN board
     * @param n the value of n for the new ConnectN board
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

    public static ConnectN[] createMany(final int number, final int width,
            final int height, final int n) {
        ConnectN r = new ConnectN(width, height, n);
        if (number < 0) {
            return null;
        } else if (r == null) {
            return null;
        } else {
            ConnectN[] arrayBoards = new ConnectN[number];
            for (int i = 0; i < number; i++) {
                arrayBoards[i] = r;
            }
            return arrayBoards;
        }
    }



}
