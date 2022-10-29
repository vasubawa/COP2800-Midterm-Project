/* 
 * File name:	Calculator.java
 * Names:	Dhruv Sharma, Mohammed Khan, Hammad Uddin, and Emanuel Martins
 * Course:	COP 2800C at Valencia College 
 * Professor:	David Stendel
 * Description:	This program displays a calculator menu where a user chooses the option to input 
 * 		values and calculates the following using those values, addition, subtraction, 
 * 		multiplication, division, largest value, smallest value, average of values, and 
 * 		sign of each value.
 * 		Options		Description
 *
 * Date:  	10/22/22 
 */

// Packages
import java.util.Scanner;

// Start of class
public class Calculator {
	// Main method
	public static void main(String[] args) throws Exception {
		// Declared Variables
		String menuChoice;
		//char menuChoice = '\0';
		double divided = 0.0;
		double[] nums = new double[3];
		Scanner scnr = new Scanner(System.in);
		//boolean getNumbers = false;
		// Calculator
		do {
			// Input
			menuChoice = userInput(scnr); 
			/*
			 * Checks if the users choice is a valid option or not and checks if the user
			 * inputed numbers in the first run before choosing anything else
			 */
			if ((nums.length == 0) && !menuChoice.equals("N") && !menuChoice.equals("X")) {
				System.out.println("\nError: Please select option N from the menu first!\n");
			} else if (menuChoice.equals("X")) {
				break;
			} else if (menuChoice.equals("N") || menuChoice.equals("A") || menuChoice.equals("S")
					|| menuChoice.equals("M") || menuChoice.equals("D") || menuChoice.equals("V")
					|| menuChoice.equals("L") || menuChoice.equals("I") || menuChoice.equals("E")) {
				// Processes the users choice
				switch (menuChoice) {
					case "N":
						// Gets the users numbers and puts them in a array for further use
						nums = getUserNum(scnr);
						break;
					case "A":
						// Prints out all added numbers inside the array
						System.out.println("\nAnswer: " + signToPrint(nums, "+") + " = " + sumOfArray(nums));
						break;
					case "S":
						// Prints out all the numbers subtracted inside the array
						System.out.println("\nAnswer: " + signToPrint(nums, "-") + " = " 
							+ subtractFromArray(nums));
						break;
					case "M":
						// Prints out all the numbers multiplied inside the array
						System.out.println("\nAnswer: " + signToPrint(nums, "*") + " = "
							+ String.format("%.3f", multiplyArray(nums)));
						break;
					case "D":
						divided = divideArray(nums);
						/*
						 * Prints out all the numbers divided inside the array if number was not divided
						 * by zero
						 */
						
						if (divided == 3.1415926535) {
							System.out.println("\nError: Cannot divide by zero.");
						} else {
							System.out.println(
									"\nAnswer: " + signToPrint(nums, "/") + " = " + String.format("%.3f", divided));
						}
						break;
					case "V":
						// Prints out the average of all numbers inside the array
						System.out.println("\nAnswer: (" + signToPrint(nums, "+") + ") / " + nums.length + " = "
								+ String.format("%.3f", averageOfArray(nums)));
						break;
					case "L":
						// Prints out the largest number from the array
						System.out.println("\nThe largest number is " + largestFromArray(nums));
						break;
					case "I":
						// Calls the method which will print if the numbers in the array are positive or
						// negative
						System.out.println("\n" + signOfArray(nums));
						;
						break;
					case "E":
						// Prints out the smallest number from the array
						System.out.println("\nThe smallest number is " + smallestFromArray(nums));
						break;
					default:
						// Prints out an error if one of the cases didn't match
						System.out.println("Error: Invalid choice!");
				}
				/*
				 * Prints an error if the user didn't select one of the give options from the
				 * menu
				 */
			} else {
				System.out.println("\nError: Please pick one of the list options and try again.\n");
			}
			// Ends the loop if the user selects "x"
		} while (!menuChoice.equals("X"));
		// Prints good-bye message
		System.out.println("\nThank you for using Team 2's calculator! Good-bye!");
	}

