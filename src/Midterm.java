import java.util.Scanner;

public class Midterm {
    public static void main(String[] args) throws Exception {
        // Variables
        String menuChoice;
        double[] numArray = new double[0];
        String userValues = "";

        // Declaring Scanner for user input.
        Scanner scnr = new Scanner(System.in);

        // Method Loops for User Choice.
        do {
            menuChoice = userInput(scnr);

            if ((numArray.length == 0) && !menuChoice.equals("N") && !menuChoice.equals("X")) {
                System.out.println("\nError: Please select option N from the menu first!\n");
            } else if (menuChoice.equals("X")) {
                break;
            } else if (menuChoice.equals("N") || menuChoice.equals("A") || menuChoice.equals("S")
                    || menuChoice.equals("M") || menuChoice.equals("D") || menuChoice.equals("V")
                    || menuChoice.equals("L") || menuChoice.equals("I") || menuChoice.equals("E")) {

                switch (menuChoice) {
                    case "N":
                        numArray = getUserNum(scnr);
                        break;
                    case "A":
                        double sum = sumOfArray(numArray);
                        System.out.println("\nAnswer: " + sum);
                        break;
                    case "S":
                        // Calls the subtractFromArray and puts the processed value into the variable
                        double subtract = subtractFromArray(numArray);
                        // Loops through the user input
                        for (int i = 0; i < numArray.length; i++) {
                            userValues = userValues + numArray[i] + " - ";
                        }
                        userValues = userValues.substring(0, userValues.length() - 3);
                        System.out.println("\nAnswer: " + userValues + " = " + subtract);
                        break;
                    case "M":
                        break;
                    case "D":
                        break;
                    case "V":
                        double average = averageOfArray(numArray);
                        System.out.println("Answer: " + average);
                        break;
                    case "L":
                        double largestNum = largestFromArray(numArray);
                        System.out.println("The largest number is " + largestNum);
                    case "I":
                        break;
                    case "E":
                        break;
                    default:
                        System.out.println("Error: Invalid choice!");
                }
            } else {
                System.out.println("\nError: Please pick one of the list options and try again.\n");
            }
        } while (!menuChoice.equals("X"));

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
    // This method will take in the user inputted values and find the largest of
    // them and return that.
    public static double largestFromArray(double[] numArray) {
        double largestNum = 0;
        for (int i = 0; i < numArray.length; i++)
            if (largestNum < numArray[i]) {
                largestNum = numArray[i];
            }
        return largestNum;
    }

    // This method will take in the user inputted values and subtract to fund the
    // final value and return it.
    public static double subtractFromArray(double[] numArray) {
        double totalSubtract = 0;
        for (int i = 0; i < numArray.length; i++) {
            totalSubtract -= numArray[i];
        }
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
        // Takes in the users inputted value and takes out the spaces in between and
        // throwes it inside a string array
        String input = scnr.nextLine();
        String[] strNumber = input.split(" ");
        // Declared new double array and take in the length of previous string array
        double[] threeNumArray = new double[strNumber.length];
        // Loops through the users input and converts it into double
        for (int i = 0; i < threeNumArray.length; i++) {
            threeNumArray[i] += Integer.parseInt(strNumber[i]);
        }
        return threeNumArray;
    }

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

        return menuChoice;
    }


}//Class ends here
