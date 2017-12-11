

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
    public static final int MIN_HEIGHT = 6;
    /**
     * Minimum width for board.
     */
    public static final int MIN_WIDTH = 6;
    /**
     * Minimum N value.
     */
    public static final int MIN_N = 4;
    /**
     * Public game title.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public String title;

    /**
     * Unique id for each ConnectN game.
     */
    private int id;
    /**
     * The height of the ConnectN board.
     */
    private int height;
    /**
     * The width of the ConnectN board.
     */
    private int width;
    /**
     * The N value for the ConnectN game.
     */
    private int n;
    /**
     * The total number of ConnectN games.
     */
    private static int totalGames = 0;
    /**
     * The 2D array board for a ConnectN game.
     */
    private Player[][] board;


    // All 4 types of constructors
    /**
     * A new ConnectN board with uninitialized width, height, and N value.
     */
    public ConnectN() {
        id = totalGames;
        totalGames++;
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
        id = totalGames;
        totalGames++;
        board = new Player[width][height];
    }
    /**
     * A new ConnectN board with given width and height and an uninitialized N value.
     *
     * @param setHeight the height of the ConnectN board
     * @param setWidth the width of the ConnectN board
     */
    public ConnectN(final int setWidth, final int setHeight) {
        if (MIN_WIDTH <= setWidth && setWidth <= MAX_WIDTH) {
            width = setWidth;
        } else {
            width = 0;
        }
        if (MIN_HEIGHT <= setHeight && setHeight <= MAX_HEIGHT) {
            height = setHeight;
        } else {
            height = 0;
        }
        id = totalGames;
        totalGames++;
        board = new Player[width][height];
    }
    /**
     * A new ConnectN board with given width, height and N value.
     *
     * @param setHeight the height of the ConnectN board
     * @param setWidth the width of the ConnectN board
     * @param setN the number of spots in a row needed to win
     */
    public ConnectN(final int setWidth, final int setHeight, final int setN) {
        if (MIN_WIDTH <= setWidth && setWidth <= MAX_WIDTH) {
            width = setWidth;
        } else {
            width = 0;
        }
        if (MIN_HEIGHT <= setHeight && setHeight <= MAX_HEIGHT) {
            height = setHeight;
        } else {
            height = 0;
        }
        int max = height;
        if (width > height) {
            max = width;
        }
        if (setN >= MIN_N && setN < max && width != 0 && height != 0) {
            n = setN;
        } else {
            n = 0;
        }
        id = totalGames;
        totalGames++;
        board = new Player[width][height];
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
        if (MIN_HEIGHT <= newHeight && newHeight <= MAX_HEIGHT && !gameStarted()) {
            height = newHeight;
            board = new Player[width][height];
            int max = height;
            if (width > height) {
                max = width;
            }
            if (max <= n) {
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
        if (MIN_WIDTH <= newWidth && newWidth <= MAX_WIDTH && !gameStarted()) {
            width = newWidth;
            board = new Player[width][height];
            int max = height;
            if (width > height) {
                max = width;
            }
            if (max <= n) {
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
        int max = height;
        if (width > height) {
            max = width;
        }
        if (!gameStarted() && width != 0 && height != 0 && newN >= MIN_N && newN < max) {
            n = newN;
            return true;
        } else {
            return false;
        }
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
        int max = height;
        if (width > height) {
            max = width;
        }
        if (width < MIN_WIDTH || width > MAX_WIDTH) {
            return null;
        } else if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            return null;
        } else if (n < MIN_N || n >= max) {
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
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        int nextY = -1;
        if (gameEnded()) {
            return false;
        }
        if (whosTurn() == null || (player.getName()).equals(whosTurn())) {
            if (0 <= setX && setX < width && 0 <= setY
                    && setY < height && board[setX][setY] == null) {
                for (int i = 0; i < height; i++) {
                    if (board[setX][i] != null) {
                        nextY = i + 1;
                    }
                }
                if (nextY == -1 && board[setX][0] == null) {
                    nextY = 0;
                }
                if (nextY == setY && board[setX][setY] == null) {
                    board[setX][setY] = player;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Drops a tile in a particular column.
     *
     * @param player the player attempting to move
     * @param setX the X coordinate that the player is trying to place a tile at
     * @return true if the move succeeds, false if error
     */
    public boolean setBoardAt(final Player player, final int setX) {
        int nextY;
        if (gameEnded()) {
            return false;
        }
        if (whosTurn() == null || (player.getName()).equals(whosTurn())) {
            if (0 <= setX && setX < width) {
                for (int i = 0; i < height; i++) {
                    if (board[setX][i] == null) {
                        nextY = i;
                        board[setX][nextY] = player;
                        return true;
                    }
                }
                return false;
            }
        }
        return false;

    }


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
        if (width != 0 && height != 0) {
            Player[][] update = new Player[width][height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (board[x][y] == null) {
                        continue;
                    }
                    update[x][y] = new Player(board[x][y]);
                }
            }
            return update;
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
    public Player getBoardAt(final int getX, final int getY) {
        if (0 <= getX && getX < width && 0 <= getY && getY < height) {
            return board[getX][getY];
        } else {
            return null;
        }
    }

    /**
     * Return the winner of the game, or null if the game has not ended.
     *
     * @return the winner of the game
     */
    public Player getWinner() {

        if (gameStarted()) {
            Player diaR = rightDia();
            Player diaL = leftDia();
            if (diaR != null) {
                diaR.addScore();
                return diaR;
            }
            if (diaL != null) {
                diaL.addScore();
                return diaL;
            }
            int streak = 0;
            String lastPlayer = "";
            String p1;
            for (int x = 0; x < width; x++) {
                streak = 0;
                lastPlayer = "";
                for (int y = 0; y < height; y++) {
                    if (board[x][y] == null) {
                        continue;
                    } else {
                    p1 = (board[x][y]).getName();
                    }
                    if (p1.equals(lastPlayer)) {
                        streak++;
                        if (streak == n) {
                            board[x][y].addScore();
                            return board[x][y];
                        }
                    } else {
                        streak = 1;
                        lastPlayer = p1;
                    }

                }
            }
            for (int y = 0; y < height; y++) {
                streak = 0;
                lastPlayer = "";
                for (int x = 0; x < width; x++) {
                    if (board[x][y] == null) {
                        continue;
                    } else {
                    p1 = (board[x][y]).getName();
                    }
                    if (p1.equals(lastPlayer)) {
                        streak++;
                        if (streak == this.n) {
                            board[x][y].addScore();
                            return board[x][y];
                        }
                    } else {
                        streak = 1;
                        lastPlayer = p1;
                    }
                }
            }
        return null;
        }
        return null;

    }


    /**
     * Compares two ConnectN boards.
     *
     * @param firstBoard the first ConnectN board to compare
     * @param secondBoard the second ConnectN board to compare
     * @return true if both the boards are the same
     */
    public static boolean compareBoards(final ConnectN firstBoard, final ConnectN secondBoard) {
        if (firstBoard == null || secondBoard == null) {
            return false;
        }
        if (firstBoard.width != secondBoard.width || firstBoard.height != secondBoard.height) {
            return false;
        }
        if (firstBoard.n != secondBoard.n) {
            return false;
        }
        for (int y = 0; y < firstBoard.height; y++) {
            for (int x = 0; x < firstBoard.width; x++) {
                Player first = firstBoard.board[x][y];
                Player second = secondBoard.board[x][y];
                if (first == null && second == null) {
                    continue;
                } else if (first == null || second == null) {
                    return false;
                } else if (!first.equals(second)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Compares any number of ConnectN boards.
     *
     * @param boards the array of ConnectN boards to compare
     * @return true if all passed boards are the same
     */
    public static boolean compareBoards(final ConnectN...boards) {

        for (int i = 0; i < boards.length - 1; i++) {
            if (boards[i] == null || boards[i + 1] == null) {
                return false;
            }
            if (boards[i].width != boards[i + 1].width
                    || boards[i].height != boards[i + 1].height) {
                return false;
            }
            if (boards[i].n != boards[i + 1].n) {
                return false;
            }
            for (int y = 0; y < boards[i].height; y++) {
                for (int x = 0; x < boards[i].width; x++) {
                    Player first = boards[i].board[x][y];
                    Player second = boards[i + 1].board[x][y];
                    if (first == null && second == null) {
                        continue;
                    } else if (first == null || second == null) {
                        return false;
                    } else if (!first.equals(second)) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

/**
 * Define the hash code for the ConnectN class.
 */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

/**
 * Define equality for the ConnectN class.
 *
 * @param obj another object of the class to test equality
 */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ConnectN other = (ConnectN) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * Determines whether the game has started or not.
     *
     * @return true if the game has started
     */
    public boolean gameStarted() {
        boolean flag = false;
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < width; i++) {
                if (board[i][k] != null) {
                    flag = true;
                }
            }
        }
        return flag;
    }
/**
 * Determines whether the game is over or not.
 *
 * @return true if the game is over
 */
    public boolean gameEnded() {
        if (hasWinner() == true) {
            return true;
        } else {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (board[x][y] == null) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
/**
 * Determines whether the ConnectN game has a winner or not.
 *
 * @return true if there is a winner, false if not
 */
    public boolean hasWinner() {

        if (gameStarted()) {
            if (rightDia() != null) {
                return true;
            }
            if (leftDia() != null) {
                return true;
            }
            int streak = 0;
            String lastPlayer = "";
            String p1;
            for (int x = 0; x < width; x++) {
                streak = 0;
                lastPlayer = "";
                for (int y = 0; y < height; y++) {
                    if (board[x][y] == null) {
                        continue;
                    } else {
                    p1 = (board[x][y]).getName();
                    }
                    if (p1.equals(lastPlayer)) {
                        streak++;
                        if (streak == n) {
                            return true;
                        }
                    } else {
                        streak = 1;
                        lastPlayer = p1;
                    }

                }
            }
            for (int y = 0; y < height; y++) {
                streak = 0;
                lastPlayer = "";
                for (int x = 0; x < width; x++) {
                    if (board[x][y] == null) {
                        continue;
                    } else {
                    p1 = (board[x][y]).getName();
                    }
                    if (p1.equals(lastPlayer)) {
                        streak++;
                        if (streak == this.n) {
                            return true;
                        }
                    } else {
                        streak = 1;
                        lastPlayer = p1;
                    }
                }
            }
        return false;
        }
        return false;

    }


    /**
     * Determines who's turn it is to play.
     *
     * @return name of the player who's turn it is
     */
    public String whosTurn() {
        int p1Turns = 0;
        int p2Turns = 0;
        String p1 = "";
        String p2 = "";

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Player current = board[x][y];
                if (current == null) {
                    continue;
                } else {
                    if (p1.equals("")) {
                        if (p2.equals("")) {
                            p2 = current.getName();
                            p2Turns++;
                        } else if (p2.equals(current.getName())) {
                            p2Turns++;
                        } else {
                            p1 = (current).getName();
                            p1Turns++;
                        }
                    } else if (p2.equals("")) {
                        if ((current.getName()).equals(p1)) {
                            p1Turns++;
                        } else {
                            p2 = current.getName();
                            p2Turns++;
                        }
                    } else {
                        if ((current.getName()).equals(p1)) {
                            p1Turns++;
                        } else if (current.getName().equals(p2)) {
                        p2Turns++;
                        }
                    }
                }
            }
        } //FOR LOOPS OVER
        if (!p1.equals("") && !p2.equals("")) {
            if (p2Turns > p1Turns) {
                return p1;
            }
            return p2;
        }

        return null;
    }


    /**
     * Determines which player (if any) has won on a positive slope.
     *
     * @return the player that won, null if n/a
     */
    public Player rightDia() {
        for (int row = 0; row < height - n + 1; row++) {
            for (int column = 0; column < width - n + 1; column++) {
              if (board[column][row] != null && board[column + 1][row + 1] != null
                      && board[column + 2][row + 2] != null
                      && board[column + 3][row + 3] != null) {

                   if ( board[column + 1][row + 1].equals(board[column][row])
                           && board[column + 2][row + 2].equals(board[column][row]) &&
                   board[column + 3][row + 3].equals(board[column][row])) {
                              return board[column][row];
                              }
              }
         }
       }
        return null;
    }
    /**
     * Determines which player (if any) has won on a negative slope.
     *
     * @return the player that won, null if n/a
     */
    public Player leftDia() {
        for (int row = n - 1; row < height; row++) {
            for (int column = 0; column < width - n + 1; column++) {
                if (board[column][row] != null && board[column + 1][row - 1] != null
                        && board[column + 2][row - 2] != null
                        && board[column + 3][row - 3] != null) {
                    if(board[column + 1][row - 1].equals(board[column][row])
                            && board[column + 2][row - 2].equals(board[column][row])
                        && board[column + 3][row - 3].equals(board[column][row])){
                        return board[column][row];
                   }
                }
            }
        }
        return null;
    }


}
