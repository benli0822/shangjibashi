<%--
  Created by IntelliJ IDEA.
  User: benli
  Date: 22/09/14
  Time: 08:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- sidebar -->
<div id="sidebar-nav">
    <ul id="dashboard-menu">
        <li class="active">
            <div class="pointer">
                <div class="arrow"></div>
                <div class="arrow_border"></div>
            </div>
            <a href="<c:url value="/index" />">
                <i class="icon-home"></i>
                <span>Index</span>
            </a>
        </li>
        <li>
            <a href="<c:url value="/dishes" />">
                <i class="icon-picture"></i>
                <span>Dishes</span>
            </a>
        </li>
        <li>
            <a class="dropdown-toggle" href="#">
                <i class="icon-th-large"></i>
                <span>Menus</span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="user-list.html">Add new menu</a></li>
                <li><a href="new-user.html">List all menu</a></li>
            </ul>
        </li>
        <li>
            <a class="dropdown-toggle" href="#">
                <i class="icon-edit"></i>
                <span>Activities</span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="form-showcase.html">Add new activity</a></li>
                <li><a href="form-wizard.html">List all activity</a></li>
            </ul>
        </li>
        <li>
            <a href="personal-info.html">
                <i class="icon-cog"></i>
                <span>My info</span>
            </a>
        </li>
    </ul>
</div>
<!-- end sidebar -->