package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mariadb://localhost/librettovoti?user=root&password=rosy2001";
		Connection conn = DriverManager.getConnection(dbUrl);
		return conn;
	}

}
