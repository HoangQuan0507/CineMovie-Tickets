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


</style>

<body>
<!-- Nav -->
<jsp:include page="../template/nav.jsp"/>

<!-- Content-->
<div class="container" style="margin-top: 50px">

    <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
        <!-- Search form -->
        <form>
            <input class="my-0 py-1" placeholder="Search" name="code" type="text" id="code">
            <button type="submit" class="btn-primary btn">Tìm</button>
        </form>
    </div>

    <c:choose>
        <c:when test="${isHasValue == true}">
            <jsp:include page="info-ticket.jsp"/>
        </c:when>
        <c:when test="${isSearched == true}">
            <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
                <hr/>
                <h5>không tìm thấy kết quả!</h5>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
                <hr/>
                <h5>Nhập code để tìm kiếm!</h5>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<!-- Footer -->
<jsp:include page="../template/footer.jsp"/>
</body>
</html>
