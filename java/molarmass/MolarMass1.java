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

  static PeriodicTable[] table;
 /*
  * 
  * method invocations:
  * construct the (empty, one-dimensional) periodic table array.
  * read in the data from elements and store in the array.
  * execute the search/molar mass algorithm
  */
  public static void main(String[]args) throws Exception {
    // Do these declarations need to be in the main method of MolarMass?
    String name;
    String symbol; 
       int atomicNumber;
    double relativeAtomicMass;
       int group;
       int period;
    

    table = new PeriodicTable[119];
    
  }

 /*
  * PeriodicTable()
  * construct a template for the periodic table
  */
  public PeriodicTable() {
    name = "Default Name";
    symbol = "Default Symbol";
  }
  
  public static void PeriodicTable(String name, String symbol, int atomicNumber, double relativeAtomicMass, int group, int period) {
    this.name = name;
    this.symbol = symbol;
    this.atomicNumber = atomicNumber;
    this.relativeAtomicMass = relativeAtomicMass;
    this.group = group;
    this.period = period;
  }

 /*
  * readData() fills the array with information from 'elements'
  * construct a new Scanner to read from the file
  * iterate over the table array with a while loop, as in the example PeriodicTable4
  * into array[period][group], feed (name, symbol, num, relativeAtomicMass, group, period)
  */ 
  static void readData() throws Exception {
  	Scanner dataFile = new Scanner(new File("/home/jbergamini/12jdata/elements"));
  	while (dataFile.hasNext()) {
  	  int num = dataFile.nextInt();
  	  String name = dataFile.next();
      String symbol = dataFile.next();; 
      int atomicNumber = dataFile.nextInt();
      double relativeAtomicMass = dataFile.nextInt();
      int group = dataFile.nextInt();
      int period = dataFile.nextInt();
      array[num] = new PeriodicTable(num, name, symbol, atomicNumber, relativeAtomicMass, group, period);
  	}
    dataFile.close();
  }
 /*
  * findmass() returns the molar mass of the compound.
  * this algorithm has to do three things:
  * parse the standard input into element name and quantity. (uses the helpful String and parsing methods)
  * look up the element by name, add atomic weight
  * add the weights from each of these elements, and return the total mass
  */
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

If the first design doesn't work, start over with a new class based on ArrayStatistics1
*/