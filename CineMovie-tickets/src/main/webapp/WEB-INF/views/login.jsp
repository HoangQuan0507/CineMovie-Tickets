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
<form id="login-form" class="login" method='post' novalidate='' action="/login">
    <p class="login__title">ĐĂNG NHẬP<br><span class="login-edition">Chào mừng bạn đến HAC Cinema</span></p>

    <div class="social social--colored">
        <a href='#' class="social__variant fa fa-facebook"></a>
        <a href='#' class="social__variant fa fa-twitter"></a>
        <a href='#' class="social__variant fa fa-tumblr"></a>
    </div>

    <p class="login__tracker">or</p>

    <div class="field-wrap">
        <input type='text' placeholder='Username' name='username' class="login__input">
        <input type='password' placeholder='Password' name='password' class="login__input">

        <input type='checkbox' id='#informed' class='login__check styled'>
        <label for='#informed' class='login__check-info'>lưu đăng nhập</label>
    </div>

    <div class="login__control">
        <button type='submit' class="btn btn-md btn--warning btn--wider">Đăng nhập</button>
        <a href="#" class="login__tracker form__tracker">Quên mật khẩu?</a>
    </div>
</form>

<div class="clearfix"></div>

<!-- Footer -->
<jsp:include page="template/footer.jsp"/>
</body>
</html>
