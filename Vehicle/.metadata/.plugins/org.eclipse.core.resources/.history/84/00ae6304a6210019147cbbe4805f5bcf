<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mybean1" class="com.vms.Contact_Add" scope="request" />
<html >
<head>
  <meta charset="UTF-8">
  <title>Contact Add</title>
  <link rel="stylesheet" href="css/normalize.min.css">
  <link rel='stylesheet prefetch' href='css/font-awesome.min.css'>
  <link rel="stylesheet" href="css/styles.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
<div class="container">
 <button onclick='location.href="index.jsp";' class="w3-button w3-black" >Home</button>
  <button onclick='location.href="customer-list.jsp";' class="w3-button w3-black" >Customer List</button>
    <div class="row">
      <h4>Contact Details</h4>
 <div class="input-group input-group-icon">

	   <select name="customerId"><%=mybean1.populateCustomer() %></select>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Contact First Name" name="contactfName"/>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Contact Last Name" name="contactlName"/>
      </div>
      <div class="input-group input-group-icon">
        <input type="email" placeholder="Email Adress" name="contactEmail"/>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Mobile" name="contactMobile"/>
      </div>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Job" name="contactJob"/>
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
