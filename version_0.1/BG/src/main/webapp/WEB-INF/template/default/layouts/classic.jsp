<%--
  Created by IntelliJ IDEA.
  User: benli
  Date: 22/09/14
  Time: 08:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<input type="hidden" value="<tiles:getAsString name="active" />" />

<tilesx:useAttribute id="stylesheets" name="stylesheets" classname="java.util.List" />
<tilesx:useAttribute id="javascript" name="javascript" classname="java.util.List" />
<%--<tiles:importAttribute name="javascripts"/>--%>
<%--<tiles:importAttribute name="stylesheets"/>--%>

<!DOCTYPE html>
<html class="login-bg">
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta name="keywords" content="<tiles:getAsString name="keywords" />"/>
    <meta name="description" content="<tiles:getAsString name="description" />"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- stylesheets -->
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
    <!-- end stylesheets -->

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<tiles:insertAttribute name="banner"/>
<tiles:insertAttribute name="menu"/>
<!-- scripts -->
<c:forEach var="script" items="${javascript}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>
<!-- end scripts -->
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="credits"/>

<script type="text/javascript">



</script>


<!-- pre load bg imgs -->
<script type="text/javascript">
    $(function () {
        // bg switcher
        var $btns = $(".bg-switch .bg");
        $btns.click(function (e) {
            e.preventDefault();
            $btns.removeClass("active");
            $(this).addClass("active");
            var bg = $(this).data("img");

            $("html").css("background-image", "url('img/bgs/" + bg + "')");
        });

    });
</script>
</body>
</html>