/* 
 * File name:	Calculator.java
 * Names:	Mohammed Khan, Emanuel Martins, Dhruv Sharma, and Hammad Uddin 
 * Course:	COP 2800C at Valencia College 
 * Professor:	David Stendel
 * Description:	This program displays a menu to the user with the following options: 
 *      	Option			Description 
 *      	Get Numbers		Ask the user for several numbers. 
 *      	Add Numbers		Adds the numbers entered by the user. 
 * 		Subtract Numbers	Subtracts the numbers entered by the user.
 *		Multiply Numbers	Multiplies the numbers entered by the user.
 *		Divide Numbers		Divides the numbers entered by the user.
 *		Average of Numbers	Finds the average of the numbers entered by the user.
 *		Largest of Numbers	Finds the largest of the numbers entered by the user.
 *		Smallest of Numbers	Finds the smallest of the numbers entered by the user.
 *		Sign of Numbers		Finds the average of the numbers entered by the user.
 * 		
 *		The program also displays the following errors: 
 *		When N is not input first:	Error: Please select option N from the menu first!
 *		When invalid input is entered:	Error: Invalid choice!
 *		When zero is input as number:	Error: Cannot divide by zero!
 *		
 *		The program also displays an exit message:
 *		Thank you for using Team 2's calculator! Good-bye!
 *
 * Date:  	10/21/22 
 */

// Packages.
import java.util.Scanner;

/**
 * This program displays a menu with several different math problems to
 * choose/solve.
 * 
 * @author Dhruv Sharma
 * @author Emanuel Martins
 * @author Hammad Uddin
 * @author Mohammed Khan
 * 
 * @version 4.5, 11/3/22
 */

public class Calculator {
    /**
     * This method is where all the main calculator program is ran from which has
     * various capabilities to do any of the calculations from one of the sleected
     * option in the menu.
     *
     * @param args A String array containing any command line options.
     */
    public static void main(String[] args) throws Exception {
        // Declared Variables.
        char menuChoice = '\n';
        double[] nums = new double[3];
        Scanner scnr = new Scanner(System.in);
        boolean numbersEntered = false;

        // A loop that will keep the program running as long as "X" isn't entered
        do {
            // Gets the users Input from the menu.
            menuChoice = userInput(scnr).charAt(0);

            if (menuChoice != 'N' && numbersEntered == false) {
                System.out.println("\n\tError: Please select option N from the menu first!");
            } else {
                nums = processChoice(menuChoice, scnr, nums);
                numbersEntered = processChoice(menuChoice, numbersEntered);
            }
            // Stops the loop if "X" is entered.
        } while (menuChoice != 'X');
        // Prints good-bye message.
        System.out.println("\nThank you for using Team 2's calculator! Good-bye!");
    }

