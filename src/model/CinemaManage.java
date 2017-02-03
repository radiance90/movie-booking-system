package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaManage extends BaseDAO {
	public CinemaList findall() {
		CinemaList listc = new CinemaList();
		String SQL = "Select * from TBL_CINEMA";

		PreparedStatement stmnt;
		try {
			stmnt = database.prepareStatement(SQL);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String locationString = rs.getString("Location");// Location
				String capacity = rs.getString("Capacity"); // Capacity
				String amenitieString = rs.getString("Amenities"); // Amenities
				Cinema cinema = new Cinema(locationString, capacity,
						amenitieString);
				listc.add(cinema);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 在这里直接就搞定了
		finally {
			return listc;
		}
	}

	/*
	 * ������cinemas
	 */
	public boolean addCinema(Cinema cinema) {
		// here insert into the database
		boolean check = false;
		String Location = cinema.getLocation();
		String capacity = cinema.getCapacity();
		String amenitie = cinema.getAmenities();
		String SQL = "insert into TBL_CINEMA VALUES(?,?,?)";

		try {
			PreparedStatement stm = database.prepareStatement(SQL);

			stm.setString(1, Location);
			stm.setString(2, capacity);
			stm.setString(3, amenitie);

			stm.executeUpdate();
			check = true;
			stm.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return check;
		}
	}

}
