package model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment extends BaseMode {
//	
//	NICKNAME varchar(20) not null,
//	RATING VARCHAR(1) NOT NULL,
//	Title varchar(40) not null,
//	CONSTRAINT fk_titleComm FOREIGN KEY (Title) REFERENCES TBL_MOVIE(Title),
//	COMDATE DATE not null,
//	COMTIME time not null,
//	Reviews varchar(1000) not null,
//	PRIMARY KEY(NICKNAME,COMDATE,COMTIME)
//	
	
	String NICKNAME;
	String RATING;
	String Title;
	Date COMDATE;
	Time COMtime;
	String Reviews;
	
	

	public Comment(String nICKNAME, String rATING, String title, Date cOMDATE,
			Time cOMtime, String reviews) {
		super();
		NICKNAME = nICKNAME;
		RATING = rATING;
		Title = title;
		COMDATE = cOMDATE;
		COMtime = cOMtime;
		Reviews = reviews;
	}







	public Comment(String nICKNAME, String title, Date cOMDATE, String reviews) {
		super();
		NICKNAME = nICKNAME;
		Title = title;
		COMDATE = cOMDATE;
		Reviews = reviews;
	}

	
	
	
	
	
	
	public String getRATING() {
		return RATING;
	}







	public void setRATING(String rATING) {
		RATING = rATING;
	}







	public Time getCOMtime() {
		return COMtime;
	}







	public void setCOMtime(Time cOMtime) {
		COMtime = cOMtime;
	}







	public String getNICKNAME() {
		return NICKNAME;
	}

	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getCOMDATE() {
		return COMDATE;
	}

	public void setCOMDATE(Date cOMDATE) {
		COMDATE = cOMDATE;
	}

	public String getReviews() {
		return Reviews;
	}

	public void setReviews(String reviews) {
		Reviews = reviews;
	}

	
	
	
	// 这个方法用在数据库的链接操作中
	public void formatSet() {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	}
}
