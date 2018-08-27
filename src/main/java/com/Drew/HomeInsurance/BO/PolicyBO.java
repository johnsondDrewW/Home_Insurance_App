package main.java.com.Drew.HomeInsurance.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.java.com.Drew.HomeInsurance.Model.Policy;
import main.java.com.Drew.HomeInsurance.dao.PolicyDao;

public class PolicyBO {
	public List<Policy> getAllPolicys() throws SQLException, IOException {
		List<Policy> allPolicys = new ArrayList<Policy>();
		PolicyDao PDao = new PolicyDao();
		return allPolicys = PDao.GetAllPolicies();
	}
	
	public int RegisterPolicy(Policy u) throws SQLException, IOException {
		PolicyDao UTDao = new PolicyDao();
		return UTDao.RegisterPolicy(u);
	}
	
	public HashMap<Integer,Policy> GetPolicyByUser(String userEmail) throws SQLException, IOException {
		PolicyDao PDao = new PolicyDao();
		return PDao.GetPolicyByUser(userEmail);
	}
	public void UpdatePolicy(Policy p) throws SQLException, IOException {
		PolicyDao PDao = new PolicyDao();
		PDao.UpdatePolicy(p);
	}
	public int RemovePolicyByID(int id) throws SQLException, IOException {
		PolicyDao PDao = new PolicyDao();
		return PDao.RemovePolicy(id);
	}
	public static void main(String[] args) throws SQLException, IOException {
		PolicyBO bo = new PolicyBO();
	
	}


}
