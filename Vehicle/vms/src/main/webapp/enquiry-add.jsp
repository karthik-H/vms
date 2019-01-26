<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mybean1" class="com.vms.Enquiry_Add" scope="request" />
<html >
<head>
  <meta charset="UTF-8">
  <title>Enquery Details</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
      <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
<a href="home.jsp">Home</a>
    <a href="customer-add.jsp">Customer Add</a>
  <form method="post" action="Enquiry_Add">
    <div class="row">
      <h4>Enquery Add</h4>
      <div class="input-group input-group-icon">
        <input type="text" placeholder="Enquery Name" name="enqueryName"/>
      </div>
      <div class="input-group input-group-icon">
      <div class="row">
      <h5>Contact name</h5>
      </div>
       <select name="contactId"><%=mybean1.populateContact() %></select>
      </div>
      <div class="row">
      <h5>Company name</h5>
      </div>
	   <div class="input-group input-group-icon">
	   <select name="itemId"><%=mybean1.populateItem() %></select>
      </div>
	     <div class="input-group input-group-icon">
        <input type="text" placeholder="Enquery Description" name="enqueryDesc"/>
      </div>
         <div class="input-group input-group-icon">
        <input type="text" placeholder="Source Of Enquery" name="soe"/>
      </div>
      <div class="input-group input-group-icon">
       <input type="submit" value="add" />
      </div>
    </div>
  </form>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="js/index.js"></script>
</body>
</html>

