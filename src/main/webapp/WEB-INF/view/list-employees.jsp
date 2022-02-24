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
    </div>
</div>

<div id="container">
    <div id="content">
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

                <%-- We loop over and we print our Employees --%>
                <%-- The employees items is generally possible to work with beacause of the model when we passed is through addAttribute--%>
                <c:forEach var="tempEmployee" items="${employees}">
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
            </tr>
            </c:forEach>
            </tr>
        </table>
    </div>
</div>


</body>

</html>









