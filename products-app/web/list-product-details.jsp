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
			
			<input type="button" value="Add Product Detail"
				   onclick="window.location.href='add-product-detail-form.jsp'; return false;"
				   class="add-student-button"/>
			
			<table>
			
				<tr>
					<th>Price</th>
					<th>Size</th>
					<th>Brand</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempProductDetail" items="${PRODUCT_DETAIL_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="ProductDetailController">
						<c:param name="command" value="LOAD" />
						<c:param name="productDetailId" value="${tempProductDetail.productDetailId}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="ProductDetailController">
						<c:param name="command" value="DELETE" />
						<c:param name="productDetailId" value="${tempProductDetail.productDetailId}" />
					</c:url>

					<c:url var="addLink" value="ProductDetailController">
						<c:param name="command" value="NEW" />
					</c:url>
																		
					<tr>
						<td> ${tempProductDetail.price} </td>
						<td> ${tempProductDetail.size} </td>
						<td> ${tempProductDetail.product.name} </td>
						<td>
							<a href="${addLink}">Add</a>
							|
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








