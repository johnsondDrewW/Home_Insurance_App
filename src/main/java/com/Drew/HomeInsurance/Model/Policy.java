package main.java.com.Drew.HomeInsurance.Model;

import java.sql.Date;
import java.util.Calendar;

public class Policy {
	private int Policy_ID;
	private int PL_ID;
	private String Owner_Email;
	private String User_Name;
	private String Status;
	private Date Start;
	private int Term;
	

	//---------------Constructor--------------------
	public Policy() {
		super();
	}

	public Policy(int policy_ID, int pL_ID, String owner_Email, String user_Name, String status, Date date, int term) {
		super();
		Policy_ID = policy_ID;
		PL_ID = pL_ID;
		Owner_Email = owner_Email;
		User_Name = user_Name;
		Status = status;
		Start = date;
		Term = term;
	}



	///---------------------getters------------
	public int getPolicy_ID() {
		return Policy_ID;
	}
	public int getPL_ID() {
		return PL_ID;
	}
	public String getOwner_Email() {
		return Owner_Email;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public String getStatus() {
		return Status;
	}
	public Date getStart() {
		return Start;
	}
	public int getTerm() {
		return Term;
	}
	////-------------------Setters------------------
	public void setPolicy_ID(int policy_ID) {
		Policy_ID = policy_ID;
	}
	public void setPL_ID(int pL_ID) {
		PL_ID = pL_ID;
	}
	public void setOwner_Email(String owner_Email) {
		Owner_Email = owner_Email;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public void setStart(Date start) {
		Start = start;
	}
	public void setTerm(int term) {
		Term = term;
	}
	
	public boolean validate() {
		int validPeriod = 60;//in days
		int conversion =(1000*3600*24);
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		if((Start.getTime()-Calendar.getInstance().getTimeInMillis())>(validPeriod*conversion)||(Start.getTime()-Calendar.getInstance().getTimeInMillis()<0))
		{
			return false;
		}
		if(Policy_ID <=0) {
			return false;
		}
		if(PL_ID <=0) {
			return false;
		}
		if(Owner_Email==null||Owner_Email.isEmpty()) {
			return false;
		}
		if(User_Name==null||User_Name.isEmpty()) {
			return false;
		}
		if(Status==null||Status.isEmpty()) {
			return false;
		}
		
		return true;
	}

}
