<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dfgsd.model.User" %>
<%@ page import="com.dfgsd.impl.Userdo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
        String userName = request.getParameter("txtUser");
        String password = request.getParameter("txtPassword");
        ArrayList<User> userList = new ArrayList<User>();
    Userdo d=new Userdo();
       /* userList.add(new User("ssh","2024051127"));
        userList.add(new User("tom","2024051127"));
        userList.add(new User("lucy","2024051127"));
        userList.add(new User("lily","2024051127"));*/
        for(User u :Userdo.userlogin()){
        	if(u.getUserName().equals(userName)&&u.getPassword().equals(password)){
        		session.setAttribute("user",u);
        		//步骤2：登录成功储存在application中
        		ArrayList<User> onLineUserList = (ArrayList<User>)application.getAttribute("onLineUserList");
        		if(onLineUserList == null){
        			onLineUserList = new ArrayList<User>();
        		}
        		onLineUserList.add(u);
    			application.setAttribute("onLineUserList",onLineUserList);
    			break;
        	}
        }
        
        
        
        response.sendRedirect("index.jsp");
%>
<%=userName%>
<%=password%>
</body>
</html>