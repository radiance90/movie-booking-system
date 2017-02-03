package model;

import java.util.Date;


public class Movie extends BaseMode implements Comparable<Movie> {
	//
	// Title VARCHAR(40) NOT NULL CONSTRAINT Title_pk PRIMARY KEY ,
	// Poster VARCHAR(20) ,
	// actors VARCHAR(300),
	// Genre VARCHAR(300) NOT NULL,
	// Director VARCHAR(50),
	// Synopsis VARCHAR(1000),
	// AGEOFRATING VARCHAR(1),
	// rating VARCHAR(1),
	// NUMBEROFRATING VARCHAR(10),
	// relaseDate date

	private String Title;
	private String Poster;
	private String actors;
	private String Genre;
	private String Director;
	private String Synopsis;
	private String rating;
	private Date relaseDate;
	private String AGEOFRATING;
	private String NUMBEROFRATING;

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this.Title == ((Movie) obj).getTitle()) {
			return true;
		} else {
			return false;
		}
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title) {
		super();
		Title = title;
	}

	public Movie(String title, String poster, String rating, String actors,String genre) {
		super();
		this.Title = title;
		this.Poster = poster;
		this.rating = rating;
		this.actors = actors;
		this.Genre = genre;
	}

	public Movie(String title, String poster, String actors, String genre,
			String director, String synopsis, String rating, String agerating,
			String NUMBEROFRATING, Date relaseDate) {
		super();
		Title = title;
		Poster = poster;
		this.actors = actors;
		Genre = genre;
		Director = director;
		Synopsis = synopsis;
		this.rating = rating;
		this.relaseDate = relaseDate;
		this.AGEOFRATING = agerating;
		this.NUMBEROFRATING = NUMBEROFRATING;
	}

	public Movie(String titleString, String posterString, String rateingString) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	public String getNUMBEROFRATING() {
		return NUMBEROFRATING;
	}

	public void setNUMBEROFRATING(String nUMBEROFRATING) {
		NUMBEROFRATING = nUMBEROFRATING;
	}

	public String getAGEOFRATING() {
		return AGEOFRATING;
	}

	public void setAGEOFRATING(String aGEOFRATING) {
		AGEOFRATING = aGEOFRATING;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getSynopsis() {
		return Synopsis;
	}

	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getRelaseDate() {
		return relaseDate;
	}

	public void setRelaseDate(Date relaseDate) {
		this.relaseDate = relaseDate;
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		if (Double.parseDouble(this.rating) <Double.parseDouble(o.getRating())) {
			return 1;
		} else if (Double.parseDouble(this.rating) > Double.parseDouble(o
				.getRating())) {
			return -1;
		} else {
			return 0;
		}
	}

}
