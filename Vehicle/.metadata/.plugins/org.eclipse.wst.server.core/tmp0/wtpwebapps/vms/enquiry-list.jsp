<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mybean1" class="com.vms.Enquiry_List" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enquiry list</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
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
 <button onclick='location.href="enquiry-add.jsp";' class="w3-button w3-black" >Enquiry Add</button>
</br>
</br>
<table>
  <tr>
    <th>Sl.no</th>
    <th>Enquiry ID</th>
    <th>Enquiry Name</th>
    <th>Customer</th>
    <th>Contact</th>
    <th>Model</th>
    <th>Item</th>
  </tr>
  <%=mybean1.populateEnquiryTable() %>
</table>
</body>
</html>