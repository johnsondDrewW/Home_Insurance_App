package main.java.com.Drew.HomeInsurance.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class OracleSqlConnection {
	public Connection getConnection() throws ClassNotFoundException,
	IOException, SQLException {
	final Properties prop = new Properties();
	final InputStream inputStream = OracleSqlConnection.class.getClassLoader()
			.getResourceAsStream(
					"properties/DB.Properties");
	prop.load(inputStream); 
	Class.forName(prop.getProperty("driver"));
	final Connection connection = DriverManager.getConnection(prop.getProperty("url"), 
			prop.getProperty("user"), prop.getProperty("password"));
	return connection;
	}
}
