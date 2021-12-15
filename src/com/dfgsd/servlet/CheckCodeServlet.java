package com.dfgsd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = (String) request.getSession().getAttribute("code");
        // 获取页面提交的验证码
        String inputCode = request.getParameter("verifyCode");
        if(code.toLowerCase().equals(inputCode.toLowerCase())) { // 验证码不区分大小写
            // 验证成功，跳转到成功页面
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else { // 验证失败
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    }

