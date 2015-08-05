import java.io.File;
import java.util.Scanner;

 /**
  * ########HELLO########
  * MolarMass is my solution to CS12J Assignment 6.
  * @author Benjamin Hung, benhotcakes@gmail.com
  */
   
 /**
  * Calculates the molar mass of a compound and prints the value to six decimal places.
  * I designed this class to be a simple, elegant answer to the challenge. 
  * I eschewed needless features, at the cost of learning to build a more complex program.
  * 
  * @param chemical compound as command line arguments separated by whitespace; i.e. H_2 O
  * @data /home/jbergamini/12jdata/elements
  * @return the molar mass of the compound, printed to six decimal points.
  */

public class MolarMass {
 /* String name;
    String symbol; 
    int atomicNumber;
    double relativeAtomicMass;
    int group;
    int period;
  * Main method
  * declarations/assignments:
  */

  static PeriodicTable[] elements;
 /*
  * 
  * method invocations:
  * construct the (empty, one-dimensional) periodic table array.
  * read in the data from elements and store in the array.
  * execute the search/molar mass algorithm
  */
  public static void main(String[] args) throws Exception {
    elements = new PeriodicTable[119];
    readData();
    //findMass(args);
    System.out.printf("%.6f \n", findMass(args));
    //System.out.println(elements[1].relativeAtomicMass);
    //System.out.println(elements[50].name);
    //System.out.println(elements[100].name);
  }

 /*
  * PeriodicTable() is a class external to this class
  * construct a template for the periodic table
  */

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
  * this algorithm has to do three things:
  * parse the standard input into element name and quantity. (uses the helpful String and parsing methods)
  * look up the element by name, add atomic weight
  * add the weights from each of these elements, and return the total mass
  */
  static double findMass(String[] str) {
    // parse the standard input into element name and quantity.
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
    //System.out.println(str[0]);
    return totalmass;
  }
}




/*
######################################DEV NOTES########################################
### import io.File & util.Scanner ### class MolarMass.java ### declare static table ### 
### main method: declare variables for the table. assign table, invoke constructor  ###
### on PeriodicTable. invoke readData(). 
#######################################################################################
### PeriodicTable method: assigns variables(???)
#######################################################################################
### 

Teh progrman: constructs an empty periodic table and fills it with the elements; interprets command line arguments; calculates the molar mass of the user's compound.

If the first design doesn't work, start over with a new class based on ArrayStatistics1
*/