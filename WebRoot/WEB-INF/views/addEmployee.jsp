<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Add Employee Data</h2>
		<form:form method="POST" action="/sdnext/save.html">
	   		<table>
			    
			    <tr>
			        <td><form:label path="brand">Brand</form:label></td>
			        <td><form:input path="brand" value="${car.brand}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="power">Power</form:label></td>
			        <td><form:input path="power" value="${car.power}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="price">Price</form:label></td>
			        <td><form:input path="price" value="${car.price}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="model">Model</form:label></td>
                    <td><form:input path="model" value="${employee.model}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
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