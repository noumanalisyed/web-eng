<%--
  Created by IntelliJ IDEA.
  User: Mian Faizan Arshad
  Date: 17-Apr-21
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.Assignment_02.Book" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>
    <title>Book Tracker App</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
    // get the Books from the request object (sent by servlet)
    List<Book> theBooks =
            (List<Book>) request.getAttribute("Book_LIST");
%>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Library System</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <table>

            <tr>
                <th>Book Title</th>
                <th>Author Name</th>
                <th>Category</th>
                <th>Price</th>
            </tr>

            <% for (Book tempBook : theBooks) { %>

            <tr>
                <td> <%= tempBook.getBookTitle() %> </td>
                <td> <%= tempBook.getAuthorName() %> </td>
                <td> <%= tempBook.getCategory() %> </td>
                <td> <%= tempBook.getPrice() %> </td>
            </tr>

            <% } %>

        </table>

    </div>

</div>
</body>


</html>
