<%--we add the JSTL support tag--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

    <title>List Employees</title>
    <%--    the be sure we are working with the propper app name we use ${pageContext.request.contextPath} --%>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/listEmployees.css"
    >
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>
            EMS - EMPLOYEES MANAGEMENT SYSTEM
        </h2>
        <h1>
            Welcome : ${admin.emailAdress}
        </h1>
    </div>
</div>

<div id="container">
    <div id="content">
        <!-- put new button: Add Customer -->

        <input type="button" value="Add a new employee."
        <%--               On click we call the spring showformforadd controller mapping--%>
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />

        <!--  add our html table here -->
        <table>
            <tr>
                <th>
                    First Name
                </th>

                <th>
                    Last Name
                </th>

                <th>
                    Email
                </th>

                <th>
                    Action
                </th>

                <%-- We loop over and we print our Employees --%>
                <%-- The employees items is generally possible to work with beacause of the model when we passed is through addAttribute--%>
                <c:forEach var="tempEmployee" items="${employees}">

                <!-- construct an "update" link with employee id -->
                <c:url var="updateLink" value="/employees/showFormForUpdate">
                    <c:param name="employeeId" value="${tempEmployee.id}"/>
                </c:url>

                <!-- construct an "delete" link with customer id -->
                <c:url var="deleteLink" value="/employees/delete">
                    <c:param name="employeeId" value="${tempEmployee.id}" />
                </c:url>

            <tr>
                    <%-- ${...} it's a jsp expression language to call the tempEmployee elements--%>
                <td>
                        ${tempEmployee.firstName}
                </td>

                <td>
                        ${tempEmployee.lastName}
                </td>

                <td>
                        ${tempEmployee.email}
                </td>

                <td>
                    <!-- display the update link -->
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}"
                       onclick="if (!(confirm('Are you sure you want to delete this employee from the lsit?'))) return false">Delete</a>
                </td>

            </tr>
            </c:forEach>
            </tr>
        </table>
    </div>
</div>


</body>

</html>









