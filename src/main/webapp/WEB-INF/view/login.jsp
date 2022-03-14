<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../../resources/css/login.css">

    <meta charset="ISO-8859-1">
    <title>Employee Management System - JEE</title>
</head>
<body>

<div class="background-wrap">
    <div class="background"></div>
</div>

<form id="accesspanel" action="<%=request.getContextPath()%>/checkLogin" modelAttribute="admin" method="post">
    <h1 id="litheader">JEE</h1>
    <div class="inset">
        <p>
            <input type="text" name="emailAdress" id="emailAdress" placeholder="Email address">
        </p>
        <p>
            <input type="password" name="password" id="password" placeholder="Access code">
        </p>

    </div>
    <p class="p-container">
        <input type="submit" name="Login" id="go" value="Authorize"
        <%-- On click we call the spring checklogin controller mapping--%>
        onclick="window.location.href='checkLogin'; return false;" >
    </p>
</form>

</body>
</html>!