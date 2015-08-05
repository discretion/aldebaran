import java.io.File;
//import java.util.Scanner;
import java.net.*;
//import java.util.InputMismatchException;
import java.util.*;

public class ZIPtest1 {
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
	zips = new ZIPTable[99951];
    readData();
    //parse();
    final String[] cmdline = new String[] { "95062", "100.00" };
    //final String[] cmdline2 = new String[] { "94062", "100.00" };
    originzip = Integer.parseInt(cmdline[0]);
    range = Double.parseDouble(cmdline[1]);
    //String origin = fetch(cmdline);
    origin = fetch(originzip);
    //other = fetchother(cmdline2);
    //search(cmdline);
    //System.out.println(zips[99950].state);
    //System.out.println(origin);
    //System.out.println(origin.distanceFrom(other));
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
    //String origin = String.format("%5d: %s, %s @ (%.2f, %.2f)", zip, cit, sta, lat, lon);
    ZIPcode origin = new ZIPcode(zip, lat, lon, cit, sta, pop);
    return origin;
  }

/*
  public static ZIPcode fetchother(String[] cmdline2) {
  	int zip = Integer.parseInt(cmdline2[0]);
  	String cit = zips[zip].city;
  	String sta = zips[zip].state;
    double lat = zips[zip].latitude;
    double lon = zips[zip].longitude;
    int pop = zips[zip].population;
    //String origin = String.format("%5d: %s, %s @ (%.2f, %.2f)", zip, cit, sta, lat, lon);
    ZIPcode other = new ZIPcode(zip, lat, lon, cit, sta, pop);
    return other;
  }
*/

  
  public static void search(Double range) {
  	//ArrayList inrange = new ArrayList();
  	int i;
  	//String j;
  	for (i = 0; i < 99950; i++) {
  	  //j = Integer.toString(i);
	  other = fetch(i);
	  if (origin.distanceFrom(other) < range)
	    //inrange.add(other);
	    System.out.printf("%f distance: %f", other.toString(), origin.distanceFrom(other));
	}
  }
}



/*
##############################

TODO: JavaDoc it up!

##############################

Have to import java.net.* to use URL objects

Remember to import all relevant packages.

Remember to match the right types or they will be incompatible.

URL gives MalformedURLException, openConnection and getInputStream give IOException... remember to throw exceptions

Some of the ZIP locations have city names that are multiple words. If you don't build this into the program, then it'll end up looking for a double where there's a string. Here's what you do. Make a while loop that concatenates the state onto the city when !hasNextDouble evaluates to TRUE.

Search() should fill an ArrayList with the geo data; each element should contain the data on each ZIP code within the given radius.

##############################*/