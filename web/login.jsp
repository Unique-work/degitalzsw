<%@ page import="com.dfgsd.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 张世文
  Date: 2021/12/15
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //String userName = (String)session.getAttribute("userName");
    User user = (User)session.getAttribute("user");
    if(user == null){
%>
<form id="loginform" name="loginform" method="post" action="doLogin.jsp" >
    <div><strong>登录名：</strong><input name="txtUser" id="txtUser" size="15" value="" /></div>
    <div><strong>密　码：</strong><input name="txtPassword" type="password" id="txtPassword" size="15" value="" /></div>
    <div>
        <strong>验证码：</strong><input name="verifyCode" id="verifyCode" size="4" />

    </div>
    <div><input type="submit" value="登录" name="submit" class="picbut" />　
        <input name="reg" type="button" value="注册用户" class="picbut" onclick="javascript:location.href=('regist.jsp');" />
    </div>
    <div><a href="findPwd.jsp">找回密码</a></div>
    <div><font color=red size=3></font></div>
</form>
<%}else{%>
<ul>
    <li>欢迎回来,<%=user.getUserName() %></li>
    <li><a href="">我的购物车</a></li>
    <li><a href="">我的订单</a></li>
    <li><a href="userInfo.jsp">个人信息</a></li>
    <li><a href="doLogout.jsp">退出</a></li>
</ul>
<%} %>




</body>
</html>
