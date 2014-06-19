<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.util.*" %>
<%@ page import= "java.sql.*" %>
    <%@ page import="java.text.NumberFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td
{
border: 1px solid black;
border-collpse: co
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>ADMINISTRATIVE PAGE</title>
</head>
<body>
<center>
<body bgcolor="gold">
<font color="green" size="10">
<h1> Welcome to the bFIT4java Administrator Page! </h1>
<img src="BFIT.png" height ="150"width = "300"/><br></center>


<form name="form" action="http://localhost:8082/OSM/AdminAddServlet">




<h2> <Center> P R O D U C T Modification System- Please complete the fields below:</Center></h2>


<font size="7">


<%

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "jades123");

Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("select * from Product");
%>


<h2>
<center>
<table>
<tr><td>
Product ID</td><td>  <INPUT TYPE="TEXT" NAME="id" LENGTH="30"></td></tr>


<tr><td>Product Name</td><td> <INPUT TYPE="TEXT" NAME="name" LENGTH="30"></td></tr>


<tr><td>Product Price </td><td><INPUT TYPE="TEXT" NAME="price" LENGTH="30"></td></tr>
</table>
</center><br>
<center><input type="submit" value="ADD" style="height:50px; width: 100px"/></center><br>


</h2>


<TABLE align="center" BORDER="1" CELLPADDING="3" CELLSPACING="1">


<TR>


<TH>Product_ID</TH>


<TH>Product_Name</TH>


<TH>Product_Price</TH>


</TR>


<% while(rs.next()) {

%>


<tr>


<td><center><%=rs.getString(1)%></center>  </td>


<td> <%=rs.getString(2) %> </td>

<td> <%=rs.getString(3) %> </td>
</tr>


<% } %>


</TABLE>


</body>


<a href="HomePgForm.html"></a><input type="submit" value="Back" />


</font>
</form>


</html>
