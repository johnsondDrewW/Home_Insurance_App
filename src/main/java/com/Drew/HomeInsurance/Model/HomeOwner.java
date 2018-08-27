package main.java.com.Drew.HomeInsurance.Model;

import java.sql.Date;
import java.util.Calendar;

public class HomeOwner {
	private String ownerEmail;//PK
	private String firstName;
	private String lastName;
	private String Retired;
	private Date DOB;
	private int SSN;
	private String userName;//FK to USerTable
	
	//------------------------Constructors----------//
	public HomeOwner() {
		super();
	}
	public HomeOwner(String inputOwnerEmail, String inputFirstName, String inputLastName, Date inputDOB, int inputSSN, String inputUserName,String retired) {
		super();
		ownerEmail = inputOwnerEmail;
		firstName = inputFirstName;
		lastName = inputLastName;
		DOB = inputDOB;
		SSN = inputSSN;
		userName = inputUserName;
		Retired = retired;
	}
	
	
	//-----------------------Getters--------------//
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getDOB() {
		return DOB;
	}
	public int getSSN() {
		return SSN;
	}
	public String getUserName() {
		return userName;
	}
	public String getRetired() {
		return Retired;
	}
	
	//-------------------Setters----------------//
	public void setOwnerEmail(String inputOwnerEmail) {
		ownerEmail = inputOwnerEmail;
	}
	public void setFirstName(String inputFirstName) {
		firstName = inputFirstName;
	}
	public void setLastName(String inputLastName) {
		lastName = inputLastName;
	}
	public void setDOB(Date inputDOB) {
		DOB = inputDOB;
	}
	public void setSSN(int inputSSN) {
		SSN = inputSSN;
	}
	public void setUserName(String inputUserName) {
		userName = inputUserName;
	}
	public void setRetired(String retired) {
		Retired = retired;
	}
	
	public boolean validate() {
		if(Calendar.getInstance().getTime().getTime()<=(DOB.getTime())) {
			return false;
		}
		String regex = "^[a-zA-z0-9\\.,_]+@[a-zA-z0-9,_]+\\.[a-zA-z0-9,_]+$";
		if(ownerEmail== null||ownerEmail.isEmpty() || !ownerEmail.matches(regex)) {
			return false;
		}
		if(userName== null||userName.isEmpty() || !userName.matches(regex)) {
			return false;
		}
		if(firstName==null||firstName.isEmpty()) {
			return false;
		}
		if(lastName==null||lastName.isEmpty()) {
			return false;
		}
		if(Retired==null||Retired.isEmpty()) {
			return false;
		}
		if(SSN<=99999999||SSN>=1000000000) {
			return false;
		}
		return true;
	}

}
