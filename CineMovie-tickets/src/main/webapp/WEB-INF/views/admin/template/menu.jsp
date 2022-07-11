<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
            <a href="/admin" class="nav-link">Quản lý</a>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
            <a href="/logout" class="nav-link">Đăng xuất</a>
        </li>
    </ul>

</nav>
<!-- /.navbar -->

<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="javascript:void(0);" class="brand-link">
        <img src="/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">Dashboard</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <%
                    String name = request.getRemoteUser();
                    out.print("<a href=\"javascript:void(0);\" class=\"d-block\">" + name + "</a>");
                %>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li class="nav-item has-treeview" id="menu-movie">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Quản lý phim
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/admin/movies" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Danh sách các bộ phim</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/admin/movies/create" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Thêm mới bộ phim</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item has-treeview" id="menu-cinema">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Quản lý rạp chiếu phim
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/admin/cinemas" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Danh sách rạp phim</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/admin/cinemas/create" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Thêm mới rạp phim</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item has-treeview" id="menu-schedule">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Quản lý lịch chiếu phim
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/admin/schedules" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Danh sách lịch chiếu</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/admin/schedules/create" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Thêm mới lịch chiếu</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item has-treeview" id="menu-report">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Báo cáo chi tiết
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/admin/reports" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Báo cáo số lượng vé</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item has-treeview" id="menu-employee">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Quản lý nhân viên
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/admin/employees" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Danh sách nhân viên</p>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/admin/employees/create" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Thêm mới nhân viên</p>
                            </a>
                        </li>
                    </ul>
                </li>

            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>