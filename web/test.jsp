<%--
  Created by IntelliJ IDEA.
  User: 张世文
  Date: 2021/12/5
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/checkCode" method="post">
    请输入验证码：<input type="text" name="code">
    <input type="submit" value="确定">
</form>
<img alt="验证码" id="scode" src="<%=request.getContextPath() %>/getCode" >
<a href="#" οnclick="javascript:flushCode();">看不清?</a>
</body>
</html>
