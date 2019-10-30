package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

	public void login(String system,String user,String pass,Connection conn) {
		try {
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");
			conn = DriverManager.getConnection("jdbc:as400://"+system, user, pass);
		}
		catch (ClassNotFoundException cnf) {
		    System.out.println("ERROR: One of the JDBC drivers did not load.");
		}
		catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
