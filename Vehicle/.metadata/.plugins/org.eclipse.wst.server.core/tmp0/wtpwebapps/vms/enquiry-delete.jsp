<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mybean1" class="com.vms.Enquiry_List" scope="request" />
<jsp:useBean id="mybean2" class="com.vms.Enquiry_Delete" scope="request" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="css/normalize.min.css">
  <link rel='stylesheet prefetch' href='css/font-awesome.min.css'>
  <link rel="stylesheet" href="css/style.css">
<title>Enquiry delete</title>
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
<a href="home.jsp">Home</a>
<a href="enquiry-add.jsp">Enquery Add</a>
</br>
<h1>Delete Query</h1>
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
<br>
<br>
 <form method="post" action="Enquiry_Delete">
 <div class="row">
 <div class="input-group input-group-icon">
 <h2>Select query to delete</h2>
 <select name="enquiryId"><%=mybean2.populateEnquiry() %></select>
 </div> 
 <div class="input-group input-group-icon">
       <input type="submit" value="delete" />
      </div>
 </div>
 </form>
</body>
</html>