<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="select-cinema">Chọn rạp:</label>
    <select class="form-control col-sm-6" id="select-cinema">
        <c:forEach var="cinema" items="${cinemas}">
            <option data-cinema-id="${cinema.id}">${cinema.name} - ${cinema.city.name}</option>
        </c:forEach>
    </select>
</div>

<c:forEach var="cinema" items="${cinemas}">
    <div class="form-group cinema-wrapper" id="cinema-wrapper-${cinema.id}">
        <label for="select-room-${cinema.id}">Chọn phòng:</label>
        <select class="form-control select-room col-sm-6" id="select-room-${cinema.id}">
            <c:forEach var="room" items="${cinema.rooms}">
                <option data-room-id="${room.id}">${room.name}</option>
            </c:forEach>
        </select>
    </div>
</c:forEach>