<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../template/header.jsp"/>
    <script>
        $(function (){
            $('#menu-report').addClass('menu-open')
        })
    </script>
    <style>
        .element {
            margin-right: 20px;
        }
    </style>
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
                            <li class="breadcrumb-item active">Báo cáo vé theo tháng</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <!-- Content -->

                <div>
                    <form method="get" action="/admin/reports" class="row">
                        <div class="form-group element">
                            <label for="start-date">Ngày bắt đầu:</label>
                            <input name="startDate" type="date" class="form-control" id="start-date">
                        </div>

                        <div class="form-group element">
                            <label for="end-date">Ngày kết thúc:</label>
                            <input name="endDate" type="date" class="form-control" id="end-date">
                        </div>

                        <div class="form-group element">
                            <label for="category">Thể loại:</label>
                            <select name="category" class="form-control" id="category">
                                <option value="ALL">Tất cả</option>
                                <c:forEach var="category" items="${categories}">
                                    <option value="${category}">${category}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Lọc báo cáo</label>
                            <button class="btn btn-primary form-control" type="submit">Lọc</button>
                        </div>
                    </form>
                </div>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Tên bộ phim</th>
                        <th>Số lượng</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="report" items="${reports}">
                        <tr>
                            <td>${report.name}</td>
                            <td>${report.count}</td>
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