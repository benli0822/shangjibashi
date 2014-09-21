<%--
  Created by IntelliJ IDEA.
  User: benli
  Date: 21/09/14
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- scripts -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
<script src="<c:url value="/resources/js/theme.js" />" ></script>

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
