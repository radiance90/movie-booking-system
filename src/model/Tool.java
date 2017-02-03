package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Tool {

	public static ArrayList<String> removeDupLocation(
			ArrayList<String> locationList) {

		System.out.println("movie list lentgh = :" + locationList.size());
		ArrayList<String> newList = new ArrayList<String>();
		for (Iterator iter = locationList.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			if (alreadyLocation(newList, element)) {

			} else {
				newList.add(element);
			}

		}

		System.out.println("movie list lentgh = :" + newList.size());

		return newList;
	}

	private static boolean alreadyLocation(ArrayList<String> newList,
			String element) {
		// TODO Auto-generated method stub
		boolean fuck = false;
		for(Iterator<String> iterator = newList.iterator();iterator.hasNext();){
			if(((String)iterator.next()).equals(element)){
				fuck = true;
			}
		}
		return fuck;
	}

	public static MovieList getNowShowing(MovieList list) {
		MovieList listmovie = new MovieList();

		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = sDateFormat.format(new java.util.Date());
		

		for (Iterator<Movie> iterator = list.iterator(); iterator.hasNext();) {
			Movie mmMovie = iterator.next();
			// System.out.println("\n\n"+mmMovie.getRelaseDate());
			// System.out.println(new java.util.Date());
			if (!mmMovie.getRelaseDate().after(new java.util.Date())) {
				listmovie.add(mmMovie);
			}
		}

		Collections.sort(listmovie);

		// for(Iterator<Movie> iterator =
		// listmovie.iterator();iterator.hasNext();){
		// System.out.println(iterator.next().getTitle());
		// }

		return listmovie;
	}

	public static ArrayList<MovieCopy> getComingSoon(MovieList list) {
		ArrayList<MovieCopy> listmove = new ArrayList<MovieCopy>();

		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = sDateFormat.format(new java.util.Date());

		for (Iterator<Movie> iterator = list.iterator(); iterator.hasNext();) {
			Movie mmMovie = iterator.next();
			// System.out.println("\n\n"+mmMovie.getRelaseDate());
			// System.out.println(new java.util.Date());
			if (mmMovie.getRelaseDate().after(new java.util.Date())) {
				MovieCopy e = new MovieCopy(mmMovie);

				listmove.add(e);
			}
		}
		Collections.sort(listmove);
		for (Iterator<MovieCopy> iterator = listmove.iterator(); iterator
				.hasNext();) {
			MovieCopy e = iterator.next();
			System.out.println(e.getTitle());
		}
		return listmove;
	}

	public static MovieList removeDuplicateWithOrder(MovieList list) {
		System.out.println("movie list lentgh = :" + list.size());
		MovieList newList = new MovieList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Movie element = (Movie) iter.next();
			if (hasMovie(newList, element)) {

			} else {
				newList.add(element);
			}

		}

		System.out.println("movie list lentgh = :" + newList.size());
		return newList;
	}

	private static boolean hasMovie(MovieList newList, Movie compare) {
		// TODO Auto-generated method stub
		boolean has = false;
		for (Iterator iter = newList.iterator(); iter.hasNext();) {
			Movie element = (Movie) iter.next();
			if (element.getTitle().equals(compare.getTitle())) {
				has = true;
			}
		}

		return has;
	}

}
