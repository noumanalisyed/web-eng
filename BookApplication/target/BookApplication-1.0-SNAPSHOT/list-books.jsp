<%--
  Created by IntelliJ IDEA.
  User: Mian Faizan Arshad
  Date: 17-Apr-21
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Book Management App</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Library Management</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- put new button: Add Student -->

        <input type="button" value="Add Student"
               onclick="window.location.href='add-book-form.jsp'; return false;"
               class="add-book-button"
        />

        <table>

            <tr>
                <th>Book Title</th>
                <th>Author Name</th>
                <th>Category</th>
                <th>Price</th>
            </tr>

            <c:forEach var="tempBook" items="${BOOK_LIST}">

                <!-- set up a link for each student -->
                <c:url var="tempLink" value="BookServlet">
                    <c:param name="command" value="LOAD" />
                    <c:param name="bookId" value="${tempBook.id}" />
                </c:url>

                <!--  set up a link to delete a student -->
                <c:url var="deleteLink" value="BookServlet">
                    <c:param name="command" value="DELETE" />
                    <c:param name="bookId" value="${tempBook.id}" />
                </c:url>

                <tr>
                    <td> ${tempBook.BookTitle} </td>
                    <td> ${tempBook.AuthorName} </td>
                    <td> ${tempBook.Catogory} </td>
                    <td> ${tempBook.Price} </td>
                    <td>
                        <a href="${tempLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this Book?'))) return false">
                            Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>