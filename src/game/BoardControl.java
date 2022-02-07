package game;

/**
 * extended_tictactoe/game/BoardControl.java
 * 09/29/2021
 * @author Phillip Ball
 * @version 1
 *
 * This class controls how the game board is created and
 * stores any updates made to the board during gameplay.
 */

public class BoardControl
{
    // fields
    private String[][] theBoard;

    // methods
    /**
     * Builds the board based on the given dimensions.
     *
     * @param boardSize int, the dimensions of the board
     */
    public void buildBoard(int boardSize)
    {
        // sets the boards size
        theBoard = new String[boardSize][boardSize];

        // builds a "blank" board
        // builds the rows
        for (int row = 0; row < boardSize; row++) {
            // builds the columns
            for (int col = 0; col < boardSize; col++) {
                theBoard[row][col] = "-";
            }
        }
    }

    /**
     * Marks a position on the board with a player symbol.
     *
     * @param row the selected row
     * @param col the selected column
     * @param turn the player symbol
     */
    public void markPosition(int row, int col, String turn)
    {
        // changes the piece of the board to a players symbol
        theBoard[row][col] = turn;
    }

    /**
     * Checks if a position is already marked or not.
     *
     * @param row the selected row
     * @param col the selected column
     * @return bool, true if the spot isn't taken yet, false otherwise
     */
    public boolean canChoosePosition(int row, int col)
    {
        return theBoard[row][col].equals("-");
    }

    /**
     * Checks whether or not the game is over based on how many open spots there are.
     *
     * @param boardSize the size of the board
     * @return bool, true if every spot on the board is filled, false otherwise
     */
    public boolean isTheGameOver(int boardSize)
    {
        // checks the rows
        for (int row = 0; row < boardSize; row++) {
            // checks the columns
            for (int col = 0; col < boardSize; col++) {
                if (theBoard[row][col].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gets theBoard
     *
     * @return theBoard multidimensional array
     */
    public String[][] getTheBoard(){
        return theBoard;
    }

    /**
     * Because the linter told me to.
     *
     * @return The truth
     */
    @Override
    public String toString() {
        return "I wanted the error to go away.";
    }
}
