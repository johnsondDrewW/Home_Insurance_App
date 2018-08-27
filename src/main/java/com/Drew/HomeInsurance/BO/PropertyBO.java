package main.java.com.Drew.HomeInsurance.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.java.com.Drew.HomeInsurance.Model.Property;
import main.java.com.Drew.HomeInsurance.dao.PropertyDao;

public class PropertyBO {
	public List<Property> getAllPropertys() throws SQLException, IOException {
		List<Property> allPropertys = new ArrayList<Property>();
		PropertyDao PDao = new PropertyDao();
		return allPropertys = PDao.GetProperties();
	}
	
	public int RegisterProperty(Property u) throws SQLException, IOException {
		PropertyDao UTDao = new PropertyDao();
		return UTDao.RegisterProperty(u);
	}
	
	public HashMap<Integer, Property> GetPropertyByUser(String userEmail) throws SQLException, IOException {
		PropertyDao UTDao = new PropertyDao();
		return UTDao.GetPropertyByUser(userEmail);
	}
	public int RemoveByName(int id) throws SQLException, IOException {
		PropertyDao UTDao = new PropertyDao();
		return UTDao.RemoveProperty(id);
	}
	public static void main(String[] args) throws SQLException, IOException {
		PropertyBO bo = new PropertyBO();
	
	}
}
