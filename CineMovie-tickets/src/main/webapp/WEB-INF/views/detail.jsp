<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <!-- Head -->
    <jsp:include page="template/header.jsp"/>
    <style>

        .col-sm-9{
            font-size: 20px;
        }

        .col-sm-9 h2,form{
            color: #357ecd;
            margin-left: 40px;
            padding-top: 12px;
        }

        .item {
            margin-left: 40px;
            padding-top: 12px;
        }

        .col-sm-9 container{
            margin-left: 90px;
        }
    </style>
</head>

<body>
<!-- Nav -->
<jsp:include page="template/nav.jsp"/>

<%--<!-- Content-->--%>
<%--<div class="content">--%>
<%--    <div class="container">--%>
<%--        <h1>NỘI DUNG PHIM </h1>--%>
<%--        <br>--%>
<%--        <div class="row">--%>
<%--            <div class="col-sm-3">--%>
<%--                <img src="${movie.image}">--%>

<%--            </div>--%>

<%--            <div class="col-sm-9">--%>

<%--                <h2>${movie.name}</h2>--%>
<%--                <hr>--%>
<%--                <label class="item">Đạo diễn:</label> ${movie.director}<br>--%>
<%--                <label class="item">Thể loại:</label> ${movie.category}<br>--%>
<%--                <label class="item">Khỏi chiếu:</label> ${movie.premiere}<br>--%>
<%--                <label class="item">Thời lượng:</label> ${movie.time} phút<br>--%>
<%--                <label class="item">Ngôn ngữ:</label> ${movie.language}<br>--%>
<%--                <label class="item">Định dạng:</label> ${movie.format}<br>--%>
<%--                <label class="item">Độ tuổi:</label> ${movie.ageLimit}<br>--%>

<%--                <a role="button"--%>
<%--                   href="/purchase/${movie.id}/${cityId}/${date}"--%>
<%--                   class="btn btn-primary item"--%>
<%--                   id="btn-submit">Mua vé</a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <h3>Chi tiết</h3>--%>
<%--        <br>--%>
<%--        ${movie.description}<br><br>--%>
<%--    </div>--%>

<%--</div>--%>

<!-- Main content -->
<section class="container">
    <div class="col-sm-12">
        <div class="movie">
            <h2 class="page-heading">Phim: ${movie.name}</h2>

            <div class="movie__info">
                <div class="col-sm-4 col-md-3 movie-mobile">
                    <div class="movie__images">
                        <img alt='' src="${movie.image}">
                    </div>
                </div>

                <div class="col-sm-8 col-md-9">
                    <a href='/movies?id=${movie.id}' class="movie__title link--huge">${movie.name}</a>

                    <p class="movie__time">${movie.time} phút</p>
                    <p class="movie__option"><strong>Ngôn ngữ: </strong>${movie.language}</p>
                    <p class="movie__option"><strong>Thể loại: </strong>${movie.category}</p>
                    <p class="movie__option"><strong>Ngày chiếu: </strong>${movie.premiere}</p>
                    <p class="movie__option"><strong>Đạo diễn: </strong>${movie.director}</p>
                    <p class="movie__option"><strong>Định dạng: </strong>${movie.format}</p>
                    <p class="movie__option"><strong>Lượt xem: </strong>${movie.view}</p>
                    <p class="movie__option"><strong>Giới hạn tuổi: </strong>${movie.ageLimit == 0 ? 13 : movie.ageLimit}</p>

                    <div class="movie__btns">
                        <a href="/movies?id=${movie.id}" class="btn btn-md btn--warning">Xem chi tiết <span
                                class="hidden-sm">phim</span></a>
                        <a href="/purchase/${movie.id}/${cityId}/${date}" class="watchlist">Mua vé</a>
                    </div>

                </div>
            </div>

            <div class="clearfix"></div>

            <h2 class="page-heading">Chi tiết</h2>

            <p class="movie__describe">${movie.description}</p>
        </div>

    </div>

</section>

<div class="clearfix"></div>

<!-- Footer -->
<jsp:include page="template/footer.jsp"/>
</body>
</html>
