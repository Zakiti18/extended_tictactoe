package game;

import java.util.Random;

/**
 * extended_tictactoe/game/GameLoop.java
 * 09/29/2021
 * @author Phillip Ball
 * @version 1
 *
 * This class is used to interact with other classes that make up the game.
 */

public class GameLoop
{
    // fields
    private ConsoleManager consoleManager = new ConsoleManager();
    private BoardControl boardControl = new BoardControl();
    private Scoring scoring = new Scoring();

    // methods
    /**
     * Gets user input as to what menu option will be selected.
     */
    public void startGame()
    {
        boolean quit = false;
        while(!quit) {
            // case 1 is to see two computers finished game
            // case 2 is to play a match between 2 players
            // case 3 is to exit the program
            switch (consoleManager.menu()) {
                case 1:
                    watch();
                    break;
                case 2:
                    play();
                    break;
                case 3:
                    quit = true;
                    break;
            }
        }
    }

    /**
     * Has 2 computer players play a match and displays just the ending board state.
     */
    private void watch()
    {
        // board setup
        int boardSize = consoleManager.getBoardSize();
        boardControl.buildBoard(boardSize);
        String[][] theBoard = boardControl.getTheBoard();

        // turns
        while (true) {
            // computer o's turn
            computerTurn("o", boardSize);
            if (boardControl.isTheGameOver(boardSize)) {
                break;
            }

            // computer x's turn
            computerTurn("x", boardSize);
            if (boardControl.isTheGameOver(boardSize)) {
                break;
            }
        }

        // end of game
        int oPoints = scoring.getPoints(theBoard, boardSize, "o");
        int xPoints = scoring.getPoints(theBoard, boardSize, "x");
        consoleManager.printFinalState(theBoard, boardSize, oPoints, xPoints);
    }

    /**
     * has 2 players play against each other and display the state of the board after every turn.
     */
    private void play()
    {
        // board setup
        int boardSize = consoleManager.getBoardSize();
        boardControl.buildBoard(boardSize);
        String[][] theBoard = boardControl.getTheBoard();

        // Assign who goes first
        String player1;
        String player2;
        Random coin = new Random();
        if((coin.nextInt(2) % 2) == 0) {
            player1 = "o";
            player2 = "x";
        }
        else {
            player1 = "x";
            player2 = "o";
        }

        // turns
        while (true) {
            // player o's turn
            playerTurn(player1, boardSize);
            if (boardControl.isTheGameOver(boardSize)) {
                break;
            }

            // player x's turn
            playerTurn(player2, boardSize);
            if (boardControl.isTheGameOver(boardSize)) {
                break;
            }
        }

        // end of game
        int oPoints = scoring.getPoints(theBoard, boardSize, "o");
        int xPoints = scoring.getPoints(theBoard, boardSize, "x");
        consoleManager.printFinalState(theBoard, boardSize, oPoints, xPoints);
    }

    /**
     * This is the a method that functions as a single turn, getting positions from the user.
     *
     * @param player either x or o
     * @param boardSize the size of the board
     */
    private void playerTurn(String player, int boardSize)
    {
        // print the board
        consoleManager.printBoard(boardControl.getTheBoard(), boardSize);

        // inform user of who's turn it is
        System.out.println("Player " + player + " turn.");

        // get the position the player wishes to mark
        int row = consoleManager.pickRow(boardSize);
        int col = consoleManager.pickCol(boardSize);
        // disallow already marked position being selected
        while (!(boardControl.canChoosePosition(row, col))) {
            System.out.println("That position has already been chosen");
            row = consoleManager.pickRow(boardSize);
            col = consoleManager.pickCol(boardSize);
        }
        // mark that position
        boardControl.markPosition(row, col, player);
    }

    /**
     * This is the a method that functions as a single turn, getting random positions.
     *
     * @param computer either x or o
     * @param boardSize the size of the board
     */
    private void computerTurn(String computer, int boardSize)
    {
        // set up the Random object
        Random computerChoice = new Random();

        // get the random position to mark
        int row = computerChoice.nextInt(boardSize);
        int col = computerChoice.nextInt(boardSize);
        // disallow already marked position being selected
        while (!(boardControl.canChoosePosition(row, col))) {
            row = computerChoice.nextInt(boardSize);
            col = computerChoice.nextInt(boardSize);
        }
        // mark that position
        boardControl.markPosition(row, col, computer);
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
