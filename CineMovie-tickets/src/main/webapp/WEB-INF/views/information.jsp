<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <!-- Head -->
    <jsp:include page="template/header.jsp"/>
</head>

<style>
    #code {
        width: auto;
        height: 30px;
    }

    .avatar {
        vertical-align: middle;
        width: 150px;
        height: 150px;
        border-radius: 50%;
    }

    .btn-update-avatar {
        text-align: center;
    }

    .avatar-container {
        width: 150px;
    }

    h3 {
        color: blue;
    }

    li label {
        height: 30px;
        margin-top: 5px;
        margin-bottom: 5px;
    }

    li input {
        height: 30px;
        margin-top: 5px;
        margin-bottom: 5px;
        width: 250px;
    }

    li select {
        height: 30px;
        margin-top: 5px;
        margin-bottom: 5px;
        width: 250px;
    }

    .hidden {
        display: none;
    }

</style>

<body>
<!-- Nav -->
<jsp:include page="template/nav.jsp"/>

<!-- Content-->
<div class="container">
    <div id="alert" class="alert alert-warning hidden">
        <strong>Warning!</strong> Không thể cập nhật thông tin cá nhân.
    </div>

    <h3>Ảnh đại diện</h3>

    <div class="avatar-container">
        <div>
            <img src="images/avatar.png" alt="Avatar" class="avatar">
        </div>
        <div class="btn-update-avatar">
            <button type="button" class="btn btn-primary disabled">Thay đổi</button>
        </div>
    </div>

    <div class="details-container">
        <h3>Thông tin tài khoản</h3>

        <div class="row">
            <div class="col-sm-3">
                <ul>
                    <li><b>Họ và tên:</b></li>
                    <li><b>Tên đăng nhập:</b></li>
                    <li><b>Ngày sinh:</b></li>
                    <li><b>Giới tính</b></li>
                    <li><b>Email:</b></li>
                    <li><b>Số điện thoại:</b></li>
                    <li><b>Khu vực:</b></li>
                    <li><b>Rạp yêu:</b></li>
                </ul>
            </div>
            <div class="col-sm-5">
                <ul>
                    <li> ${user.fullName}</li>
                    <li> ${user.username}</li>
                    <li> ${user.dateOfBirth}</li>
                    <li> ${user.gender? "Nam" : "Nữ"}</li>
                    <li> ${user.email}</li>
                    <li> ${user.phone}</li>
                    <li> ${user.zone}</li>
                    <li> ${user.cinemaLove}</li>
                </ul>
            </div>
        </div>
        <button type="button" class="btn btn-primary" id="edit-information">Sửa thông tin</button>
    </div>

    <div class="update-information hidden">
        <h3>Cập nhật tài khoản</h3>
        <form method="post" action="/information">
            <div class="row">
                <div class="col-sm-3">
                    <ul>
                        <li><label>Họ và tên:</label></li>
                        <li><label>Tên đăng nhập:</label></li>
                        <li><label>Email:</label></li>
                        <li><label>Số điện thoại:</label></li>
                        <li><label>Ngày sinh:</label></li>
                        <li><label>Giới tính</label></li>
                        <li><label>Khu vực</label></li>
                        <li><label>Rạp yêu thích</label></li>
                    </ul>
                </div>
                <div class="col-sm-4">
                    <ul>
                        <li><input type="text" value="${user.fullName}" name="fullName" required></li>
                        <li><input type="text" value="${user.username}" name="username" readonly></li>
                        <li><input type="email" value="${user.email}" name="email" required></li>
                        <li><input type="number" value="${user.phone}" name="phone" required></li>
                        <li><input type="date" value="${user.dateOfBirth}" name="dateOfBirth" required></li>
                        <li><select name="gender">
                            <option value="true">Nam</option>
                            <option value="false">Nữ</option>
                        </select></li>
                        <li><input type="text" value="${user.zone}" name="zone" required></li>
                        <li><input type="text" value="${user.cinemaLove}" name="cinemaLove" required></li>
                    </ul>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" id="update-information">Cập nhật thông tin</button>
        </form>
    </div>
</div>

<div class="clearfix"></div>

<script>
    $(function () {
        $('#edit-information').click(function () {
            $('.details-container').addClass('hidden');
            $('.update-information').removeClass('hidden');
        })
    });

    const isError = '${error}';

    if (isError !== '') {
        $('#alert').removeClass('hidden');
    }
</script>

<!-- Footer -->
<jsp:include page="template/footer.jsp"/>
</body>
</html>
