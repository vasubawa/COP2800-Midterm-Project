/* 
 * File name: MPa - Midterm Project - Calculator
 * Names:  Dhruv Sharma, Mohammed Khan, Hammad Uddin, Emanuel Martins
 * Course:   COP 2800C at Valencia College 
 * Professor: David Stendel
 * Description: This program displays a calculator menu where a user chooses the option to input values and calculates
 * the following using those values, addition, subtraction, multiplication, division, largest value, smallest value, 
 * average of values, and sign of each value
 * Date:  10/22/2022 
 */

// Packages
import java.util.Scanner;

// Start of class
public class testing {
    // Main method
    public static void main(String[] args) throws Exception {
        // Declared Variables
        char menuChoice = '\n';
        double[] nums = new double[3];
        Scanner scnr = new Scanner(System.in);
        boolean getNumbers = false;
        // Method Loops for User Choice.
        do {
            // Gets the users Input from the menu
            menuChoice = userInput(scnr).charAt(0);
            nums = processChoice(menuChoice, scnr, nums);
        } while (menuChoice != 'X');
        // Prints good-bye message
        System.out.println("\nThank you for using Team 2's calculator! Good-bye!");
    }

    /// FOR TEAMMATES, REMEMBER TO PUT METHODS ALPHABETICALLY IN ORDER

    public static double[] processChoice(char menuChoice, Scanner scnr, double[] nums){
        double[] numsArr = nums;
        switch (menuChoice) {
            case 'N':
                numsArr = getUserNum(scnr);
                System.out.println("Inside N case currently");
                break;

            case 'A':
                System.out.println("Inside A case currently");
                break;

            case 'S':
                System.out.println("\nAnswer: " + signToPrint(numsArr, "-") + " = " 
                + subtractFromArray(numsArr));
                System.out.println("Inside S case currently");
                break;

            case 'M':
                System.out.println("Inside M case currently");
                break;

            case 'D':
                System.out.println("Inside D case currently");
                break;

            case 'V':
                System.out.println("Inside V case currently");
                break;

            case 'L':
                System.out.println("Inside L case currently");
                break;

            case 'E':
                System.out.println("Inside E case currently");
                break;

            case 'I':
                System.out.println("Inside I case currently");
                break;

            default:
                // Prints out an error if one of the cases didn't match
                System.out.println("Error: Invalid choice!");
        }
        return numsArr;
    }

    // This method will find the average of the elements in the array
    public static double averageOfArray(double[] numArray) {
        // Declared variable
        double sum = 0;
        double average = 0;
        // Loops through numArray and adds elements then divides by 3
        for (int i = 0; i < numArray.length; i++) {
            sum = sum + numArray[i];
            average = sum / numArray.length;
        }
        // Returns the value
        return average;
    }

