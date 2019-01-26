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
 * Servlet implementation class Enquiry_List
 */
public class Enquiry_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Statement stmt=null;  
	java.sql.Connection con=null;
	public ResultSet result=null;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enquiry_List() {
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
	public StringBuilder populateEnquiryTable() throws ClassNotFoundException, SQLException{
		StringBuilder Str=new StringBuilder();
		Class.forName("com.mysql.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");  
		stmt=con.createStatement();
		String Sql="SELECT enquiry_id,enquiry_Name,customer_name,contact_lname,contact_fname,model_name,item_name"
				+ " FROM enquiry "
				+ " INNER JOIN contact ON contact_id=enquiry_contact_id"
				+ " INNER JOIN customer ON customer_id=contact_customer_id"
				+ " INNER JOIN item ON item_id=enquiry_item_id"
				+ " INNER JOIN model ON model_id=item_model_id";
				System.out.println("Sql======"+Sql);
				result=stmt.executeQuery(Sql);
				int count=0;
				while(result.next()){
					count++;
				Str.append("<tr><td>").append(count).append("</td>")
				.append("<td>").append(result.getString("enquiry_id")).append("</td>")
				.append("<td>").append(result.getString("enquiry_Name")).append("</td>")
				.append("<td>").append(result.getString("customer_name")).append("</td>")
				.append("<td>").append(result.getString("contact_fname")).append(result.getString("contact_lname")).append("</td>")
				.append("<td>").append(result.getString("model_name")).append("</td>")
				.append("<td>").append(result.getString("item_name")).append("</td></tr>");
				}
		return Str;
	}

}
