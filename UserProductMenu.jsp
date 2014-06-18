<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
     <%@ page import="java.text.NumberFormat;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Menu</title>
</head>
<body>  <center>
<%Object tempUn=request.getAttribute("username");
String un=(String)tempUn; %>
<h1>Welcome <%out.print(un);%></h1><br>
<h2>Product Menu</h2><br><br>
<center>
	
	<%
		
	//grabs vectors from servlet and sets it to local vector in the jsp page
		Object id = request.getAttribute("productId");
		Vector productId = (Vector)id;
		Object name = request.getAttribute("productName");
		Vector productName = (Vector)name;
		Object price = request.getAttribute("productPrice");
		Vector productPrice = (Vector)price;
		//creates iterater to go through the vectors in print them out.
		//ANY JAVA CODE THAT YOU DO NOT WANT TO PRINT WORDS MUST BE SURROUNDED BY <% (OPEN AND CLOSE)
		Iterator itId = productId.iterator();
		Iterator itName = productName.iterator();
		Iterator itPrice = productPrice.iterator();
		int num=0;

		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		 %>	
		 
<form name="myform" onsubmit="return validate();" action="http://localhost:8082/OSM/pmenuservlet" method = "post">

		Search: <input type="text" name = "pp"><br><br>
	<input type = "submit" value ="Search"><br><br>
	
</form><br>

<form action="http://localhost:8082/OSM/AddToCartServlet" >
<table border = "1" color="FF0000">
<tr><td>Product ID</td><td>Product Name</td><td>Product Price</td></tr>

<%//started the iterator and display information in the vector 
while(itId.hasNext()){%>
<tr><td><%out.print(itId.next());%></td><td><%out.print(itName.next());%></td><td><%out.print(fmt.format(itPrice.next()));%></td><td><input type="checkbox" name = "buyList" value='<%=num %>'></td> </tr>
<%num++; %>
<% }%>
		
</table><br>
 <input type="hidden" name="productId" value="<%= request.getParameter("productId") %>" />


<input type="submit" value ="Add To Cart" style="height:60px; width:140px"><br>
</form>
</center>
<center>
<form action = >
<input type="submit" value ="Product View" style="height:60px; width:140px"><br>
</form>

 










<a style="margin-left:50px" href="history.go(-1)">BACK</a>
		</center>












</body>
</html>
