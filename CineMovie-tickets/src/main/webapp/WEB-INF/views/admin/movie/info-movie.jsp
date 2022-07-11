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
                Bạn muốn kết thúc bộ phim này?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <a id="movie-delete-confirm" role="button" class="btn btn-primary" href="">Kết thúc</a>
            </div>
        </div>
    </div>
</div>

<c:forEach var="movie" items="${movies}">
    <div class="info-movie" id="info-movie-${movie.id}">
        <div id="detail-movie-${movie.id}" style="margin-left: 150px">
            <h2>${movie.name}</h2><br>
            <img width="120" height="160" src="${movie.image}"><br><br>
            <label>Tác giả:</label> ${movie.director}<br><br>
            <label>Miêu tả:</label> ${movie.description}<br><br>
            <label>Thể loại:</label> ${movie.category}<br><br>
            <label>Ra mắt:</label> ${movie.premiere}<br><br>
            <label>Thời gian:</label> ${movie.time}<br><br>
            <label>Ngôn ngữ:</label> ${movie.language}<br><br>
            <label>Định dạng:</label> ${movie.format}<br><br>
            <label>Độ tuổi:</label> ${movie.ageLimit}<br><br>

            <a href="/admin/movies/${movie.id}/update">
                <button data-movie-id="${movie.id}" type="button" class="btn btn-primary btn-update-movie">Cập nhật</button>
            </a>

            <button type="button"
                    data-toggle="modal"
                    data-target="#exampleModal"
                    data-movie-id="${movie.id}"
                    class="btn btn-danger movie-delete-action">Kết thúc phim</button>
        </div>
    </div>
</c:forEach>
