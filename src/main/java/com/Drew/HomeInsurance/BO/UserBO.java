package main.java.com.Drew.HomeInsurance.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import main.java.com.Drew.HomeInsurance.Model.User;
import main.java.com.Drew.HomeInsurance.dao.UserTableDao;

public class UserBO {

	public List<User> getAllUsers() throws SQLException, IOException {
		List<User> allUsers = new ArrayList<User>();
		UserTableDao UTDao = new UserTableDao();
		return allUsers = UTDao.GetAllUsers();
	}
	
	public int RegisterUser(User u) throws SQLException, IOException {
		UserTableDao UTDao = new UserTableDao();
		return UTDao.RegisterUsers(u);
	}
	
	public User GetUserByName(String inputName) throws SQLException, IOException {
		UserTableDao UTDao = new UserTableDao();
		return UTDao.GetUserByName(inputName);
	}
	public int RemoveByName(String inputName) throws SQLException, IOException {
		UserTableDao UTDao = new UserTableDao();
		return UTDao.RemoveUsers(inputName);
	}
//	public static void main(String[] args) throws SQLException, IOException {
//		UserBO bo = new UserBO();
//		
//		bo.RegisterUser(new User("Slop","pool"));
////		
////		for(User u:bo.getAllUsers()) {
////			System.out.println(u.getUserName()+u.getPassword().hashCode());
////		}
//		System.out.println("rows affected"+bo.RemoveByName("Johnson.drew.w@gmail.com"));
//	}
}
