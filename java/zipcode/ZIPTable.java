public class ZIPTable {
	int zipcode;
	String city;
	String state;
	double latitude;
	double longitude;
	int population;

	public ZIPTable() {
		zipcode = 0;
		city = "Default city";
	}

	public ZIPTable(int zipcode, String city, String state, double latitude, double longitude, int population) {
	this.zipcode = zipcode;
	this.city = city;
	this.state = state;
	this.latitude = latitude;
	this.longitude = longitude;
	this.population = population;
	}
}