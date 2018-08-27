package test.java.com.Drew.HomeInsurance.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import main.java.com.Drew.HomeInsurance.Model.Policy;
import main.java.com.Drew.HomeInsurance.Model.User;
import main.java.com.Drew.HomeInsurance.dao.PolicyDao;

public class PolicyDaoTest {
	PolicyDao p_dao = new PolicyDao();
	@Test
	public void GetAllPoliciesPosTest() throws ParseException, SQLException, IOException {
		List<Policy> sampleL = new ArrayList<Policy>();//giving sample data to be compared against dao DB return
		sampleL.add(new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-01-24").getTime()),0 ));
		
		List<Policy> resultL = p_dao.GetAllPolicies();//gets list of all policies from the data base 
		assertThat(resultL , notNullValue());// assert that  a list is actually returned
		
		boolean found;//this lets us know if we found the primary key
		for(Policy sampleP:sampleL) {
			found = false;//sets found to default of false for each item
			for(Policy resultP:resultL) {
				if(sampleP.getPolicy_ID()==resultP.getPolicy_ID()) {// limits asserts to only if we find the sample data
					found = true;//we found it
					assertThat(sampleP, samePropertyValuesAs(resultP));
				}
			}
			assertTrue(found);//assert that we have found the sample data
		}
		
	}
	@Test
	public void GetAllPoliciesNegTest() throws ParseException, SQLException, IOException {
		List<Policy> sampleL = new ArrayList<Policy>();//giving sample data to be compared against dao DB return
		sampleL.add(new Policy(63,63,"johnson.eew.w@gmail.com",	"Mark@gm1ail.com",	"Canlcled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-24").getTime()),0 ));
		sampleL.add(new Policy( 41,	61	,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-24").getTime()),0) );
	
		List<Policy> resultL = p_dao.GetAllPolicies();//gets list of all policies from the data base 
		assertThat(resultL , notNullValue());// assert that  a list is actually returned
		
		
		for(Policy sampleP:sampleL) {
			
			for(Policy resultP:resultL) {
				if(sampleP.getPolicy_ID()==resultP.getPolicy_ID()) {// limits asserts to only if we find the sample data
					assertThat(sampleP, not( samePropertyValuesAs(resultP)));
				}
			}
		}
		
	}
	
	@Test
	public void GetPolicyByUserPosTest() throws ParseException, SQLException, IOException{
		//new policy sample data
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-24").getTime()),0 );
		//get dao results
		HashMap<Integer,Policy> resultP = p_dao.GetPolicyByUser(sampleP.getUser_Name());
		
		assertTrue(resultP.containsKey(sampleP.getPolicy_ID()));//assert that we have the correct key
		assertThat(resultP.get(sampleP.getPolicy_ID()),samePropertyValuesAs(sampleP));//assert all values are the same
	}
	@Test
	public void GetPolicyByUserNegTest() throws ParseException, SQLException, IOException{
		//new policy sample data
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"bob@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-24").getTime()),0 );
		//get dao results
		HashMap<Integer,Policy> resultP = p_dao.GetPolicyByUser(sampleP.getUser_Name());
		
		assertFalse(resultP.containsKey(sampleP.getPolicy_ID()));//assert that we do not have the key
		
	}
	
	@Test
	public void UpdatePolicyPosTest() throws ParseException, SQLException, IOException {
		//new policy sample data
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Renew",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		
		p_dao.UpdatePolicy(sampleP);//update Policy
		
		HashMap<Integer,Policy> resultP = p_dao.GetPolicyByUser(sampleP.getUser_Name());//retrieve all polcies for the user
		//assert that the policy has been updated
		assertThat(resultP.get(sampleP.getPolicy_ID()),samePropertyValuesAs(sampleP));
		
		//reset dB
		sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-24").getTime()),0 );
	
		p_dao.UpdatePolicy(sampleP);//update Policy
		
		resultP = p_dao.GetPolicyByUser(sampleP.getUser_Name());//retrieve all polcies for the user
		//assert that the policy has been updated
		assertThat(resultP.get(sampleP.getPolicy_ID()),samePropertyValuesAs(sampleP));
	}
	@Test//neg test update record there
	public void UpdatePolicyNegTest() throws ParseException, SQLException, IOException {
		List<Policy> beforeL = p_dao.GetAllPolicies();//retrieve before
		//new policy sample data
		Policy sampleP = new Policy(-1,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Renew",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		
		p_dao.UpdatePolicy(sampleP);//update Policy
		
		List<Policy> afterL = p_dao.GetAllPolicies();//retrieve after
		
				
		//make sure every thing in before is in after
		boolean found;
		for(Policy  beforeE: beforeL) {
			found = false;
			for(Policy afterE: afterL) {
				if(beforeE.getPolicy_ID()==afterE.getPolicy_ID()) {
					assertThat(beforeE, samePropertyValuesAs(afterE));
					found = true;
				}
			}
			assertTrue(found);
		}
		
		
		
	}
	@Test//pos test all values populated
	public void RegisterPolicyPosTest() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Pos1",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(not(-1)));//asssert the register was succeful
		if(result !=-1) {
			System.out.println("pos1: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	@Test//Pos test ID is not possible
	public void RegisterPolicyPosTest2() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(-1,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Pos2",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(not(-1)));//asssert the register was succeful
		if(result !=-1) {
			System.out.println("pos2: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	@Test//pos test date null
	public void RegisterPolicyPosTest3() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Pos3",null,1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(not(-1)));//asssert the register was succeful
		if(result !=-1) {
			System.out.println("pos3: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	@Test//pos test term -1
	public void RegisterPolicyPosTest4() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Pos4",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),-1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(not(-1)));//asssert the register was succeful
		if(result !=-1) {
			System.out.println("pos4: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	
	@Test//Neg test -1 PL_ID fk
	public void RegisterPolicyNegTest() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,-1,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Neg1",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(-1));//asssert the register was failed
		if(result !=-1) {
			System.out.println("Neg1: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	@Test//Neg test Owner email null
	public void RegisterPolicyNegTest2() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,63,null,	"Mark@gmail.com",	"Neg2",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(-1));//asssert the register was failed
		if(result !=-1) {
			System.out.println("Neg2: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	@Test//Neg test User Name null
	public void RegisterPolicyNegTest3() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	null,	"Neg3",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(-1));//asssert the register was Failed
		if(result !=-1) {
			System.out.println("Neg3: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	@Test//Neg test Status null
	public void RegisterPolicyNegTest4() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	null,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(-1));//asssert the register was Failed
		if(result !=-1) {
			System.out.println("Neg4: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	@Test//Neg test User Name fk
	public void RegisterPolicyNegTest5() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,63,"johnson.drew.w@gmail.com",	"Owner1gmail.com",	"Neg5",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(-1));//asssert the register was Failed
		if(result !=-1) {
			System.out.println("Neg5: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	@Test//Neg test Owner Email FK
	public void RegisterPolicyNegTest6() throws ParseException, SQLException, IOException {
		Policy sampleP = new Policy(63,63,"iopgmail.com",	"Mark@gmail.com",	"Neg6",new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2019-08-24").getTime()),1 );
		int result = p_dao.RegisterPolicy(sampleP);
		assertThat(result, is(-1));//asssert the register was Failed
		if(result !=-1) {
			System.out.println("Neg6: "+result);
			p_dao.RemovePolicy(result);
			
		}
	}
	
	@Test
	public void RemovePolicyPosTest() throws SQLException, IOException {
		HashMap<Integer,Policy> beforeL = p_dao.GetPolicyByUser("Slop");//retrieve before
		
		for(HashMap.Entry<Integer,Policy> entry: beforeL.entrySet()) {
		
			//delete record
			int result = p_dao.RemovePolicy(entry.getKey());
			
			//assert query ran
			assertThat(result, is(not(-1)));
			assertThat(result, is(not(0)));
			
			HashMap<Integer,Policy> afterL = p_dao.GetPolicyByUser("Slop");//retrieve After
			
			assertFalse(afterL.containsKey(entry.getKey()));//check deletion of right thing
			if(result > 0) {
				p_dao.RegisterPolicy(beforeL.get(entry.getKey()));//clean up
			}
		}
	}
	@Test//remove not there... check nothing got messed up
	public void RemoveUserNegTest() throws SQLException, IOException {
		List<Policy> beforeL = p_dao.GetAllPolicies();//retrieve before
		
		assertFalse(beforeL.isEmpty());// assert sample is populated
		
		//try to delete missing record
		int result = p_dao.RemovePolicy(-1);
		
		//assert either did not run or no rows deleted
		assertThat(result, anyOf(is(-1),is( 0)));;
		
		List<Policy> afterL = p_dao.GetAllPolicies();//retrieve after
		
		//make sure the two Lists are the same size
		assertThat(beforeL.size(), is(afterL.size()));
		
		//make sure every thing in before is in after
		boolean found;
		for(Policy  beforeE: beforeL) {
			found = false;
			for(Policy afterE: afterL) {
				if(beforeE.getPolicy_ID()==afterE.getPolicy_ID()) {
					assertThat(beforeE, samePropertyValuesAs(afterE));
					found = true;
				}
			}
			assertTrue(found);
		}
		
			
	}
}
