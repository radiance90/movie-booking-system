package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sun.awt.geom.AreaOp.IntOp;
import sun.net.smtp.SmtpClient;

/*
 */
public class ShowManage extends BaseDAO {

	@SuppressWarnings("finally")
	public ShowList showAllTime(String date, String location, String movieTitle) {

		ShowList listShowList = new ShowList();

		String findListSQL = "select * from TBL_SHOWTIME where UPPER(Title) = ? and Location = ? and ShowingDate = ?";

		try {
			PreparedStatement preparedStatement = database
					.prepareStatement(findListSQL);
			preparedStatement.setString(1, movieTitle);
			preparedStatement.setString(2, location);
			preparedStatement.setString(3, date);

			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				String Title = set.getString("Title");
				String Location = set.getString("Location");
				;
				String SeatLeft = set.getString("SeatLeft");
				;
				Date DateSHow = set.getDate("ShowingDate");
				;
				Time ShowingTime = set.getTime("ShowingTime");

				Show neShow = new Show(Title, Location, SeatLeft, DateSHow,
						ShowingTime);
				listShowList.add(neShow);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return listShowList;
		}
	}

	@SuppressWarnings("finally")
	public ShowList findList(Movie movie, String date) {
		// obtain a list of cinemas that the movie is playing at and their
		// showtimes for a particular date
		ShowList listShow = new ShowList();
		java.sql.Date date2 = java.sql.Date.valueOf(date);

		String sqlQueryString = "Select * from TBL_SHOWTIME where Title = ? and ShowingDate = ?";
		String title = movie.getTitle();

		PreparedStatement stmt;
		try {
			stmt = database.prepareStatement(sqlQueryString);
			stmt.setString(1, title);
			stmt.setDate(2, date2);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Show movieShow = new Show();
				movieShow.setDateSHow(date2);
				movieShow.setLocation(rs.getString("Location"));
				movieShow.setTitle(title);
				movieShow.setSeatLeft(rs.getString("SeatLeft"));
				movieShow.setShowing(rs.getTime("ShowingTime"));

				listShow.add(movieShow);
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			return listShow;
		}
	}

	/*
	 * this is add showing time for each movie
	 */
	// The owner adds the cinema(s) and the showtimes for the movie at each
	// cinema.

	@SuppressWarnings("finally")
	public boolean addShowing(String location, Date date, String time,
			String title) {
		// first get the seats in the cinema

		boolean stat = false;
		String SQLSeats = "select CAPACITY from TBL_CINEMA where LOCATION = ?";
		String seat = null;
		try {
			PreparedStatement stm = database.prepareStatement(SQLSeats);
			stm.setString(1, location);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				seat = rs.getString("CAPACITY");
			}
			stm.close();

			String SQL = "insert into TBL_SHOWTIME values(default,?,?,?,?,?)";

			PreparedStatement stmsP = database.prepareStatement(SQL);

			stmsP.setString(1, title);
			stmsP.setString(2, location);
			stmsP.setString(3, seat);
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dates = sDateFormat.format(date);
			stmsP.setString(4, dates);
			stmsP.setString(5, time);

			stmsP.executeUpdate();
			stmsP.close();
			stat = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return stat;
		}
	}

	/*
	 * 憨鸡鸡要求返回的 但是不知道 还要具体什么
	 */

	@SuppressWarnings("finally")
	public ArrayList<String> findcinema(Movie movie) {
		ArrayList<String> findList = new ArrayList<String>();
		// ShowList listShow = new ShowList();
		// java.sql.Date date2 = java.sql.Date.valueOf(date);

		String sqlQueryString = "Select * from TBL_SHOWTIME where Title = ?";
		String title = movie.getTitle();

		PreparedStatement stmt;
		try {
			stmt = database.prepareStatement(sqlQueryString);
			stmt.setString(1, title);
			// stmt.setDate(2, date2);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Show movieShow = new Show();
				// movieShow.setDateSHow(date2);
				// // movieShow.setLocation(rs.getString("Location"));
				// movieShow.setTitle(title);
				// movieShow.setSeatLeft(rs.getString("SeatLeft"));
				// movieShow.setShowing(rs.getTime("ShowingTime"));

				// listShow.add(movieShow);
				findList.add(rs.getString("Location"));
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return findList;
		}

	}

	@SuppressWarnings("finally")
	public boolean book(Show show, int ticket,String accountName) {
		boolean check = false;
		String ACCOUNTNAME = accountName;
		String tittle = show.getTitle();
		String tickets = Integer.toString(ticket);
		String leftTicket = Integer.toString(Integer.parseInt(show.SeatLeft)
				- ticket);
		if (Integer.parseInt(leftTicket) < 0) {
			return false;
		} else {
			String Location = show.getLocation();
			Date ShowingDate = show.getDateSHow();
			Time ShowingTime = show.getShowing();

			// put them IntOp oRderIntOp;
			// INSERT INTO TBL_ORDER VALUES
			// (default,'qiaofeng','20','eastgarden','2014-10-29','13:00:00');
			String sqlQueryString = "INSERT INTO TBL_ORDER VALUES (default,?,?,?,?,?,?)";
			// sqlQueryString =
			// "INSERT INTO TBL_COMENTS VALUES ('qiaofeng','3','UP',CURRENT_DATE,CURRENT_TIME,'wagaga')";
			PreparedStatement smt;
			try {
				smt = database.prepareStatement(sqlQueryString);
				smt.setString(1, ACCOUNTNAME);
				smt.setString(2, tittle);
				smt.setString(3, tickets);
				smt.setString(4, Location);
				//Title
				
				SimpleDateFormat sDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd");
				String dates = sDateFormat.format(ShowingDate);
				smt.setString(5, dates);
				smt.setTime(6, ShowingTime);

				smt.executeUpdate();

				smt.close();

				// 下面更新show里面的表

				String updateSQL = "update TBL_SHOWTIME set SeatLeft = ? where Location = ? and ShowingDate = ? and ShowingTime = ?";
				PreparedStatement upStatement = database
						.prepareStatement(updateSQL);
				upStatement.setString(1, leftTicket);
				upStatement.setString(2, Location);

				SimpleDateFormat sDaFormat = new SimpleDateFormat(
						"yyyy-MM-dd");
				String updates = sDaFormat.format(ShowingDate);

				upStatement.setString(3, updates);
				upStatement.setTime(4, ShowingTime);
				check = true;
				upStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// leftTicket
			finally {
				return check;
			}
		}
	}

}
