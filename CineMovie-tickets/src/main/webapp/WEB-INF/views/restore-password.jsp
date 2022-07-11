<%@ page import="com.project.movietickets.model.Message" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <!-- Head -->
    <jsp:include page="template/header.jsp"/>
</head>

<body>
<!-- Nav -->
<jsp:include page="template/nav.jsp"/>
<!-- Content-->
<div class="content">

    <%
        Message message = (Message) request.getAttribute("message");
        if (message != null) {
            if (message.getCode() == Message.SUCCESS) {
                out.print("<div class='alert alert-success'>"
                        + "<strong>Thành công!</strong> "
                        + message.getMessage()
                        + "</div>");
            } else {
                out.print("<div class='alert alert-danger'>"
                        + "<strong>Thất bại!</strong> "
                        + message.getMessage()
                        + "</div>");
            }
        }
    %>

    <div class="container-fluid" style="min-height: 450px;">
        <h2 class="text-center" style="color:#000000;">KHÔI PHỤC MẬT KHẨU</h2><br>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
                <legend><a href=""></a>Quên mật khẩu
                </legend>
                <form method="post" class="form" role="form" action="/restore-password">
                    <input class="form-control" name="username" placeholder="Tên đăng nhập" type="text" required><br>
                    <input class="form-control" name="password" placeholder="Mật khẩu" type="password" required><br>
                    <input class="form-control" name="rePassword" placeholder="Nhập lại mật khẩu" type="password"
                           required><br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Lấy lại mật khẩu</button>
                    <br>
                    <h5 style="color: #0f1315">Bạn chưa có tài khoản ?
                        <a href="/register">Đăng kí</a>
                    </h5>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<jsp:include page="template/footer.jsp"/>
</body>
</html>
