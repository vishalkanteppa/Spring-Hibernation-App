<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
</head>
<body>
<h1>List Employees</h1>
<h3><a href="add.html">Add More Cars</a></h3>

<c:if test="${!empty employees}">
		<h2>List Employees</h2>
	<table align="left" border="1">
		<tr>
			
			<th>Car Brand</th>
			<th>Car Power</th>
			<th>Car Price</th>
			<th>Car Model</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${employees}" var="car">
			<tr>
				
				<td><c:out value="${car.brand}"/></td>
				<td><c:out value="${car.power}"/></td>
				<td><c:out value="${car.price}"/></td>
				<td><c:out value="${car.model}"/></td>
				<td align="center"><a href="edit.html?id=${car.id}">Edit</a> | <a href="delete.html?id=${car.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>