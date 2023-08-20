<%@ page import="com.sun.prism.shader.DrawEllipse_LinearGradient_PAD_AlphaTest_Loader" %>
<html>

<head><title>User Data </title></head>

<body>

	The User Information :
	<%
		String hobbies[] = request.getParameterValues("hobbies");
	%>
	<TABLE border="1">
		<tr>
			<td>First Name:</td>
			<td><%=request.getParameter("txtFirstName")%></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><%=request.getParameter("txtLastName")%></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><%=request.getParameter("txtAddress")%></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><%=request.getParameter("txtEmail")%></td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td><%=request.getParameter("gender")%></td>
		</tr>
		<tr>
			<td>Marital Status :</td>
			<td><%=request.getParameter("marital-status")%></td>
		</tr>
		<tr>
			<td>Hobbies:</td>
			<td><%
				for (String hobby : hobbies)
					out.print(hobby+"</br>");
				%></td>
		</tr>

	</TABLE>
</body>
</html>
