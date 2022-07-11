<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="template/header.jsp"/>
</head>
<body>
<jsp:include page="template/nav.jsp"/>

<div class="container">
    <h2>BẢNG GIÁ VÉ PHIM 2D TẠI RẠP HAC CINEMA</h2>

    <div class="table-responsive">
        <table border="1" class="table table-bordered">
            <thead>
            <tr class="info">
                <th rowspan="2"></th>
                <th colspan="2">NGƯỜI LỚN</th>
                <th rowspan="2">HS - SV, TRẺ EM, NGƯỜI CAO TUỔI</th>
            </tr>
            <tr class="info">
                <td>10h - 18h</td>
                <td>18h - 22h</td>
            </tr>
            </thead>
            <tbody>
            <tr class="active">
                <td>Thứ 2, 3, 4, 5, 6</td>
                <td colspan="2">Đồng giá 60.000</td>
                <td rowspan="2">40.000</td>
            </tr>
            <tr class="active">
                <td>Thứ 7, CN</td>
                <td>60.000</td>
                <td>65.000</td>
            </tr>
            <tr class="active">
                <td>Ngày lễ</td>
                <td colspan="3">70.000</td>
            </tr>
            </tbody>
        </table>
    </div>

    <h2>BẢNG GIÁ VÉ PHIM 3D TẠI RẠP HAC CINEMA</h2>

    <div class="table-responsive">
        <table border="1" class="table table-bordered">
            <thead>
            <tr class="info">
                <th rowspan="2"></th>
                <th colspan="2">NGƯỜI LỚN</th>
                <th rowspan="2">HS - SV, TRẺ EM, NGƯỜI CAO TUỔI</th>
            </tr>
            <tr class="info">
                <td>10h - 18h</td>
                <td>18h - 22h</td>
            </tr>
            </thead>
            <tbody>
            <tr class="active">
                <td>Thứ 2, 3, 4, 5, 6</td>
                <td colspan="2">Đồng giá 60.000</td>
                <td rowspan="2">40.000</td>
            </tr>
            <tr class="active">
                <td>Thứ 7, CN</td>
                <td>60.000</td>
                <td>65.000</td>
            </tr>
            <tr class="active">
                <td>Ngày lễ</td>
                <td colspan="3">70.000</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="template/footer.jsp"/>
</body>
</html>
