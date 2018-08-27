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

import main.java.com.Drew.HomeInsurance.Model.Policy;
@RunWith(Parameterized.class)
public class PolicyModelTest 
{

	Policy Policy;
	boolean outcome;
   ////------------------------Constructor
   public PolicyModelTest(Policy p ,boolean o) {
		super();
		Policy = p;
		outcome = o;
	}
   @Parameterized.Parameters
   public static Collection Data() throws ParseException{
	   Object[][] data = new Object[][]{
/*0*/ 			{new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),true},
/*1*/ 			{new Policy(-1,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),false},
/*2*/ 			{new Policy(63,-63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),false},
/*3*/ 			{new Policy(63,63,null,	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),false},
/*4*/ 			{new Policy(63,63,"",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),false},
/*5*/ 			{new Policy(63,63,"johnson.drew.w@gmail.com",null,	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),false},
/*6*/ 			{new Policy(63,63,"johnson.drew.w@gmail.com",	"",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),false},
/*7*/ 			{new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",null,new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),false},
/*8*/ 			{new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com","",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-30").getTime()),0 ),false},
/*9*/ 			{new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-24").getTime()),0 ),false},
/*10*/ 			{new Policy(63,63,"johnson.drew.w@gmail.com",	"Mark@gmail.com",	"Cancled",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-24").getTime()),0 ),false}

	   };
	   return Arrays.asList(data);
   }
   
  

   @Test
   public void validate() throws ClassNotFoundException, IOException {
	 System.out.println("1000");
	   assertThat(Policy.validate(),is(outcome));
   }

}
