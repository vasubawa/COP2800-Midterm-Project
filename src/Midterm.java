/* 
import java.util.Scanner;

public class Midterm {
        public static void main(String[] args) throws Exception {
        //Variables 
        String menuChoice;
        double[] numArray = new double[3];
        numArray = null;

        //scanner
        Scanner scnr = new Scanner(System.in);
        //System.out.println(numArray[0]);
        
    
        //Method Loops for User Choice 
        do{
            menuChoice = userInput(scnr);
            //System.out.println(numArray);
            if(numArray == null && !menuChoice.equals("N") && !menuChoice.equals("X")){
                System.out.println("Error: Please select option N from the menu first!\n");
            }
            else if(menuChoice.equals("X")){
                break;
            }
            else{

                processUserChoice(menuChoice);
            }
        }
        while (!menuChoice.equals("X"));
        
        System.out.println("\nThank you for using Team 2's calculator! Good-bye!");
    }

    public static void processUserChoice(String menuChoice) {
        System.out.println("\nThis prints inside processUserChoice. Remove this when its working at the end\n");
    }

    public static double[] getThreeNum(Scanner scnr) {
        double[] threeNumArray = new double[3];
        //threeNumArray = scnr.nextDouble();
        System.out.println("getThreeNum Works");
        return threeNumArray;
    }

    public static String userInput(Scanner scnr){
        //copy/paste System.out.println("");
        //Menu options
        System.out.println("Calculator Menu\n");
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
        String menuChoice = scnr.nextLine();
        System.out.println("");

        return menuChoice;
    }
}
*/