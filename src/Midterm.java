import java.util.Scanner;

public class Midterm {
    public static void main(String[] args) throws Exception {
        // Declared Variables
        String menuChoice;
        double[] numArray = new double[0];
        String userValues = "";

        // Declaring Scanner for user input.
        Scanner scnr = new Scanner(System.in);

        // Method Loops for User Choice.
        do {
            // Gets the users Input from the menu
            menuChoice = userInput(scnr);
            // Checks if the users choice is a valid option or not and checks if the user
            // inputed numbers in the first run before choosing anything else
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
                        double sum = sumOfArray(numArray);
                        System.out.println("\nAnswer: " + sum);
                        break;
                    case "S":
                        // Calls the subtractFromArray and puts the processed value into the variable
                        double subtract = subtractFromArray(numArray);
                        // Loops through the numArray and add the sign in between
                        for (int i = 0; i < numArray.length; i++) {
                            userValues = userValues + numArray[i] + " - ";
                        }
                        // Removes the last extra sign added in the for-loop and prints the final
                        userValues = userValues.substring(0, userValues.length() - 3);
                        System.out.println("\nAnswer: " + userValues + " = " + subtract);
                        break;
                    case "M":
                        // Calls the multiplyArray and put the value inside multiply
                        double multiply = multiplyArray(numArray);
                        // Loops through the numArray and add the sign in between
                        for (int i = 0; i < numArray.length; i++) {
                            userValues = userValues + numArray[i] + " * ";
                        }
                        // Removes the last extra sign added in the for-loop and prints the final answer
                        userValues = userValues.substring(0, userValues.length() - 3);
                        System.out.println("\nAnswer: " + userValues + " = " + multiply);
                        break;
                    case "D":
                        // Calls the divideArray and put the value inside divited
                        double divided = divideArray(numArray);
                        // Loops through the numArray and add the sign in between
                        for (int i = 0; i < numArray.length; i++) {
                            userValues = userValues + numArray[i] + " / ";
                        }
                        // Removes the last extra sign added in the for-loop and prints the final answer
                        userValues = userValues.substring(0, userValues.length() - 3);
                        System.out.println("\nAnswer: " + userValues + " = " + divided);
                        break;
                    case "V":
                        double average = averageOfArray(numArray);
                        System.out.println("Answer: " + average);
                        break;
                    case "L":
                        // Calls largestFromArray method and prints the answer
                        System.out.println("The largest number is " + largestFromArray(numArray));
                        break;
                    case "I":
                        break;
                    case "E":
                        break;
                    default:
                        System.out.println("Error: Invalid choice!");
                }
                // Prints an error if the user didn't select one of the give options from the
                // menu
            } else {
                System.out.println("\nError: Please pick one of the list options and try again.\n");
            }
            // Ends the loop if the user selects "x"
        } while (!menuChoice.equals("X"));
        // Prints good-bye messagw
        System.out.println("\nThank you for using Team 2's calculator! Good-bye!");
    }

    public static double averageOfArray(double[] numArray) {
        double sum = 0;
        double average = 0;
        for (int i = 0; i < numArray.length; i++) {
            sum = sum + numArray[i];
            average = sum / 3;
        }
        return average;
    }

    public static double divideArray(double[] numArray) {
        double totalDivide = 1;
        for (int i = 0; i < numArray.length; i++) {
            totalDivide /= numArray[i];
        }
        return totalDivide;
    }

    // This method will take in the user inputed values and find the largest of
    // them and return that.
    public static double largestFromArray(double[] numArray) {
        // Declared needed varables
        double largestNum = 0;
        // Loops through numArray values and checks/updated largestNum if a number is
        // greater than the stored value
        for (int i = 0; i < numArray.length; i++)
            if (largestNum < numArray[i]) {
                largestNum = numArray[i];
            }
        // Returns the value
        return largestNum;
    }

    // This method will take in the user inputed values and find the largest of
    // them and return that.
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

    // This method will take in the user inputed values and subtract to fund the
    // final value and return it.
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

    public static double sumOfArray(double[] numArray) {
        double sum = 0;

        for (int i = 0; i < numArray.length; i++) {
            sum = sum + numArray[i];
        }
        return sum;
    }

    public static double[] getUserNum(Scanner scnr) {
        // Asks the user to input x amount of values
        System.out.print("\nEnter 3 numbers separated with spaces: ");
        // Takes in the users inputed value and takes out the spaces in between and
        // throwes it inside a string array
        String input = scnr.nextLine();
        String[] strNumber = input.split(" ");
        // Declared new double array and take in the length of previous string array
        double[] threeNumArray = new double[strNumber.length];
        // Loops through the users input and converts it into double
        for (int i = 0; i < threeNumArray.length; i++) {
            threeNumArray[i] += Integer.parseInt(strNumber[i]);
        }
        // Returns the value
        return threeNumArray;
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
