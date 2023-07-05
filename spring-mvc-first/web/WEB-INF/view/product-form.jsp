<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Product Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="product">
	
		Name: <form:input path="name" />
		
		<br><br>
	
		Description: <form:textarea path="description" />

		<br><br>

		Price: <form:input path="price" />
		
		<br><br>
	
		Country:

	    <form:select path="category">
	     	<form:options items="${theCategoryOptions}" />
	    </form:select>
    		
				
		<br><br>

		Favorite Brands:
		
		<form:radiobuttons path="favoriteBrand" items = "${product.favoriteBrandsOptions}" />
	

		<br><br>

		Feedback:
		
		Buy Again <form:checkbox path="feedback" value="Buy again" />
		Average quality <form:checkbox path="feedback" value="Average Quality" />
		Good Price <form:checkbox path="feedback" value="Good Price" />

		<br><br>
	
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>












