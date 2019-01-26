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
 * Servlet implementation class Enquiry_Delete
 */
public class Enquiry_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Statement stmt=null;  
	java.sql.Connection con=null; 
	private String enquiryid;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enquiry_Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");  
			getValues(request);//request is a java obj
			stmt=con.createStatement();
			
			//sql
			String Str="DELETE FROM enquiry WHERE enquiry_id ="+ enquiryid;
			
			System.out.println("str============="+Str);
			int i=stmt.executeUpdate(Str);
			if(i!=0){
				RequestDispatcher rd = request.getRequestDispatcher("/enquiry-delete.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/enquiry-list.jsp");
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
	
	private void getValues(HttpServletRequest request) {
		enquiryid = request.getParameter("enquiryId");
		
	}
	
	public String populateEnquiry() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");  
		String Str="<option value='0'>Enquiry List</option>";
		stmt=con.createStatement();
		ResultSet result=stmt.executeQuery("SELECT enquiry_id,enquiry_name FROM enquiry");
		while(result.next()){
			Str+="<option value="+result.getString("enquiry_id")+">"+result.getString("enquiry_name")+"</option>";
		}
		return Str;
	}

}