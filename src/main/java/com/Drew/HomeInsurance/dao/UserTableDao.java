package main.java.com.Drew.HomeInsurance.dao;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import main.java.com.Drew.HomeInsurance.Model.*;;


public class UserTableDao {
	
	public List<User> GetAllUsers() throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		
		List<User> allUser = null;
		
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
			String qString = "SELECT * FROM User_Table";
			
			rs = stmt.executeQuery(qString);
			
			allUser = new ArrayList<User>();
			while(rs.next()) {
				user = new User();
				user.setUserName(rs.getString("User_Name"));
				user.setPassword(rs.getString("User_Password"));
				user.setRole(rs.getString("User_Role"));
				allUser.add(user);
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
		
		return allUser;
	}
	public int RegisterUsers(User u) throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		
		String qString = "INSERT INTO User_Table"+
						"(User_Name, User_Password,User_Role)"+
						"Values(?,?,?)";
	      
		int ID = -1;
		//String[] COL = {"User_Id"}; // for Auto Incremented ID
		
		try{
		
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.prepareStatement(qString);
			
			
			stmt.setString(1, u.getUserName());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getRole());
			ID=stmt.executeUpdate();
//			rs = stmt.getGeneratedKeys();  //for auto increment ID
//			if(rs != null &&rs.next())
//			{
//				ID = rs.getInt(1);
//			}
//			
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
	public int RemoveUsers(String uName) throws SQLException, IOException{
		//creating the connnection variable
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String qString = "DELETE FROM User_Table WHERE User_Name = ?";
		
		
		int RowsAffected = -1;//if it stays -1 the query did not run
		//String[] COL = {"User_Id"}; // for Auto Incremented ID
		
		try{
		
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.prepareStatement(qString);
			
			
			stmt.setString(1, uName);
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
	public int RemoveUsers(User user) throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String qString = "DELETE FROM User_Table WHERE User_Name = ?";
		
		
		int ID = -1;
		//String[] COL = {"User_Id"}; // for Auto Incremented ID
		
		try{
		
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.prepareStatement(qString);
			
			
			stmt.setString(1,user.getUserName());
			ID=stmt.executeUpdate();
//			rs = stmt.getGeneratedKeys();  //for auto increment ID
//			if(rs != null &&rs.next())
//			{
//				ID = rs.getInt(1);
//			}
//			
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
	public User GetUserByName(String uName) throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user =null;
		
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
					
			String qString = "Select * FROM User_Table Where User_Name = "+"'"+uName+"'";
			
			rs = stmt.executeQuery(qString);
			
			if(rs.next()) {
				user = new User();
				user.setUserName(rs.getString("User_Name"));
				user.setPassword(rs.getString("User_Password"));
				user.setRole(rs.getString("User_Role"));
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
		
		return user;
	}
	
		
}
