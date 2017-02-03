package model;

import java.sql.Time;
import java.util.Date;

public class Show extends BaseMode {
	String Title;
	String Location;
	String SeatLeft;
	Date DateSHow;
	Time ShowingTime;

	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Show(String title, String location, String seatLeft, Date DateSHow,
			Time showing) {
		super();
		Title = title;
		Location = location;
		SeatLeft = seatLeft;
		this.DateSHow = DateSHow;
		ShowingTime = showing;
	}
	
	
	
	
	public Date getDateSHow() {
		return DateSHow;
	}

	public void setDateSHow(Date dateSHow) {
		DateSHow = dateSHow;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getSeatLeft() {
		return SeatLeft;
	}

	public void setSeatLeft(String seatLeft) {
		SeatLeft = seatLeft;
	}

	public Time getShowing() {
		return ShowingTime;
	}

	public void setShowing(Time showing) {
		ShowingTime = showing;
	}

}
