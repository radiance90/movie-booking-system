package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class UserManager extends BaseDAO {
	private static UserManager instance = null;
	static Logger logger = Logger.getLogger(UserManager.class.getName());

	@SuppressWarnings("finally")
	public boolean addUser(User user) {
		boolean status = false;
		PreparedStatement stmnt = null;

		String accountname = user.getACCOUNTNAME();
		String password = user.getPASSWORD();
		String email = user.getEMAIL();
		String statsus = "no";

		System.out.println("e  :" + accountname);
		try {
			String sqlStr = "INSERT INTO TBL_USR  VALUES (?,?,?,?,?,?,?,?,?,'no','1')";
			stmnt = database.prepareStatement(sqlStr);
	
			
			stmnt.setString(1, user.getACCOUNTNAME());
			stmnt.setString(2, user.getPASSWORD());
			stmnt.setString(3, user.getEMAIL());
			stmnt.setString(4, "");
			stmnt.setString(5, "");
			stmnt.setString(6, "");
			stmnt.setString(7, "");
			stmnt.setString(8, "");
			stmnt.setString(9, "");
			
			logger.info("sql string is " + sqlStr);
			int result = stmnt.executeUpdate();
			logger.info("Statement successfully executed " + result);
			status = true;
			// stmnt.close();
		} catch (Exception e) {
			logger.severe("Unable to add user! ");
			e.printStackTrace();
		} finally {
			return status;
		}

	}

	// TODO ���������check���������
	// ������������role ���������������������������������������
	// 1 ������ 0 ������������ -1 ������������������
	public int loginUser(String userName, String password) {
		int status = -1;
		try {

			String sqlStr = "Select * from TBL_USR where ACCOUNTNAME =" + "\'"
					+ userName + "\'"; // ������������������
			logger.info("sql string is : " + sqlStr);
			PreparedStatement stmnt = database.prepareStatement(sqlStr);
			// ResultSet rs = stmnt.executeQuery();
			ResultSet log_rs = stmnt.executeQuery();
			boolean hasUser = log_rs.next();
			if (hasUser) {
				String realPassword = log_rs.getString("PASSWORD");
				if (password.equals(realPassword)) {
					status = 1;
					System.out.println("Congustations you are now login");
				} else {
					status = 0;
					System.out.println("Password is not right");
				}
				// ���������������������������,������������������������������
			} else {
				System.out.println("no user exist");
				status = -1;
			}

			stmnt.close();
			// database.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return status;
		}

	}

	/*
	 * here is return
	 */
	@SuppressWarnings("finally")
	public User returnRole(String userName) {

		User user = null;
		try {

			String sqlStr = "Select * from TBL_USR where ACCOUNTNAME =" + "\'"
					+ userName + "\'"; // ������������������
			logger.info("sql string is : " + sqlStr);
			PreparedStatement stmnt = database.prepareStatement(sqlStr);
			// ResultSet rs = stmnt.executeQuery();
			ResultSet log_rs = stmnt.executeQuery();
			if (log_rs.next()) {
				String ACCOUNTNAME = log_rs.getString("ACCOUNTNAME");
				String PASSWORD = log_rs.getString("PASSWORD");
				String EMAIL = log_rs.getString("EMAIL");
				String NICKNAME = log_rs.getString("NICKNAME");
				String FIRSTNAME = log_rs.getString("FIRSTNAME");
				String LASTNAME = log_rs.getString("LASTNAME");
				String birthString = log_rs.getString("BIRTHDAY");
				String FAVOURITEGENRE = log_rs.getString("FAVOURITEGENRE");
				String FAVOURITECAST = log_rs.getString("FAVOURITECAST");
				String status = log_rs.getString("status");
				String ROLE = log_rs.getString("ROLE");
				user = new User(ACCOUNTNAME, PASSWORD, EMAIL, NICKNAME,
						FIRSTNAME, LASTNAME, status, ROLE, birthString,
						FAVOURITEGENRE, FAVOURITECAST);
			} else {
				System.out.println("no user exist");
			}

			stmnt.close();
			// database.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return user;
		}
	}

	// ������������role ���������������������������������������
	// ������������������������ ���������������������������������
	// ���������������������������user
	public boolean loginUser(String userName) {
		boolean status = false;
		try {

			String sqlStr = "Select * from TBL_USR where ACCOUNTNAME =" + "\'"
					+ userName + "\'"; // ������������������
			logger.info("sql string is : " + sqlStr);
			PreparedStatement stmnt = database.prepareStatement(sqlStr);
			// ResultSet rs = stmnt.executeQuery();
			ResultSet log_rs = stmnt.executeQuery();
			boolean hasUser = log_rs.next();
			if (hasUser) {
				status = true;
				// ���������������������������,������������������������������
			} else {
				System.out.println("no user exist");
			}
			stmnt.close();
			// database.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return status;
		}
	}

	/*
	 * ������������������������������������ ������������������������������������
	 * ������������������userID password ��������������� ���������������
	 * ��������� BIRTHDAY VARCHAR(30), -- FAVOURITEGENRE VARCHAR(30),
	 * FAVOURITECAST VARCHAR(30),
	 */
	public boolean updateUser(User user) {
		boolean upStatus = false;
		String accountName = user.getACCOUNTNAME();
		String nickname = user.getNICKNAME();
		String firstname = user.getFIRSTNAME();
		String lastname = user.getLASTNAME();
		String birthday = user.getBIRTHDAY();
		String favourgenre = user.getFAVOURITEGENRE();
		String favourcast = user.getFAVOURITECAST();
		String status = "yes";

		String updateSQL = "update TBL_USR set FIRSTNAME = ? ,LASTNAME = ? , NICKNAME = ?,BIRTHDAY = ?,FAVOURITEGENRE = ?,FAVOURITECAST = ?,status = 'yes' where ACCOUNTNAME = ?";
		System.out.println(updateSQL);
		try {
			PreparedStatement upStatement = database
					.prepareStatement(updateSQL);
			upStatement.setString(1, firstname);
			upStatement.setString(2, lastname);
			upStatement.setString(3, nickname);
			upStatement.setString(4, birthday);
			upStatement.setString(5, favourgenre);
			upStatement.setString(6, favourcast);
			upStatement.setString(7, accountName);

			int rows = upStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("operate successfully");
				upStatus = true;
			}
			upStatement.close();
			// database.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return upStatus;
		}
	}
}
