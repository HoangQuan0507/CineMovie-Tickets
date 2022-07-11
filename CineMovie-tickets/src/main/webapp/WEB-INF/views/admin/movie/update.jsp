<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../template/header.jsp"/>
    <script>
        $(function (){
            $('#menu-movie').addClass('menu-open')
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
                            <li class="breadcrumb-item active">Cập nhật bộ phim</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>


        <!-- Main content -->
        <section class="content">
            <div class="container">
                <form action="#" method="post">
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Tên</labe>
                        </div>
                        <div class="col-sm-4">
                            <input value="${movie.name}" type="text" class="form-control" name="name" required>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Đạo diễn</labe>
                        </div>
                        <div class="col-sm-4">
                            <input value="${movie.director}" type="text" class="form-control" name="director" required>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Thể loại</labe>
                        </div>
                        <div class="col-sm-4">
                            <input value="${movie.category}" type="text" class="form-control" name="category" required>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Ra mắt</labe>
                        </div>
                        <div class="col-sm-4">
                            <input value="${movie.premiere}" type="date" class="form-control" name="premiere" required>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Thời gian</labe>
                        </div>
                        <div class="col-sm-4">
                            <input value="${movie.time}" type="number" class="form-control" name="time" required>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Ngôn ngữ</labe>
                        </div>
                        <div class="col-sm-4">
                            <input value="${movie.time}" type="text" class="form-control" name="language" required>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Định dạng</labe>
                        </div>
                        <div class="col-sm-4">
                            <input value="${movie.format}" type="text" class="form-control" name="format" required>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Độ tuổi</labe>
                        </div>
                        <div class="col-sm-4">
                            <input value="${movie.ageLimit}" type="number" class="form-control" name="ageLimit" required>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Miêu tả</labe>
                        </div>
                        <div class="col-sm-4">
                            <textarea name="description" cols="30" rows="5" class="form-control">${movie.description}</textarea>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Chức năng</labe>
                        </div>
                        <div class="row col-sm-4">
                            <button type="submit" class="btn btn-primary">Cập nhật</button>
                            <a style="margin-left: 5px" class="btn btn-primary" role="button" href="/admin/movies">Hủy bỏ</a>
                        </div>
                    </div>
                </form>

            </div>
        </section>
    </div>
</div>
<jsp:include page="../template/footer.jsp"/>
</body>

</html>