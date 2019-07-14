<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册我们的网站</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]-->
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <!--[endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">


    <style>

        body {

            background-image: url("assets/img/backgrounds/2.jpg");
        }

    </style>


</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>注册我们的网站</h3>
                            <p>输入您的用户名、密码和邮箱：</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="${pageContext.request.contextPath}/registerServlet" method="post"
                              class="login-form">

                            <div class="form-group">
                                <label class="sr-only">Username</label>
                                <input type="text" name="username" placeholder="用户名(必填)..." value="${register_submit.username}"
                                       class="form-username form-control" id="username">
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Password</label>
                                <input type="password" name="password" placeholder="密码(必填)..."
                                       class="form-password form-control" id="password">
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Repassword</label>
                                <input type="password" name="repassword" placeholder="再次输入密码(必填)..."
                                       class="form-password form-control" id="repassword">
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Email</label>
                                <input type="text" name="email" placeholder="邮箱(必填)..." value="${register_submit.email}"
                                       class="form-username form-control" id="email">
                            </div>

                            <div class="form-group">
                                <label class="sr-only">手机号</label>
                                <input type="text" name="phone" placeholder="手机号(必填)..." value="${register_submit.phone}"
                                       class="form-username form-control" id="phone">
                            </div>


                            <div class="form-group">
                                <label class="sr-only">昵称</label>
                                <input type="text" name="nickname" placeholder="昵称..." value="${register_submit.nickname}"
                                       id="nickname" style="height: 50px;width: 100%">
                            </div>

                            <div class="form-group">
                                <label class="sr-only">性别</label>
                                <select class="form-control" name="sex" id="sex" value="${register_submit.sex}"
                                        style="height: 50px;border: solid #d5d5d5;background-color: #FFFAFA">
                                    <option <c:if test="${register_submit.sex == '男'}">selected</c:if>>男</option>
                                    <option <c:if test="${register_submit.sex == '女'}">selected</c:if>>女</option>
                                </select>
                            </div>

                            <div class="form-group"
                                 style="width: 40%;float: left;height: 50px;border: solid #d5d5d5;background-color: #FFFAFA">
                                <p style="font-size: medium;font-weight: normal;margin-top: 8px;margin-left: 20px;">
                                    生日...</p>
                            </div>
                            <div style="width: 50%;height:50px;float: left;margin-left: 5%">
                                <input type="date" name="birthday" id="birthday" value="${register_submit.birthday}"
                                       style="border: solid #d5d5d5;height: 50px;background-color: #FFFAFA;text-align: center">
                            </div>

                            <div class="form-group">
                                <label class="sr-only">所在省份</label>
                                <select class="form-control" name="address" id="address"
                                        style="height: 50px;border: solid #d5d5d5;background-color: #FFFAFA">
                                    <option <c:if test="${register_submit.address == '北京'}">selected</c:if>>北京</option>
                                    <option <c:if test="${register_submit.address == '天津'}">selected</c:if>>天津</option>
                                    <option <c:if test="${register_submit.address == '河北'}">selected</c:if>>河北</option>
                                    <option <c:if test="${register_submit.address == '山西'}">selected</c:if>>山西</option>
                                    <option <c:if test="${register_submit.address == '内蒙古'}">selected</c:if>>内蒙古</option>
                                    <option <c:if test="${register_submit.address == '辽宁'}">selected</c:if>>辽宁</option>
                                    <option <c:if test="${register_submit.address == '吉林'}">selected</c:if>>吉林</option>
                                    <option <c:if test="${register_submit.address == '黑龙江'}">selected</c:if>>黑龙江</option>
                                    <option <c:if test="${register_submit.address == '上海'}">selected</c:if>>上海</option>
                                    <option <c:if test="${register_submit.address == '江苏'}">selected</c:if>>江苏</option>
                                    <option <c:if test="${register_submit.address == '浙江'}">selected</c:if>>浙江</option>
                                    <option <c:if test="${register_submit.address == '安徽'}">selected</c:if>>安徽</option>
                                    <option <c:if test="${register_submit.address == '福建'}">selected</c:if>>福建</option>
                                    <option <c:if test="${register_submit.address == '江西'}">selected</c:if>>江西</option>
                                    <option <c:if test="${register_submit.address == '山东'}">selected</c:if>>山东</option>
                                    <option <c:if test="${register_submit.address == '河南'}">selected</c:if>>河南</option>
                                    <option <c:if test="${register_submit.address == '湖北'}">selected</c:if>>湖北</option>
                                    <option <c:if test="${register_submit.address == '湖南'}">selected</c:if>>湖南</option>
                                    <option <c:if test="${register_submit.address == '广东'}">selected</c:if>>广东</option>
                                    <option <c:if test="${register_submit.address == '广西'}">selected</c:if>>广西</option>
                                    <option <c:if test="${register_submit.address == '海南'}">selected</c:if>>海南</option>
                                    <option <c:if test="${register_submit.address == '重庆'}">selected</c:if>>重庆</option>
                                    <option <c:if test="${register_submit.address == '四川'}">selected</c:if>>四川</option>
                                    <option <c:if test="${register_submit.address == '贵州'}">selected</c:if>>贵州</option>
                                    <option <c:if test="${register_submit.address == '云南'}">selected</c:if>>云南</option>
                                    <option <c:if test="${register_submit.address == '西藏'}">selected</c:if>>西藏</option>
                                    <option <c:if test="${register_submit.address == '陕西'}">selected</c:if>>陕西</option>
                                    <option <c:if test="${register_submit.address == '甘肃'}">selected</c:if>>甘肃</option>
                                    <option <c:if test="${register_submit.address == '青海'}">selected</c:if>>青海</option>
                                    <option <c:if test="${register_submit.address == '宁夏'}">selected</c:if>>宁夏</option>
                                    <option <c:if test="${register_submit.address == '新疆'}">selected</c:if>>新疆</option>
                                    <option <c:if test="${register_submit.address == '港澳台'}">selected</c:if>>港澳台</option>

                                </select>
                            </div>

                            <div class="form-group">
                                <label class="sr-only">职业</label>
                                <input type="text" name="occupation" placeholder="职业..." value="${register_submit.occupation}"
                                       style="height: 50px;width: 100%" id="occupation">
                            </div>

                            <div class="form-group">
                                <label class="sr-only">个人说明</label>
                                <textarea style="width: 100%" name="describe" placeholder="个人说明..." rows="3"
                                          id="describes"><%--<c:if test="${not empty register_submit.describes}">${register_submit.describes}</c:if>--%>
                                </textarea>
                            </div>


                            <div class="form-group" style="width: 60%;float: left">
                                <label class="sr-only">验证码</label>
                                <input type="text" name="checkcode" placeholder="验证码(必填)..."
                                       class="form-username form-control" id="checkcode">
                            </div>

                            <div style="width: 30%;height:50px;float: left;border: solid #d5d5d5;margin-left: 5%">
                                <img src="${pageContext.request.contextPath}/checkCodeServlet" id="checkImage"
                                     style="width: 100%;height: 100%" onclick="changeCheckImage()">
                            </div>

                            <button type="submit" class="btn" id="btn">注册</button>

                        </form>

                    </div>
                </div>
            </div>
            <div class="row"><p style="color: red">${pageContext.request.getAttribute("register_msg")}</p></div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>...or login with:</h3>
                    <div class="social-login-buttons">
                        <a class="btn btn-link-2" href="#">
                            <i class="fa fa-facebook"></i> Facebook
                        </a>
                        <a class="btn btn-link-2" href="#">
                            <i class="fa fa-twitter"></i> Twitter
                        </a>
                        <a class="btn btn-link-2" href="#">
                            <i class="fa fa-google-plus"></i> Google Plus
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<div class="row">
    <p>Create By BOOM : 2495399053@qq.com</p>
</div>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>


<script>

    function checkUsernaem(username) {
        var flag = true;
        if (username.length == 0) {
            alert("用户名不能为空！");
            flag = false;
            return flag;
        }
        var regexp = /^[a-zA-Z]{6,20}/;
        if (!regexp.test(username)) {
            alert("非法的用户名！用户名必须是以字母开头，只含字母的6-20位字母组合！");
            flag = false
        }
        return flag;
    }

    function checkPassword(password, repassword) {
        var flag = true;

        if (!(password.length >= 6 && password.length <= 20) || password.length == 0) {
            alert("密码必须是6-20位的字符！");
            flag = false;
            return flag;
        }
        if (password == username) {
            alert("密码不能和账号一样！");
            flag = false;
            return flag;
        }

        if (password != repassword) {
            alert("两次输入的密码不一致！");
            flag = false;
            return flag;
        }

        return flag;
    }

    function checkEmail(email) {
        var flag = true;
        if (email.indexOf("@") == -1 || email.length == 0) {
            alert("非法的邮箱地址！");
            flag = false;
        }
        return flag;
    }

    function checkPhone(phone) {
        var flag = true;
        var phoneNumReg = /^1[3456789]\d{9}$/;
        if (!phoneNumReg.test(phone) || phone.length == 0) {
            alert("请输入正确的手机号！");
            flag = false;
        }
        return flag;
    }

    function checkCode(checkcode) {
        var flag = true;
        if (checkcode.length == 0) {
            alert("验证码不能为空！");
            flag = false;
        }
        return flag;
    }


    function check() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var repassword = document.getElementById("repassword").value;
        var email = document.getElementById("email").value;
        var phone = document.getElementById("phone").value;
        var checkcode = document.getElementById("checkcode").value;
        if (checkUsernaem(username) && checkPassword(password, repassword) && checkEmail(email) && checkPhone(phone) && checkCode(checkcode)) {
            return true;
        } else {
            return false;
        }
    }

    var submit = document.getElementById("btn").onclick = function (ev) {
        return check();
    }

    //鼠标点击切换验证码
    function changeCheckImage() {
        var checkImage = document.getElementById("checkImage");
        var date = new Date();
        var time = date.getTime();
        checkImage.setAttribute("src", "${pageContext.request.contextPath}/checkCodeServlet?" + time);
    }

    document.getElementById("describes").value = "${register_submit.describes}";

</script>


</body>

</html>