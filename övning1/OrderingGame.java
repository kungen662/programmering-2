package progr2_exercise1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author chli
 */
public class OrderingGame {

    /**
     * @param args the command line arguments
     *
     * Implements an ordering game, where the player must place given random
     * numbers in order
     *
     * Pseudo code, version 1:
     *
     * 1. get number of positions of game board 2. get max random number used 3.
     * create game board 4. get a random number 5. get position from player 6 if
     * player position is available and not lost 6.1 place random number 7 else
     * 7.1 wrong, goto 5 8 if winning 8.1 congrats! 8.2 exit game 9 else if lost
     * 9.1 tough shit 9.2 exit game 10. goto 4
     *
     * Version 2 (bättre): 1. get number of positions of game board 2. get max
     * random number used 3. create game board 4. while not game over 4.1 get a
     * random number 4.2 get position from player 4.3 while position not
     * available 4.3.1 get new position from player 4.4 place number on
     * gameboard 5. if winning 5.1 print congrats! 6. else 6.1 print you lost,
     * hahahaha
     *
     */
    /*
     *   Convert an int array to String respresentation
     *   Input: array = the array to convert
     *   Output: the string representation of array
     */
    public static String convertIntArrayToString(int[] array) {
        String result = "";

        for (int index = 0; index < array.length; index++) {
            String addition = "_";
            if (array[index] != 0) {
                addition = "" + array[index];
            }
            result = result + " " + addition;
        }
        return result;
    }

    /*
     *   Check if an array is in order or not
     *   Input: array = the array to check
     *   Output: true if array in order, false otherwise
     */
    public static boolean order(int[] array) {
        boolean inOrder = true; //assume array is in order
        int biggestNumberSoFar = array[0];
        for (int index = 1; index < array.length; index++) {
            if (array[index] != 0) {
                if (biggestNumberSoFar > array[index]) {
                    inOrder = false;
                    break;
                } else {
                    biggestNumberSoFar = array[index];
                }
            }
        }
        return inOrder;
    }

    public static void main(String[] args) {
        int numberOfPositions = 0;
        int randomMax = 0;
        int[] test = {0, 2, 0, 6};
        JOptionPane.showMessageDialog(null, order(test));
        //read game data from player
        String numberOfPositionsS = JOptionPane.showInputDialog("Please enter the game board size");
        String randomMaxS = JOptionPane.showInputDialog("Please enter the highest random number used");
        //convert to int
        numberOfPositions = Integer.parseInt(numberOfPositionsS);
        randomMax = Integer.parseInt(randomMaxS);
        //create game board
        int[] gameBoard = new int[numberOfPositions];
        boolean gameOver = false;
        int numberOfRoundsPlayed = 0;
        Random randomGenerator = new Random();
        while (!gameOver) {
            int randomNumber = randomGenerator.nextInt(randomMax) + 1;
            String gameBoardS = convertIntArrayToString(gameBoard);
            String positionS = JOptionPane.showInputDialog("The random number is "
                    + randomNumber + "\nThe gameboard: " + gameBoardS + "\nPlease enter your chosen position (1-" + numberOfPositions + ")");
            int position = Integer.parseInt(positionS) - 1;
            while (gameBoard[position] > 0) {    //while chosen position taken, ask for a new position
                positionS = JOptionPane.showInputDialog("Sorry, the position is occupid!\nThe random number is "
                        + randomNumber + "\nThe gameboard: " + gameBoardS + "\nPlease enter your chosen position");
                position = Integer.parseInt(positionS) - 1;
            }
            gameBoard[position] = randomNumber;
            numberOfRoundsPlayed++;
            gameOver = (numberOfRoundsPlayed == numberOfPositions)|| !order(gameBoard);  //
        }
        if (order(gameBoard)) {
            JOptionPane.showMessageDialog(null, convertIntArrayToString(gameBoard) + "\nCongrats!!!");
        } else {
            JOptionPane.showMessageDialog(null, convertIntArrayToString(gameBoard) + "\nYou lose, hahahahsa!");
        }

    }
}
