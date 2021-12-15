<%@page import="com.dfgsd.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.dfgsd.impl.Userdo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type='text/javascript'>alert('注册成功')</script>
<body>
<jsp:useBean id="user" class="com.dfgsd.model.User" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<%
	Userdo.insertUser(user);
if(user.getUserName()==null || user.getUserName().equals("")||user.getPassword().equals("")||user.getPassword()==null){
	session.removeAttribute("user");
	out.print("<script type='text/javascript'>alert('注册失败')</script>");
}else{
	ArrayList<User>onLineuserList = new ArrayList<User>();
	if(onLineuserList==null){
		onLineuserList=new ArrayList<User>();
	}
	onLineuserList.add(user);
application.setAttribute("onLineuserList", onLineuserList);

	out.print("<script type='text/javascript'>alert('注册成功')</script>");
}
response.setHeader("refresh", "2;URL=index.jsp");

%>
</body>
</html>