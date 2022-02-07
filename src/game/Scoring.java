package game;

/**
 * extended_tictactoe/game/Scoring.java
 * 09/29/2021
 * @author Phillip Ball
 * @version 1
 *
 * This class looks at the board and determines the score of each player.
 * 1 point is given for each 3 in a row on the board.
 */

public class Scoring
{
    // fields
    private static final int NUM_FOR_POINT = 3;

    // methods
    /**
     * Gets the points from vertical matches.
     *
     * @param theBoard the board multidimensional array
     * @param boardSize the size of the board
     * @param symbol either an "o" or and "x"
     * @return int, the number of at least NUM_FOR_POINT identical adjacent symbols
     */
    private int vertical(String[][] theBoard, int boardSize, String symbol)
    {
        // variables for number of points gained and number of same symbols in a row
        int points = 0;
        int sameInACol = 1;

        // loop through each column
        for (int col = 0; col < boardSize; col++) {
            // loop through each row but the last
            for (int row = 0; row < boardSize - 1; row++) {
                // if two adjacent spots are identical, increment the tracking variable
                if (theBoard[row][col].equals(symbol) && theBoard[row + 1][col].equals(symbol)) {
                    sameInACol++;
                }
                // if two adjacent spots are not identical, reset the tracking variable
                else {
                    sameInACol = 1;
                }
                // if there are at least NUM_FOR_POINT symbols in a column, add a point
                if (sameInACol >= NUM_FOR_POINT) {
                    points++;
                }
            }
            // reset the tracking variable when starting at a new column
            sameInACol = 1;
        }

        return points;
    }

    /**
     * Gets the points from horizontal matches.
     *
     * @param theBoard the board multidimensional array
     * @param boardSize the size of the board
     * @param symbol either an "o" or and "x"
     * @return int, the number of at least NUM_FOR_POINT identical adjacent symbols
     */
    private int horizontal(String[][] theBoard, int boardSize, String symbol)
    {
        // variables for number of points gained and number of same symbols in a row
        int points = 0;
        int sameInARow = 1;

        // loop through each row
        for (int row = 0; row < boardSize; row++) {
            // loop through each column but the last
            for (int col = 0; col < boardSize - 1; col++) {
                // if two adjacent spots are identical, increment the tracking variable
                if (theBoard[row][col].equals(symbol) && theBoard[row][col + 1].equals(symbol)) {
                    sameInARow++;
                }
                // if two adjacent spots are not identical, reset the tracking variable
                else {
                    sameInARow = 1;
                }
                // if there are at least NUM_FOR_POINT symbols in a row, add a point
                if (sameInARow >= NUM_FOR_POINT) {
                    points++;
                }
            }
            // reset the tracking variable when starting at a new row
            sameInARow = 1;
        }

        return points;
    }

    /**
     * Gets the points for 3+ identical symbols going diagonally down and to the right.
     *
     * @param theBoard the board multidimensional array
     * @param boardSize the size of the board
     * @param symbol either an "o" or and "x"
     * @return int, the number of at least NUM_FOR_POINT identical adjacent symbols
     */
    private int diagonalSE(String[][] theBoard, int boardSize, String symbol)
    {
        // variables for number of points gained and number of same symbols in a diagonal
        int points = 0;
        int sameInADiagonal = 1;
        // variables for which row and column we're looking at
        int row = 0;
        int col = 0;

        // loop while we're still within the boardSize dimensions
        while (row < boardSize && col < boardSize) {
            // if col + sameInADiagonal and row + sameInADiagonal
            // are smaller than the boardSize, then we're within the borders of the board
            if ((col + sameInADiagonal) < boardSize && (row + sameInADiagonal) < boardSize) {
                // if the symbol matches the one down and to the right
                if (theBoard[row][col].equals(symbol) &&
                        theBoard[row + sameInADiagonal][col + sameInADiagonal].equals(symbol)) {
                    // increment
                    sameInADiagonal++;

                    // if parameters are met, increment points
                    if (sameInADiagonal == NUM_FOR_POINT) {
                        points++;
                    }
                }
                // otherwise, reset the tracker and move right, to the next column
                else {
                    sameInADiagonal = 1;
                    col++;
                }
            }
            // otherwise, a wall has been reached, move to the left side of the next row
            else {
                row++;
                col = 0;
                sameInADiagonal = 1;
            }
        }

        return points;
    }

    /**
     * Gets the points for 3+ identical symbols going diagonally down and to the left.
     *
     * @param theBoard the board multidimensional array
     * @param boardSize the size of the board
     * @param symbol either an "o" or and "x"
     * @return int, the number of at least NUM_FOR_POINT identical adjacent symbols
     */
    private int diagonalSW(String[][] theBoard, int boardSize, String symbol)
    {
        // variables for number of points gained and number of same symbols in a diagonal
        int points = 0;
        int sameInADiagonal = 1;
        // variables for which row and column we're looking at
        int row = 0;
        int col = boardSize - 1;

        // loop while we're still within the boardSize dimensions
        while (row < boardSize && col > -1) {
            // if col - sameInADiagonal is bigger than -1 and
            // row + sameInADiagonal is smaller than the boardSize,
            // then we're within the borders of the board
            if ((col - sameInADiagonal) > -1 && (row + sameInADiagonal) < boardSize) {
                // if the symbol matches the one down and to the left
                if (theBoard[row][col].equals(symbol) &&
                        theBoard[row + sameInADiagonal][col - sameInADiagonal].equals(symbol)) {
                    // increment
                    sameInADiagonal++;

                    // if parameters are met, increment points
                    if (sameInADiagonal == NUM_FOR_POINT) {
                        points++;
                    }
                }
                // otherwise, reset the tracker and move left, to the next column
                else {
                    sameInADiagonal = 1;
                    col--;
                }
            }
            // otherwise, a wall has been reached, move to the right side of the next row
            else {
                row++;
                col = boardSize - 1;
                sameInADiagonal = 1;
            }
        }

        return points;
    }

    /**
     * Gets the full amount of points.
     *
     * @param theBoard the board multidimensional array
     * @param boardSize the size of the board
     * @param symbol either an "o" or and "x"
     * @return int, the sum of vertical, horizontal and diagonal points
     */
    public int getPoints(String[][] theBoard, int boardSize, String symbol)
    {
        return vertical(theBoard, boardSize, symbol) +
                horizontal(theBoard, boardSize, symbol) +
                diagonalSE(theBoard, boardSize, symbol) +
                diagonalSW(theBoard, boardSize, symbol);
    }
}
