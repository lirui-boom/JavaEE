<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户管理</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->

    <style>

        tr, th, td {
            text-align: center;
        }

    </style>

</head>
<body>


<div style="width: 70%;margin-left: 15%;margin-top: 50px;" align="center">
    <form class="form-inline" action="${pageContext.request.contextPath}/findServletByPage" method="post">
        <div class="form-group">
            <label>编号</label>
            <input id="id" type="text" name="id" value="${condition.id[0]}" placeholder="输入编号" align="center"/>
        </div>
        <div class="form-group">
            <label>用户名</label>
            <input id="username" type="text" value="${condition.username[0]}" name="username" placeholder="输入用户名" align="center"/>
        </div>
        <div class="form-group">
            <label>昵称</label>
            <input type="text" id="nickname" value="${condition.nickname[0]}" name="nickname" placeholder="昵称" align="center"/>
        </div>

        <div class="form-group">
            <label>地址</label>
            <input type="text" id="address" value="${condition.address[0]}" name="address" placeholder="地址" align="center"/>
        </div>

        <button type="submit" class="btn btn-default" id="find">查询</button>&nbsp;&nbsp;&nbsp;
        <a  href="register.jsp"><button type="button" class="btn btn-primary">添加用户</button></a>
    </form>
</div>


<div style="width: 80%;margin-left: 10%;margin-top: 50px;">
    <table class="table table-hover">
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>昵称</th>
            <th>性别</th>
            <th>生日</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>地址</th>
            <th>职业</th>
            <th>描述</th>
            <th colspan="2">操作</th>
        </tr>

        <c:if test="${not empty pageBean}">

            <c:forEach items="${pageBean.list}" var="user" begin="0" end="${pageBean.list.size() - 1}" step="1"
                       varStatus="s">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.nickname}</td>
                    <td>${user.sex}</td>
                    <td>${user.birthday}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td>${user.occupation}</td>
                    <td>${user.describes}</td>
                    <td><a href="${pageContext.request.contextPath}/updateUserForwordServlet?beforeUserId=${user.id}" name="del" id="update${s}">修改</a></td>
                    <td><a href="${pageContext.request.contextPath}/delServletById?delId=${user.id}" name="del" id="${s}"
                           onclick="delLine(this)">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>


<%--分页栏--%>
<div align="center" style="margin-top: 50px;">
    <nav aria-label="Page navigation">
        <ul class="pagination">


            <c:if test="${pageBean.page == 1}">
                <li class="disabled">
                    <a href="#"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${pageBean.page != 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/findServletByPage?page=${pageBean.page - 1}&rows=5&id=${condition.id[0]}&username=${condition.username[0]}&nickname=${condition.nickname[0]}&address=${condition.address[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>


            <c:forEach begin="1" end='${pageContext.request.getAttribute("pageBean").pages}' var="i">
                <c:if test="${pageBean.page == i}">
                    <li class="active"><a
                            href='${pageContext.request.contextPath}/findServletByPage?page=${i}&rows=5&id=${condition.id[0]}&username=${condition.username[0]}&nickname=${condition.nickname[0]}&address=${condition.address[0]}'>${i}</a></li>
                </c:if>
                <c:if test="${pageBean.page != i}">
                    <li><a href='${pageContext.request.contextPath}/findServletByPage?page=${i}&rows=5&id=${condition.id[0]}&username=${condition.username[0]}&nickname=${condition.nickname[0]}&address=${condition.address[0]}'>${i}</a></li>
                </c:if>
            </c:forEach>


            <c:if test="${pageBean.pages == pageBean.page}">
                <li class="disabled">
                    <a href="#"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

            <c:if test="${pageBean.pages != pageBean.page}">
                <li>
                    <a href="${pageContext.request.contextPath}/findServletByPage?page=${pageBean.page + 1}&rows=5&id=${condition.id[0]}&username=${condition.username[0]}&nickname=${condition.nickname[0]}&$address=${condition.address[0]}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

        </ul>
    </nav>
    <p style="font-weight: bold">
        共${pageBean.count == null ? 0 : pageBean.count}条记录,共${pageBean.pages == null ? 0 : pageBean.pages}页</p>
</div>


<script>
    function delLine(obj) {
        if (confirm("确认删除?")) {
            return true;
        }
    }


</script>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>