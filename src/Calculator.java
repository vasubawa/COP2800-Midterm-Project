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

// Start of class.
public class Calculator {
	/**
	 * This method contains the entire program.
	 *
	 *@param number An array of any numbers, sum, subtraction, product, quotient, 
	 *average, and sign of array values. 
	 */
    // Main method
    public static void main(String[] args) throws Exception {
        // Declared Variables
        char menuChoice = '\n';
        double[] nums = new double[3];
        Scanner scnr = new Scanner(System.in);
        boolean numbersEntered = false;
        // Method Loops for User Choice.
        System.out.println(numbersEntered);
        do {
            // Gets the users Input from the menu
            menuChoice = userInput(scnr).charAt(0);
            if (menuChoice != 'N' && numbersEntered == false){
                System.out.println("\n\tError: Please select option N from the menu first!");
            } else{
                nums = processChoice(menuChoice, scnr, nums);
                numbersEntered = processChoice(menuChoice, numbersEntered);
            }
            
        } while (menuChoice != 'X');
        // Prints good-bye message
        System.out.println("\nThank you for using Team 2's calculator! Good-bye!");
    }

    /// FOR TEAMMATES, REMEMBER TO PUT METHODS ALPHABETICALLY IN ORDER
    // This method will find the average of the elements in the array
    public static double averageNum(double[] nums) {
        // Declared variable
        double sum = 0;
        double average = 0;
        // Loops through numArray and adds elements then divides by 3
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            average = sum / nums.length;
        }
        // Returns the value
        return average;
    }

    /*
     * This method will take in the user inputted values and subtract to fund the
     * final value and return it.
     */
    public static double differenceNum(double[] nums) {
        // Declared needed varables
        double totalSubtract = nums[0];
        // Loops through numArray values and subtracts them
        for (int i = 1; i < nums.length; i++) {
            totalSubtract -= nums[i];
        }
        // Returns the value
        return totalSubtract;
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
    public static double largestNum(double[] nums) {
        // Declared needed varables
        double largestNum = 0;
        /*
         * Loops through numArray values and checks/updated largestNum if a number is
         * greater than the stored value
         */
        for (int i = 0; i < nums.length; i++)
            if (largestNum < nums[i]) {
                largestNum = nums[i];
            }
        // Returns the value
        return largestNum;
    }

    public static void largestOrSmallestNum(double answer, char c) {
        if(c == 'L'){
            System.out.println("\nThe largest number is: " + String.format("%.3f",answer));
        }else{
            System.out.println("\nThe smallest number is: " + String.format("%.3f",answer));
        }
    }

    // This method will find the sign of each number in the array
    public static double numSign(double[] nums) {
        // Declare variables
        double sign = 0;
        // Determines if each number in array is either positive or negative and prints
        // accordingly
        System.out.println("");
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= 0) {
                System.out.println("The number in position " + nums[i] + " is positive. ");
            } else {
                System.out.println("The number in position " + nums[i] + " is negative.");
            }
        // Returns value
        return sign;
    }
    
    public static void printCommonAnswer(double[] nums, String sign, double answer, char menuChoice) {
        
        switch(menuChoice){
            case 'V':
                System.out.print("\nAnswer: (" + String.format("%.3f",nums[0]));
                for(int i = 1; i < nums.length; i++){
                    System.out.print(" " + sign + " " + String.format("%.3f",nums[i]));
                }
                System.out.print(") / " + nums.length + " = " + String.format("%.3f",answer) 
                    + "\n");
                break;

            default:
                System.out.print("\nAnswer: " + String.format("%.3f",nums[0]));
                for(int i = 1; i < nums.length; i++){
                    System.out.print(" " + sign + " " + String.format("%.3f",nums[i]));
                }
                System.out.println(" = " + String.format("%.3f",answer) + "\n");
        }
    }

    public static double[] processChoice(char menuChoice, Scanner scnr, double[] nums){
        double answer = 0.0;
        switch (menuChoice) {
            case 'N':
                nums = getUserNum(scnr);
                break;

            case 'A':
                answer = sumNum(nums);
                printCommonAnswer(nums ,"+", answer, menuChoice);  
                break;

            case 'S':
                answer = differenceNum(nums);
                printCommonAnswer(nums ,"-", answer, menuChoice);
                break;

            case 'M':
                answer = productNum(nums);
                printCommonAnswer(nums ,"*", answer, menuChoice);  
                break;

            case 'D':
                answer = quotientNum(nums);
                printCommonAnswer(nums ,"/", answer, menuChoice);
                break;

            case 'V':
                answer = averageNum(nums);
                printCommonAnswer(nums ,"+", answer, menuChoice);
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
        return nums;
    }

    public static boolean processChoice(char menuChoice, boolean numbersEntered){
        switch (menuChoice) {
            case 'N':
                numbersEntered = true;
                break;
        }
        return numbersEntered;
    }

    /*
     * This method will take in the user inputed values and find the largest of
     * them and return that.
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

    //THIS NEEDS FIXING 2.7 -3 5.2946 DOES NOT GIVE -0.170 
    // This method will call divide all the numbers in the array
    public static double quotientNum(double[] nums) {;
        // Declare variables
        double totalDivide = 1;
        // Loops though num array and divides each number
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] == 0) {
                totalDivide = 0;
            } else {
                totalDivide /= nums[i];
            }
        }
        // Returns the value
        return totalDivide;
    }

    /*
     * This method will take in the values user inputed and will multiply and return
     * the result.
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

    // This method finds the sum of elements in an array
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
        menuChoice = menuChoice.toUpperCase();
        // Returns the choice
        return menuChoice;
    }

}
