import java.lang.Object;

/**
 * A class that implements like a Connect4 game.
 *
 * ConnectN is a tile-based game played on a grid. Like Connect4, players
 *  try to get a run of tiles of a given length (N). However, unlike Connect4
 *  ConnectN does not check diagonal runs, although you can add this feature if you like.
 */
public class ConnectN {

    // All static variables
    public static final int MAX_HEIGHT = 16;
    public static final int MAX_WIDTH = 16;
    public static final int MIN_HEIGH = 4;
    public static final int MIN_WIDTH = 4;
    public static final int MIN_N = 4;
    public String title;


    // Non-static variables
    private int height;
    private int width;
    private int n;


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
    public ConnectN(ConnectN otherBoard) {
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
    public ConnectN(int setHeight, int setWidth) {
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
    public ConnectN(int setHeight, int setWidth, int setN) {
        height = setHeight;
        width = setWidth;
        n = setN;
    }


    //


}