    /**
     * Finds the average of all the numbers.
     * 
     * @param nums An array of numbers.
     * @return average Returns the average of numbers.
     */
    public static double averageNum(double[] nums) {
        // Declared variable.
        double sum = 0;
        double average = 0;
        // Loops through numArray and adds elements then divides by 3.
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            average = sum / nums.length;
        }
        // Returns the value
        return average;
    }

    /**
     * Checks if theres a zero or not after the first number.
     * 
     * @param nums An array of numbers.
     * @return zero Returns true if zero exists, otherwise returns false.
     */
    public static boolean checkZeros(double[] nums) {
        boolean zero = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero = true;
                break;
            }
        }
        return zero;
    }

    /**
     * Finds the difference of all the numbers inside the array.
     * 
     * @param nums An array of numbers.
     * @return totalSubtract Returns the difference of all the numbers.
     */
    public static double differenceNum(double[] nums) {
        // Declared needed varables
        double totalSubtract = nums[0];
        // Loops through numArray values and subtracts them.
        for (int i = 1; i < nums.length; i++) {
            totalSubtract -= nums[i];
        }
        // Returns the value
        return totalSubtract;
    }

    /**
     * Get the users numbers and put it inside an array.
     * 
     * @return threeNumArray Returns the numbers entered by the user.
     */
    public static double[] getUserNum(Scanner scnr) {
        // Asks the user to input x amount of values
        System.out.print("\nEnter 3 numbers separated with spaces: ");
        /*
         * Takes in the users inputed value and takes out the spaces in between and
         * throwes it inside a string array.
         */
        String input = scnr.nextLine();
        String[] strNumber = input.split(" ");
        // Declared new double array and take in the length of previous string array.
        double[] threeNumArray = new double[strNumber.length];
        // Loops through the users input and converts it into double.
        for (int i = 0; i < threeNumArray.length; i++) {
            threeNumArray[i] += Double.parseDouble(strNumber[i]);
        }

        // Returns the value.
        return threeNumArray;
    }

    /**
     * Finds the difference of all the numbers inside the array.
     * 
     * @param nums An array of numbers.
     * @return largestNum Returns the largest of all the numbers.
     */
    public static double largestNum(double[] nums) {
        // Declared needed varables
        double largestNum = 0;
        /*
         * Loops through numArray values and checks/updated largestNum if a number is
         * greater than the stored value.
         */
        for (int i = 0; i < nums.length; i++)
            if (largestNum < nums[i]) {
                largestNum = nums[i];
            }
        // Returns the value
        return largestNum;
    }

    /**
     * Finds the difference of all the numbers inside the array.
     * 
     * @param answer Afinal answer of the number.
     * @param c      users character input.
     */
    public static void largestOrSmallestNum(double answer, char c) {
        // Prints out the answer depending on the choice.
        if (c == 'L') {
            System.out.println("\nThe largest number is: " + String.format("%.3f", answer));
        } else {
            System.out.println("\nThe smallest number is: " + String.format("%.3f", answer));
        }
    }

    /**
     * Figures out whether the number is positive or negative and prints it out.
     * 
     * @param nums An array of numbers.
     */
    public static void numSign(double[] nums) {
        // Determines if each number in array is either positive or negative and prints
        // accordingly.
        System.out.println("");
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= 0) {
                System.out.println("The number in position " + nums[i] + " is positive. ");
            } else {
                System.out.println("The number in position " + nums[i] + " is negative.");
            }
    }

    /**
     * Prints out the result of Addition, Subtraction, Multiplcation, Division, and
     * Average.
     * 
     * @param nums       An array of numbers.
     * @param sign       Sign of the operation (+, -, etc.).
     * @param answer     Final answer of the equation.
     * @param menuChoice Users entered menu choice.
     * @param zeros      Returns true or false if it detect any zeros in the array.
     */
    public static void printCommonAnswer(double[] nums, String sign, double answer, char menuChoice, boolean zeros) {
        // Depending on the users menu choice, prints out the answer accordly.
        switch (menuChoice) {
            // If a(V)erage was choosen, this is the format its printed in.
            case 'V':
                System.out.print("\nAnswer: (" + String.format("%.3f", nums[0]));
                for (int i = 1; i < nums.length; i++) {
                    System.out.print(" " + sign + " " + String.format("%.3f", nums[i]));
                }
                System.out.print(") / " + nums.length + " = " + String.format("%.3f", answer)
                        + "\n");
                break;
            // Default format for rest of the 4 operations.
            default:
                if (menuChoice == 'D' && zeros == true) {
                    System.out.println("\n\tError: Cannot divide by zero!");
                } else {
                    System.out.print("\nAnswer: " + String.format("%.3f", nums[0]));
                    for (int i = 1; i < nums.length; i++) {
                        System.out.print(" " + sign + " " + String.format("%.3f", nums[i]));
                    }
                    System.out.println(" = " + String.format("%.3f", answer));
                }
        }
    }

    /**
     * Finds the difference of all the numbers inside the array.
     * 
     * @param menuChoice Users choice from the menu
     * @param nums       An array of numbers.
     * @return nums Returns users inputed numbers.
     */
    public static double[] processChoice(char menuChoice, Scanner scnr, double[] nums) {
        // Declared varables.
        double answer = 0.0;
        boolean zeros = false;
        // Processes the users choice.
        switch (menuChoice) {
            case 'N':
                nums = getUserNum(scnr);
                break;

            case 'A':
                answer = sumNum(nums);
                printCommonAnswer(nums, "+", answer, menuChoice, zeros);
                break;

            case 'S':
                answer = differenceNum(nums);
                printCommonAnswer(nums, "-", answer, menuChoice, zeros);
                break;

            case 'M':
                answer = productNum(nums);
                printCommonAnswer(nums, "*", answer, menuChoice, zeros);
                break;

            case 'D':
                zeros = checkZeros(nums);
                answer = quotientNum(nums);
                printCommonAnswer(nums, "/", answer, menuChoice, zeros);
                break;

            case 'V':
                answer = averageNum(nums);
                printCommonAnswer(nums, "+", answer, menuChoice, zeros);
                break;

            case 'L':
                largestOrSmallestNum(largestNum(nums), 'L');
                break;

            case 'E':
                largestOrSmallestNum(smallestNum(nums), 'E');
                break;

            case 'I':
                numSign(nums);
                break;

            case 'X':
                break;

            default:
                // Prints out an error if one of the cases didn't match
                System.out.println("\n\tError: Invalid choice!");
        }
        // Returns the inputted numbers.
        return nums;
    }

    /**
     * Finds the difference of all the numbers inside the array.
     * 
     * @param menuChoice     Users selection from the menu.
     * @param numbersEntered Boolean value with false stance.
     * @return numbersEntered Returns if numbers were entered true or false..
     */
    public static boolean processChoice(char menuChoice, boolean numbersEntered) {
        switch (menuChoice) {
            case 'N':
                numbersEntered = true;
                break;
        }
        // Returns true or false.
        return numbersEntered;
    }

    /**
     * This will take in users numbers and multiply them.
     * 
     * @param nums An array of numbers.
     * @return totalMulti Returns the multiplication of all the numbers.
     */
    public static double productNum(double[] nums) {
        // Declared needed varables
        double totalMulti = 1;
        // Loops through numArray values and multiplies them
        for (int i = 0; i < nums.length; i++) {
            totalMulti *= nums[i];
        }
        // Returns the value
        return totalMulti;
    }

    /**
     * This will take in users numbers and divides them.
     * 
     * @param nums An array of numbers.
     * @return totalDivide Returns the division of all the numbers.
     */
    public static double quotientNum(double[] nums) {
        // Declare variables
        double totalDivide = nums[0];
        // Loops though num array and divides each number
        for (int i = 1; i < nums.length; i++) {
            if (nums[0] == 0) {
                totalDivide = 0;
            } else {
                totalDivide = totalDivide / nums[i];
            }
        }
        // Returns the value
        return totalDivide;
    }

    /**
     * This will take in users numbers and find the smallest of them.
     * 
     * @param nums An array of numbers.
     * @return nums[0] Returns the smallest number in index zero.
     */
    public static double smallestNum(double[] nums) {
        // Declare a variable
        double smallestNum;
        // Loops thorugh numArray and finds the smallest value in the array
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    smallestNum = nums[i];
                    nums[i] = nums[j];
                    nums[j] = smallestNum;
                }
            }
        }
        // Returns value
        return nums[0];
    }

    /**
     * This will take in users numbers and find the sum of them.
     * 
     * @param nums An array of numbers.
     * @return sum Returns the sum of all the numbers.
     */
    public static double sumNum(double[] nums) {
        // Declared variable
        double sum = 0;
        // Loops through numArray and adds each element in array
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        // Returns the value
        return sum;
    }

    /**
     * Prints out the menu for the user to select from.
     * 
     * @return menuChoice Returns whatever the user has inputted.
     */
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
        menuChoice = menuChoice.toUpperCase();
        // Returns the choice
        return menuChoice;
    }

}
