<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../template/header.jsp" />
    <script>
        $(function() {
            $('#menu-movie').addClass('menu-open')

            $('.movie-list a').click(function() {
                const sender = $(this)
                const id = sender.data('movie-id')

                $('.movie-list a').removeClass('active')
                sender.addClass('active')

                $('.info-movie').hide()
                $('#info-movie-' + id).show()
            })

            $('.movie-list a').first().click()

            $('#exampleModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget);
                var id = button.data('movie-id');

                const link = "/admin/movies/" + id + "/delete";
                $('#movie-delete-confirm').attr('href', link)
            })
        })
    </script>
    <style>
        .hidden {
            display: none;
        }
    </style>
</head>

<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <jsp:include page="../template/menu.jsp" />
    <div class="content-wrapper">
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">

                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin">Home</a></li>
                            <li class="breadcrumb-item active">Danh sách các bộ phim</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="container">
                <!-- Content -->

                <div class="row">
                    <div class="col-sm-3">
                        <div class="list-group movie-list">
                            <c:forEach var="movie" items="${movies}">
                                <a data-movie-id="${movie.id}" class="list-group-item" href="javascript:void(0);"
                                   style="margin-top: 5px">${movie.name}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-sm-9">
                        <jsp:include page="info-movie.jsp" />
                    </div>
                </div>

                <!-- End Content -->
            </div>
        </section>
    </div>
</div>
<jsp:include page="../template/footer.jsp"/>
</body>

</html>