<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="java.security.Principal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header class="header-wrapper">
    <div class="container">
        <!-- Logo link-->
        <a href='/' class="logo">
            <img alt='logo' width="300" height="300" src="/images/logoCinemovie.jpg">
<%--            <span width="210" height="80" class="btn btn--sign">CINEMOVIE</span>--%>
        </a>

        <!-- Main website navigation-->
        <nav id="navigation-box">
            <!-- Toggle for mobile menu mode -->
            <a href="#" id="navigation-toggle">
                        <span class="menu-icon">
                            <span class="icon-toggle" role="button" aria-label="Toggle Navigation">
                              <span class="lines"></span>
                            </span>
                        </span>
            </a>

            <!-- Link navigation -->
            <ul id="navigation">
                <li>
                    <span class="sub-nav-toggle plus"></span>
                    <a href="/">Trang chủ</a>
                </li>
                <li>
                    <span class="sub-nav-toggle plus"></span>
                    <a href="/amount">Trang giá</a>
                </li>

                <%
                    if (request.isUserInRole("ROLE_USER")) {
                        out.print("<li>\n" +
                                "                    <span class=\"sub-nav-toggle plus\"></span>\n" +
                                "                    <a href=\"/history\">Lịch sử</a>\n" +
                                "                </li>");
                    } else if (request.isUserInRole("ROLE_EMPLOYEE")) {
                        out.print("<li>\n" +
                                "                    <span class=\"sub-nav-toggle plus\"></span>\n" +
                                "                    <a href=\"/manage\">In vé</a>\n" +
                                "                </li>");
                    } else if (request.isUserInRole("ROLE_ADMIN")) {
                        out.print("<li>\n" +
                                "                    <span class=\"sub-nav-toggle plus\"></span>\n" +
                                "                    <a href=\"/admin\">Quản lý</a>\n" +
                                "                </li>");
                    }

                    if (request.getRemoteUser() != null) {
                        out.print("<li>\n" +
                                "                    <span class=\"sub-nav-toggle plus\"></span>\n" +
                                "                    <a href=\"/information\">Cá nhân</a>\n" +
                                "                </li>");
                    } else {
                        out.print("<li>\n" +
                                "                    <span class=\"sub-nav-toggle plus\"></span>\n" +
                                "                    <a href=\"/login\">Đăng nhập</a>\n" +
                                "                </li>");
                    }
                %>

            </ul>
        </nav>

        <!-- Additional header buttons / Auth and direct link to booking-->
        <div class="control-panel">
            <%
                if (request.getRemoteUser() != null) {
                    out.print("<a href=\"/logout\" class=\"btn btn--sign\">Đăng xuất</a>");
                } else {
                    out.print("<a href=\"/register\" class=\"btn btn--sign\">Sign in</a>");
                }
            %>

        </div>

    </div>
</header>
