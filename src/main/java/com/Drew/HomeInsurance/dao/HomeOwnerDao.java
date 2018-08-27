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

import main.java.com.Drew.HomeInsurance.Model.HomeOwner;

public class HomeOwnerDao {
	
	public List<HomeOwner> GetAllHomeOwners() throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HomeOwner homeOwner = null;
		
		List<HomeOwner> allHomeOwner = null;
		
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
			String qString = "SELECT * FROM Home_Owner";
			
			rs = stmt.executeQuery(qString);
			
			allHomeOwner = new ArrayList<HomeOwner>();
			while(rs.next()) {
				homeOwner = new HomeOwner();
				homeOwner.setOwnerEmail(rs.getString("Owner_Email"));
				homeOwner.setFirstName(rs.getString("First_Name"));
				homeOwner.setLastName(rs.getString("Last_Name"));
				homeOwner.setDOB(rs.getDate("D_O_B"));
				homeOwner.setSSN(rs.getInt("SS#"));
				homeOwner.setUserName(rs.getString("User_name"));
				homeOwner.setRetired(rs.getString("Retired"));
				allHomeOwner.add(homeOwner);
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
		
		return allHomeOwner;
	}
	
	public HashMap<String,HomeOwner> getHomeOwnerByUser(String email) throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HomeOwner homeOwner = null;
		HashMap<String,HomeOwner> homeOwners = new HashMap<String,HomeOwner>();
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
			String qString = "SELECT * FROM Home_Owner Where User_Name = '"+email+"'";
			
			rs = stmt.executeQuery(qString);
			
			while(rs.next()) {
				homeOwner = new HomeOwner();
				homeOwner.setOwnerEmail(rs.getString("Owner_Email"));
				homeOwner.setFirstName(rs.getString("First_Name"));
				homeOwner.setLastName(rs.getString("Last_Name"));
				homeOwner.setDOB(rs.getDate("D_O_B"));
				homeOwner.setSSN(rs.getInt("SS#"));
				homeOwner.setUserName(rs.getString("User_name"));
				homeOwner.setRetired(rs.getString("Retired"));
				
				homeOwners.put(homeOwner.getOwnerEmail(), homeOwner);
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
		
		return homeOwners;
	}
	public HomeOwner getHomeOwnerByEmail(String email) throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HomeOwner homeOwner = null;
		
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
			String qString = "SELECT * FROM Home_Owner Where Owner_Email = '"+email+"'";
			
			rs = stmt.executeQuery(qString);
			
			if(rs.next()) {
				homeOwner = new HomeOwner();
				homeOwner.setOwnerEmail(rs.getString("Owner_Email"));
				homeOwner.setFirstName(rs.getString("First_Name"));
				homeOwner.setLastName(rs.getString("Last_Name"));
				homeOwner.setDOB(rs.getDate("D_O_B"));
				homeOwner.setSSN(rs.getInt("SS#"));
				homeOwner.setUserName(rs.getString("User_name"));
				homeOwner.setRetired(rs.getString("Retired"));
				
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
		
		return homeOwner;
	}
	public int RegisterHomeOwner(HomeOwner owner) throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String qString = "INSERT INTO Home_Owner"+
						"(Owner_Email,First_Name,Last_Name,D_O_B,SS#,User_Name,Retired)"+
						"Values(?,?,?,?,?,?,?)";
		
		
		int rowsAffected = -1;
		//String[] COL = {"HomeOwner_Id"}; // for Auto Incremented ID
		
		try{
		
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.prepareStatement(qString);
			
			
			stmt.setString(1, owner.getOwnerEmail());
			stmt.setString(2, owner.getFirstName());
			stmt.setString(3, owner.getLastName());
			stmt.setDate(4, owner.getDOB());
			stmt.setInt(5, owner.getSSN());
			stmt.setString(6, owner.getUserName());
			stmt.setString(7, owner.getRetired());
			rowsAffected=stmt.executeUpdate();
//			rs = stmt.getGeneratedKeys();  //for auto increment ID
//			if(rs != null &&rs.next())
//			{
//				ID = rs.getInt(1);
//			}
//			
			System.out.println(rowsAffected);
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
		
		return rowsAffected;
	}
	public int RemoveHomeOwner(String inputName) throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String qString = "DELETE FROM Home_Owner WHERE Owner_Email = ?";
		
		
		int rowsAffected = -1;
		//String[] COL = {"HomeOwner_Id"}; // for Auto Incremented ID
		
		try{
		
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.prepareStatement(qString);
			
			
			stmt.setString(1, inputName);
			rowsAffected=stmt.executeUpdate();
//			rs = stmt.getGeneratedKeys();  //for auto increment ID
//			if(rs != null &&rs.next())
//			{
//				ID = rs.getInt(1);
//			}
//			
			System.out.println(rowsAffected);
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
		
		return rowsAffected;
	}
}