	/// FOR TEAMMATES, REMEMBER TO PUT METHODS ALPHABETICALLY IN ORDER

	// This method will find the average of the elements in the array
	public static double averageOfArray(double[] nums) {
		// Declared variable
		double sum = 0;
		double average = 0;
		// Loops through nums and adds elements then divides by 3
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			average = sum / nums.length;
		}
		// Returns the value
		return average;
	}

	// This method will call divide all the numbers in the array
	public static double divideArray(double[] nums) {
		// Declare variables
		double totalDivide = 1;
		// Loops though num array and divides each number
		for (int i = 0; i < nums.length; i++) {
			if (nums[0] == 0) {
				return totalDivide = 0;
			} else if ((nums[i] == 0) && (nums[0] != 0)) {
				return totalDivide = 3.1415926535;
			} else {
				totalDivide /= nums[i];
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
	public static double largestFromArray(double[] nums) {
		// Declared needed varables
		double largestNum = 0;
		/*
		 * Loops through nums values and checks/updated largestNum if a number is
		 * greater than the stored value
		 */
		for (int i = 0; i < nums.length; i++)
			if (largestNum < nums[i]) {
				largestNum = nums[i];
			}
		// Returns the value
		return largestNum;
	}

	/*
	 * This method will take in the user inputed values and find the largest of
	 * them and return that.
	 */
	public static double multiplyArray(double[] nums) {
		// Declared needed varables
		double totalMulti = 1;
		// Loops through nums values and multiplies them
		for (int i = 0; i < nums.length; i++) {
			totalMulti *= nums[i];
		}
		// Returns the value
		return totalMulti;
	}

	// This method will find the sign of each number in the array
	public static double signOfArray(double[] nums) {
		// Declare variables
		double sign = 0;
		// Determines if each number in array is either positive or negative and prints
		// accordingly
		for (int i = 0; i < nums.length; i++)
			if (nums[i] >= 0) {
				System.out.println("The number in position " + nums[i] + " is positive. ");
			} else {
				System.out.println("The number in position " + nums[i] + " is negative.");
			}
		// Returns value
		return sign;
	}

	// This method will figure out what math sign needs to be added between numbers
	public static String signToPrint(double[] nums, String sign) {
		// Declared Variable
		String signForPrint = "";
		// Loops through all the numbers inside the array and add the corresponding
		// signs
		for (int i = 0; i < nums.length; i++) {
			signForPrint = signForPrint + nums[i] + " " + sign + " ";
		}
		// Removes the last extra sign added in the for-loop and prints the final answer
		signForPrint = signForPrint.substring(0, signForPrint.length() - 3);

		return signForPrint;
	}

	/*
	 * This method will take in the values user inputed and will multiply and return
	 * the result.
	 */
	public static double smallestFromArray(double[] nums) {
		// Declare a variable
		double smallestNum;
		// Loops thorugh nums and finds the smallest value in the array
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

	/*
	 * This method will take in the user inputted values and subtract to fund the
	 * final value and return it.
	 */
	public static double subtractFromArray(double[] nums) {
		// Declared needed varables
		double totalSubtract = 0;
		// Loops through nums values and subtracts them
		for (int i = 0; i < nums.length; i++) {
			totalSubtract -= nums[i];
		}
		// Returns the value
		return totalSubtract;
	}

	// This method finds the sum of elements in an array
	public static double sumOfArray(double[] nums) {
		// Declared variable
		double sum = 0;
		// Loops through nums and adds each element in array
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
		// Take in the users choice and uppercases the value incase it was lowercase
		menuChoice = scnr.nextLine();
		menuChoice = menuChoice.toUpperCase();
		// Returns the choice
		return menuChoice;
	}

}// Class ends here
