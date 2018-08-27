package test.java.com.Drew.HomeInsurance.dao;

import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import main.java.com.Drew.HomeInsurance.Model.HomeOwner;
import main.java.com.Drew.HomeInsurance.dao.HomeOwnerDao;

public class HomeOwnerDaoTest {
	HomeOwnerDao h_dao = new HomeOwnerDao();
	@Test//
	public void  GetAllHomeOwnersPosTest() throws ParseException, SQLException, IOException {
		List<HomeOwner> sampleL = new ArrayList<HomeOwner>();//sample data list
		//add some sample data
		sampleL.add(new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123654789,"Mark@gmail.com","Yes"));
		sampleL.add(new HomeOwner("Owner2@gmail.com","Oqner2","Owner2",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-26").getTime()),987654321,"bob@gmail.com","No"));
		sampleL.add(new HomeOwner("johnson.drew.w@gmail.com","Drew","Johnson",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-05-06").getTime()),123456798,"Mark@gmail.com","No"));
		
		//list of all stored data
		List<HomeOwner> resultL = h_dao.GetAllHomeOwners();
		
		boolean found;
		for(HomeOwner sample:sampleL) {
			found=false;//defualt false per item
			for(HomeOwner actual:resultL) {
				if(sample.getOwnerEmail().equals(actual.getOwnerEmail())){
					assertThat(sample, samePropertyValuesAs(actual));//compares all the values in both objects
					found = true;// found to be true
				}
			}
			assertTrue(found);
		}
	
	}
	@Test//
	public void  GetAllHomeOwnersNegTest() throws ParseException, SQLException, IOException {
		List<HomeOwner> sampleL = new ArrayList<HomeOwner>();//sample data list
		//add some sample data not in the DB
		sampleL.add(new HomeOwner("Mark@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123456789,"Mark@gmail.com","Yes"));
		sampleL.add(new HomeOwner("Owner2@gmail.com","Oqwnr2","Owner2",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2017-08-26").getTime()),987664321,"bob@gmail.com","No"));
		sampleL.add(new HomeOwner("Johnson.Drew.W@gmail.com","Dew","Johnson",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-05-06").getTime()),123456798,"Mark@gmail.com","No"));
		
		//list of all stored data
		List<HomeOwner> resultL = h_dao.GetAllHomeOwners();
		
		
		for(HomeOwner sample:sampleL) {
			for(HomeOwner actual:resultL) {
				if(sample.getUserName().equals(actual.getUserName())){
					assertThat(sample, not( samePropertyValuesAs(actual)));//compares all the values in both objects
				}
			}
		}
	
	}
	
	@Test
	public void  getHomeOwnerByUserPosTest() throws SQLException, IOException, ParseException {
		HomeOwner sampleO = new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123654789,"Mark@gmail.com","Yes");
		HashMap<String,HomeOwner> resultO = h_dao.getHomeOwnerByUser(sampleO.getUserName());
		assertTrue(resultO.containsKey(sampleO.getOwnerEmail()));
		assertThat(resultO.get(sampleO.getOwnerEmail()),samePropertyValuesAs(sampleO));
	}
	@Test
	public void  getHomeOwnerByUserNegTest() throws SQLException, IOException, ParseException {
		HomeOwner sampleO = new HomeOwner("Owner2@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123456789,"Mark@gmail.com","Yes");
		HashMap<String,HomeOwner> resultO = h_dao.getHomeOwnerByUser(sampleO.getUserName());
		assertFalse(resultO.containsKey(sampleO.getOwnerEmail()));
	}
	
	
	
	@Test
	public void  getHomeOwnerByEmailPosTest() throws SQLException, IOException, ParseException {
		HomeOwner sampleO = new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123654789,"Mark@gmail.com","Yes");
		HomeOwner resultO = h_dao.getHomeOwnerByEmail(sampleO.getOwnerEmail());
		assertThat(resultO, notNullValue());
		assertThat(resultO,samePropertyValuesAs(sampleO));
	}
	@Test
	public void  getHomeOwnerByEmailNegTest() throws SQLException, IOException, ParseException {
		HomeOwner sampleO = new HomeOwner("Mark@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123456789,"Mark@gmail.com","Yes");
		HomeOwner resultO = h_dao.getHomeOwnerByEmail(sampleO.getOwnerEmail());
		assertThat(resultO, nullValue());
	}
	
	@Test
	public void  RegisterHomeOwnerPosTest() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123416789,"Mark@gmail.com","Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//Owner email null
	public void  RegisterHomeOwnerNegTest() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner(null,"Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),1234116789,"Mark@gmail.com","Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//First name null
	public void  RegisterHomeOwnerNegTest2() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner_2@gmail.com",null,"Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),1234116789,"Mark@gmail.com","Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//last name null
	public void  RegisterHomeOwnerNegTest3() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner_3@gmail.com","Owner1",null,	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),1234116789,"Mark@gmail.com","Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//DOB null
	public void  RegisterHomeOwnerNegTest4() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner_4@gmail.com","Owner1","Owner1",	null,1234116789,"Mark@gmail.com","Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//User email null
	public void  RegisterHomeOwnerNegTest5() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner_5@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),111111111, null ,"Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//retired  null
	public void  RegisterHomeOwnerNegTest6() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner_6@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123416789,"Mark@gmail.com",null);
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//SS# not uniqe
	public void  RegisterHomeOwnerNegTest7() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner_7@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123654789,"Mark@gmail.com","Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//User key fail
	public void  RegisterHomeOwnerNegTest8() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner_8@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123416789,"Owner2@gmail.com","Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}
	@Test//Primary key fail
	public void  RegisterHomeOwnerNegTest9() throws ParseException, SQLException, IOException {
		HomeOwner test = new HomeOwner("Owner1@gmail.com","Owner1","Owner1",	new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-15").getTime()),123416789,"Owner2@gmail.com","Yes");
		int result =h_dao.RegisterHomeOwner(test);
		assertThat(result, is(-1));
		if(result ==1) {
			h_dao.RemoveHomeOwner(test.getOwnerEmail());
		}
		
	}

	@Test
	public void  RemoveHomeOwnerPosTest() throws SQLException, IOException {
		HomeOwner test = h_dao.getHomeOwnerByEmail("Owner1@gmail.com");//easy cleanup
		assertThat(test, notNullValue());
		
		int result = h_dao.RemoveHomeOwner("Owner1@gmail.com");
		
		assertThat(result, is(1));//testing if it ran
		assertThat(h_dao.getHomeOwnerByEmail("Owner1@gmail.com"), is(nullValue()));//testing if we can't find the owner
		if(result==1) {
			h_dao.RegisterHomeOwner(test);
		}
	}
	@Test
	public void  RemoveHomeOwnerNegTest() throws SQLException, IOException {
		List<HomeOwner> beforeL = h_dao.GetAllHomeOwners();
		
		
		int result = h_dao.RemoveHomeOwner("Mark###@gmail.com");
		
		assertThat(result, is(0));
		assertThat(h_dao.getHomeOwnerByEmail("Mark###@gmail.com"), is(nullValue()));
		
		List<HomeOwner> afterL = h_dao.GetAllHomeOwners();
		
		assertThat(beforeL.size(), is( afterL.size()));
		
		boolean found;
		
		//chechs to make sure no data has been altered
		for(HomeOwner before:beforeL) {
				found = false;
			for(HomeOwner after:afterL) {
				if(before.getOwnerEmail().equals(after.getOwnerEmail())) {
					assertThat(before, samePropertyValuesAs(after));
					found = true;
				}
			}
			assertTrue(found);
		}
			
	}

}
