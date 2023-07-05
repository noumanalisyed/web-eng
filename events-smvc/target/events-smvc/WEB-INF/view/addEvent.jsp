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
		<h2>Create New Event</h2>
		<form:form method="POST" action="saveEvent.html">
	   		<table>
			    <tr>
			        <td><form:label path="name">Event Name :</form:label></td>
			        <td><form:input path="name" value="${event.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="tournamentId">Tournament Name:</form:label></td>
			        <td><form:input path="tournamentId" value="${event.tournamentId}"/></td>
			    </tr>
				<tr>
					<td><form:label path="startDate">Start Date :</form:label></td>
					<td><form:input path="startDate" value="${event.startDate}"/></td>
				</tr>
				<tr>
					<td><form:label path="endDate">End Date :</form:label></td>
					<td><form:input path="endDate" value="${event.endDate}"/></td>
				</tr>
				<tr>
					<td><form:label path="status">Status :</form:label></td>
					<td><form:input path="status" value="${event.status}"/></td>
				</tr>
				<tr>
					<td><form:label path="createdAt">Created At :</form:label></td>
					<td><form:input path="createdAt" value="${event.createdAt}"/></td>
				</tr>
				<tr>
					<td><form:label path="updatedAt">Updated At :</form:label></td>
					<td><form:input path="updatedAt" value="${event.updatedAt}"/></td>
				</tr>
				<tr>
					<td><form:label path="activated">Activated :</form:label></td>
					<td><form:input path="activated" value="${event.activated}"/></td>
				</tr>
				<tr>
					<td><form:label path="eventTypeId">EventType Id :</form:label></td>
					<td><form:input path="eventTypeId" value="${event.eventTypeId}"/></td>
				</tr>
			   	<tr>
			    <tr>
			    	<td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      	</tr>
			</table> 
		</form:form>
		<br/>
  <c:if test="${!empty events}">
	<table align="center" border="1">
		<tr>
			<th>Event ID</th>
			<th>Event Name</th>
			<th>Tournament Name</th>
			<th>Start Date </th>
			<th>End Date</th>
			<th>Status</th>
			<th>Created At</th>
			<th>Updated At</th>
			<th>Activated </th>
			<th>Event Type</th>
			<th>Options</th>
		</tr>

		<c:forEach items="${events}" var="eventObj">
			<tr>
				<td><c:out value="${eventObj.id}"/></td>
				<td><c:out value="${eventObj.name}"/></td>
				<td><c:out value="${eventObj.tournamentId}"/></td>
				<td><c:out value="${eventObj.startDate}"/></td>
				<td><c:out value="${eventObj.endDate}"/></td>
				<td><c:out value="${eventObj.status}"/></td>
				<td><c:out value="${eventObj.createdAt}"/></td>
				<td><c:out value="${eventObj.updatedAt}"/></td>
				<td><c:out value="${eventObj.activated}"/></td>
				<td><c:out value="${eventObj.eventTypeId}"/></td>
				<td align="center"><a href="editEvent.html?eventId=${eventObj.id}">Edit</a> | <a href="deleteEvent.html?eventId=${eventObj.id}">Delete</a></td>
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
