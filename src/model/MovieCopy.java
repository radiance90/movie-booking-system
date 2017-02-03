package model;

import java.util.Date;


public class MovieCopy extends BaseMode implements Comparable<MovieCopy> {

	private String Title;
	private String Poster;
	private String actors;
	private String Genre;
	private String Director;
	private String Synopsis;
	private String rating;
	private Date relaseDate;

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this.Title == ((MovieCopy) obj).getTitle()) {
			return true;
		} else {
			return false;
		}
	}

	public MovieCopy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieCopy(String title, String poster, String rating) {
		super();
		Title = title;
		Poster = poster;
		this.rating = rating;
	}

	public MovieCopy(String title, String poster, String actors, String genre,
			String director, String synopsis, String rating, Date relaseDate) {
		super();
		Title = title;
		Poster = poster;
		this.actors = actors;
		Genre = genre;
		Director = director;
		Synopsis = synopsis;
		this.rating = rating;
		this.relaseDate = relaseDate;
	}

	public MovieCopy(Movie mmMovie) {
		// TODO Auto-generated constructor stub
		Title = mmMovie.getTitle();
		Poster = mmMovie.getPoster();
		this.actors = mmMovie.getActors();
		Genre = mmMovie.getGenre();
		Director = mmMovie.getDirector();
		Synopsis = mmMovie.getSynopsis();
		this.rating = mmMovie.getRating();
		this.relaseDate = mmMovie.getRelaseDate();
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
	public int compareTo(MovieCopy o) {
		// TODO Auto-generated method stub
		if (this.getRelaseDate().after(o.getRelaseDate())) {
			return 1;
		} else if (this.getRelaseDate().before(o.getRelaseDate())) {
			return -1;
		} else {
			return 0;
		}
	}

}
