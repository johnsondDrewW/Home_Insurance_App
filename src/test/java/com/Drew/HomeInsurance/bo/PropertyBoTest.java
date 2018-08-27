package test.java.com.Drew.HomeInsurance.bo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import main.java.com.Drew.HomeInsurance.Model.Property;
import main.java.com.Drew.HomeInsurance.BO.PropertyBO;

public class PropertyBoTest {
	PropertyBO p_bo = new PropertyBO();
	@Test
	public void getAllPropertysPosTest() throws SQLException, IOException {
		List<Property> sampleL = new ArrayList<Property>();
		sampleL.add(new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993));
		sampleL.add(new Property(81,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero","United States",77954	,"Rental Property",1000000.0,1500,"2 Story","Clay","Detached","1","1","Yes",1993));
	
		List<Property> resultL = p_bo.getAllPropertys();
		
		boolean found;
		for(Property sample:sampleL) {
			found = false;
			for(Property result:resultL) {
				if(sample.getPL_ID()==result.getPL_ID()) {
					found = true;
					assertThat(sample, samePropertyValuesAs(result));
				}
			}
			assertTrue(found);
		}
	
	}
	@Test
	public void getAllPropertysNegTest() throws SQLException, IOException {
		List<Property> sampleL = new ArrayList<Property>();
		sampleL.add(new Property(63,"Mark@gmail.com","johnson.drew.w@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993));
		sampleL.add(new Property(83,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero","United States",77954	,"Rental Property",1000000.0,1500,"2 Story","Clay","Detached","1","1","Yes",1993));
	
		List<Property> resultL = p_bo.getAllPropertys();
		
		for(Property sample:sampleL) {
			for(Property result:resultL) {
				if(sample.getPL_ID()==result.getPL_ID()) {
					assertThat(sample, not(samePropertyValuesAs(result)));
				}
			}
		}
	
	}
	
	
	@Test
	public void GetPropertyByUserTest() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		HashMap<Integer, Property> result = p_bo.GetPropertyByUser(sample.getUser_Name());
		
		assertTrue(result.containsKey(sample.getPL_ID()));
		assertThat(result.get(sample.getPL_ID()), samePropertyValuesAs(sample));
	}
	@Test
	public void GetPropertyByUserNegTest() throws SQLException, IOException {
		Property sample = new Property(63,"Mark@gmail.com","j22ail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		HashMap<Integer, Property> result = p_bo.GetPropertyByUser(sample.getUser_Name());
		
		assertFalse(result.containsKey(sample.getPL_ID()));
	}
	
	///positive reg tests.... 
	@Test//pos
	public void RegisterPropertyPosTest() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos Detached garage
	public void RegisterPropertyPosTest2() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Detached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos None garage
	public void RegisterPropertyPosTest3() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","None","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos type condo
	public void RegisterPropertyPosTest4() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Condo","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Detached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos type TownHouse
	public void RegisterPropertyPosTest5() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","TownHouse","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Detached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos type RowHouse
	public void RegisterPropertyPosTest6() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Rowhouse","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Detached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos type Duplex
	public void RegisterPropertyPosTest7() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Duplex","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Detached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos type Apartment
	public void RegisterPropertyPosTest8() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Apartment","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Detached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos use secondary
	public void RegisterPropertyPosTest9() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Secondary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos use Vacation
	public void RegisterPropertyPosTest10() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Vacation",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos use Rental Property
	public void RegisterPropertyPosTest11() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Rental Property",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos Pool No
	public void RegisterPropertyPosTest12() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","No",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//pos adress 2
	public void RegisterPropertyPosTest13() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		sample.setAddress2("apt. 3");
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(not(-1)));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}	
	
	
	//null inputs
	@Test//Neg owner Null
	public void RegisterPropertyNegTest() throws SQLException, IOException {
		Property sample = new Property(63,null,"Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","	Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg User Null
	public void RegisterPropertyNegTest2() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com",null,"Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg Type null
	public void RegisterPropertyNegTest3() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com",null,"408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg adress1 null
	public void RegisterPropertyNegTest4() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home",null,"Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg City null
	public void RegisterPropertyNegTest5() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.",null,"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg State null
	public void RegisterPropertyNegTest6() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",null,77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg use Null
	public void RegisterPropertyNegTest7() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,null,1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg Roof null
	public void RegisterPropertyNegTest8() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story",null,"Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg floors null
	public void RegisterPropertyNegTest9() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,null,"Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg garage null
	public void RegisterPropertyNegTest10() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete",null,"1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg full baths null
	public void RegisterPropertyNegTest11() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached",null,"1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg half baths null
	public void RegisterPropertyNegTest12() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1",null,"Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg pool null
	public void RegisterPropertyNegTest13() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1",null,1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	//wrong inpuits
	@Test//Neg pool wrong
	public void RegisterPropertyNegTest14() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","boo",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg use wrong
	public void RegisterPropertyNegTest16() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"sleep",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg type wrong
	public void RegisterPropertyNegTest17() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Business","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg garage wrong
	public void RegisterPropertyNegTest18() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Temp","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg adress1 wrong
	public void RegisterPropertyNegTest19() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408$#& E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg address2
	public void RegisterPropertyNegTest20() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		sample.setAddress2("%$#");
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result != -1) {
			p_bo.RemoveByName(result);
		}
	}
	//fk constraints
	@Test//Neg user FK
	public void RegisterPropertyNegTest21() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Marmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result == 1) {
			p_bo.RemoveByName(result);
		}
	}
	@Test//Neg owner fk
	public void RegisterPropertyNegTest22() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.dreail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result, is(-1));
		if(result == 1) {
			p_bo.RemoveByName(result);
		}
	}
	
	
	@Test
	public void RemoveByNamePosTest() throws SQLException, IOException {
		Property sample = new Property(63,"johnson.drew.w@gmail.com","Mark@gmail.com","Single-Family Home","408 E Reuss Blvd.","Cuero",	"United States",77954,"Primary",1000000.0,1500,"1.5 Story","Concrete","Attached","1","1","Yes",1993);
		int result = p_bo.RegisterProperty(sample);
		assertThat(result , is(not(-1)));
		p_bo.RemoveByName(result);
		
		
		HashMap<Integer, Property> DBInfo = p_bo.GetPropertyByUser(sample.getUser_Name());
		assertFalse(DBInfo.containsKey(result));
	}
	@Test
	public void RemoveByNameNegTest() throws SQLException, IOException {
		List<Property> beforeL = p_bo.getAllPropertys();
		
		p_bo.RemoveByName(-1);
		
		List<Property> afterL = p_bo.getAllPropertys();
				
		boolean found;
		for(Property before:beforeL) {
			found = false;
			for(Property after:afterL) {
				if(before.getPL_ID()==after.getPL_ID()) {
					found = true;
					assertThat(before, samePropertyValuesAs(after));
				}
			}
			assertTrue(found);
		}
	}
	
}
