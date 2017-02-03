package model;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * This is used managing on Movie
 * such as : search movie
 * adding comments
 * 这个就是单纯的对list进行操作,获取需要的信息,很简单
 * 但是把单纯的arraylist升级成了高端的movielist
 */


public class MovieList extends ArrayList<Movie>{
	
	//根据用户输入的moive名字来返回查询结果
	//detail 就直接在这个里面进行处理啦
	public Movie getByUserName(String title){
		Movie movies = new Movie();
		for(Movie movie : this){
			if(movie.getTitle().equals(title)){
				movies =  movie;
			}
		}
		
		return movies;
	}


	

	
	

}
