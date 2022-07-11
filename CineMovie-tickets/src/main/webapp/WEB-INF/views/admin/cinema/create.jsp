<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../template/header.jsp"/>
    <script>
        $(function (){
            $('#menu-cinema').addClass('menu-open')
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
                            <li class="breadcrumb-item active">Thêm rạp phim</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">

                <div class="container">
                    <form action="/admin/cinemas" method="post">
                        <div class="row" style="margin-bottom: 15px">
                            <div class="col-sm-2" style="margin-left: 150px">
                                <labe>Tên</labe>
                            </div>
                            <div class="col-sm-4" style="">
                                <input type="text" name="name" class="form-control">
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 15px">
                            <div class="col-sm-2" style="margin-left: 150px">
                                <labe>Thành phố</labe>
                            </div>

                            <div class="col-sm-4" style="">
                                <select name="cityId"class="form-control">
                                    <c:forEach var="city" items="${cities}">
                                        <option value="${city.id}">${city.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="row" style="margin-bottom: 15px">
                            <div class="col-sm-2" style="margin-left: 150px">
                                <labe></labe>
                            </div>
                            <div class="col-sm-4" style="">
                                <button type="submit" class="btn btn-primary">Thêm</button>
                            </div>
                        </div>



                    </form>

                </div>
            </div>
        </section>
    </div>
</div>
<jsp:include page="../template/footer.jsp"/>
</body>
</html>