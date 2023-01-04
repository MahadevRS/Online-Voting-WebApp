package Online_Voting_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;


public class DatabaseManager extends HttpServlet {
	public Connection getConnection() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinevotingdb","root","60079@mM");
			return conn;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
