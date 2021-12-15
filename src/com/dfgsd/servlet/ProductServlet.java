package com.dfgsd.servlet;

import com.dfgsd.impl.Prodouctdo;
import com.dfgsd.model.Cart;
import com.dfgsd.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String flag = request.getParameter("flag");

        Boolean result=false;
        String nextpage = null;
        Prodouctdo pd=new Prodouctdo();
        HttpSession session=request.getSession();


        System.out.println(flag);

        if(flag.equals("add")){

            System.out.println("add");

            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String brand = request.getParameter("brand");
            String pic = request.getParameter("pic");
            String price = request.getParameter("price");
            String num = request.getParameter("num");
            String sale=request.getParameter("sale");
            Product p=new Product();

            p.setCode(code);
            p.setName(name);
            p.setType(type);
            p.setBrand(brand);
            p.setPic(pic);
            p.setPrice(Integer.parseInt(price));
            p.setNum(Integer.parseInt(num));
            p.setSale(Integer.parseInt(sale));
            ArrayList<Product> productlist;
            result=new Prodouctdo().addProduct(p);
           productlist=pd.findAll();
            session.setAttribute("productlist",  productlist);



        }else if(flag.equals("update")){
            System.out.println("update");
            String id = request.getParameter("id");
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String brand = request.getParameter("brand");
            String pic = request.getParameter("pic");
            String price = request.getParameter("price");
            String num = request.getParameter("num");
            String sale=request.getParameter("sale");
            Product p = new Product();
            p.setId(Integer.parseInt(id));
            p.setBrand(brand);
            p.setCode(code);

            p.setName(name);
            p.setNum(Integer.parseInt(num));
            p.setPrice(Integer.parseInt(price));
            p.setNum(Integer.parseInt(num));
            p.setSale(Integer.parseInt(sale));
            p.setType(type);

            result = pd.update(p,Integer.parseInt(id));



        }else if(flag.equals("delete")){
            System.out.println("delete");
            String id = request.getParameter("id");
            pd.deleteProduct(Integer.parseInt(id));
            ArrayList<Product> productlist = (ArrayList<Product>) session.getAttribute("productlist");
            for(Product p:productlist){
               if(p.getId()==Integer.parseInt(id)){
                   System.out.println(p.getName());
                   productlist.remove(p);
                    result=pd.deleteProduct(Integer.parseInt(id));
                   System.out.println(result);


               }

            }
            System.out.println();

        }else if(flag.equals("list")){
            System.out.println("list");


        }

        nextpage="admin/list_product.jsp";
        response.sendRedirect(nextpage);

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
