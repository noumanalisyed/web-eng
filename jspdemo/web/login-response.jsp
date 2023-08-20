<html>

<head><title>Login Confirmation Title</title></head>

<body>

	<%!
		String storedUserName = "admin";
		String storedPassword = "admin";
		String message = "";

		boolean getVerifiedLogin(String userName, String password){
			boolean flag = false;
			if (userName.equals(storedUserName)
					&& password.equals(storedPassword)){
				flag = true;
			}
			return flag;
		}
	%>
	<%
		String strUserName = request.getParameter("txtUserName");
		String strPassword = request.getParameter("txtPassword");
		if (getVerifiedLogin(strUserName,strPassword)){
			message = "Welcome "+request.getParameter("txtUserName")+"," +
					" Login Successful ";
		}
		else{
			message = "User Name or Password invalid !!! ";
		}

	%>
	Message : <%=message %>

</body>
</html>
