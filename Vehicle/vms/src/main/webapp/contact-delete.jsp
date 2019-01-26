<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mybean1" class="com.vms.Contact_Delete" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Delete</title>
  <link rel="stylesheet" href="css/normalize.min.css">
  <link rel='stylesheet prefetch' href='css/font-awesome.min.css'>
  <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
 <button onclick='location.href="index.jsp";' class="w3-button w3-black" >Home</button>
  <button onclick='location.href="contact-add.jsp";' class="w3-button w3-black" >Contact Add</button>
</br>
<h1>Contact delete</h1>
</br>
<table>
  <tr>
    <th>Sl.no</th>
    <th>Contact Id</th>
    <th>Contact FirstName</th>
    <th>Contact Email</th>
    <th>Contact LastName</th>
    <th>Contact Mobile</th>
    <th>Contact Job</th>
    <th>Customer Name</th>
  </tr>
  <%=mybean1.populateContactTable() %>
</table>
<br>
<br>
 <form method="post" action="Contact_Delete">
 <div class="row">
 <div class="input-group input-group-icon">
 <h2>Select contact to delete</h2>
 <select name="contactId"><%=mybean1.populateContact() %></select>
 </div> 
 <div class="input-group input-group-icon">
       <input type="submit" value="delete" />
      </div>
 </div>
 </form>
</body>
</html>