/* 
 * File name:	Calculator.java
 * Names:		Dhruv Sharma, Mohammed Khan, Hammad Uddin, and Emanuel Martins
 * Course:		COP 2800C at Valencia College 
 * Professor:	David Stendel
 * Description:	This program displays a calculator menu where a user chooses the option to input 
 * 				values and calculates the following using those values, addition, subtraction, 
 * 				multiplication, division, largest value, smallest value, average of values, and 
 * 				sign of each value.
 * 				Options
 * Date:  		10/22/22 
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
		double[] numArray = new double[]{0,0,0}; //change numArray to nums 
		Scanner scnr = new Scanner(System.in);
		// Calculator
		do {
			// Input
			menuChoice = userInput(scnr); 
			/*
			 * Checks if the users choice is a valid option or not and checks if the user
			 * inputed numbers in the first run before choosing anything else
			 */
			if ((numArray.length == 0) && !menuChoice.equals("N") && !menuChoice.equals("X")) {
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
						numArray = getUserNum(scnr);
						break;
					case "A":
						// Prints out all added numbers inside the array
						System.out.println("\nAnswer: " + signToPrint(numArray, "+") + " = " + sumOfArray(numArray));
						break;
					case "S":
						// Prints out all the numbers subtracted inside the array
						System.out.println("\nAnswer: " + signToPrint(numArray, "-") + " = " 
							+ subtractFromArray(numArray));
						break;
					case "M":
						// Prints out all the numbers multiplied inside the array
						System.out.println("\nAnswer: " + signToPrint(numArray, "*") + " = "
							+ String.format("%.3f", multiplyArray(numArray)));
						break;
					case "D":
						divided = divideArray(numArray);
						/*
						 * Prints out all the numbers divided inside the array if number was not divided
						 * by zero
						 */
						
						if (divided == 3.1415926535) {
							System.out.println("\nError: Cannot divide by zero.");
						} else {
							System.out.println(
									"\nAnswer: " + signToPrint(numArray, "/") + " = " + String.format("%.3f", divided));
						}
						break;
					case "V":
						// Prints out the average of all numbers inside the array
						System.out.println("\nAnswer: (" + signToPrint(numArray, "+") + ") / " + numArray.length + " = "
								+ String.format("%.3f", averageOfArray(numArray)));
						break;
					case "L":
						// Prints out the largest number from the array
						System.out.println("\nThe largest number is " + largestFromArray(numArray));
						break;
					case "I":
						// Calls the method which will print if the numbers in the array are positive or
						// negative
						System.out.println("\n" + signOfArray(numArray));
						;
						break;
					case "E":
						// Prints out the smallest number from the array
						System.out.println("\nThe smallest number is " + smallestFromArray(numArray));
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
	public static double signOfArray(double[] numArray) {
		// Declare variables
		double sign = 0;
		// Determines if each number in array is either positive or negative and prints
		// accordingly
		for (int i = 0; i < numArray.length; i++)
			if (numArray[i] >= 0) {
				System.out.println("The number in position " + numArray[i] + " is positive. ");
			} else {
				System.out.println("The number in position " + numArray[i] + " is negative.");
			}
		// Returns value
		return sign;
	}

	// This method will figure out what math sign needs to be added between numbers
	public static String signToPrint(double[] numArray, String sign) {
		// Declared Variable
		String signForPrint = "";
		// Loops through all the numbers inside the array and add the corresponding
		// signs
		for (int i = 0; i < numArray.length; i++) {
			signForPrint = signForPrint + numArray[i] + " " + sign + " ";
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
	public static double subtractFromArray(double[] numArray) {
		// Declared needed varables
		double totalSubtract = 0;
		// Loops through numArray values and subtracts them
		for (int i = 0; i < numArray.length; i++) {
			totalSubtract -= numArray[i];
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
		// Take in the users choice and uppercases the value incase it was lowercase
		menuChoice = scnr.nextLine();
		menuChoice = menuChoice.toUpperCase();
		// Returns the choice
		return menuChoice;
	}

}// Class ends here