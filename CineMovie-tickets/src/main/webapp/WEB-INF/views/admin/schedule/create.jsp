<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../template/header.jsp"/>
    <script>
        $(function (){
            $('#menu-schedule').addClass('menu-open')

            $('.select-room').change(function (){
                const sender = $(this).find('option:selected')
                const id = sender.data('room-id')

                $('#room-id').val(id)
            })

            $('#select-cinema').change(function (){
                const sender = $('#select-cinema option:selected')
                const id = sender.data('cinema-id')

                $('.cinema-wrapper').hide()
                $('#cinema-wrapper-' + id).show()

                $('#select-room-' + id).change()
            })

            $('#select-cinema').change()
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
                            <li class="breadcrumb-item active">Thêm mới lịch chiếu</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <!-- Content -->

                <jsp:include page="info-cinemas.jsp"/>

                <form action="/admin/schedules/create" method="post">
                    <div class="form-group">
                        <label for="select-movie">Chọn phim:</label>
                        <select class="form-control col-sm-6" name="movieId" id="select-movie">
                            <c:forEach var="movie" items="${movies}">
                                <option value="${movie.id}">${movie.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="select-time">Chọn giờ:</label>
                        <input name="time" class="form-control col-sm-6" id="select-time" type="datetime-local" required>
                    </div>

                    <input hidden name="roomId" id="room-id">

                    <button class="btn btn-primary" type="submit">Thêm lịch</button>
                </form>

                <!-- End Content -->
            </div>
        </section>
    </div>
</div>
<jsp:include page="../template/footer.jsp"/>
</body>
</html>