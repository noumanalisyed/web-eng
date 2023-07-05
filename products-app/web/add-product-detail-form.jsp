<!DOCTYPE html>
<html>

<head>
	<title>Add Product</title>

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
		<h3>Add Product Detail</h3>
		
		<form action="ProductDetailController" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Product Price:</label></td>
						<td><input type="text" name="price" /></td>
					</tr>

					<tr>
						<td><label>Size:</label></td>
						<td><input type="text" name="size" /></td>
					</tr>

					<tr>
						<td><label>Product:</label></td>
						<td><select name="product">
							<c:forEach items="${PRODUCTLIST}" var="product">
								<option value="${product.productId}">${product.name}</option>
							</c:forEach>
						</select></td>
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
			<a href="ProductDetailController">Back to List</a>
		</p>
	</div>
</body>

</html>











