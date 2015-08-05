import java.util.Scanner;
/**
*Class (Currency) is my solution to CS 12J Assignment 3 (hi Jeff)
*
* @author Benjamin Hung, benhotcakes@gmail.com
*/
public class Currency {
    public static void main(String[] args) {
        /* Scanner input is complex, man
        * Prompt for a cash amount
        * Store the value as double dinput */
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a cash amount, dollars and cents.");
        double dinput = input.nextDouble();
        /* Take the input, convert the double to a long, and round */
        long totalcents = Math.round(dinput * 100);
        
        /* From here on, the program describes the (fewest) bills and coins required to represent the amount of money */

        /* Hundreds */
        /*Take totalcents, adjust the decimal place to indicate hundreds, store as hundred_s
        *Convert hundred_s to a long, store as hundreds */
        double hundred_s = (double) totalcents / 10000;
        long hundreds = (long) hundred_s;
        /* The next six lines form a conditional system that prints the number of hundreds, if any. The nested conditional prints the singular or plural form of "hundred" when appropriate. The rest of the denominations use this same block; in keeping with the DRY principal, the other blocks are not commented. */
        if (hundred_s >= 1) {
            if (hundreds == 1)
                System.out.println(hundreds + " hundred");
            else
                System.out.println(hundreds + " hundreds");
        }
        /* Fifties */
        /* Solve for fifties: Adjust the decimal place to reflect fifties, then subtract the number of hundreds (after converting hundreds to fifties), store the value as fiftie_s
        *Convert fiftie_s to a long, store as fifties
        *Then, print. */
        double fiftie_s = ((double) totalcents / 5000) - (2 * hundreds);
        long fifties = (long) fiftie_s;
        if (fiftie_s >= 1) {
            if (fifties == 1)
                System.out.println(fifties + " fifty");
            else
                System.out.println(fifties + " fifties");
        }
        /* Twenties */
        /* Solve for twenties as above, convert to integer, store the values as twentie_s and twenties respectively. Then, print. */
        double twentie_s = ((double) totalcents / 2000) - (5 * hundreds) - (2.5 * fifties);
        long twenties = (long) twentie_s;
        if (twentie_s >= 1) {    
            if (twenties == 1)
                System.out.println(twenties + " twenty");
            else
                System.out.println(twenties + " twenties");
        }
        /* Tens */
        /* Solve for tens, convert, then print, as above. */
        double ten_s = ((double) totalcents / 1000) - (10 * hundreds) - (5 * fifties) - (2 * twenties);
        long tens = (long) ten_s;
        if (ten_s >= 1) {
            if (tens == 1)
                System.out.println(tens + " ten");
            else
                System.out.println(tens + " tens");
        }
        /* Fives */
        /* Solve for fives, convert, then print, as above. */
        double five_s = ((double) totalcents / 500) - (20 * hundreds) - (10 * fifties) - (4 * twenties) - (2 * tens);
        long fives = (long) five_s;
        /* Interesting: If this conditional is dependent on the long, then an input ending in 4.999 gives 1 five. If the conditional is dependent on the double, then 4.999 gives 0 fives... oops, wrong. it's that values taken from the Scanner that have more than two decimal places will round. */
        if (five_s >= 1) {
            if (fives == 1)
                System.out.println(fives + " five");
            else
                System.out.println(fives + " fives");
        }
        /* Ones */
        /* Solve for ones, convert, then print, as above. */
        double one_s = ((double) totalcents / 100) - (100 * hundreds) - (50 * fifties) - (20 * twenties) - (10 * tens) - (5 * fives);
        //System.out.println(one_s);
        long ones = (long) one_s;
        if (ones >= 1) {
            if (ones == 1)
                System.out.println(ones + " one");
            else
                System.out.println(ones + " ones");
        }

        /* For coins, first take the modulo of dinput / 1 and move the decimal place. Store this value as cent_s.
        Convert cent_s to a long, store as cents. */
        double cent_s = (dinput % 1) * 100;
        long cents = Math.round(cent_s);
        //System.out.println(cents);
        /* Quarters */
        /* Solve for quarters by dividing cents by 25 
        * Convert double quarter_s to long quarters
        * Then, print as above.
        */
        long quarters = cents / 25;
        if (quarters >= 1) {
            if (quarters == 1)
                System.out.println(quarters + " quarter");
            else
                System.out.println(quarters + " quarters");
        }
        /* Dimes */
        /* Calculate dimes, convert, then print, as above */
        long dimes = (long) Math.round((cents / 10) - (quarters * 2.5));
        //System.out.println(dimes);
        if (dimes >= 1) {
            if (dimes == 1)
                System.out.println(dimes + " dime");
            else
                System.out.println(dimes + " dimes");
        }
        /* Nickels */
        /* Calculate nickels, convert, then print, as above */
        long nickels = (long) Math.round((cents / 5) - (quarters * 5) - (dimes * 2));
        //System.out.println(nickels);
        if (nickels >= 1) {
            if (nickels == 1)
                System.out.println(nickels + " nickel");
            else
                System.out.println(nickels + " nickels");
        }
        /* Pennies */
        /* Calculate pennies, convert, then print, as above */
        long pennies = (long) Math.round(cents - (quarters * 25) - (dimes * 10) - (nickels * 5));
        //System.out.println(pennies);
        if (pennies >= 1) {
            if (pennies == 1)
                System.out.println(pennies + " penny");
            else
                System.out.println(pennies + " pennies");
        }
    }
}