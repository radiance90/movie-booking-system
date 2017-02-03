package model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie movie = new Movie("UP");
		movie.setTitle("UP");
		
		CommentManager manager = new CommentManager();
		System.out.println(manager.findSpecialMovie(movie).size());
		
		
	}

}
