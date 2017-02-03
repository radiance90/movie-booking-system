package model;

public class Cinema extends BaseMode {
	String Location;
	String Capacity;
	String Amenities;
	
	
	public Cinema(String location, String capacity, String amenities) {
		super();
		Location = location;
		Capacity = capacity;
		Amenities = amenities;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getCapacity() {
		return Capacity;
	}
	public void setCapacity(String capacity) {
		Capacity = capacity;
	}
	public String getAmenities() {
		return Amenities;
	}
	public void setAmenities(String amenities) {
		Amenities = amenities;
	}
	
	
}
