package com.vms;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Customer_List
 */
public class Customer_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Statement stmt=null;  
	java.sql.Connection con=null;
	public ResultSet result=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_List() {
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
	
	public StringBuilder populateCustomerTable() throws ClassNotFoundException, SQLException{
		StringBuilder Str=new StringBuilder();
		Class.forName("com.mysql.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");  
		stmt=con.createStatement();
		String Sql="SELECT customer_id,customer_name,contact_lname,contact_fname,Customer_address,Customer_email,Customer_job"
				+ " FROM customer "
				+ " LEFT JOIN contact ON contact_customer_id=customer_id";
				System.out.println("Sql======"+Sql);
				result=stmt.executeQuery(Sql);
				int count=0;
				while(result.next()){
					count++;
				Str.append("<tr><td>").append(count).append("</td>")
				.append("<td>").append(result.getString("customer_id")).append("</td>")
				.append("<td>").append(result.getString("customer_name")).append("</td>")
				.append("<td>").append(result.getString("Customer_email")).append("</td>")
				.append("<td>").append(result.getString("Customer_job")).append("</td>")
				.append("<td>").append(result.getString("contact_fname")).append(result.getString("contact_lname")).append("</td></tr>");
				}
		return Str;
	}

}
