<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: #f1f1f1;
}

li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

li a.active {
    background-color: #4CAF50;
    color: white;
}

li a:hover:not(.active) {
    background-color: #555;
    color: white;
}
</style>
</head>
<body>
<h1>VEHICLE MANAGEMENT SYSTEM</h1>
<ul>
<li><a class="active" href="enquiry-add.jsp">Enquiry Add</a></li>
<li><a href="customer-add.jsp">Customer Add</a></li>
<li><a href="enquiry-list.jsp">List Enquiry</a></li>
<li><a href="customer-list.jsp">List customer</a></li>
<li><a href="contact-add.jsp">contact Add</a></li>
<li><a href="enquiry-delete.jsp">enquiry delete</a></li>
</ul>
</body>
</html>