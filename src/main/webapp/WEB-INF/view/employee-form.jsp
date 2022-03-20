<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save New Employee</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/listEmployees.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/addEmployee.css">
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>EMS - Employee management system.</h2>
	</div>
</div>

<div id="container">
	<h3>Save Employee</h3>

	<form:form action="saveEmployee" modelAttribute="employee" method="POST">

		<table>
			<tbody>
			<i>
				Inputs with marked with * are required.
			</i>
			<br>
			<br>
			<tr>
				<td><label>First name (*):</label></td>
				<td><form:input path="firstName" />
					<form:errors path="firstName" cssClass="eroor" />
				</td>
			</tr>

			<tr>
				<td><label>Last name (*):</label></td>
				<td><form:input path="lastName" />
					<form:errors path="lastName" cssClass="eroor" />
				</td>
			</tr>

			<tr>
				<td><label>Email (*):</label></td>
				<td><form:input path="email" />
					<form:errors path="email" cssClass="eroor" />
				</td>
			</tr>

			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save" /></td>
			</tr>


			</tbody>
		</table>


	</form:form>

	<div style="clear: both;"></div>

	<p>
		<a href="${pageContext.request.contextPath}/employees">Back to Employee List</a>
	</p>

</div>

</body>

</html>
