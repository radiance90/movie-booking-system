package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import com.sun.org.apache.regexp.internal.recompile;

public class CommentManager extends BaseDAO {

	public CommentList findAll() {
		return null;
	}

	/*
	 * 这个地方 是单个 movie的 comments 这个是要添加到movie后面的
	 */
	@SuppressWarnings("finally")
	public CommentList findSpecialMovie(Movie movie) {
		String title = movie.getTitle();
		CommentList listComSpecial = new CommentList();
		try {
			String sql = "SELECT * FROM TBL_COMENTS WHERE Title = '" + title
					+ "'";
			PreparedStatement stmnt = database.prepareStatement(sql); // 在这里直接就搞定了
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String nICKNAME = rs.getString("NICKNAME");
				Date cOMDATE = rs.getDate("COMDATE");
				String Reviews = rs.getString("Reviews");
				String RATING = rs.getString("RATING");
				String Title = rs.getString("Title");

				Time COMTIME = rs.getTime("COMTIME");

				Comment comment = new Comment(nICKNAME, RATING, Title, cOMDATE,
						COMTIME, Reviews);

				listComSpecial.add(comment);
				System.out.println(Reviews);
			}
			stmnt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return listComSpecial;
		}
	}

	// add comment(String movie.title, String nickname, String newcomment, int
	// rating)
	// #TODO rating 告诉憨鸡鸡 是 string类型
	// it is just a insert fangfa
	@SuppressWarnings("finally")
	public boolean addComment(String title, String nickname, String newcomment,
			String rating) {
		// NICKNAME varchar(20) not null,
		// RATING VARCHAR(1) NOT NULL,
		// Title varchar(40) not null,
		// COMDATE DATE not null,
		// COMTIME time not null,
		// Reviews varchar(1000) not null,
		try {
			System.out.println(title + nickname + newcomment + rating);
			String sqlQueryString = "INSERT INTO TBL_COMENTS VALUES (?,?,?,CURRENT_DATE,CURRENT_TIME,?)";
			// sqlQueryString =
			// "INSERT INTO TBL_COMENTS VALUES ('qiaofeng','3','UP',CURRENT_DATE,CURRENT_TIME,'wagaga')";
			PreparedStatement smt = database.prepareStatement(sqlQueryString);
			smt.setString(1, nickname);
			smt.setString(2, rating);
			smt.setString(3, title);
			smt.setString(4, newcomment);

			smt.executeUpdate();

			System.out.println("nimabi");

			// then update the table of movie

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return false;
		}
	}

}
