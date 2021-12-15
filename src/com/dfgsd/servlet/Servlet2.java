package com.dfgsd.servlet;

import com.dfgsd.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/Servlet2" )
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        HttpSession session=request.getSession();
        ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cartlist");
        if (cartlist == null) {
            cartlist = new ArrayList<Cart>();
            session.setAttribute("cartlist",cartlist);
        }


        if (flag.equals("add")) {
            System.out.println("add");
            String id = request.getParameter("id");
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String brand = request.getParameter("brand");
            String pic = request.getParameter("pic");
            String price = request.getParameter("price");
            String num = request.getParameter("num");
            System.out.println(id);
            Cart cart = new Cart();
            cart.setCode(code);
            cart.setBrand(brand);
            cart.setId(id);
            cart.setName(name);
            cart.setType(type);
            cart.setPic(pic);

            cart.setNum(Integer.parseInt(num));
            cart.setPrice(Integer.parseInt(price));

            boolean hascart=false;
            for (Cart c: cartlist){
                if(c.getId()==cart.getId()){
                    cart.setNum(c.getNum()+cart.getNum());
                    hascart=true;
                    break;
                }
            }
            if (!hascart) {
                cartlist.add(cart);
            }
        } else if (flag.equals("update")) {


        } else if (flag.equals("delete")) {
            System.out.println("delete");
           String strid= request.getParameter("id");
            System.out.println(strid);
         for (Cart c: cartlist){
             System.out.println("delete2");
             if (c.getId().equals(strid)){
                 System.out.println("delet3");
                 cartlist.remove(c);
                 System.out.println(c.getId());
             }

         }


    }
        response.sendRedirect("product/list_cart.jsp");

    }
}
