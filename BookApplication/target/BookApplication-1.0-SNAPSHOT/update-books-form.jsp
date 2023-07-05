<%--
  Created by IntelliJ IDEA.
  User: Mian Faizan Arshad
  Date: 17-Apr-21
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Update Book</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-Book-style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>Library System</h2>
    </div>
</div>

<div id="container">
    <h3>Update Book</h3>

    <form action="BookServlet" method="GET">

        <input type="hidden" name="command" value="UPDATE" />

        <input type="hidden" name="BookId" value="${THE_Book.id}" />

        <table>
            <tbody>
            <tr>
                <td><label>Book Title:</label></td>
                <td><input type="text" name="BookTitle"
                           value="${THE_Book.BookTitle}" /></td>
            </tr>

            <tr>
                <td><label>Author Name:</label></td>
                <td><input type="text" name="AuthorName"
                           value="${THE_Book.AuthorName}" /></td>
            </tr>

            <tr>
                <td><label>Category:</label></td>
                <td><input type="text" name="Category"
                           value="${THE_Book.Category}" /></td>
            </tr>

            <tr>
                <td><label>Price:</label></td>
                <td><input type="text" name="Price"
                           value="${THE_Book.Price}" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="BookServlet">Back to List</a>
    </p>
</div>
</body>

</html>
