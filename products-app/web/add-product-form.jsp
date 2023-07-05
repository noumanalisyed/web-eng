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
		<h3>Add Product</h3>
		
		<form action="ProductController" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Product Name:</label></td>
						<td><input type="text" name="name" /></td>
					</tr>

					<tr>
						<td><label>Description:</label></td>
						<td><input type="text" name="description" /></td>
					</tr>

					<tr>
						<td><label>Brand:</label></td>
						<td><input type="text" name="brand" /></td>
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











