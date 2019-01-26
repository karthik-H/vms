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
 * Servlet implementation class Contact_Delete
 */
public class Contact_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Statement stmt=null;  
	java.sql.Connection con=null;
	public ResultSet result=null;
	private String contactid;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact_Delete() {
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
			String Str="DELETE FROM contact WHERE contact_id ="+ contactid;
			
			System.out.println("str============="+Str);
			int i=stmt.executeUpdate(Str);
			if(i!=0){
				RequestDispatcher rd = request.getRequestDispatcher("/contact-delete.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
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
		contactid = request.getParameter("contactId");
		
	}
	
	public String populateContact() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");  
		String Str="<option value='0'>Contact List</option>";
		stmt=con.createStatement();
		ResultSet result=stmt.executeQuery("SELECT contact_id,contact_fname FROM contact");
		while(result.next()){
			Str+="<option value="+result.getString("contact_id")+">"+result.getString("contact_fname")+"</option>";
		}
		return Str;
	}
	
	public StringBuilder populateContactTable() throws ClassNotFoundException, SQLException{
		StringBuilder Str=new StringBuilder();
		Class.forName("com.mysql.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");  
		stmt=con.createStatement();
		String Sql="SELECT contact_id,contact_fname,contact_email,contact_lname,contact_mobile,contact_job,customer_name"
				+ " FROM contact "
				+ " INNER JOIN customer ON customer_id=contact_customer_id";
				System.out.println("Sql======"+Sql);
				result=stmt.executeQuery(Sql);
				int count=0;
				while(result.next()){
					count++;
				Str.append("<tr><td>").append(count).append("</td>")
				.append("<td>").append(result.getString("contact_id")).append("</td>")
				.append("<td>").append(result.getString("contact_fname")).append("</td>")
				.append("<td>").append(result.getString("contact_email")).append("</td>")
				.append("<td>").append(result.getString("contact_lname")).append(result.getString("contact_lname")).append("</td>")
				.append("<td>").append(result.getString("contact_mobile")).append("</td>")
				.append("<td>").append(result.getString("contact_job")).append("</td>")
				.append("<td>").append(result.getString("customer_name")).append("</td></tr>");
				}
		return Str;
	}


}