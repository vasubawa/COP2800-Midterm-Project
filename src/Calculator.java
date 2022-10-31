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
	public static void main(String[] args) throws Exception {
		// Variables
		String menuChoice;
		//char menuChoice = '\0';
		double divided = 0.0;
		double[] nums = new double[3];
		Scanner scnr = new Scanner(System.in);
		//boolean getNumbers = false;
		// Calculator.
		do {
			// Input.
			menuChoice = userInput(scnr); 
			/*
			 * Check if the users choice is a valid option or not and checks if the user
			 * input numbers in the first run before choosing anything else.
			 */
			if ((nums.length == 0) && !menuChoice.equals("N") && !menuChoice.equals("X")) {
				System.out.println("\nError: Please select option N from the menu first!\n");
			} else if (menuChoice.equals("X")) {
				break;
			} else if (menuChoice.equals("N") || menuChoice.equals("A") || menuChoice.equals("S")
					|| menuChoice.equals("M") || menuChoice.equals("D") || menuChoice.equals("V")
					|| menuChoice.equals("L") || menuChoice.equals("I") || menuChoice.equals("E")) {
				// Process the users choice.
				switch (menuChoice) {
					case "N":
						// Get the users numbers and puts them in a array for further use.
						nums = getUserNum(scnr);
						break;
					case "A":
						// Print out all added numbers inside the array.
						System.out.println("\nAnswer: " + signToPrint(nums, "+") + " = " + sumOfArray(nums));
						break;
					case "S":
						// Print out all the numbers subtracted inside the array.
						System.out.println("\nAnswer: " + signToPrint(nums, "-") + " = " 
							+ subtractFromArray(nums));
						break;
					case "M":
						// Print out all the numbers multiplied inside the array.
						System.out.println("\nAnswer: " + signToPrint(nums, "*") + " = "
							+ String.format("%.3f", multiplyArray(nums)));
						break;
					case "D":
						divided = divideArray(nums);
						/*
						 * Print out all the numbers divided inside the array if number was not divided
						 * by zero.
						 */
						
						if (divided == 3.1415926535) {
							System.out.println("\nError: Cannot divide by zero.");
						} else {
							System.out.println(
									"\nAnswer: " + signToPrint(nums, "/") + " = " + String.format("%.3f", divided));
						}
						break;
					case "V":
						// Print out the average of all numbers inside the array.
						System.out.println("\nAnswer: (" + signToPrint(nums, "+") + ") / " + nums.length + " = "
								+ String.format("%.3f", averageOfArray(nums)));
						break;
					case "L":
						// Print out the largest number from the array.
						System.out.println("\nThe largest number is " + largestFromArray(nums));
						break;
					case "I":
						// Call the method which will print if the numbers in the array are positive or
						// negative.
						System.out.println("\n" + signOfArray(nums));
						;
						break;
					case "E":
						// Print out the smallest number from the array.
						System.out.println("\nThe smallest number is " + smallestFromArray(nums));
						break;
					default:
						// Print out an error if one of the cases didn't match.
						System.out.println("Error: Invalid choice!");
				}
				/*
				 * Print an error if the user didn't select one of the give options from the
				 * menu.
				 */
			} else {
				System.out.println("\nError: Please pick one of the list options and try again.\n");
			}
			// End the loop if the user selects "x".
		} while (!menuChoice.equals("X"));
		// Exit message.
		System.out.println("\nThank you for using Team 2's calculator! Good-bye!");
	}

	/// FOR TEAMMATES, REMEMBER TO PUT METHODS ALPHABETICALLY IN ORDER

	/**
	 *This method will find the average of the elements in the array.
	 *
	 *@param numbers An array of any numbers, sum, average of array values.
	 *@return The average of the array values.
	 */
	public static double averageOfArray(double[] nums) {
		// Variables
		double sum = 0;
		double average = 0;
		// Loop through nums and adds elements then divides by array length.
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			average = sum / nums.length;
		}
		// Return the value.
		return average;
	}

	/* This method will call divide all the numbers in the array.
	 *
	 *@param numbers An array if any numbers, quotient of numbers in the array.
	 *@return The quotient of the array values.
	 */
	public static double divideArray(double[] nums) {
		// Variables.
		double totalDivide = 1;
		// Loop though num array and divides each number.
		for (int i = 0; i < nums.length; i++) {
			if (nums[0] == 0) {
				return totalDivide = 0;
			} else if ((nums[i] == 0) && (nums[0] != 0)) {
				return totalDivide = 3.1415926535;
			} else {
				totalDivide /= nums[i];
			}
		}
		// Return the value.
		return totalDivide;
	}

	/* This method will ask the user to enter any amount of numbers they want.
	 *
	 *@param numbers An array of numbers.
	 *@return An array of numbers.
	 */
	public static double[] getUserNum(Scanner scnr) {
		// Ask the user to input x amount of values.
		System.out.print("\nEnter 3 numbers separated with spaces: ");
		/*
		 * Take in the users inputed value and takes out the spaces in between and
		 * throwes it inside a string array.
		 */
		String input = scnr.nextLine();
		String[] strNumber = input.split(" ");
		// Declare new double array and take in the length of previous string array.
		double[] threeNumArray = new double[strNumber.length];
		// Loop through the users input and converts it into double.
		for (int i = 0; i < threeNumArray.length; i++) {
			threeNumArray[i] += Double.parseDouble(strNumber[i]);
		}
		// Returns the value.
		return threeNumArray;
	}

	/*
	 * This method will take in the user inputted values and find the largest of
	 * them and return that.
	 *
	 *@param number An array of numbers.
	 *@return Largest value of numbers in the array.
	 */
	public static double largestFromArray(double[] nums) {
		// Variables.
		double largestNum = 0;
		/*
		 * Loop through nums values and checks/updated largestNum if a number is
		 * greater than the stored value.
		 */
		for (int i = 0; i < nums.length; i++)
			if (largestNum < nums[i]) {
				largestNum = nums[i];
			}
		// Return the value.
		return largestNum;
	}

	/*
	 * This method will take in the user inputed values and calculate the quotient.
	 * 
	 *@param numbers An array of numbers, quotient of the numbers in the array.
	 *@return Quotient of the numbers in the array.
	 */
	public static double multiplyArray(double[] nums) {
		// Variables.
		double totalMulti = 1;
		// Loop through nums values and multiplies them.
		for (int i = 0; i < nums.length; i++) {
			totalMulti *= nums[i];
		}
		// Return the value.
		return totalMulti;
	}

	/*
	 *This method will find the sign of each number in the array.
	 *
	 *@param numbers An array of numbers.
	 *@return The sign of the numbers in the array.
	 */
	public static double signOfArray(double[] nums) {
		// Variables.
		double sign = 0;
		/* 
		 * Determines if each number in array is either positive or negative and prints
		 * accordingly.
		 */ 
		for (int i = 0; i < nums.length; i++)
			if (nums[i] >= 0) {
				System.out.println("The number in position " + nums[i] + " is positive. ");
			} else {
				System.out.println("The number in position " + nums[i] + " is negative.");
			}
		// Return the sign.
		return sign;
	}

	/*
	 *This method will figure out what math sign needs to be added between numbers.
	 *
	 *@param numbers An array of numbers.
	 *@return Operation sign.
	 */
	public static String signToPrint(double[] nums, String sign) {
		// DVariable.
		String signForPrint = "";
		/*
		 * Loops through all the numbers inside the array and add the corresponding
		 * signs.
		 */
		for (int i = 0; i < nums.length; i++) {
			signForPrint = signForPrint + nums[i] + " " + sign + " ";
		}
		// Removes the last extra sign added in the for-loop and prints the final answer.
		signForPrint = signForPrint.substring(0, signForPrint.length() - 3);

		return signForPrint;
	}

	/*
	 * This method will take in the values user inputed and will find the smallest number in 
	 * the array and return the result.
	 *
	 *@param numbers An array of numbers.
	 *@return Smallest value in array.
	 */
	public static double smallestFromArray(double[] nums) {
		// Variable.
		double smallestNum;
		// Loop thorugh nums and finds the smallest value in the array.
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					smallestNum = nums[i];
					nums[i] = nums[j];
					nums[j] = smallestNum;
				}
			}
		}
		// Return value.
		return nums[0];
	}

	/*
	 * This method will take in the user inputted values and subtract to fund the
	 * final value and return it.
	 *
	 *@param numbers An array of numbers, difference of numbers in the array.
	 *@return The difference of numbers in the array.
	 */
	public static double subtractFromArray(double[] nums) {
		// Variables.
		double totalSubtract = 0;
		// Loop through nums values and subtracts them.
		for (int i = 0; i < nums.length; i++) {
			totalSubtract -= nums[i];
		}
		// Return the differnce.
		return totalSubtract;
	}

	/*
	 *This method finds the sum of the numbers in the array.
	 *
	 *@param numbers An array of numbers, sum of numbers in the array.
	 *@return The sum of numbers in the array.
	 */
	public static double sumOfArray(double[] nums) {
		// Variable.
		double sum = 0;
		// Loop through nums and adds each element in array.
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		// Return the value.
		return sum;
	}

	// Print the calculator menu and gets the users choice.
	public static String userInput(Scanner scnr) {
		// String Variable.
		String menuChoice;
		// Print menu options for user to choose.
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
		// Take in the users choice and uppercases the value incase it was lowercase.
		menuChoice = scnr.nextLine();
		menuChoice = menuChoice.toUpperCase();
		// Return the user choice.
		return menuChoice;
	}

}// Class ends here.
