<%--
  Created by IntelliJ IDEA.
  User: benli
  Date: 22/09/14
  Time: 08:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- sidebar -->
<div id="sidebar-nav">
    <ul id="dashboard-menu">
        <li id="index">
            <div class="pointer">
                <div class="arrow"></div>
                <div class="arrow_border"></div>
            </div>
            <a href="<c:url value="/index" />">
                <i class="icon-home"></i>
                <span><spring:message code="label.index" /></span>
            </a>
        </li>
        <li id="dishes">
            <a href="<c:url value="/dishes" />">
                <i class="icon-picture"></i>
                <span><spring:message code="label.dishes" /></span>
            </a>
        </li>
        <li id="menu">
            <a class="dropdown-toggle" href="#">
                <i class="icon-th-large"></i>
                <span><spring:message code="label.menu" /></span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="user-list.html"><spring:message code="label.addnewmenu" /></a></li>
                <li><a href="new-user.html"><spring:message code="label.listmenu"/> </a></li>
            </ul>
        </li>
        <li id="activites">
            <a class="dropdown-toggle" href="#">
                <i class="icon-edit"></i>
                <span><spring:message code="label.activites" /></span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="form-showcase.html"><spring:message code="label.addnewactivity"/> </a></li>
                <li><a href="form-wizard.html"><spring:message code="label.listactivity"/></a></li>
            </ul>
        </li>
        <li id="info">
            <a href="personal-info.html">
                <i class="icon-cog"></i>
                <span><spring:message code="label.info" /></span>
            </a>
        </li>
    </ul>
    <span>
    <a href="?lang=en">en</a>
    |
    <a href="?lang=cn">cn</a>
    |
    <a href="?lang=fr">fr</a>
</span>
</div>
<!-- end sidebar -->