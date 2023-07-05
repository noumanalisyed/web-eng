<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

The Product is : ${product.name} ${product.description}

<br><br>

Category: ${product.category}

<br><br>

Favorite Brand: ${product.favoriteBrand}

<br><br>

Feed Back:

<ul>
	<c:forEach var="temp" items="${product.feedback}">

		<li> ${temp} </li>

	</c:forEach>
</ul>

</body>

</html>







