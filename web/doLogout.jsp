<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.dfgsd.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <% 
        User user = (User)session.getAttribute("user");
        ArrayList<User> onLineUserList = (ArrayList<User>)application.getAttribute("onLineUserList");
        for(User u : onLineUserList){
        	if(u.getUserName().equals(user.getUserName())){
        		onLineUserList.remove(u);
        		break;
        	}
        }
        session.invalidate();
        response.sendRedirect("index.jsp");
        %>
</body>
</html>