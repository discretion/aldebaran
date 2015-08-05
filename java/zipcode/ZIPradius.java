import java.io.File;
import java.util.Scanner;

 /**
  * ########HELLO########
  * Class ZIPcode is my solution to CS12J Assignment 9.
  * ZIPcode models several basic characteristics of a USPS ZIP code.
  * @author Benjamin Hung, benhotcakes@gmail.com
  */
   
public class ZIPcode {
  // Which fields should be private?
    private int zip;
    private double latitude;
    private double longitude;
    private String city;
    private String state;
    private int population;
    static ZIPTable[] zips;

 /**
  * 
  * @param zip the ZIP code
  * @param latitude the latitude of this ZIP's geographical center (in degrees)
  * @param longitude the longitude of this ZIP's geographical center (in degrees)
  * @param city the city containing the ZIP
  * @param state the state containing the ZIP
  * @param population a population estimate for the ZIP
  */

  public static void main(String[] args) {
    zips = new ZIPTable[99950];
    readData();
    testDistance();
    
  }

  public ZIPradius(int zip, double latitude, double longitude, String city, String state, int population) {
  //TODO: implement this constructor.
    this.zip = zip;
    this.latitude = latitude;
    this.longitude = longitude;
    this.city = city;
    this.state = state;
    this.population = population;
    System.out.println(this.toString());
  }

 /**
  * Calculates and returns the distance between this ZIP code and another ZIP code in kilometers, using the spherical law of cosines.
  * @return the distance between this ZIP code and another ZIP code.
  */
  public double distanceFrom(ZIPcode other) {
    double lat1 = this.getLatitude();
    double lat2 = other.getLatitude();
    double lon1 = this.getLongitude();
    double lon2 = other.getLongitude();
    double latA = Math.toRadians(lat1);
    double latB = Math.toRadians(lat2);
    double lonA = Math.toRadians(lon1);
    double lonB = Math.toRadians(lon2);
    double delta = Math.toRadians(lon2-lon1);
    double R = 6371.00;
    double distance = Math.acos(Math.sin(latA) * Math.sin(latB) + Math.cos(latA) * Math.cos(latB) * Math.cos(delta)) * R;
    return distance;
  }

 /**
  * Getter for city
  * @return a string stating the city
  */
  public String getCity() {
    String city = this.city;
    return city;
  }

 /**
  * Getter for latitude.
  * @return latitude as a double
  */
  public double getLatitude() {
    double latitude = this.latitude;
    return latitude;
  }

 /**
  * Getter for longitude.
  * @return longitude as a double.
  */
  public double getLongitude() {
    double longitude = this.longitude;
    return longitude;
  }

 /**
  * Getter for population.
  * @return population as an int
  */
  public int getPopulation() {
    int population = this.population;
    return population;
  }

 /**
  * Getter for state.
  * @return the state
  */
  public String getState() {
    String state = this.state;
    return state;
  }

 /**
  * Getter for ZIP code.
  * @return this ZIP code
  */
  public int getZIP() {
    int zip = this.zip;
    return zip;
  }

 /**
  * toString composes and returns a string representation of this ZIPcode.
  * @return a string representation of this ZIPcode.
  */
  public String toString() {
    return String.format("%5d: %s, %s @ (%.2f, %.2f)", this.getZIP(), this.getCity(), this.getState(), this.getLatitude(), this.getLongitude());
  }
}