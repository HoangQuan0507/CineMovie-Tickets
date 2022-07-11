<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Bạn muốn xóa rạp này?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <a id="cinema-delete-confirm" role="button" class="btn btn-primary" href="">Xóa</a>
            </div>
        </div>
    </div>
</div>

<c:forEach var="cinema" items="${cinemas}">
    <div class="info-cinema" id="info-cinema-${cinema.id}">
        <div class="row">
            <div class="col-sm-4">
                <h2>Danh sách phòng</h2>
                <ul class="list-group">
                   <c:forEach var="room" items="${cinema.rooms}">
                       <li class="list-group-item">${room.name}</li>
                   </c:forEach>
                </ul>
                <br>
                Thêm phòng
                <form action="/admin/rooms" method="post">
                    <input name="cinemaId" value="${cinema.id}" hidden>
                    <input class="form-control" placeholder="Tên" type="text" name="name" required>
                    <button class="btn btn-primary" type="submit">Thêm</button>
                </form>
            </div>

            <div class="col-sm-8">
                <div id="detail-cinema-${cinema.id}" >
                    <h2>${cinema.name}</h2><br>
                    <label>Thuộc thành phố:</label> ${cinema.city.name}<br><br>
                    <a href="/admin/cinemas/${cinema.id}/update" role="button" class="btn-update-cinema btn btn-primary">Cập nhật</a>
                    <button data-toggle="modal"
                            data-target="#exampleModal"
                            class="btn btn-danger"
                            data-cinema-id="${cinema.id}"
                            type="button">Xóa</button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>