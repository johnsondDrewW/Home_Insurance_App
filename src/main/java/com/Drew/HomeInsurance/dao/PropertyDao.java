package main.java.com.Drew.HomeInsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.java.com.Drew.HomeInsurance.Model.Property;

public class PropertyDao {
	public List<Property> GetProperties() throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Property property = null;
		
		List<Property> allProperties = null;
		
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
			String qString = "SELECT * FROM Property_Location";
			
			rs = stmt.executeQuery(qString);
			
			allProperties = new ArrayList<Property>();
			while(rs.next()) {
				property = new Property();
				property.setPL_ID(rs.getInt("PL_ID"));
				property.setUser_Name(rs.getString("User_Name"));
				property.setOwner_Email(rs.getString("Owner_Email"));
				property.setLocation_Type(rs.getString("Location_Type"));
				property.setAddress1(rs.getString("Address1"));
				property.setAddress2(rs.getString("Address2"));
				property.setCity(rs.getString("City"));
				property.setLocation_State(rs.getString("Location_State"));
				property.setZip(rs.getInt("Zip"));
				property.setLocation_Use(rs.getString("Location_Use"));
				property.setMarket_Value(rs.getDouble("Market_Value"));
				property.setSquare_Footage(rs.getInt("Square_Footage"));
				property.setNumber_Floors(rs.getString("Number_Floors"));
				property.setRoof_Material(rs.getString("Roof_Material"));
				property.setDetached_Garage(rs.getString("Detached_Garage"));
				property.setFull_Baths(rs.getString("Full_Baths"));
				property.setHalf_Baths(rs.getString("Half_Baths"));
				property.setPool(rs.getString("Pool"));
				property.setYear(rs.getInt("Year"));
				allProperties.add(property);
			}
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println("error: unable to load driver class");
			e.printStackTrace();
		//	System.exit(1);
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		
		return allProperties;
	}
	public int RegisterProperty(Property p) throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String qString = "INSERT INTO Property_Location("
						+ "Owner_Email, User_Name, Location_Type, Address1,"
						+ "Address2, City, Location_State, Zip, Location_Use,"
						+ "Market_Value, Square_Footage, Number_Floors, Roof_Material,"
						+ "Detached_Garage, Full_Baths, Half_Baths, Pool, Year"
						+ ")Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int ID = -1;
		String[] COL = {"PL_ID"}; // for Auto Incremented ID
		
		try{
		
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.prepareStatement(qString, COL);
			
			
			stmt.setString(1,p.getOwner_Email());
			stmt.setString(2,p.getUser_Name());
			stmt.setString(3,p.getLocation_Type());
			stmt.setString(4,p.getAddress1());
			stmt.setString(5,p.getAddress2());
			stmt.setString(6,p.getCity());
			stmt.setString(7,p.getLocation_State());
			stmt.setInt(8,p.getZip());
			stmt.setString(9,p.getLocation_Use());
			stmt.setDouble(10,p.getMarket_Value());
			stmt.setInt(11,p.getSquare_Footage());
			stmt.setString(12,p.getNumber_Floors());
			stmt.setString(13,p.getRoof_Material());
			stmt.setString(14,p.getDetached_Garage());
			stmt.setString(15,p.getFull_Baths());
			stmt.setString(16,p.getHalf_Baths());
			stmt.setString(17,p.getPool());
			stmt.setInt(18,p.getYear());
			ID=stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();  //for auto increment ID
			if(rs != null &&rs.next())
			{
				ID = rs.getInt(1);
			}
			System.out.println(ID);
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println("error: unable to load driver class");
			e.printStackTrace();
		//	System.exit(1);
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		
		return ID;
	}
	public int RemoveProperty(int id) throws SQLException, IOException{
		//creating the connnection variable
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String qString = "DELETE FROM Property_Location WHERE PL_ID = ?";
		
		
		int RowsAffected = -1;//if it stays -1 the query did not run
		//String[] COL = {"User_Id"}; // for Auto Incremented ID
		
		try{
		
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.prepareStatement(qString);
			
			
			stmt.setInt(1, id);
			RowsAffected=stmt.executeUpdate();//if runs will return the number of rows affected
//			rs = stmt.getGeneratedKeys();  //for auto increment ID
//			if(rs != null &&rs.next())
//			{
//				ID = rs.getInt("User_ID");
//			}
//			
			System.out.println(RowsAffected);
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println("error: unable to load driver class");
			e.printStackTrace();
		//	System.exit(1);
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		
		return RowsAffected;
	}
	
	public HashMap<Integer, Property> GetPropertyByUser(String userEmail) throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Property property = new Property();
		HashMap<Integer, Property> properties = new HashMap<Integer, Property>();
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
					
			String qString = "Select * FROM Property_Location Where User_Name = '"+userEmail+"'";
			
			rs = stmt.executeQuery(qString);
			
			while(rs.next()) {
				property = new Property();
				property.setPL_ID(rs.getInt(1));
				property.setOwner_Email(rs.getString("Owner_Email"));
				property.setUser_Name(rs.getString("User_Name"));
				property.setLocation_Type(rs.getString("Location_Type"));
				property.setAddress1(rs.getString("Address1"));
				property.setAddress2(rs.getString("Address2"));
				property.setCity(rs.getString("City"));
				property.setLocation_State(rs.getString("Location_State"));
				property.setZip(rs.getInt("Zip"));
				property.setLocation_Use(rs.getString("Location_Use"));
				property.setMarket_Value(rs.getDouble("Market_Value"));
				property.setSquare_Footage(rs.getInt("Square_Footage"));
				property.setNumber_Floors(rs.getString("Number_Floors"));
				property.setRoof_Material(rs.getString("Roof_Material"));
				property.setDetached_Garage(rs.getString("Detached_Garage"));
				property.setFull_Baths(rs.getString("Full_Baths"));
				property.setHalf_Baths(rs.getString("Half_Baths"));
				property.setPool(rs.getString("Pool"));
				property.setYear(rs.getInt("Year"));
				properties.put(property.getPL_ID(), property);
				
			}
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println("error: unable to load driver class");
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		
		return properties;
	}
}
