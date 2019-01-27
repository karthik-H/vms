package com.vms;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Customer_Add
 */
public class Customer_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String customerName="connection";
	private String customerEmail;
	private String customerJob;
	java.sql.Connection con=null;
	private String customerAddress;
	private String gender;
	private java.sql.Statement stmt;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_Add() {
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
			//System.out.println("dadjasdgjagdj");
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");
			//from data
			customerName = request.getParameter("customerName");
			customerEmail = request.getParameter("customerEmail");
			customerJob = request.getParameter("customerJob");
			gender = request.getParameter("gender");
			customerAddress = request.getParameter("customerAddress");
			
			stmt=con.createStatement();
			String Str="INSERT INTO Customer(customer_name,customer_job,customer_email,customer_gender,customer_address)"
					+ " VALUES('"+customerName+"','"+customerJob+"','"+customerEmail+"','"+gender+"','"+customerAddress+"')";
			System.out.println("Customer Insert======"+Str);
			int result=stmt.executeUpdate(Str);
			if(result<0){
				RequestDispatcher rd = request.getRequestDispatcher("/customer-add.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/customer-list.jsp");
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

}
