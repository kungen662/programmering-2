/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package övning1;

/**
 *
 * @author Jonathan
 */
public class Rulse {
    String arryG="";   
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
            arrayG = arrayG + " " + addition;
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
    
}
