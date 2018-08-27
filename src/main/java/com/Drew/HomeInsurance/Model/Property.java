package main.java.com.Drew.HomeInsurance.Model;

public class Property {
private int PL_ID;
private String Owner_Email;
private String User_Name;
private String Location_Type;
private String Address1;
private String Address2;
private String City;
private String Location_State;
private int Zip;
private String Location_Use;
private double Market_Value;
private int Square_Footage;
private String Number_Floors;
private String Roof_Material;
private String Detached_Garage;
private String Full_Baths;
private String Half_Baths;
private String Pool;
private int Year;




//--------------------Constructors------------------------
public Property() {
	super();
}

public Property(int pL_ID, String owner_Email, String user_Name, String location_Type, String address1, String address2,
		String city, String location_State, int zip, String location_Use, double market_Value, int square_Footage,
		String number_Floors, String roof_Material, String detached_Garage, String full_Baths, String half_Baths, String pool) {
	super();
	PL_ID = pL_ID;
	Owner_Email = owner_Email;
	User_Name = user_Name;
	Location_Type = location_Type;
	Address1 = address1;
	Address2 = address2;
	City = city;
	Location_State = location_State;
	Zip = zip;
	Location_Use = location_Use;
	Market_Value = market_Value;
	Square_Footage = square_Footage;
	Number_Floors = number_Floors;
	Roof_Material = roof_Material;
	Detached_Garage = detached_Garage;
	Full_Baths = full_Baths;
	Half_Baths = half_Baths;
	Pool = pool;
}

public Property(int pL_ID, String owner_Email, String user_Name, String location_Type, String address1, 
		String city, String location_State, int zip, String location_Use, double market_Value, int square_Footage,
		String number_Floors, String roof_Material, String detached_Garage, String full_Baths, String half_Baths, String pool, int year) {
	super();
	PL_ID = pL_ID;
	Owner_Email = owner_Email;
	User_Name = user_Name;
	Location_Type = location_Type;
	Address1 = address1;
	City = city;
	Location_State = location_State;
	Zip = zip;
	Location_Use = location_Use;
	Market_Value = market_Value;
	Square_Footage = square_Footage;
	Number_Floors = number_Floors;
	Roof_Material = roof_Material;
	Detached_Garage = detached_Garage;
	Full_Baths = full_Baths;
	Half_Baths = half_Baths;
	Pool = pool;
	Year = year;
}


//--------------------Getters----------------
public int getPL_ID() {
	return PL_ID;
}
public String getOwner_Email() {
	return Owner_Email;
}
public String getUser_Name() {
	return User_Name;
}
public String getLocation_Type() {
	return Location_Type;
}
public String getAddress1() {
	return Address1;
}
public String getAddress2() {
	return Address2;
}
public String getCity() {
	return City;
}
public String getLocation_State() {
	return Location_State;
}
public int getZip() {
	return Zip;
}
public String getLocation_Use() {
	return Location_Use;
}
public double getMarket_Value() {
	return Market_Value;
}
public int getSquare_Footage() {
	return Square_Footage;
}
public String getNumber_Floors() {
	return Number_Floors;
}
public String getRoof_Material() {
	return Roof_Material;
}
public String getDetached_Garage() {
	return Detached_Garage;
}
public String getFull_Baths() {
	return Full_Baths;
}
public String getHalf_Baths() {
	return Half_Baths;
}
public String getPool() {
	return Pool;
}
public int getYear() {
	return Year;
}


//---------------------Setters---------------------
public void setPL_ID(int pL_ID) {
	PL_ID = pL_ID;
}
public void setOwner_Email(String owner_Email) {
	Owner_Email = owner_Email;
}
public void setUser_Name(String user_Name) {
	User_Name = user_Name;
}
public void setLocation_Type(String location_Type) {
	Location_Type = location_Type;
}
public void setAddress1(String address1) {
	Address1 = address1;
}
public void setAddress2(String address2) {
	Address2 = address2;
}
public void setCity(String city) {
	City = city;
}
public void setLocation_State(String location_State) {
	Location_State = location_State;
}
public void setZip(int zip) {
	Zip = zip;
}
public void setLocation_Use(String location_Use) {
	Location_Use = location_Use;
}
public void setMarket_Value(double market_Value) {
	Market_Value = market_Value;
}
public void setSquare_Footage(int square_Footage) {
	Square_Footage = square_Footage;
}
public void setNumber_Floors(String number_Floors) {
	Number_Floors = number_Floors;
}
public void setRoof_Material(String roof_Material) {
	Roof_Material = roof_Material;
}
public void setDetached_Garage(String detached_Garage) {
	Detached_Garage = detached_Garage;
}
public void setFull_Baths(String full_Baths) {
	Full_Baths = full_Baths;
}
public void setHalf_Baths(String half_Baths) {
	Half_Baths = half_Baths;
}
public void setPool(String pool) {
	Pool = pool;
}
public void setYear(int year) {
	Year = year;
}
public void Display() {

	System.out.println(Address1);
	System.out.println(Address2);
	System.out.println(City);
	System.out.println(Location_Type);
	System.out.println(Location_Use);
}

public boolean validate() {
	String regex = "[^A-Za-z0-9'\\.\\-\\s\\,]";
	if(Address1==null||Address1.isEmpty()||Address1.matches(regex)) {
		return false;
	}
	if(City==null||City.isEmpty()) {
		return false;
	}
	if(Location_Type==null||Location_Type.isEmpty()) {
		return false;
	}
	if(Location_Use==null||Location_Use.isEmpty()) {
		return false;
	}
	if(Location_State==null||Location_State.isEmpty()) {
		return false;
	}
	if(PL_ID<=0) {
		return false;
	}
	if(Owner_Email==null||Owner_Email.isEmpty()) {
		return false;
	}
	if(User_Name==null||User_Name.isEmpty()) {
		return false;
	}
	if(Zip<=9999) {
		return false;
	}
	if(City==null||City.isEmpty()) {
		return false;
	}
	if(Market_Value<0) {
		return false;
	}
	if(Number_Floors==null||Number_Floors.isEmpty()) {
		return false;
	}
	if(Square_Footage<0) {
		return false;
	}
	if(Detached_Garage==null||Detached_Garage.isEmpty()) {
		return false;
	}
	if(Full_Baths==null||Full_Baths.isEmpty()) {
		return false;
	}
	if(Half_Baths==null||Half_Baths.isEmpty()) {
		return false;
	}
	if(Pool==null||Pool.isEmpty()) {
		return false;
	}
	if(Roof_Material==null||Roof_Material.isEmpty()) {
		return false;
	}
	if(Detached_Garage==null||Detached_Garage.isEmpty()) {
		return false;
	}
	return true;
}


}
