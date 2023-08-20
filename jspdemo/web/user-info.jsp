<%--
  Created by IntelliJ IDEA.
  User: nouman
  Date: 7/17/2023
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="user-info-response.jsp" method="post" >
  <TABLE>
    <Tr>
      <Td>First Name :</Td><td><input type="text" name="txtFirstName"/></td>
    </Tr>
    <tr>
      <td>Last Name :</td><td><input type="text" name="txtLastName"/></td>
    </tr>
   <<tr>
      <td>Gender :</td>
    <td><input type="radio" name="gender" value="Male"/>Male
    <input type="radio" name="gender" value="Female"/>Female</td>
   </tr>
   <tr>
     <td>Address :</td><td><input type="text" name="txtAddress"/></td>
   </tr>
    <tr>
      <td>Marital Status :</td> <td><select name="marital-status">
                                        <option>Single</option>
                                        <option>Married</option>
                                    </select>
                                </td>
    </tr>
    <tr>
      <td>Email  :</td><td> <input type="text" name="txtEmail"/></td>
    </tr>
    <tr>
      <td>Hobbies :</td><td> <input type="checkbox" name="hobbies" value="gaming"/>Gaming
                             <input type="checkbox" name="hobbies" value="reading"/>Reading
                             <input type="checkbox" name="hobbies" value="movies"/>Movies
                        </td>
    </tr>
    <tr>
        <td><input type="submit" value="submit"/></td>
        <td><input type="reset" value="reset"/></td>
    </tr>
  </TABLE>
</form>

</body>
</html>
