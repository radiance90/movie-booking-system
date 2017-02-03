package model;

import java.sql.Date;
import java.sql.Time;

public class Order extends BaseMode {

	
//	PrimekyNumber SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,
	String ID;
	String ACCOUNTNAME ;
	String Title ;
	String tickets ;
	String Location; 
	Date ShowingDate ;
	Time ShowingTime ;
	
	
	
	
	
	
	
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String aCCOUNTNAME, String title, String tickets,
			String location, Date showingDate, Time showingTime) {
		super();
		ACCOUNTNAME = aCCOUNTNAME;
		Title = title;
		this.tickets = tickets;
		Location = location;
		ShowingDate = showingDate;
		ShowingTime = showingTime;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getACCOUNTNAME() {
		return ACCOUNTNAME;
	}
	public void setACCOUNTNAME(String aCCOUNTNAME) {
		ACCOUNTNAME = aCCOUNTNAME;
	}
	public String getTickets() {
		return tickets;
	}
	public void setTickets(String tickets) {
		this.tickets = tickets;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Date getShowingDate() {
		return ShowingDate;
	}
	public void setShowingDate(Date showingDate) {
		ShowingDate = showingDate;
	}
	public Time getShowingTime() {
		return ShowingTime;
	}
	public void setShowingTime(Time showingTime) {
		ShowingTime = showingTime;
	}

	
	
	
}
