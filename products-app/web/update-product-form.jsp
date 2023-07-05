<!DOCTYPE html>
<html>

<head>
	<title>Update Product</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Inventory Management System</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Product</h3>
		
		<form action="ProductController" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="productId" value="${THE_PRODUCT.productId}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Product Name:</label></td>
						<td><input type="text" name="name"
								   value="${THE_PRODUCT.name}" /></td>
					</tr>

					<tr>
						<td><label>Description:</label></td>
						<td><input type="text" name="description"
								   value="${THE_PRODUCT.description}" /></td>
					</tr>

					<tr>
						<td><label>Brand:</label></td>
						<td><input type="text" name="brand"
								   value="${THE_PRODUCT.brand}" /></td>
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
			<a href="ProductController">Back to List</a>
		</p>
	</div>
</body>

</html>