    // This method will call divide all the numbers in the array
    public static double divideArray(double[] numArray) {
        // Declare variables
        double totalDivide = 1;
        // Loops though num array and divides each number
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[0] == 0) {
                return totalDivide = 0;
            } else if ((numArray[i] == 0) && (numArray[0] != 0)) {
                return totalDivide = 3.1415926535;
            } else {
                totalDivide /= numArray[i];
            }
        }
        // Returns the value
        return totalDivide;
    }

    // This method will ask the user to enter any amount of numbers they want
    public static double[] getUserNum(Scanner scnr) {
        // Asks the user to input x amount of values
        System.out.print("\nEnter 3 numbers separated with spaces: ");
        /*
         * Takes in the users inputed value and takes out the spaces in between and
         * throwes it inside a string array
         */
        String input = scnr.nextLine();
        String[] strNumber = input.split(" ");
        // Declared new double array and take in the length of previous string array
        double[] threeNumArray = new double[strNumber.length];
        // Loops through the users input and converts it into double
        for (int i = 0; i < threeNumArray.length; i++) {
            threeNumArray[i] += Double.parseDouble(strNumber[i]);
        }
        // Returns the value
        return threeNumArray;
    }

    /*
     * This method will take in the user inputted values and find the largest of
     * them and return that.
     */
    public static double largestFromArray(double[] numArray) {
        // Declared needed varables
        double largestNum = 0;
        /*
         * Loops through numArray values and checks/updated largestNum if a number is
         * greater than the stored value
         */
        for (int i = 0; i < numArray.length; i++)
            if (largestNum < numArray[i]) {
                largestNum = numArray[i];
            }
        // Returns the value
        return largestNum;
    }

    /*
     * This method will take in the user inputed values and find the largest of
     * them and return that.
     */
    public static double multiplyArray(double[] numArray) {
        // Declared needed varables
        double totalMulti = 1;
        // Loops through numArray values and multiplies them
        for (int i = 0; i < numArray.length; i++) {
            totalMulti *= numArray[i];
        }
        // Returns the value
        return totalMulti;
    }

    // This method will find the sign of each number in the array
    public static double signOfArray(double[] numsArr) {
        // Declare variables
        double sign = 0;
        // Determines if each number in array is either positive or negative and prints
        // accordingly
        for (int i = 0; i < numsArr.length; i++)
            if (numsArr[i] >= 0) {
                System.out.println("The number in position " + numsArr[i] + " is positive. ");
            } else {
                System.out.println("The number in position " + numsArr[i] + " is negative.");
            }
        // Returns value
        return sign;
    }

    // This method will figure out what math sign needs to be added between numbers
    public static String signToPrint(double[] numsArr, String sign) {
        // Declared Variable
        String signForPrint = "";
        // Loops through all the numbers inside the array and add the corresponding
        // signs
        for (int i = 0; i < numsArr.length; i++) {
            signForPrint = signForPrint + numsArr[i] + " " + sign + " ";
        }
        // Removes the last extra sign added in the for-loop and prints the final answer
        signForPrint = signForPrint.substring(0, signForPrint.length() - 3);

        return signForPrint;
    }

    /*
     * This method will take in the values user inputed and will multiply and return
     * the result.
     */
    public static double smallestFromArray(double[] numArray) {
        // Declare a variable
        double smallestNum;
        // Loops thorugh numArray and finds the smallest value in the array
        for (int i = 0; i < numArray.length; i++) {
            for (int j = i; j < numArray.length; j++) {
                if (numArray[i] > numArray[j]) {
                    smallestNum = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = smallestNum;
                }
            }
        }
        // Returns value
        return numArray[0];
    }

    /*
     * This method will take in the user inputted values and subtract to fund the
     * final value and return it.
     */
    public static double subtractFromArray(double[] numsArr) {
        // Declared needed varables
        double totalSubtract = 0;
        // Loops through numArray values and subtracts them
        for (int i = 0; i < numsArr.length; i++) {
            totalSubtract -= numsArr[i];
        }
        // Returns the value
        return totalSubtract;
    }

    // This method finds the sum of elements in an array
    public static double sumOfArray(double[] numArray) {
        // Declared variable
        double sum = 0;
        // Loops through numArray and adds each element in array
        for (int i = 0; i < numArray.length; i++) {
            sum = sum + numArray[i];
        }
        // Returns the value
        return sum;
    }

    // Prints the calculator menu and gets the users choice
    public static String userInput(Scanner scnr) {
        // Declaring String Variable;
        String menuChoice;
        // Menu options for user to choose.
        System.out.println("\nCalculator Menu\n");
        System.out.println("Get 3 (N)umbers.");
        System.out.println("(A)dd the numbers.");
        System.out.println("(S)ubtract the numbers.");
        System.out.println("(M)ultiply the numbers.");
        System.out.println("(D)ivide the numbers.");
        System.out.println("A(V)erage the numbers.");
        System.out.println("Determine the (L)argest number.");
        System.out.println("Determine the small(E)st number.");
        System.out.println("Determine the s(I)gn of each number.");
        System.out.println("E(X)it.\n");
        System.out.print("Choice: ");

        menuChoice = scnr.nextLine();
        // Returns the choice
        return menuChoice;
    }

}// Class ends here