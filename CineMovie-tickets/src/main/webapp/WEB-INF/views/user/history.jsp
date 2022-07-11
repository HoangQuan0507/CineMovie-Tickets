<%@ page import="com.project.movietickets.entity.RoomMovieScheduleEntity" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <!-- Head -->
    <jsp:include page="../template/header.jsp"/>
</head>

<body>
<!-- Nav -->
<jsp:include page="../template/nav.jsp"/>
<!-- Content-->
<div class="container" style="min-height: 400px">
    <h2>Danh sách các vé đã đặt</h2>
    <div>
        <c:forEach var="ticket" items="${tickets}">
            <div class="panel panel-default">
                <div class="panel-heading">${ticket.roomMovieSchedule.movie.name}</div>
                <div class="panel-body">
                    <div>
                        <h4>Mã code: ${ticket.code}</h4>
                    </div>
                    <div>
                        <h4>Ngày đặt: ${ticket.date}</h4>
                    </div>
                    <div>
                        <h4>Ngày chiếu: ${ticket.roomMovieSchedule.schedule.time}</h4>
                    </div>
                    <div>
                        <h4>Phòng: ${ticket.roomMovieSchedule.room.name}</h4>
                    </div>
                    <div>
                        <h4>Ghế: ${ticket.roomChair.chair.position}</h4>
                    </div>
                    <div>
                        <a href="/history/${ticket.id}/delete" type="button" class="btn btn-primary">Hủy vé</a>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</div>
<!-- Footer -->
<jsp:include page="../template/footer.jsp"/>
</body>
</html>