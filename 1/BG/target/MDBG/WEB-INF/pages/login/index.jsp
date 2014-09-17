<%--
  Created by IntelliJ IDEA.
  User: benli
  Date: 17/09/14
  Time: 08:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../included/header.jsp" %>

<!-- background switcher -->
<div class="bg-switch visible-desktop">
    <div class="bgs">
        <a href="#" data-img="landscape.jpg" class="bg active">
            <img src="img/bgs/landscape.jpg"/>
        </a>
        <a href="#" data-img="blueish.jpg" class="bg">
            <img src="img/bgs/blueish.jpg"/>
        </a>
        <a href="#" data-img="7.jpg" class="bg">
            <img src="img/bgs/7.jpg"/>
        </a>
        <a href="#" data-img="8.jpg" class="bg">
            <img src="img/bgs/8.jpg"/>
        </a>
        <a href="#" data-img="9.jpg" class="bg">
            <img src="img/bgs/9.jpg"/>
        </a>
        <a href="#" data-img="10.jpg" class="bg">
            <img src="img/bgs/10.jpg"/>
        </a>
        <a href="#" data-img="11.jpg" class="bg">
            <img src="img/bgs/11.jpg"/>
        </a>
    </div>
</div>


<div class="login-wrapper">
    <a href="index.html">
        <img class="logo" src="img/logo-white.png">
    </a>

    <div class="box">
        <div class="content-wrap">
            <h6>登录</h6>
            <input class="form-control" type="text" placeholder="邮箱地址">
            <input class="form-control" type="password" placeholder="密码">
            <a href="#" class="forgot">忘记密码?</a>

            <div class="remember">
                <input id="remember-me" type="checkbox">
                <label for="remember-me">记住密码</label>
            </div>
            <a class="btn-glow primary login" href="index.html">登录</a>
        </div>
    </div>

    <div class="no-account">
        <p>还没账号?</p>
        <a href="signup.html">注册</a>
    </div>
</div>

<%@include file="../included/footer.jsp" %>
