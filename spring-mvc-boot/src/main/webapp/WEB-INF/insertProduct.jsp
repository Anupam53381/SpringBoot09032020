<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> ${myheader}</h2>
	
	<form:form action="registerProduct" modelAttribute="product"  method="get">
	
	<!-- Product Id : <input type="text" name="productId" > <br/> -->
	
	Product Id <form:input path="productId"/> <br/>
	
	<form:errors path="productId"></form:errors>
	
	<!-- Product Name : <input type="text" name="productName" > <br/> -->
	
	Product Name <form:input path="productName"/> <br/>
	
	
	<!-- Product Cost : <input type="text" name="productCost" > <br/> -->
	
	Product Cost <form:input  path="productCost"/> <br/>
	
	<input type="submit" value="Register">
	
	
	</form:form>
	
	
</body>
</html>