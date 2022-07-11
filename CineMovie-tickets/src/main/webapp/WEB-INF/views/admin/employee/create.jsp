<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../template/header.jsp"/>
    <script>
        $(function (){
            $('#foget-password').val('');

            const isError = ${message != null};
            if (isError){
                setTimeout(function (){
                    $('#user-alert').removeClass('hidden');
                }, 500);
            }

            $('#form').submit(function (e){
                const password = $('#foget-password').val();
                const username = $('#username').val();
                const email = $('#email').val();

                if (password == ''){
                    alert('Mật khẩu không được trống');
                    e.preventdefault();
                    return false;
                }

                if (username == ''){
                    alert('Username không được trống');
                    e.preventdefault();
                    return;
                }

                if (email == ''){
                    alert('Email không được trống');
                    e.preventdefault();
                    return;
                }
            })
        })
    </script>
</head>

<style>
    .hidden {
        display: none;
    }
</style>

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
                            <li class="breadcrumb-item active">Thêm mới nhân viên</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>


        <!-- Main content -->
        <section class="content">
            <div class="container">
                <div id="user-alert" class="alert alert-warning alert-dismissible hidden">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Thất bại!</strong> Tên đăng nhập hoặc email đã được sử dụng.
                </div>

                <%--@elvariable id="user" type="com.project.movietickets.entity.UserEntity"--%>
                <form:form id="form" action="/admin/employees/create" method="post" modelAttribute="user">
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Họ tên nhân viên</labe>
                        </div>
                        <div class="col-sm-4">
                            <form:input id="fullName" type="text" class="form-control" path="fullName"/>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Tên đăng nhập</labe>
                        </div>
                        <div class="col-sm-4">
                            <form:input id="username" type="text" class="form-control" path="username"/>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Mật khẩu</labe>
                        </div>
                        <div class="col-sm-4">
                            <form:input type="text" id="foget-password" class="form-control" path="password"/>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Email</labe>
                        </div>
                        <div class="col-sm-4">
                            <form:input id="email" type="email" class="form-control" path="email"/>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                            <labe>Chức vụ</labe>
                        </div>
                        <div class="col-sm-4">
                            <form:select path="role" class="form-control">
                                <form:option value="ROLE_EMPLOYEE">Nhân viên</form:option>
                                <form:option value="ROLE_ADMIN">Admin</form:option>
                            </form:select>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col-sm-2" style="margin-left: 150px">
                        </div>
                        <div class="col-sm-4">
                            <button id="btn-submit" type="submit" class="btn btn-primary">Thêm</button>
                        </div>
                    </div>

                </form:form>

            </div>
            <!-- Content -->

            <!-- End Content -->

        </section>
    </div>
</div>
<jsp:include page="../template/footer.jsp"/>
</body>

</html>
