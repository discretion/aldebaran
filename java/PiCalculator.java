 /**
  * ########HELLO########
  * PiCalculator is my solution to the CS12J Midterm.
  * @author Benjamin Hung, benhotcakes@gmail.com
  */
   
 /**
  * Uses the formula pi = 4(1-1/3+1/5-1/7+1/9...), which take a given number of terms to compute gradually better approximations of pi.
  * Calculates an approximation of pi as a double by evaluating to one-hundred million terms.
  * printf to 15 digits after the decimal.
  * main method only.
  * expected output: 3.141592643589326
  */

public class PiCalculator{
  public static void main(String[] args) {
  	double pi;
  	double coefficient = 1;
  	double sign;
  	double term;
  	long i;

  	for (i = 1; i < 100000000; i++) {
 	  if (i % 2 == 0)
      //can also do -1^n
        sign = 1.0;
      else
      	sign = -1.0;
      term = sign * (1 / (1 + (2 * (double) i)));
      coefficient += term;
    }

  	pi = 4 * (coefficient);
  	System.out.printf("%.15f \n", pi);
  }
}