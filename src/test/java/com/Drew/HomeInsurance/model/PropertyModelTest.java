package test.java.com.Drew.HomeInsurance.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.java.com.Drew.HomeInsurance.Model.Property;
@RunWith(Parameterized.class)
public class PropertyModelTest
{
	Property property;
	boolean outcome;
   ////------------------------Constructor
   public PropertyModelTest(Property p ,boolean o) {
		super();
		property = p;
		outcome = o;
	}
   @Parameterized.Parameters
   public static Collection Data(){
	   Object[][] data = new Object[][]{
/*0*/ 			{new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993), true},
/*1*/			{new Property(63,null,"Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*2*/   		{new Property(63,"","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*3*/   		{new Property(63,"johnson.drew.w@gmail.com",null,"Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*4*/   		{new Property(63,"johnson.drew.w@gmail.com","","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*5*/   		{new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com",null,"408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*6*/   		{new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*7*/   		{new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home",null,"Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*8*/			{new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*9*/			{new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.",null,	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*10*/			{new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","","United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*11*/	 	   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",null,77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*12*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero","",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*13*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",-1,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*14*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,null,1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*15*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*16*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",-1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*17*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,-1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993),false},
/*18*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,null,"Concrete","Attached","1","1","Yes",1993),false},
/*19*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"","Concrete","Attached","1","1","Yes",1993),false},
/*20*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story",null,"Attached","1","1","Yes",1993),false},
/*21*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","","Attached","1","1","Yes",1993),false},
/*22*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete",null,"1","1","Yes",1993),false},
/*23*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","","1","1","Yes",1993),false},
/*24*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached",null,"1","Yes",1993),false},
/*25*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","","1","Yes",1993),false},
/*26*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1",null,"Yes",1993),false},
/*27*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","","Yes",1993),false},
/*28*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1",null,1993),false},
/*29*/		   {new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","",1993),false}
	   };
	   return Arrays.asList(data);
   }
   
  

   @Test
   public void validate() throws ClassNotFoundException, IOException {
	 System.out.println("1000");
	   assertThat(property.validate(),is(outcome));
   }
	
}