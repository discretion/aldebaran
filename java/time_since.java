/** Hi Jeff. Didn't manage to solve it in time, but I think I'm on the right track. Based on the example... First, declare and assign variables for days, hr, min, sec, then use one System.out invocation w/ placeholders to print the output. **/
public class TimeSince {
// Main Method (Hi Jeff)
 public static void main(String[] args) {
// Declare a variable "now" of type "long" and assign it to an invocation of the time method of the System class.
  long now = System.currentTimeMillis();
// Declare an int variable called "days" and make it use division to convert milliseconds to days, casting the result to an int.
  int days = (int) (now / 1000.0 / 60.0 / 60.0 / 24.0);
// 
  double days2 = (now / 1000.0 / 60.0 / 60.0 / 24.0);

// Declare & assign again, calculating hours.
  int hours = (int) ((days2 - (double)days)*24);
//  double hours2 = ()
  double hours2 = ((days2 - (double)days)*24);

// Declare & assign as above, calculating minutes directly from the "now" variable.
  int minutes = (int) ((hours2 - (double)hours) * 60.0);
  
  double minutes2 = ((hours2 - (double)hours) * 60.0);


// Declare an int variable called "seconds" and make it use division to convert milliseconds to seconds, casting the result to an int.
  int seconds = (int) ((minutes2 - (double)minutes) * 60.0);
// Use one invocation of the placeholder print method to spit out a nice list of the present values of the above variables.
  System.out.printf("%d days\n%d hours\n%d minutes\n%d seconds\n", days, hours, minutes, seconds);
 }
}