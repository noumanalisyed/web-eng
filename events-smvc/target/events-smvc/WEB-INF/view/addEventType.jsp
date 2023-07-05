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
	<body><center>
		<h2>Create New Category</h2>
		<form:form method="POST" action="saveEventType.html">
	   		<table>
			    <tr>
			        <td><form:label path="id">Event Type ID:</form:label></td>
			        <td><form:input path="id" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Category Name:</form:label></td>
			        <td><form:input path="name" value="${eventType.name}"/></td>
			    </tr>
				<tr>
			        <td><form:label path="createdAt">Created At :</form:label></td>
			        <td><form:input path="createdAt" value="${eventType.createdAt}"/></td>
			    </tr>
				<tr>
			        <td><form:label path="updatedAt">Updated At :</form:label></td>
			        <td><form:input path="updatedAt" value="${eventType.updatedAt}"/></td>
			    </tr>
			    
			   	<tr>
			    <tr>
			    	<td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      	</tr>
			</table> 
		</form:form>
		<br/>
  <c:if test="${!empty categories}">
	<table align="center" border="1">
		<tr>
			<th>ID</th>
			<th>Event Type Name</th>
			<th>Created At</th>
			<th>Updated At</th>
			<th>Options</th>
		</tr>

		<c:forEach items="${eventTypes}" var="eventObj">
			<tr>
				<td><c:out value="${eventObj.id}"/></td>
				<td><c:out value="${eventObj.name}"/></td>
				<td><c:out value="${eventObj.createdAt}"/></td>
				<td><c:out value="${eventObj.updatedAt}"/></td>
				<td align="center"><a href="editEventType.html?eventTypeId=${eventObj.id}">Edit</a> | <a href="deleteEventType.html?eventTypeId=${eventObj.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
		<h2><a href="addEventType.html">Adding Event Type</a></h2>
		<h2><a href="addTournamentType.html">Adding Tournament Type</a></h2>
		<h2><a href="addEvent.html">Adding Event</a></h2>
		<h2><a href="addTournament.html">Adding Tournament</a></h2>
</center>
	</body>
</html>
