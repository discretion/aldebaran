import java.io.File;
import java.util.Scanner;

 /**
  * ########HELLO########
  * MolarMass is my solution to CS12J Assignment 6.
  * @author Benjamin Hung, benhotcakes@gmail.com
  */
   
 /**
  * Calculates the molar mass of a compound and prints the value to six decimal places.
  * 
  * @param chemical compound as command line arguments separated by whitespace; i.e. H_2 O
  * @data /home/jbergamini/12jdata/elements
  * @return the molar mass of the compound, printed to six decimal points.
  */

public class MolarMass {
  static PeriodicTable[] elements;
 /*
  * method invocations:
  * construct the (empty, one-dimensional) periodic table array.
  * read in the data from elements and store in the array.
  * execute the search/molar mass algorithm
  */
  public static void main(String[] args) throws Exception {
    elements = new PeriodicTable[119];
    readData();
    System.out.println(elements[5].symbol);
    //System.out.printf("%.6f \n", findMass(args));
  }
 /*
  * readData() fills the array with information from 'elements'
  * construct a new Scanner to read from the file
  * iterate over the table array with a while loop, as in the example PeriodicTable4
  * into array[period][group], feed (name, symbol, num, relativeAtomicMass, group, period)
  */ 
  static void readData() throws Exception {
    Scanner dataFile = new Scanner(new File("elements"));
    while (dataFile.hasNext()) {
      int num = dataFile.nextInt();
      double relativeAtomicMass = dataFile.nextDouble();
      String name = dataFile.next();
      String symbol = dataFile.next();
      int group = dataFile.nextInt();
      int period = dataFile.nextInt();
      elements[num] = new PeriodicTable(num, relativeAtomicMass, name, symbol, group, period);
    }
    dataFile.close();
  }
 /*
  * findMass() returns the molar mass of the compound.
  * this algorithm does three things:
  * parse the standard input into element symbol and quantity. (uses the helpful String and parsing methods)
  * look up the element by symbol, add atomic weight
  * add the weights from each of these elements, and return the total mass
  */
  static double findMass(String[] str) {
    double totalmass = 0;
    double mass = 0;
    int atoms = 0;
    String[] compound = str;
    int i;
    int j;
    for (i = 0; i < str.length; i++) {
      String[] components = compound[i].split("_");
      String element = components[0];
      if (components.length == 1)
        atoms = 1;
      else
        atoms = Integer.parseInt(components[1]);
      for (j = 1; j < elements.length - 1; j++) {
        if (elements[j].symbol.equals(element)) {
          mass = elements[j].relativeAtomicMass;
          break;
        }
      }
      totalmass += mass * atoms;
    }
    return totalmass;
  }
}
/*
######################################DEV NOTES########################################
problems I ran into:
confused element name with symbol.
needed to use equals() instead of == to compare element with elements[j], else null pointer exception
where the search algorithm splits the argument into symbol and number, it needed an if/else structure, or else it returned array index out of bounds.
almost forgot to make the output a printf.
*/