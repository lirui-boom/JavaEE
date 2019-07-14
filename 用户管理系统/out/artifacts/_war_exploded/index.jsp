<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理员登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <meta name="keywords"
          content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates"/>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <!--webfonts-->
    <link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
          rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
    <!--//webfonts-->
    <script src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
<script>$(document).ready(function (c) {
    $('.close').on('click', function (c) {
        $('.login-form').fadeOut('slow', function (c) {
            $('.login-form').remove();
        });
    });
});
</script>
<!--SIGN UP-->
<h1>管理员登录</h1>
<div class="login-form">
    <div class="close"></div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"></div>
    <div class="avtar">
        <img src="images/avtar.png"/>
    </div>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <input type="text" name="administrators" class="text" value="Username" onfocus="this.value = '';"
               onblur="if (this.value == '') {this.value = 'Username';}">
        <div class="key">
            <input type="password" id ="password" name="password" value="Password" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = 'Password';}">
        </div>

        <%--<input type="text" name="checkcode" width="50px;"><img src="/hehewocao/checkCodeServlet" height="30px">--%>

        <div class="signin">
            <input type="submit" value="Login" >
        </div>
    </form>
</div>
<br>
<p align="center" style="color: red">
    <c:if test="${not empty login_msg}">
        ${login_msg}
    </c:if></p>
<div class="copy-rights">
    <p>Create By BOOM : 2495399053@qq.com</p>
</div>
</body>
</html>