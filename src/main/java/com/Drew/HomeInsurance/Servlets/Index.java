package main.java.com.Drew.HomeInsurance.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import main.java.com.Drew.HomeInsurance.Model.*;
import main.java.com.Drew.HomeInsurance.dao.PropertyDao;
import main.java.com.Drew.HomeInsurance.BO.*;


@WebServlet(urlPatterns = {"/","/Index"})
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String,String> errors  = new HashMap<String,String>(); 
    
    public Index() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
    	String action = request.getServletPath();
		System.out.println(action);
		if(!(action.equals("/RegisterUser")||action.equals("/newRegisterUser")||action.equals("/login"))&&(!request.isRequestedSessionIdValid()|| session== null||session.getAttribute("currentUser")==null)) {
			action = "not signed in";
		}
        try {
            switch (action) {
            case "/newRegisterUser":
            	newRegisterUser(request,response);
            	break;
            case "/RegisterUser":
                RegisterUser(request, response);
                break;
            case "/login":
                loginUser(request, response);
                break;
            case "/GetStarted":
            	GetStarted(request,response);
            	break;
            case "/GetQoute":
            	GetQoute(request,response);
            	break;
            case "/CreateProperty":
            	CreateProperty(request,response);
            	break;
            case "/CreateHomeOwner":
            	try {
					CreateHomeOwner(request,response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	break;
            case "/UpdateProperty":
            	UpdateProperty(request,response);
            	break;
            case "/Details":
            	Details(request,response);
            	break;
            case "/QouteDetails":
            	QouteDetails(request,response);
            	break;
            case "/BuyQoute":
            	BuyQoute(request,response);
            	break;
            case "/ViewQoutes":
            	ViewQoutes(request,response);
            	break;
            case "/ViewPolicies":
            	ViewPolicies(request,response);
            	break;
            case "/Summary":
            	Summary(request,response);
            	break;
            case "/SearchUsers":
            	SearchUsers(request,response);
            	break;
            case "/SeeDetails":
            	SeeDetails(request,response);
            	break;
            case "/AdminUpdate":
            	AdminUpdate(request,response);
            	break;
            case "/LogOut":
            	session.invalidate();
            	response.sendRedirect("./Views/Index.jsp");
            	break;
            case "not signed in":
            	response.sendRedirect("./Views/Index.jsp");
            	break;
            default:
            	System.out.println("404 load login");
            	response.sendRedirect("/Home_Insurance_App/Views/Index.jsp");
        		break;
            }
        } catch (SQLException|ParseException ex) {
            throw new ServletException(ex);
        }
	}
    
   
	
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession(true);//returns a new session
		
		String email = request.getParameter("email");//retrives values from the fields
		String password = request.getParameter("password");
		
		System.out.println("LoginUSer line 128 "+email+" "+password);
		
		//empty the hashmap
		errors.clear();
		//Login Validation
		if (email.isEmpty()||password.isEmpty()){
			session.setAttribute("error", "password or user name is wrong try again");
			RequestDispatcher rd = request.getRequestDispatcher("/main");
			rd.forward(request, response);
		}else {
			User u = new User();
			u.setUserName((email));
			UserBO UTBO = new UserBO();
			User user = UTBO.GetUserByName(u.getUserName());
			
			if (user.getUserName() == null) {
				session.setAttribute("error", "password or user name is wrong try again");
				session.setAttribute("currentUser", null);
				session.setAttribute("errors", errors);
				RequestDispatcher rd = request.getRequestDispatcher("main");
				rd.forward(request, response);
			}
			
			if (user.getPassword().equals(password)) {
				
				System.out.println("Logged in User Index.147");
				session.setAttribute("currentUser", user);
				session.setAttribute("role", user.getRole());
				response.sendRedirect("GetStarted");
			} else {
				session.setAttribute("error", "password or user name is wrong try again");
				RequestDispatcher rd = request.getRequestDispatcher("main");
				rd.forward(request, response);
			}
		}
		
	}

	
	private void newRegisterUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("."
				+ "/Views/RegisterUser.jsp");
		
	}
	private void RegisterUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		HttpSession session = request.getSession(true);
		String userName = request.getParameter("UserName");
		String password = request.getParameter("password");
		String reEnterPassword = request.getParameter("reEnterPassword");
		System.out.println(userName+" "+password+" "+reEnterPassword);
		
		if(!(userName==null&&password==null&&reEnterPassword==null)
			&&!(userName.isEmpty()&&password.isEmpty()&&reEnterPassword.isEmpty())) {
			if(password.equals(reEnterPassword)) {
				UserBO ubo = new UserBO();
				User u = new User(userName, password);
				if(u.validateInput()&&ubo.RegisterUser(u)!=-1) {
				
				session.setAttribute("currentUser", u);//in session set currentUser to u
				response.sendRedirect("GetStarted");
				}
				else {
					session.setAttribute("error", "please follow the rules for creating user name and passwordS");
					RequestDispatcher rd = request.getRequestDispatcher("newRegisterUser");
					rd.forward(request, response);
				}
			}
			else
			{
				session.setAttribute("error", "Passwords dont Match");
				RequestDispatcher rd = request.getRequestDispatcher("newRegisterUser");
				rd.forward(request, response);
			}
		}
		else {
			
			session.setAttribute("error", "something was left empty");
			RequestDispatcher rd = request.getRequestDispatcher("newRegisterUser");
			rd.forward(request, response);
		}
	}
	
	
	
	private void GetStarted(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("currentUser"));
		response.sendRedirect("./Views/GetStarted.jsp");
	}
	private void GetQoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("currentUser"));
		response.sendRedirect("./Views/NewLocation.jsp");
		
	}
	private void CreateProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		System.out.println("user"+session.getAttribute("currentUser"));
		Property p= new Property();
		
		p.setLocation_Type(request.getParameter("Type"));
		p.setAddress1(request.getParameter("address1"));
		p.setAddress2(request.getParameter("address2"));
		p.setCity(request.getParameter("City"));
		p.setLocation_State(request.getParameter("State"));
		p.setZip(Integer.parseInt(request.getParameter("Zip")));
		p.setLocation_Use(request.getParameter("Use"));
		
		p.Display();
		p.setUser_Name(user.getUserName());
		if(p.validate()==false) {
			session.setAttribute("error", "Property info not set right");
			response.sendRedirect("./Views/NewLocation.jsp");
		}else {
			session.setAttribute("Property", p);
			response.sendRedirect("./Views/NewHomeOwner.jsp");
		}
	}
	private void CreateHomeOwner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("currentUser");
		
		HomeOwner owner = new HomeOwner();
		owner.setOwnerEmail(request.getParameter("email"));
		owner.setFirstName(request.getParameter("fName"));
		owner.setLastName(request.getParameter("lName"));
		owner.setSSN(Integer.parseInt(request.getParameter("ss#")));
		owner.setUserName(user.getUserName());
		
		if(request.getParameter("Retired").equals("Yes")) {
			owner.setRetired("Yes");
		}
		else {
			owner.setRetired("No");
		}
		try {
			String i =request.getParameter("DOB");
			java.util.Date s = new SimpleDateFormat("yyyy-MM-dd").parse(i);
			owner.setDOB(new java.sql.Date(s.getTime()));

		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		if(owner.validate()==false) {
			session.setAttribute("error", "owner info not set right");
			response.sendRedirect("./Views/NewHomeOwner.jsp");
		}else {
			session.setAttribute("ho", owner);
			response.sendRedirect("./Views/UpdateProperty.jsp");
		}
		
		
	}
	private void UpdateProperty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			HttpSession session = request.getSession();
			HomeOwner ho = (HomeOwner)session.getAttribute("ho");
			
			Double value = Double.parseDouble(request.getParameter("market value"));
			int year = Integer.parseInt(request.getParameter("year built"));
			int area = Integer.parseInt(request.getParameter("sq.ft."));
			String floors = request.getParameter("floors");
			String roof = request.getParameter("roof");
			String fullB = request.getParameter("full baths");
			String halfB = request.getParameter("half baths");
			String pool =request.getParameter("pool");
			String garage = request.getParameter("garage");
			System.out.print(value+" "+year+" "+ area+" "+floors+" "+roof+" "+fullB+" "+halfB+" "+pool);
			
			Property p = (Property) session.getAttribute("Property");
			p.setNumber_Floors(floors);
			p.setRoof_Material(roof);
			p.setFull_Baths(fullB);
			p.setHalf_Baths(halfB);
			p.setPool(pool);
			p.setSquare_Footage(area);
			p.setYear(year);
			p.setMarket_Value(value);
			p.setOwner_Email(ho.getOwnerEmail());//fk
			p.setDetached_Garage(garage);
			
			Policy policy = new Policy();
			policy.setOwner_Email(ho.getOwnerEmail());
			policy.setUser_Name(ho.getUserName());
			
			PolicyBO pobo = new PolicyBO();
			PropertyBO pbo = new PropertyBO();
			HomeOwnerBO hbo =new HomeOwnerBO();
			if(hbo.RegisterOwner(ho) ==-1) {
				ho=hbo.GetHomeOwnerByEmail(ho.getOwnerEmail());
			}
			
			int result = pbo.RegisterProperty(p);
			p.setPL_ID(result);
			policy.setPL_ID(result);
			policy.setStatus("Qoute");
			result = pobo.RegisterPolicy(policy);
			policy.setPolicy_ID(result);
			
			//calculate coverage
			int age =Calendar.getInstance().get(Calendar.YEAR)- p.getYear();
			double DwellingC =( (120*p.getSquare_Footage()) );
			if(age<5) {
				DwellingC= DwellingC- .1*DwellingC;
			}else if(age<10) {
				DwellingC-= .2*DwellingC;
			}else if(age <20) {
				DwellingC-= .3*DwellingC;
			}else {
				DwellingC-= .5*DwellingC;
			}
			DwellingC+= .5*p.getMarket_Value();
			//So jsp can find
			session.setAttribute("coverage", DwellingC);
			session.setAttribute("detached", .1*DwellingC);
			session.setAttribute("personalProperty", .6*DwellingC);
			session.setAttribute("living", .2*DwellingC);
			session.setAttribute("deductable", .01*p.getMarket_Value());
			//calculate premium
			double Premium = 5*(DwellingC/1000);
			switch(p.getLocation_Type()) {
			case "Single-Family Home":{
				session.setAttribute("Premium", (double)Math.round((1.05*Premium)/12*100)/100);
				break;
			}
			case "Condo":{
				session.setAttribute("Premium", (double)Math.round((1.006*Premium)/12*100)/100);
				break;
			}
			case "Duplex":{
				session.setAttribute("Premium", (double)Math.round((1.006*Premium)/12*100)/100);
				break;
			}
			case "Apartment":{
				session.setAttribute("Premium", (double)Math.round((1.006*Premium)/12*100)/100);
				break;
			}
			case "TownHouse":{
				session.setAttribute("Premium", (double)Math.round((1.007*Premium)/12*100)/100);
				break;
			}
			case "RowHouse":{
				session.setAttribute("Premium", (double)Math.round((1.007*Premium)/12*100)/100);
				break;
			}
			}
			
			session.setAttribute("p", p);
			session.setAttribute("policy", policy);
			response.sendRedirect("./Views/CreateQoute.jsp");
			
		}
	private void Details(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Views/AdditionalDetails.jsp");
		
	}
	private void QouteDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Views/QouteDetails.jsp");
		
	}
	private void BuyQoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
		HttpSession session = request.getSession(false);
		Policy policy = (Policy)session.getAttribute("policy");
		PolicyBO pbo = new PolicyBO();
		String s = request.getParameter("startdate");
		java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(s);
		
		java.sql.Date date = new java.sql.Date(d.getTime());
		
		
		
		policy.setStart(date);//startdate
		policy.setStatus("Active");
		policy.setTerm(1);
		if(policy.validate()==false) {
			session.setAttribute("error", "Policy info not set right");
			response.sendRedirect("./Views/BuyQoute.jsp");
		}else {
			pbo.UpdatePolicy(policy);
			
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(d);
			cal.add(Calendar.YEAR, policy.getTerm()); // Where n is int
			d = cal.getTime();
			
			date=new java.sql.Date(d.getTime());
			session.setAttribute("end",date);
			session.setAttribute("policy", policy);
			
			response.sendRedirect("./Views/PolicyConfirmation.jsp");
		}
		
	}


	private void ViewQoutes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("currentUser");
		PropertyBO pbo = new PropertyBO();
		HomeOwnerBO hbo = new HomeOwnerBO();
		PolicyBO policybo = new PolicyBO();
		
		HashMap<Integer,Policy> policies = policybo.GetPolicyByUser(user.getUserName());
		HashMap<String,HomeOwner> homeOwners =  hbo.GetHomeOwnerByUser(user.getUserName());
		HashMap<Integer,Property> properties = pbo.GetPropertyByUser(user.getUserName());
		HashMap<Integer,Policy> pol = new HashMap<Integer,Policy>();
		
		 for (HashMap.Entry<Integer,Policy> p: policies.entrySet()) {
			 if(p.getValue().getStatus().equals("Qoute")) {
				 pol.put(p.getKey(),p.getValue());
			 }
		 }
		session.setAttribute("Properties", properties);
		session.setAttribute("HomeOwners", homeOwners);
		session.setAttribute("Policies", pol);
		
		
		
		response.sendRedirect("./Views/ViewQoutes.jsp?buying=yes");
	}

	private void ViewPolicies(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("currentUser");
		PropertyBO pbo = new PropertyBO();
		HomeOwnerBO hbo = new HomeOwnerBO();
		PolicyBO policybo = new PolicyBO();
		
		HashMap<Integer,Policy> policies = policybo.GetPolicyByUser(user.getUserName());
		HashMap<String,HomeOwner> homeOwners =  hbo.GetHomeOwnerByUser(user.getUserName());
		HashMap<Integer,Property> properties = pbo.GetPropertyByUser(user.getUserName());
		HashMap<Integer,Policy> pol = new HashMap<Integer,Policy>();
		 for (HashMap.Entry<Integer,Policy> p: policies.entrySet()) {
			 if(!p.getValue().getStatus().equals("Qoute")) {
				 pol.put(p.getKey(),p.getValue());
			 }
		 }
		session.setAttribute("Properties", properties);
		session.setAttribute("HomeOwners", homeOwners);
		session.setAttribute("Policies", pol);
		
		
		
		response.sendRedirect("./Views/ViewQoutes.jsp?buying=no");
	}
	private void Summary(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("currentUser");
		PropertyBO pbo = new PropertyBO();
		HomeOwnerBO hbo = new HomeOwnerBO();
		PolicyBO policybo = new PolicyBO();
		int id = Integer.parseInt(request.getParameter("qoute"));
		System.out.println(id);
		HashMap<Integer,Policy> policies = (HashMap<Integer,Policy>)session.getAttribute("Policies");
		HashMap<String,HomeOwner> homeOwners =  (HashMap<String,HomeOwner>)session.getAttribute("HomeOwners");
		HashMap<Integer,Property> properties = (HashMap<Integer,Property>)session.getAttribute("Properties");
		session.setAttribute("Property", properties.get(policies.get(id).getPL_ID()));
		session.setAttribute("HomeOwner", homeOwners.get(policies.get(id).getOwner_Email()));
		session.setAttribute("policy", policies.get(id));
		
		//calculate coverage
		int age =Calendar.getInstance().get(Calendar.YEAR)- properties.get(policies.get(id).getPL_ID()).getYear();
		double DwellingC =( (120*properties.get(policies.get(id).getPL_ID()).getSquare_Footage()) );
		if(age<5) {
			DwellingC= DwellingC- .1*DwellingC;
		}else if(age<10) {
			DwellingC-= .2*DwellingC;
		}else if(age <20) {
			DwellingC-= .3*DwellingC;
		}else {
			DwellingC-= .5*DwellingC;
		}
		DwellingC+= .5*properties.get(policies.get(id).getPL_ID()).getMarket_Value();
		//So jsp can find
		session.setAttribute("coverage", DwellingC);
		session.setAttribute("detached", .1*DwellingC);
		session.setAttribute("personalProperty", .6*DwellingC);
		session.setAttribute("living", .2*DwellingC);
		session.setAttribute("deductable", .01*properties.get(policies.get(id).getPL_ID()).getMarket_Value());
		//calculate premium
		double Premium = 5/(DwellingC/1000);
		switch(properties.get(policies.get(id).getPL_ID()).getLocation_Type()) {
			case "Single-Family Home":{
				session.setAttribute("Premium", (double)Math.round((1.05*Premium)/12*100)/100);
				break;
			}
			case "Condo":{
				session.setAttribute("Premium", (double)Math.round((1.006*Premium)/12*100)/100);
				break;
			}
			case "Duplex":{
				session.setAttribute("Premium", (double)Math.round((1.006*Premium)/12*100)/100);
				break;
			}
			case "Apartment":{
				session.setAttribute("Premium", (double)Math.round((1.006*Premium)/12*100)/100);
				break;
			}
			case "TownHouse":{
				session.setAttribute("Premium", (double)Math.round((1.007*Premium)/12*100)/100);
				break;
			}
			case "RowHouse":{
				session.setAttribute("Premium", (double)Math.round((1.007*Premium)/12*100)/100);
				break;
			}
		}
		
		response.sendRedirect("./Views/QuoteSummary.jsp?buying=yes");
	}
	private void SearchUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("role")==null||!session.getAttribute("role").equals("Admin")) {
			response.sendRedirect("./Views/AccessRestricted.jsp");
		}
		else {
			String search = request.getParameter("username");
			UserBO ubo = new UserBO();
			List<User> users = new ArrayList<User>();
			if(search ==null||search.isEmpty()) {
			users = ubo.getAllUsers();
			}else {
				users.add(ubo.GetUserByName(search));
			}
			session.setAttribute("users", users);
			response.sendRedirect("./Views/SearchUsers.jsp");
		}
	}


	private void SeeDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("role")==null||!session.getAttribute("role").equals("Admin")) {
			response.sendRedirect("./Views/AccessRestricted.jsp");
		}
		else {
			PropertyBO pbo = new PropertyBO();
			HomeOwnerBO hbo = new HomeOwnerBO();
			PolicyBO policybo = new PolicyBO();
			

			HashMap<Integer,Policy> pol = new HashMap<Integer,Policy>();
			HashMap<Integer,Policy> policies = policybo.GetPolicyByUser(request.getParameter("search"));
			HashMap<String,HomeOwner> homeOwners =  hbo.GetHomeOwnerByUser(request.getParameter("search"));
			HashMap<Integer,Property> properties = pbo.GetPropertyByUser(request.getParameter("search"));
			if(request.getParameter("type")!=null &&request.getParameter("type").equals("qoute")) {
			 for (HashMap.Entry<Integer,Policy> p: policies.entrySet()) {
				 if(p.getValue().getStatus().equals("Qoute")) {
					 pol.put(p.getKey(),p.getValue());
				 }
				 
			 }
			}else {
				for (HashMap.Entry<Integer,Policy> p: policies.entrySet()) {
					 if(!p.getValue().getStatus().equals("Qoute")) {
						pol.put(p.getKey(),p.getValue());
					 }
				 }
			}
			session.setAttribute("Properties", properties);
			session.setAttribute("HomeOwners", homeOwners);
			session.setAttribute("Policies", pol);
			
			response.sendRedirect("./Views/SeeDetails.jsp");
		}
	}

	private void AdminUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		HttpSession session = request.getSession();
		HashMap<Integer,Policy> policies = (HashMap<Integer,Policy>)session.getAttribute("Policies");
		PolicyBO pbo = new PolicyBO();
		Policy policy = policies.get(Integer.parseInt(request.getParameter("qoute")));
		policy.setStart(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		
		String message;
		
		if(request.getParameter("message").equals("Renewed")) {
			policy.setStatus("Renewed");
			policy.setTerm(1);
			message = "this policy has been renewed";
		}else {
			policy.setStatus("Cancled");
			policy.setTerm(0);
			message = "This policy has been Cancled";
		}
		session.setAttribute("policy", policy);
		pbo.UpdatePolicy(policy);
		response.sendRedirect("./Views/AdminUpdate.jsp?qoute="+policy.getPolicy_ID()+"&message="+message);
		
	}
}
