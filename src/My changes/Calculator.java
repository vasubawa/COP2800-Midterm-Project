
import java.util.Scanner;

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
        boolean numEntered = false;
        double[] nums = new double[3];

        // A loop that will keep the program running as long as "X" isn't entered
        do {
            // Gets the users Input from the menu.
            menuChoice = userInput().charAt(0);
            numEntered = processChoice(menuChoice, numEntered, nums);

            // Stops the loop if "X" is entered.
        } while (menuChoice != 'X');
        // Prints good-bye message.
        System.out.println("\nThank you for using Team 2's calculator! Good-bye!");
    }

    /**
     * Get the users numbers and put it inside an array.
     * 
     * @return threeNumArray Returns the numbers entered by the user.
     */
    public static double[] getUserNum() {
        // Declared Variables
        Scanner scnr = new Scanner(System.in);
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

        // Closes Scanner and Returns the value.
        //scnr.close();
        return threeNumArray;
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
     * @param numEntered
     * @return nums Returns users inputed numbers.
     */
    public static boolean processChoice(char menuChoice, boolean numEntered, double[] nums) {
        // Declared varables.
        double answer = 0.0;
        boolean zeros = false;
        Scanner scnr = new Scanner(System.in);
        
        // Processes the users choice.
        if (menuChoice == 'N') {
            numEntered = true;
            nums = getUserNum();
        } else if (menuChoice == 'A' && numEntered == true){
            // answer = sumNum(nums);
            //printCommonAnswer(nums, "+", answer, menuChoice, zeros);

        } else if (menuChoice == 'X'){

        } else{
            // Prints out an error if one of the cases didn't match
            System.out.println("\n\tError: Invalid choice!");
        }

        // Returns if the first choice was 'n' or not.
        //scnr.close();
        return numEntered;
    }

    /**
     * Prints out the menu for the user to select from.
     * 
     * @return menuChoice Returns whatever the user has inputted.
     */
    public static String userInput() {
        // Declaring String Variable;
        Scanner scnr = new Scanner(System.in);
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
        //scnr.close();
        // Returns the choice
        return menuChoice;
    }

}
 