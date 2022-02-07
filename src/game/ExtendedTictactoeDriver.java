package game;

/**
 * extended_tictactoe/game/ExtendedTictactoeDriver.java
 * 09/29/2021
 * @author Phillip Ball
 * @version 1
 *
 * This is the driver class.
 */

public class ExtendedTictactoeDriver
{
    // methods
    /**
     * Loads my program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        GameLoop gameLoop = new GameLoop();
        gameLoop.startGame();

        /*
        Don't worry about it

        String[][] testBoard = {
        {"x", "o", "x", "x", "x", "o"},
        {"o", "o", "o", "x", "o", "x"},
        {"o", "o", "o", "x", "x", "o"},
        {"x", "x", "x", "o", "o", "x"},
        {"o", "o", "o", "x", "x", "o"},
        {"o", "x", "o", "x", "x", "x"}};
        Scoring testScoring = new Scoring();
        ConsoleManager testConsoleManager = new ConsoleManager();
        int oPoints = testScoring.getPoints(testBoard, 6, "o");
        int xPoints = testScoring.getPoints(testBoard, 6, "x");
        testConsoleManager.printFinalState(testBoard, 6, oPoints, xPoints);
        */
    }
}
