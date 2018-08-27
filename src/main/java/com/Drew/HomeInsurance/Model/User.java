package main.java.com.Drew.HomeInsurance.Model;

public class User {
	
	private String User_Name;
	private String Password;
	private String Role;
	
//---------------------------------------Constructor----------------------------------------------//
	public User() {}
	public User(String inputUserName,String inputPassword) {
		User_Name = inputUserName;
		Password = inputPassword;
	}
	public User(String inputUserName,String inputPassword,String inputRole) {
		User_Name = inputUserName;
		Password = inputPassword;
		Role = inputRole;
	}
	public User(User copyUser) {
		User_Name = copyUser.User_Name;
		Password = copyUser.Password;
		Role = copyUser.Role;
	}
	
//---------------------------------------Getters----------------------------------------------//
public void setUserName(String inputUserName)
	{
		User_Name = inputUserName;
	}
	public void setPassword(String inputPassword) {
		Password = inputPassword;
	}
	public void setRole(String inputRole) {
		Role = inputRole;
	}
//---------------------------------------Getters----------------------------------------------//
	public String getUserName()
	{
		return User_Name;
	}
	public String getPassword() {
		return Password;
	}
	public String getRole() {
		return Role;
	}

	public boolean validateInput() {
		String regex = "^[a-zA-z0-9\\.,_]+@[a-zA-z0-9,_]+\\.[a-zA-z0-9,_]+$";
		
		if(User_Name== null || !User_Name.matches(regex)) {
			return false;
		}
		regex = "^(?!=[^a-zA-Z0-9])(?=[a-zA-z1-9]).{8,16}$";
		if(Password == null||!Password.matches(regex)) {
			return false;
		}
		
		return true;
	}

	public boolean validateReg(String repw) {
		String regex = "^[a-zA-z0-9\\.,_]+@[a-zA-z0-9,_]+\\.[a-zA-z0-9,_]+$";
		
		if(User_Name== null || !User_Name.matches(regex)) {
			return false;
		}
		regex = "^(?!=[^a-zA-Z0-9])(?=[a-zA-z1-9]).{8,16}$";
		if(Password == null||!Password.matches(regex)) {
			return false;
		}
		if(!repw.equals(Password))
		{
			return false;
		}
		
		return true;
	}

}


