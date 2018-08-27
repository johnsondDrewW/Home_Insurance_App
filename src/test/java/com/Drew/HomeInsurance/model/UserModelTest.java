package test.java.com.Drew.HomeInsurance.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.java.com.Drew.HomeInsurance.Model.User;


@RunWith(Parameterized.class)
public class UserModelTest
{
	User user;
	String password;
	boolean outcome;
   ////------------------------Constructor
   public UserModelTest(User u,String s ,boolean o) {
		super();
		password = s;
		user = u;
		outcome = o;
	}
   @Parameterized.Parameters
   public static Collection Data(){
	   Object[][] data = new Object[][]{
		   {new User("aa@aa.aa","hlaaaaaajfd","User"),"hlaaaaaajfd", true},
		   {new User("a1a@A1a.a1a","hlaaaaaaj1fd","User"), "hlaaaaaaj1fd",true},
		   {new User("aa@Aa.aa","Hlaaaaaajfd","User"),"Hlaaaaaajfd", true},
		   {new User("aa@aa.aa","hljfd","User"),"hljfd",false},
		   {new User("a#a@Aa.aa","Hlbbbbbbbbjfd","User"),"Haaaaaaljfd", false},
		   {new User("aa@Aa.aa","hl#jfd","User"),"Hljfd", false},
		   {new User("aa@Aa.aa",null,"User"),"Hljfd", false},
		   {new User("aa@Aa.aa",null,"User"),"Hljfd", false},
		   {new User(null,"hljfd","User"),"Hljfd", false}
		   };
	   return Arrays.asList(data);
   }
   
  

   @Test
   public void validateInput() throws ClassNotFoundException, IOException {
	 
	   assertThat(user.validateInput(),is(outcome));
   }
	@Test
	public void validateReg() throws ClassNotFoundException, IOException {
		
		assertThat(user.validateReg(password),is(outcome));
	}
}

