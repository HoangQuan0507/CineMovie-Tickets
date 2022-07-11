<%@ page import="com.project.movietickets.model.Message" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Message message = (Message) request.getAttribute("message");
    if (message != null){
        if (message.getCode() == Message.SUCCESS){
            response.sendRedirect("/login");
        } else {
            out.print("<div class='alert alert-danger'>"
                    + "<strong>Thất bại!</strong> "
                    + message.getMessage()
                    + "</div>");
        }
    }
%>
