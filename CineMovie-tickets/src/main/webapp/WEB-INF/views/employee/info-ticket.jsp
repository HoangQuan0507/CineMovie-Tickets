<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.project.movietickets.entity.TicketEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
    <h4 class="card-title">${ticket.roomMovieSchedule.movie.name}</h4>
    <span>Mã code: ${ticket.code}</span><br>
    <span>Ngày đặt: ${ticket.date}</span><br>
    <span>Ngày chiếu: ${ticket.roomMovieSchedule.schedule.time}</span><br>
    <span>Phòng: ${ticket.roomChair.room.name}</span><br>
    <span>Ghế: ${ticket.roomChair.chair.position}</span><br>
    <c:choose>
        <c:when test="${ticket.received}">
            <span>Tình trạng: Đã nhận vé!</span>
        </c:when>
        <c:when test="${ticket.pay}">
            <span>Tình trạng: Đã thanh toán!</span>
        </c:when>
        <c:otherwise>
            <span>Tình trạng: Chưa thanh toán!</span>
        </c:otherwise>
    </c:choose>

    <hr>

    <c:choose>
        <c:when test="${ticket.received}">
            <button disabled class="btn btn-primary" type="submit">Nhận vé</button>
        </c:when>
        <c:when test="${ticket.pay}">
            <form method="post" action="/manage/receive">
                <input name="code" value="${ticket.code}" hidden>
                <button class="btn btn-primary" type="submit">Nhận vé</button>
            </form>
        </c:when>
        <c:otherwise>
            <form method="post" action="/manage/checkout">
                <input name="code" value="${ticket.code}" hidden>
                <button class="btn btn-primary" type="submit">Thanh toán</button>
            </form>
        </c:otherwise>
    </c:choose>
</div>