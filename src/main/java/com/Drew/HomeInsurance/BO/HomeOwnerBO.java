package main.java.com.Drew.HomeInsurance.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.java.com.Drew.HomeInsurance.Model.HomeOwner;
import main.java.com.Drew.HomeInsurance.dao.HomeOwnerDao;
public class HomeOwnerBO {
	public List<HomeOwner> getAllHomeOwners() throws SQLException, IOException {
		List<HomeOwner> allHomeOwners = new ArrayList<HomeOwner>();
		HomeOwnerDao OwnerDao = new HomeOwnerDao();
		return allHomeOwners = OwnerDao.GetAllHomeOwners();
	}
	
	public int RegisterOwner(HomeOwner owner) throws SQLException, IOException {
		HomeOwnerDao OwnerDao = new HomeOwnerDao();
		return OwnerDao.RegisterHomeOwner(owner);
	}
	
	public HashMap<String,HomeOwner> GetHomeOwnerByUser(String inputEmail) throws SQLException, IOException {
		HomeOwnerDao OwnerDao = new HomeOwnerDao();
		return OwnerDao.getHomeOwnerByUser(inputEmail);
	}
	public HomeOwner GetHomeOwnerByEmail(String inputEmail) throws SQLException, IOException {
		HomeOwnerDao OwnerDao = new HomeOwnerDao();
		return OwnerDao.getHomeOwnerByEmail(inputEmail);
	}
	public int RemoveByName(String inputName) throws SQLException, IOException {
		HomeOwnerDao OwnerDao = new HomeOwnerDao();
		return OwnerDao.RemoveHomeOwner(inputName);
	}
}
