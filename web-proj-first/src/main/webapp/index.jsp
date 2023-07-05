<%@ page import="java.util.Timer" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.web.project.web_proj_first.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%!
        public String makeItLower(String data){
            return data.toLowerCase();
        }
        public String makeItUpper(String data){
            return data.toUpperCase();
        }
    %>
</head>
<body>
<h1><%= "Hello World!" %>

</h1>
<br/>

<a href="hello-servlet">Hello Servlet</a>
<p>Current Date Time on Server is = <%= new java.util.Date()%></p>
<p>4 + 5 = <%=4+5%></p>
<p>4 x 5 = <%=4*5%></p>
<p>4 - 5 = <%=4-5%></p>
Converting Results to UpperCase : <%= new String("pakistan").toUpperCase()%> </br>
// JSP Expression
25 Multiplied by 4 <%= 25 * 4%> </br>
67 is less than 75 <%=67 < 75 %> </br>

<%
    int i = 1;
    while (i <= 5) {
        out.println(makeItLower("WEB ENGINEERING") + i);
        //hello
%>
</br>
<%
        out.println(makeItUpper("web engineering") + i);
%>
</br>
<%
        i++;
    }
%>
<P>PAKISTAN = <%= makeItLower("PAKISTAN")%></P>

<p>NADEEM = <%=UtilityClass.makeItLower("NADEEM")%></p>
<p>NADEEM = <%=UtilityClass.makeItUpper("nadeem")%></p>
<p>Current Date Time = <%=UtilityClass.getCurrentDateAndTime()%></p>
</body>
</html>
