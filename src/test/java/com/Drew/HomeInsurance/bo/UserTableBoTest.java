package test.java.com.Drew.HomeInsurance.bo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.com.Drew.HomeInsurance.BO.UserBO;
import main.java.com.Drew.HomeInsurance.Model.User;

public class UserTableBoTest {
	UserBO u_bo = new UserBO();

	@Test
	public void getUserByNamePosTest() throws SQLException, IOException {

		assertNotNull(u_bo);
		String userName = "Mark@gmail.com";
		assertEquals(userName,u_bo.GetUserByName(userName).getUserName());

	}
	@Test
	public void getUserByNameNegTest() throws SQLException, IOException {

		assertNotNull(u_bo);
		String userName = "Johnson.drew.w@gmail.com";
		assertNull(u_bo.GetUserByName(userName));
	}
	
	
	@Test
	public void getAllUserPosTest() throws SQLException, IOException {
		List<User> userList = new ArrayList<User>();
			userList.add(new User("Mark@gmail.com","123e",null));
			userList.add(new User("bob@gmail.com","556","Admin"));
			userList.add(new User("Snoopy@gmail.com","111",null));
		
		List<User> u_list = new ArrayList<User>();
		u_list = u_bo.getAllUsers();
		assertFalse(u_list.isEmpty());
		
		boolean found;
		
		//iterate thruogh both lists 
		for(User sample:userList) {
			found=false;//defualt false per item
			for(User actual:u_list) {
				if(sample.getUserName().equals(actual.getUserName())){
					assertThat(sample, samePropertyValuesAs(actual));//compares all the values in both objects
					found = true;// found to be true
				}
			}
			assertTrue(found);
		}
	}
	@Test
	public void getAllUserNegTest() throws SQLException, IOException {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("Mark@gmail.com", "556", null));
		userList.add(new User("bob@gmail.com","123e" , "Admin"));
		userList.add(new User("Snoopy@gmail.com", "111", "Admin"));
		userList.add(new User("Johnson.drew.w@gmail.com","123e","Admin"));

		List<User> u_list = new ArrayList<User>();
		u_list = u_bo.getAllUsers();
		assertFalse(u_list.isEmpty());
		for (User sample : userList) {
			for (User actual : u_list) {

				if (sample.getUserName().equals(actual.getUserName())) {
					assertThat(sample, not(samePropertyValuesAs(actual)));
				}
			}
		}

	}
	
	@Test
	public void RegisterUserPosTest() throws SQLException, IOException {
		User user = new User("Mohamad0@gmail.com","GodDaBest",null);
		int result =u_bo.RegisterUser(user);
		assertThat(result, is(not(-1)));
		if(result !=-1)
		{
			u_bo.RemoveByName(user.getUserName());
		}
		
		user.setRole("Admin");
		result =u_bo.RegisterUser(user);
		assertThat(result, is(not(-1)));
		if(result !=-1)
		{
			u_bo.RemoveByName(user.getUserName());
		}
	}
	
	@Test//already registered
	public void RegisterUserNegTest() throws SQLException, IOException {
		User user = new User("Mohamad@gmail.com","GodDaBest",null);
		int result = u_bo.RegisterUser(user);
		assertThat(result, is(-1));
		if(result !=-1)
		{
			u_bo.RemoveByName(user.getUserName());//removing test data in case of failure
		}
	
	}
	@Test//register no name
	public void RegisterUserNegTest2() throws SQLException, IOException {
		User user = new User(null,"GodDaBest",null);
		int result = u_bo.RegisterUser(user);
		assertThat(result, is(-1));
		if(result !=-1)
		{
			u_bo.RemoveByName(user.getUserName());
		}
	
	}
	@Test//register no Password
	public void RegisterUserNegTest3() throws SQLException, IOException {
		User user = new User("Mohamad1@gmail.com",null,null);
		int result = u_bo.RegisterUser(user);
		assertThat(result, is(-1));
		if(result !=-1)
		{
			u_bo.RemoveByName(user.getUserName());
		}
	
	}
	@Test//register weird role
	public void RegisterUserNegTest4() throws SQLException, IOException {
		User user = new User("Mohamad2@gmail.com","GodDaBest","My");
		int result = u_bo.RegisterUser(user);
		assertThat(result, is(-1));
		if(result !=-1)
		{
			u_bo.RemoveByName(user.getUserName());
		}
	
	}
	
	
	@Test
	public void RemoveByNamePosTest() throws SQLException, IOException {
		User user = u_bo.GetUserByName("Mohamad@gmail.com");
		
		assertThat(user, notNullValue());
		
		int result = u_bo.RemoveByName(user.getUserName());
		
		assertThat(result, is(not(-1)));
		assertThat(result, is(not(0)));
		assertThat(u_bo.GetUserByName(user.getUserName()), nullValue());//check deletion of right thing
		if(result > 0) {
			u_bo.RegisterUser(user);
		}
		
	}
	@Test//remove not there... check nothing got messed up
	public void RemoveByNameNegTest() throws SQLException, IOException {
		List<User> beforeL = u_bo.getAllUsers();
		
		User user =new User("If this registers it is bad","CHecking",null);
		int result = u_bo.RemoveByName(user.getUserName());
		
		assertThat(result, is(0));
		assertThat(u_bo.GetUserByName(user.getUserName()), nullValue());
		
		List<User> afterL = u_bo.getAllUsers();
		
		assertThat(beforeL.size(), is( afterL.size()));
		
		boolean found;
		
		for(User before:beforeL) {
				found = false;
			for(User after:afterL) {
				if(before.getUserName().equals(after.getUserName())) {
					assertThat(before, samePropertyValuesAs(after));
					found = true;
				}
			}
			assertTrue(found);
		}
			
	}

}
