<%--
  Created by IntelliJ IDEA.
  User: nouman
  Date: 2/13/2023
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Response</title>
</head>
<body>
      First Name : <%=request.getParameter("txtFirstName")%>
      Last Name : <%=request.getParameter("txtLastName")%>
      Country : <%=request.getParameter("country")%>
      Favorite Language :   <%=request.getParameter("favoriteLanguage")%>
        <%
            String favoriteSports [] = request.getParameterValues("favoriteSport");
        %>
      Favorite Sports :
      <UL>
      <% for(int i =0; i< favoriteSports.length; i++){
          %>
            <LI><%=favoriteSports[i]%></LI>
          <%
              }
          %>
      </UL>
    <p>Response Through Expression Language </p>
      First Name : ${param.txtFirstName}
      Last Name : ${param.txtLastName}
      Country : ${param.country}
      </br>Favorite Language : ${param.favoriteLanguage}
      </br>Favorite Sport :
      <UL>
      <%
          String  favSport[] = request.getParameterValues("favoriteSport");
          for (int j=0; j <  favSport.length; j++){
      %>
          <LI> <%=favSport[j].toString() %></LI>
      <%
          }
      %>
      </UL>
</body>
</html>
