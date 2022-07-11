<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../template/header.jsp" />
    <script>
        $(function() {
            $('#menu-cinema').addClass('menu-open')

            $('.cinema-list a').click(function() {
                const sender = $(this)
                const id = sender.data('cinema-id')

                $('.cinema-list a').removeClass('active')
                sender.addClass('active')

                $('.info-cinema').hide()
                $('#info-cinema-' + id).show()
            })

            $('.cinema-list a').first().click()

            $('#exampleModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget);
                var id = button.data('cinema-id');

                const link = "/admin/cinemas/" + id + "/delete";
                $('#cinema-delete-confirm').attr('href', link)
            })
        })
    </script>
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
                            <li class="breadcrumb-item active">Danh sách rạp phim</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

       <section class="content">
           <div class="container">
               <div class="row">
                   <div class="col-sm-3 list-group cinema-list">
                       <a:forEach var="cinema" items="${cinemas}">
                           <a data-cinema-id="${cinema.id}" class="list-group-item" href="javascript:void(0);" style="margin-top:
                                5px">
                                   ${cinema.name}
                           </a>
                       </a:forEach>
                   </div>

                   <div class="col-sm-9">
                       <jsp:include page="info-cinema.jsp" />
                   </div>
               </div>

           </div>
       </section>

    </div>
</div>
<jsp:include page="../template/footer.jsp" />
</body>

</html>