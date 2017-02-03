package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sun.net.smtp.SmtpClient;

public class OrderManager extends BaseDAO {

	/*
	 */
	@SuppressWarnings("finally")
	public OrderList returnOrder(User user) {
		OrderList orderList = new OrderList();
		String accountname = user.getACCOUNTNAME();
		String SQL = "Select * from TBL_ORDER where ACCOUNTNAME = ?";
		try {
			PreparedStatement smt = database.prepareStatement(SQL);
			smt.setString(1, accountname);
			ResultSet rs = smt.executeQuery();
			while (rs.next()) {
				
				Order order = new Order();

				//System.out.println("mabimabi");
				order.setID(Integer.toString(rs.getInt("PrimekyNumber")));
				order.setACCOUNTNAME(rs.getString("ACCOUNTNAME"));
				order.setLocation(rs.getString("Location"));
				order.setShowingDate(rs.getDate("ShowingDate"));
				order.setShowingTime(rs.getTime("ShowingTime"));
				order.setTickets(rs.getString("tickets"));
				order.setTitle(rs.getString("Title"));
				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return orderList;
		}
	}
	
	
	
	
}
