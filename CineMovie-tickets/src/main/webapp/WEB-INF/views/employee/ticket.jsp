<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
    <div class="row">
        <div class="col-sm-2">
            <h3>Số:01</h3>
        </div>
        <div class="col-sm-7">
            <h1 style="text-align: center;">VÉ XEM PHIM</h1>

        </div>
        <div class="col-sm-3">
            <h1 style="color: red;">HAC</h1>
        </div>
    </div>

    <c:set var="roomMovieSchedule" value="${ticket.roomMovieSchedule}"/>
    <c:set var="chair" value="${ticket.roomChair.chair.position}"/>

    <div class="row" style="text-align: center;">
        <div class="col-sm-12">
            <h4>CÔNG TY TNHH HAC VIỆT NAM</h4>
            <h5>Lầu 10-11 số 2 Phạm Như Xương -Đà Nẵng</h5>

            <br/>
            <h2>${roomMovieSchedule.movie.name}</h2>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-sm-7">
            <h3>${ticket.date}</h3>
            <h1>Da Nang</h1>
            <h4>Adult-v</h4>
            <h4>110.000</h4>
            <h5>Da bao gom 5% thue VAT</h5>
            <h5>${ticket.user.fullName}</h5>
            <h5>${ticket.date}</h5>
            <h5>Ma Code : ${ticket.code}</h5>
        </div>
        <div class="col-sm-5">
            <h3>${roomMovieSchedule.schedule.time}</h3><br><br><br>
            <h2>RAP</h2>
            <h2>${roomMovieSchedule.room.name} / ${chair}</h2>
            <h3>(Ghe/Rap)</h3>
            <h4>Da thanh toan !</h4>
        </div>
    </div>
    <hr>
    <h1 style="text-align: center;">WWW.HAC.COM</h1>
</div>

