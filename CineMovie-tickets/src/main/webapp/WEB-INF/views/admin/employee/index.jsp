<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../template/header.jsp"/>
    <script>
        $(function () {
            $('.delete-employee-action').click(function () {
                const id = $(this).data('employee-id');
                const confirm = $('#employee-delete-confirm');
                const link = '/admin/employees/' + id + '/delete';
                confirm.attr('href', link);
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
                            <li class="breadcrumb-item active">Danh sách nhân viên</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="container">
                <!-- Content -->

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Bạn muốn xóa nhân viên này?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                <a id="employee-delete-confirm" role="button" class="btn btn-primary" href="">Xóa</a>
                            </div>
                        </div>
                    </div>
                </div>

                <p>Danh sách các nhân viên:</p>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Tên nhân viên</th>
                        <th>Chức vụ</th>
                        <th>Email</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.fullName}</td>
                            <td><span class="badge badge-primary">${employee.role}</span></td>
                            <td>${employee.email}</td>
                            <td>
                                <a
                                        role="button"
                                        class="btn-primary btn"
                                        href="/admin/employees/${employee.id}/update">Sửa</a>
                                <button
                                        data-toggle="modal"
                                        data-target="#exampleModal"
                                        data-employee-id="${employee.id}"
                                        class="btn btn-danger delete-employee-action">Xóa
                                </button>
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
