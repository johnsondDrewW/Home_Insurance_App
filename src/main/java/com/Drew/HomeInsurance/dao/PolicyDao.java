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
import main.java.com.Drew.HomeInsurance.Model.Policy;
import main.java.com.Drew.HomeInsurance.Model.User;

public class PolicyDao {
	public List<Policy> GetAllPolicies() throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Policy policy = null;
		
		List<Policy> allPolicies = null;
		
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
			String qString = "SELECT * FROM INS_Policy";
			
			rs = stmt.executeQuery(qString);
			
			allPolicies = new ArrayList<Policy>();
			while(rs.next()) {
				policy = new Policy();
				policy.setPolicy_ID(rs.getInt("Policy_ID"));
				policy.setPL_ID(rs.getInt("PL_ID"));
				policy.setOwner_Email(rs.getString("Owner_Email"));
				policy.setStatus(rs.getString("Status"));
				policy.setUser_Name(rs.getString("User_Name"));
				policy.setStart(rs.getDate("Start_Date"));
				allPolicies.add(policy);
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
		
		return allPolicies;
	}
	public int RegisterPolicy(Policy p) throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		
		String qString = "INSERT INTO INS_Policy"+
						"(PL_ID,Owner_Email, User_Name, STATUS)"+
						"Values(?,?,?,?)";
		int ID = -1;
		String[] COL = {"Policy_Id"}; // for Auto Incremented ID
		
		try{
		
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.prepareStatement(qString,COL);
			
			stmt.setInt(1, p.getPL_ID());
			stmt.setString(2, p.getOwner_Email());
			stmt.setString(3, p.getUser_Name());
			stmt.setString(4, p.getStatus());
			System.out.println();
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();  //for auto increment ID
			if(rs != null &&rs.next())
			{
				ID = rs.getInt(1);
			}
//			
			System.out.println(ID);
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
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
	public int RemovePolicy(int id) throws SQLException, IOException{
		//creating the connnection variable
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String qString = "DELETE FROM INS_Policy WHERE Policy_ID = ?";
		
		
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
	public HashMap<Integer,Policy> GetPolicyByUser(String userEmail) throws SQLException, IOException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Policy policy = null;
		HashMap<Integer,Policy> policies = new HashMap<Integer,Policy>();
		try{
			OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
			stmt = conn.createStatement();
					
			String qString = "Select * FROM INS_Policy Where User_Name = '"+userEmail+"'";
			
			rs = stmt.executeQuery(qString);
			
			while(rs.next()) {
				policy = new Policy();
				policy.setPolicy_ID(rs.getInt("Policy_ID"));
				policy.setPL_ID(rs.getInt("PL_ID"));
				policy.setOwner_Email(rs.getString("Owner_Email"));
				policy.setStatus(rs.getString("Status"));
				policy.setUser_Name(rs.getString("User_Name"));
				policy.setStart(rs.getDate("Start_Date"));
				policy.setTerm(rs.getInt("Term_Length"));
				policies.put(policy.getPolicy_ID(), policy);
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
		
		return policies;
	}
	public void UpdatePolicy(Policy p) throws SQLException {
		
		Connection conn = null;
        PreparedStatement stmt = null;
        
        String updatePolicy = "UPDATE INS_Policy SET Status = '"+ p.getStatus()+"' , Start_Date = date '"+p.getStart()+ "' , TERM_LENGTH =" +p.getTerm()
                + " WHERE Policy_Id ="+p.getPolicy_ID();
        System.out.println(updatePolicy);
        try
        {
        	OracleSqlConnection connection = new OracleSqlConnection();
			conn = connection.getConnection();
            stmt = conn.prepareStatement(updatePolicy);
            stmt.executeQuery();
            
        }
        catch (ClassNotFoundException | IOException | SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			 
		}
		
	}
}
