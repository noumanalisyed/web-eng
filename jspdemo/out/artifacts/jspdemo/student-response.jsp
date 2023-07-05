<html>

<head><title>Student Confirmation Title</title></head>

<body>

	The student is confirmed: ${param.firstName} ${param.lastName}

	<p>Second Approach :
	</br>

	The Student is Confirmed : <%=request.getParameter("firstName") %> ,
							   <%= request.getParameter("lastName")%> </p>

</body>
</html>
