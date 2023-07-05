<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import="com.student.studentregistration.Utility" %>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Student Registration!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%!
    int j  = 0;
%>
<%
    Utility utility = new Utility();
%>
<form action="student-response.jsp" method="get">
    <table>
        <tr>
            <td><label>First Name : </label></td>
            <td><input type="text" name="txtFirstName"/></td>
        </tr>
        <tr>
            <td><label>Last Name : </label></td>
            <td><input type="text" name="txtLastName"/></td>
        </tr>
        <tr>
            <td><label>Country : </label></td>
            <td><select name="country">
                <%
                    for ( int i =0; i < utility.getLenght(); i++){
                %>
                    <option><%= utility.getCountry(i) %></option>
                <%
                        //System.out.println("Country : "+utility.getCountry(i));
                }
                %>
                </select>
            </td>
        </tr>
        <tr>
            <td><label>Favorite Programming Laguage : </label></td>
            <td>
                <input type="radio" name="favoriteLanguage" value="C++"/>C++
                <input type="radio" name="favoriteLanguage" value="Java"/>Java
                <input type="radio" name="favoriteLanguage" value="PhP"/>PhP
                <input type="radio" name="favoriteLanguage" value="Ruby"/>Ruby
            </td>
        </tr>
        <tr>
            <td><label>Favorite Sports : </label></td>
            <td>
                <input type="checkbox" name="favoriteSport" value="Cricket"/>Cricket
                <input type="checkbox" name="favoriteSport" value="Hockey"/>Hockey
                <input type="checkbox" name="favoriteSport" value="Football"/>Football
                <input type="checkbox" name="favoriteSport" value="Tennis"/>Tennis
            </td>
        </tr>
        <tr>
            <td><input type="submit" name="btnSubmit"/></td>
            <td><input type="reset" name="btnCancel"/></td>
        </tr>
    </table>
</form>
</body>
</html>
