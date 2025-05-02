package edu.pucp.mechatronics.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	Connection con;
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //register driver
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab01","root","TianXiWei@36yi");
		}
		catch (Exception e) {
			System.err.println("Error: "+e);
		}
	}
	public Connection getConnection() {
		return con;
	}
}
