package game;

import java.util.Scanner;

/**
 * extended_tictactoe/game/ConsoleManager.java
 * 09/29/2021
 * @author Phillip Ball
 * @version 1
 *
 * This class contains all logic related to the console and interaction with the player.
 */

public class ConsoleManager
{
    // fields
    private Scanner keyboard = new Scanner(System.in);

    // methods
    /**
     * This method acquires input from the user to select a menu option.
     *
     * @return int, option chosen
     */
    public int menu()
    {
        // intro and menu options
        System.out.println("1. Watch a randomized match\n" +
                "2. Play a match\n" +
                "3. Exit program\n" +
                "Please enter the number of one of the above options");

        // get the user input
        int input = keyboard.nextInt();
        while (input > 3 || input < 1) {
            System.out.println("You may only choose one of the three options");
            input = keyboard.nextInt();
        }

        return input;
    }

    /**
     * This method acquires input from the user to use as a size for the board.
     *
     * @return int, size given
     */
    public int getBoardSize()
    {
        System.out.print("Please enter the dimensions of the board (3+): ");

        // get user input
        int input = keyboard.nextInt();
        while (input < 3) {
            System.out.println("The dimensions must be 3 or higher");
            input = keyboard.nextInt();
        }

        return input;
    }

    /**
     * Prints the current state of the board
     *
     * @param theBoard current board
     * @param boardSize dimension given for the board
     */
    public void printBoard(String[][] theBoard, int boardSize){
        // loop through the rows
        for (int row = 0; row < boardSize; row++) {
            // loop through the columns
            for (int col = 0; col < boardSize; col++) {
                // print the one piece of the board at a time
                System.out.print(theBoard[row][col] + " ");
            }
            // move to the next line each row
            System.out.println();
        }
    }

    /**
     * Gets user input for what row they would like to mark
     *
     * @param boardSize The board size
     * @return int, the row number that the user chose
     */
    public int pickRow(int boardSize)
    {
        System.out.print("Please enter your chosen row: ");

        // get user input
        int row = keyboard.nextInt();
        while (row < 0 || row >= boardSize) {
            System.out.println("You must select an actual row");
            row = keyboard.nextInt();
        }

        return row;
    }

    /**
     * Gets user input for what column they would like to mark
     *
     * @param boardSize The board size
     * @return int, the column number that the user chose
     */
    public int pickCol(int boardSize)
    {
        System.out.print("Please enter your chosen column: ");

        // get user input
        int col = keyboard.nextInt();
        while (col < 0 || col >= boardSize) {
            System.out.println("You must select an actual column");
            col = keyboard.nextInt();
        }

        return col;
    }

    /**
     * Prints the final state of the board as well as
     * displays each player's points and the outcome of the match.
     *
     * @param theBoard The board multidimensional array
     * @param boardSize The size of the board
     * @param oPoints Os points
     * @param xPoints Xs points
     */
    public void printFinalState(String[][] theBoard, int boardSize, int oPoints, int xPoints)
    {
        // print the board
        System.out.println("\nFinal Board\n" +
                "***************");
        printBoard(theBoard, boardSize);
        System.out.println("***************\n");

        // print the players points
        System.out.println("Player o points: " + oPoints);
        System.out.println("Player x points: " + xPoints);

        // print how the game ended
        if (oPoints > xPoints) {
            System.out.println("Player o wins!");
        }
        else if (oPoints < xPoints) {
            System.out.println("Player x wins!");
        }
        else {
            System.out.println("Game is a tie!");
        }
        System.out.println();
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
