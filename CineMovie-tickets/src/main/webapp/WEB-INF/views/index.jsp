<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="template/header.jsp"/>
</head>
<style>
    .movie-container {
        margin-left: 100px;
    }
</style>
<body>
<jsp:include page="template/nav.jsp"/>

<%--<div class="content">--%>
<%--    --%>
<%--    <div class="wrap">--%>
<%--        <div class="content-top movie-container">--%>
<%--            <h1 class="h1">NEW MOVIES </h1>--%>
<%--            <c:forEach var="movie" items="${newMovies}">--%>
<%--                <div class="col_1_of_4 span_1_of_4">--%>
<%--                    <div class="imageRow">--%>
<%--                        <div class="single">--%>
<%--                            <a href="${movie.image}" rel="lightbox"><img height="300" width="200" src="${movie.image}" alt="" /></a>--%>
<%--                        </div>--%>
<%--                        <div class="movie-text">--%>
<%--                            <h5><a href="/movies?id=${movie.id}">${movie.name}</a></h5>--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                            <a role="button" class="btn btn-info" href="/movies?id=${movie.id}">Chi tiết</a>--%>
<%--                            <a role="button" class="btn btn-primary" href="/purchase/${movie.id}/${cityId}/${date}">Đặt vé</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--            <div class="clear"></div>--%>
<%--        </div>--%>

<%--        <div class="movie-top movie-container">--%>
<%--            <h1 class="h1" >HOT MOVIES</h1>--%>
<%--            <c:forEach var="movie" items="${hotMovies}">--%>
<%--                <div class="col_1_of_4 span_1_of_4">--%>
<%--                    <div class="imageRow">--%>
<%--                        <div class="single">--%>
<%--                            <a href="${movie.image}" rel="lightbox"><img height="300" width="200" src="${movie.image}" alt="" /></a>--%>
<%--                        </div>--%>
<%--                        <div class="movie-text">--%>
<%--                            <h5><a href="/movies?id=${movie.id}">${movie.name}</a></h5>--%>
<%--                            <div>--%>
<%--                                <a role="button" class="btn btn-info" href="/movies?id=${movie.id}">Chi tiết</a>--%>
<%--                                <a role="button" class="btn btn-primary" href="/purchase/${movie.id}/${cityId}/${date}">Đặt vé</a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--            <div class="clear"></div>--%>
<%--        </div>--%>

<%--        <div class="movie-top movie-container">--%>
<%--            <h1 class="h1" >ALL MOVIES</h1>--%>
<%--            <c:forEach var="movie" items="${allMovies}">--%>
<%--                <div class="col_1_of_4 span_1_of_4">--%>
<%--                    <div class="imageRow">--%>
<%--                        <div class="single">--%>
<%--                            <a href="${movie.image}" rel="lightbox"><img height="300" width="200" src="${movie.image}" alt="" /></a>--%>
<%--                        </div>--%>
<%--                        <div class="movie-text">--%>
<%--                            <h5><a href="/movies?id=${movie.id}">${movie.name}</a></h5>--%>
<%--                            <div>--%>
<%--                                <a role="button" class="btn btn-info" href="/movies?id=${movie.id}">Chi tiết</a>--%>
<%--                                <a role="button" class="btn btn-primary" href="/purchase/${movie.id}/${cityId}/${date}">Đặt vé</a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--            <div class="clear"></div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="clear"></div>--%>
<%--</div>--%>

<!-- Main content -->
<section class="container">
    <div class="col-sm-12">
        <h2 class="page-heading">Movies</h2>

        <c:forEach var="movie" items="${allMovies}">
            <!-- Movie preview item -->
            <div class="movie movie--preview movie--full release">
                <div class="col-sm-3 col-md-2 col-lg-2">
                    <div class="movie__images">
                        <img alt='image' src="${movie.image}">
                    </div>
                </div>

                <div class="col-sm-9 col-md-10 col-lg-10 movie__about">
                    <a href='/movies?id=${movie.id}' class="movie__title link--huge">${movie.name}</a>
                    <p class="movie__time">${movie.time} phút</p>

<%--                    <p class="movie__option"><strong>Ngôn ngữ: </strong>${movie.language}</p>--%>
<%--                    <p class="movie__option"><strong>Thể loại: </strong>${movie.category}</p>--%>
<%--                    <p class="movie__option"><strong>Ngày chiếu: </strong>${movie.premiere}</p>--%>
<%--                    <p class="movie__option"><strong>Đạo diễn: </strong>${movie.director}</p>--%>
<%--                    <p class="movie__option"><strong>Định dạng: </strong>${movie.format}</p>--%>
<%--                    <p class="movie__option"><strong>Lượt xem: </strong>${movie.view}</p>--%>
<%--                    <p class="movie__option"><strong>Giới hạn tuổi: </strong>${movie.ageLimit == 0 ? 13 : movie.ageLimit}</p>--%>

                    <div class="movie__btns">
                        <a href="/movies?id=${movie.id}" class="btn btn-md btn--warning">Xem chi tiết <span
                                class="hidden-sm">phim</span></a>
                        <a href="/purchase/${movie.id}/${cityId}/${date}" class="watchlist">Mua vé</a>
                    </div>

                    <div class="preview-footer">
<%--                        <hr/>--%>
                    </div>
                </div>

                <div class="clearfix"></div>
            </div>
            <!-- end movie preview item -->
        </c:forEach>
    </div>
</section>

<div class="clearfix"></div>

<jsp:include page="template/footer.jsp"/>
</body>
</html>
