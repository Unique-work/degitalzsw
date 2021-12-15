<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm;ss");
        out.print(date);
%>
<font color="red" size="8"><%=sdf.format(date) %></font>
</body>
</html>