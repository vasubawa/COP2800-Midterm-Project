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
import java.io.PrintWriter;
import java.io.StringWriter;

// Start of class
public class testing {
    public static void main(String[] args) {
        String item;
        int quantity;
        int discount;

        StringWriter itemCharStream = new StringWriter();
        PrintWriter itemOSS = new PrintWriter(itemCharStream);

        item = "Shoes";
        quantity = 18;
        discount = 40;

        itemOSS.println(item + " x" + quantity);
        itemOSS.print(discount + "% off");

        System.out.print(itemCharStream.toString());
    }
}