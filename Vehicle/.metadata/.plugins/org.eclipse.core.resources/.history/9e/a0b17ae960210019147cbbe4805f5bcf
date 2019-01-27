package com.vms;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contact_Add
 */
public class Contact_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String contactfName="connection";
	private String contactlName;
	private String contactEmail;
	java.sql.Connection con=null;
	private String contactJob;
	private String contactMobile;
	//private String dobMonth;
	private java.sql.Statement stmt;
	public String customerId="0";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact_Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			System.out.println("dadjasdgjagdj");
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");
			//from data
			customerId = request.getParameter("customerId");
			contactfName = request.getParameter("contactfName");
			contactlName = request.getParameter("contactlName");
			contactEmail = request.getParameter("contactEmail");
			contactMobile = request.getParameter("contactMobile");
			contactJob = request.getParameter("contactJob");
			if(!contactfName.equals("") && !contactlName.equals("")){
			stmt=con.createStatement();
			String Str="INSERT INTO contact(contact_fname,contact_email,contact_lname,contact_mobile,contact_job,contact_customer_id)"
					+ " VALUES('"+contactfName+"','"+contactEmail+"','"+contactlName+"','"+contactMobile+"','"+contactJob+"','"+customerId+"')";
			System.out.println("Customer Insert======"+Str);
			int result=stmt.executeUpdate(Str);
			if(result<0){
				RequestDispatcher rd = request.getRequestDispatcher("/contact-add.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/customer-list.jsp");
				rd.forward(request, response);
			}
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/contact-add.jsp");
				rd.forward(request, response);
			}
			}catch(Exception e){
				System.out.println("Exception ======="+e);
				System.out.println("Exception ======="+e.getStackTrace());
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public String populateCustomer() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");  
		String Str="<option value='0'>Select</option>";
		stmt=con.createStatement();
		ResultSet result=stmt.executeQuery("SELECT customer_id,customer_name FROM customer");
		while(result.next()){
			Str+="<option value="+result.getString("customer_id")+">"+result.getString("customer_name")+"</option>";
		}
		return Str;
	}

}
