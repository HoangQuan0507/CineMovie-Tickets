<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <!-- Head -->
    <jsp:include page="../template/header.jsp"/>
</head>

<style>
    #code {
        width: auto;
        height: 30px;
    }

    .container {
        margin-top: 50px;
        padding: 20px;
        min-height: 400px;
    }

</style>

<body>
<!-- Nav -->
<jsp:include page="../template/nav.jsp"/>

<!-- Content-->
<div class="container">
    <jsp:include page="ticket.jsp"/>
</div>

<!-- Footer -->
<jsp:include page="../template/footer.jsp"/>
</body>
</html>