package test.java.com.Drew.HomeInsurance.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.java.com.Drew.HomeInsurance.Model.HomeOwner;

@RunWith(Parameterized.class)
public class HomeOwnerModelTest 
{

	HomeOwner Owner;
	boolean outcome;
   ////------------------------Constructor
   public HomeOwnerModelTest(HomeOwner p ,boolean o) {
		super();
		Owner = p;
		outcome = o;
	}
   @Parameterized.Parameters
   public static Collection Data() throws ParseException{
	   Object[][] data = new Object[][]{
/*0*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),true},
/*1*/ 			{new HomeOwner(null,"Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),false},
/*2*/ 			{new HomeOwner("","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),false},
/*3*/ 			{new HomeOwner("Owner1@gmail.com",null,"Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),false},
/*4*/ 			{new HomeOwner("Owner1@gmail.com","","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),false},
/*5*/ 			{new HomeOwner("Owner1@gmail.com","Owner1",null,	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),false},
/*6*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),false},
/*7*/ 			{new HomeOwner("Owner1gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),false},
/*8*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,null,"Yes"),false},
/*9*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"","Yes"),false},
/*10*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Markgmail.com","Yes"),false},
/*11*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com",null),false},
/*12*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-12-15").getTime()),123654789,"Mark@gmail.com",""),false},
/*13*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123654789,"Mark@gmail.com","Yes"),false},
/*14*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),1234789,"Mark@gmail.com","Yes"),false},
/*15*/ 			{new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),1236054789,"Mark@gmail.com","Yes"),false},



	   };
	   return Arrays.asList(data);
   }
   
  

   @Test
   public void validate() throws ClassNotFoundException, IOException {
	 System.out.println("1000");
	   assertThat(Owner.validate(),is(outcome));

   }
}

