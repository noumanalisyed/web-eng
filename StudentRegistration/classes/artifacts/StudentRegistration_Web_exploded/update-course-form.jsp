<!DOCTYPE html>
<html>

<head>
	<title>Update Course</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Course</h3>
		
		<form action="CourseControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="courseId" value="${THE_COURSE.courseId}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Course name:</label></td>
						<td><input type="text" name="courseName"
								   value="${THE_COURSE.courseName}" /></td>
					</tr>

					<tr>
						<td><label>Course Code:</label></td>
						<td><input type="text" name="courseCode"
								   value="${THE_COURSE.courseCode}" /></td>
					</tr>

					<tr>
						<td><label>Decription:</label></td>
						<td><input type="text" name="description"
								   value="${THE_COURSE.description}" /></td>
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
			<a href="CourseControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











