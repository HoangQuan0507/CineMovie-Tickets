<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../template/header.jsp"/>
    <script>
        $(function (){
            $('#menu-schedule').addClass('menu-open')

            $('.room-movie-schedule-delete-action').click(function (){
                const id = $(this).data('id')
                const link = '/admin/schedules/' + id + '/delete'

                $('#schedule-delete-confirm').attr('href', link)
            })
        })
    </script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <jsp:include page="../template/menu.jsp"/>
    <div class="content-wrapper">
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">

                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin">Home</a></li>
                            <li class="breadcrumb-item active">Danh sách lịch chiếu</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <!-- Content -->

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
                                Bạn muốn xóa lịch chiếu này?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                <a id="schedule-delete-confirm" role="button" class="btn btn-primary" href="">Xóa</a>
                            </div>
                        </div>
                    </div>
                </div>

                <p>Danh sách lịch chiếu của toàn bộ hệ thống</p>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Thành phố</th>
                        <th>Tên rạp</th>
                        <th>Tên phòng</th>
                        <th>Tên phim</th>
                        <th>Thời gian</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="roomMovieSchedule" items="${roomMovieSchedules}">
                        <tr>
                            <td>${roomMovieSchedule.room.cinema.city.name}</td>
                            <td>${roomMovieSchedule.room.cinema.name}</td>
                            <td>${roomMovieSchedule.room.name}</td>
                            <td>${roomMovieSchedule.movie.name}</td>
                            <td>${roomMovieSchedule.schedule.time}</td>
                            <td>
                                <a role="button" href="/admin/schedules/${roomMovieSchedule.id}/update" class="btn btn-primary">Cập nhật</a>

                                <button type="button"
                                        data-toggle="modal"
                                        data-target="#exampleModal"
                                        data-id="${roomMovieSchedule.id}"
                                        class="btn btn-danger room-movie-schedule-delete-action">Xóa</button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

                <!-- End Content -->
            </div>
        </section>
    </div>
</div>
<jsp:include page="../template/footer.jsp"/>
</body>
</html>