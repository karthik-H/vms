<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mybean1" class="com.vms.Customer_Update" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Contact update</title>
  <link rel="stylesheet" href="css/normalize.min.css">
  <link rel='stylesheet' href='css/font-awesome.min.css'>
      <link rel="stylesheet" href="css/styles.css">
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container">
 <button onclick='location.href="index.jsp";' class="w3-button w3-black" >Home</button>
  <form method="post" action="Customer_Update">
 <div class="row">
   <div class="input-group input-group-icon"> 
	   <select name="customerId"><%=mybean1.populateCustomer() %></select>
      </div>
      <h4>Customer Details</h4>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Customer Name" name="customerName"/>
      </div>
      <div class="input-group input-group-icon">
        <input type="email" placeholder="Email Adress" name="customerEmail"/>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Job" name="customerJob"/>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Address" name="customerAddress"/>
      </div>
      <div class="col-half">
        <div class="input-group">
          <input type="radio" name="gender" value="male" id="gender-male" name="gender"/>
          <label for="gender-male">Male</label>
          <input type="radio" name="gender" value="female" id="gender-female" name="gender"/>
          <label for="gender-female">Female</label>
        </div>
      </div>
      </div>
       <div class="input-group input-group-icon">
       <input type="submit" value="add" />
      </div>
       </form>
    </div>

  <script src='js/jquery.js'></script>
    <script  src="js/index.js"></script>
</body>
</html>