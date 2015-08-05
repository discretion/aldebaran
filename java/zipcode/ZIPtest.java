import java.io.File;
import java.net.*;
import java.util.*;
/**
 * ########HELLO########
 * Class ZIPcode is part of my solution to CS12J Assignment 9.
 * ZIPcode models several basic characteristics of a USPS ZIP code.
 * @author Benjamin Hung, benhotcakes@gmail.com
 * @data http://jeff.cis.cabrillo.edu/~jbergamini/12jdata/zips
 * @return a list of ZIP codes within the specified range, as well as some geographical data and the distance in kilometers.
 */
public class ZIPtest {
  private int zip;
  private double latitude;
  private double longitude;
  private String city;
  private String state;
  private int population;
  static ZIPTable[] zips;
  public static ZIPcode origin;
  public static ZIPcode other;
  private static double range;
  private static int originzip;

  public static void main(String[] args) throws Exception {
    //Below: for testing
    //final String[] args = new String[] { "95062", "100.00" };

    try {
    originzip = Integer.parseInt(args[0]);
    range = Double.parseDouble(args[1]);
    } catch (Exception e) {
      System.out.println("Please enter a ZIP code and a distance in KM!");
      System.exit(0);
    }
	  zips = new ZIPTable[99951];
    readData();
    origin = fetch(originzip);
    search(range);
  }

  static void readData() throws Exception {
	  URL url = new URL("http://jeff.cis.cabrillo.edu/~jbergamini/12jdata/zips");
	  URLConnection conn = url.openConnection();
	  Scanner zipScanner = new Scanner(conn.getInputStream());
	  while (zipScanner.hasNext()) {
	    int zipcode = zipScanner.nextInt();
	    String city = zipScanner.next();
	    String state = zipScanner.next();
	    while (!zipScanner.hasNextDouble()) {
	      city = city.concat(" "+state);
		    state = zipScanner.next();
	    }
	    double latitude = zipScanner.nextDouble();
	    double longitude = zipScanner.nextDouble();
	    int population = zipScanner.nextInt();
	    zips[zipcode] = new ZIPTable(zipcode, city, state, latitude, longitude, population);
	  }
  }

  public static ZIPcode fetch(int originzip) {
  	//
  	int zip = originzip;
  	//
  	String cit = zips[zip].city;
  	String sta = zips[zip].state;
    double lat = zips[zip].latitude;
    double lon = zips[zip].longitude;
    int pop = zips[zip].population;

    ZIPcode origin = new ZIPcode(zip, lat, lon, cit, sta, pop);
    return origin;
  }
  
  public static void search(Double range) {
  	//ArrayList inrange = new ArrayList();
  	int i;
  	//String j;
  	for (i = 0; i < 99949; i++) {
  	  //j = Integer.toString(i);
      if (zips[i] != null) {
    	  other = fetch(i);
	      if (origin.distanceFrom(other) < range && i != origin.getZIP())
	      //inrange.add(other);
	      System.out.printf("%s  %.2f km \n", other.toString(), origin.distanceFrom(other));
      }
	  }
  }
}
/*
####################################################################
Have to import java.net.* to use URL objects
Remember to import all relevant packages.
Remember to match the right types or they will be incompatible.
URL gives MalformedURLException, openConnection and getInputStream give IOException... remember to throw exceptions
Some of the ZIP locations have city names that are multiple words. If you don't build this into the program, then it'll end up looking for a double where there's a string. Here's what you do. Make a while loop that concatenates the state onto the city when !hasNextDouble evaluates to TRUE.
Search() should fill an ArrayList with the geo data; each element should contain the data on each ZIP code within the given radius.
####################################################################
*/