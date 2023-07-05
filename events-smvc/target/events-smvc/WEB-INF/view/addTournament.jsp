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
		<h2>Create New Tournament</h2>
		<form:form method="POST" action="saveTournament.html" modelAttribute="command">
	   		<table>
			    <tr>
			        <td><form:label path="name">Name :</form:label></td>
			        <td><form:input path="name"/></td>
			    </tr>
				<tr>
					<td>
						<form:label path="tournamentType">Tournament Type:</form:label>
					</td>
					<td>
						<form:select path="tournamentType" cssStyle="width: 150px;">
							<option value="-1">Select a type</option>
							<c:forEach items="${tournamentTypes}" var="tournamentType">
								<option value="${tournamentType.id}">${tournamentType.name}</option>
							</c:forEach>
						</form:select>
					</td>
				</tr>
			    <tr>
			        <td><form:label path="startDate">Start Date :</form:label></td>
			        <td><form:input  path="startDate" value="${startDate}"/></td>
			    </tr>
				<tr>
					<td><form:label path="endDate">End Date :</form:label></td>
					<td><form:input  path="endDate" value="${endDate}"/></td>
				</tr>
				<tr>
					<td><form:label path="status">End Date :</form:label></td>
					<td><form:input  path="status" value="${status}"/></td>
				</tr>
				<tr>
					<td><form:label path="createdAt">Created Date :</form:label></td>
					<td><form:input  path="createdAt" value="${createdAt}"/></td>
				</tr>
				<tr>
					<td><form:label path="updatedAt">Updated Date :</form:label></td>
					<td><form:input  path="updatedAt" value="${updatedAt}"/></td>
				</tr>
				<tr>
					<td><form:label path="activated">Activated :</form:label></td>
					<td><form:input  path="activated" value="${activated}"/></td>
				</tr>
			   	<tr>
			    <tr>
			    	<td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      	</tr>
			</table>
		</form:form>
		<br/>
		<c:if test="${!empty tournaments}">
		<table align="center" border="1">
			<tr>
				<th>Tournament ID</th>
				<th>Tournament Name</th>

				<th>tournamentType</th>;

				<th>startDate</th>;

				<th>endDate</th>;

				<th>status</th>;

				<th>createdAt</th>;

				<th> updatedAt</th>;

				<th>activated</th>;
				<th>Options</th>
			</tr>

		<c:forEach items="${tournaments}" var="tObj">
			<tr>
				<td><c:out value="${tObj.id}"/></td>
				<td><c:out value="${tObj.name}"/></td>
				<td><c:out value="${tObj.tournamentType}"/></td>
				<td><c:out value="${tObj.startDate}"/></td>
				<td><c:out value="${tObj.endDate}"/></td>
				<td><c:out value="${tObj.status}"/></td>
				<td><c:out value="${tObj.createdAt}"/></td>
				<td><c:out value="${tObj.updatedAt}"/></td>
				<td><c:out value="${tObj.activated}"/></td>

				<td align="center"><a href="editTournament.html?tournamentId=${tObj.id}">Edit</a> | <a href="deleteTournament.html?tournamentId=${tObj.id}">Delete</a></td>
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
