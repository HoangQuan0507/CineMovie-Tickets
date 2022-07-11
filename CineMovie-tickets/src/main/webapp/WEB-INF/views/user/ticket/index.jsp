<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <!-- Head -->
    <jsp:include page="../../template/header.jsp"/>
</head>

<style>
    body #chair button {
        width: 50px;
        height: 50px;
        margin-left: 15px;
        margin-right: 15px;
        margin-top: 10px;
        margin-bottom: 10px;
    }

</style>

<body>
<!-- Nav -->
<jsp:include page="../../template/nav.jsp"/>

<div class="container">
    <div>

        <ul class="pagination">
            <%
                LocalDate now = LocalDate.now();
                String dateSelected = (String) request.getAttribute("date");

                for (int i = 0; i < 7; i++) {
                    LocalDate date = now.plusDays(i);

                    if (dateSelected.equals(date.toString())) {
                        out.println(String.format("<li class='active'><a href='/purchase/%d/%d/%s'>%d/%d/%d</a></li>",
                                request.getAttribute("movieId"),
                                request.getAttribute("cityId"),
                                date.toString(),
                                date.getDayOfMonth(),
                                date.getMonthValue(),
                                date.getYear()
                        ));
                    } else {
                        out.println(String.format("<li><a href='/purchase/%d/%d/%s'>%d/%d/%d</a></li>",
                                request.getAttribute("movieId"),
                                request.getAttribute("cityId"),
                                date.toString(),
                                date.getDayOfMonth(),
                                date.getMonthValue(),
                                date.getYear()
                        ));
                    }
                }
            %>
        </ul>
    </div>

    <div>
        <ul class="pagination">
            <c:forEach items="${cities}" var="city">
                <li <c:if test="${city.id == cityId}">class='active'</c:if>>
                    <a href='/purchase/${movieId}/${city.id}/${date}'>${city.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div>
        <c:choose>
            <c:when test="${cinemas.size() != 0}">
                <c:forEach items="${cinemas}" var="cinema">
                    <label>${cinema.name}</label>
                    <ul>
                        <c:forEach items="${cinema.schedules}" var="schedule">
                            <li><a class="btn-primary btn" role="button" href="/booking/chair/${schedule.id}">${schedule.time}</a></li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </c:when>

            <c:otherwise>
                <p>Xin lỗi chưa có lịch chiếu!</p>
            </c:otherwise>
        </c:choose>
    </div>

</div>

<!-- Footer -->
<jsp:include page="../../template/footer.jsp"/>
</body>
</html>
