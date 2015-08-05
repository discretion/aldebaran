import java.util.Scanner;
/**
*Class (Jeedai) is my solution to CS 12J Assignment 2 (hi Jeff)
*
* @author Benjamin Hung, benhotcakes@gmail.com
*/
public class Jeedai {
    public static void main(String[] args) {
        /* First, declare a scanner called input and tell it to read from System.in */
        Scanner input = new Scanner(System.in);
        /* Prompt the user for their first name;
        *  Declare a String called firstname and tell it to catch the first name */
        System.out.println("Please enter your first name.");
        String firstname = input.next();
        /* Prompt the user for their last name;
        *  Declare a String called lastname and tell it to catch the last name */
        System.out.println("Please enter your last name.");
        String lastname = input.next();
        /* Prompt the user to enter their mother's maiden name;
        *  Read in and store the mother's maiden name */
        System.out.println("Please enter your mother's maiden name.");
        String maiden = input.next();
        /* Prompt the user to enter the name of their birth city;
        *  Read in and store the name of the birth city */
        System.out.println("Please enter the name of your birth city.");
        String city = input.next();
        /* Take the first three letters of firstname and assign to firstname_3;
        *  Declare a String named firstname_first and give it the first character of firstname;
        *  Declare a String named firstname_rest and give it the rest of the firstname_3 string;
        *  Take the first two letters of the user's last name and assign them to lastname_2 */
        String 
            firstname_3 = firstname.substring(0, 3),
            firstname_first = firstname_3.substring(0, 1),
            firstname_rest = firstname_3.substring(1, 3),
            lastname_2 = lastname.substring(0, 2),
            /* Declare a String called Firstname and concatenate firstname_first (using the toUpperCase() method), firstname_rest and lastname_2 (both using the method toLowerCase()) */
            Firstname = firstname_first.toUpperCase() + firstname_rest.toLowerCase() + lastname_2.toLowerCase();
        /* Declare a String called maiden_2 and give it the first two letters of the maiden name;
        *  Take the first letter of maiden_2 and assign to maiden_first;
        *  Take the second letter of maiden_2 and assign it to maiden_rest;
        *  Take the first three letters of the birth city and assign to City. */
        String 
            maiden_2 = maiden.substring(0, 2),
            maiden_first = maiden_2.substring(0, 1),
            maiden_rest = maiden_2.substring(1, 2),
            City = city.substring(0, 3),
            /* Declare a String called Lastname and concatenate maiden_first (toUpperCase(), maiden_rest and City (both toLowerCase()) */
            Lastname = maiden_first.toUpperCase() + maiden_rest.toLowerCase() + City.toLowerCase();
        /* Print the user's Star Wars name along with some fun messages! */
        System.out.println("Here's your glorious Star Wars name!" + " " + Firstname + " " + Lastname);
        System.out.println("Wookiees make great buddies imo");
 }
}