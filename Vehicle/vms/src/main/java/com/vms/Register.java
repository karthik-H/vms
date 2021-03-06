package com.vms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Statement stmt;
	java.sql.Connection con=null;
	private String username ="";
	private String password = "";
	private String email = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehicle","root","");
			username = request.getParameter("user_name").toString();
			password = request.getParameter("user_password").toString();
			email = request.getParameter("user_email").toString();
			stmt=con.createStatement();
			String str = "INSERT INTO user(username,email,password)"
					+ " VALUES('"+username+"','"+email+"','"+password+"')";
			System.out.println("user Insert======"+str);
			int result=stmt.executeUpdate(str);
			PrintWriter out = response.getWriter();
			if(result<0){
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('unable to register try again');");
				   out.println("location='register.jsp';");
				   out.println("</script>");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
			
		}catch(Exception e) {
			
		}
	}

}
