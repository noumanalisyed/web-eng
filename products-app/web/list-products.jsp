<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Product Management App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Inventory Management System</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<c:input type="button" value="Add Product"
				   onclick="window.location.href='add-product-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Brand</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempProduct" items="${PRODUCT_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="ProductController">
						<c:param name="command" value="LOAD" />
						<c:param name="productId" value="${tempProduct.productId}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="ProductController">
						<c:param name="command" value="DELETE" />
						<c:param name="productId" value="${tempProduct.productId}" />
					</c:url>
																		
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.description} </td>
						<td> ${tempProduct.brand} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








