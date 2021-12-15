package com.dfgsd.impl;

import com.dfgsd.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Prodouctdo {

    com.dfgsd.DAO.DAO DAO = null;
    static Connection conn = null;
    public ArrayList<Product> findAll() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            conn = DAO.getConn(); //获取数据库链接

            String sql = "select * from product_info;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setCode(rs.getString(2));
                p.setName(rs.getString(3));
                p.setType(rs.getString(4));
                p.setBrand(rs.getString(5));
                p.setPic(rs.getString(6));
                p.setNum(rs.getInt(7));
                p.setPrice(rs.getInt(8));
                p.setSale(rs.getInt(9));
                p.setIntro(rs.getString(10));
                p.setStatus(rs.getString(11));
                System.out.println(rs.getString(3));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {


        }
        return list;
    }
    public   Product getProductById(int id){
        Product p = new Product();
        try {
            conn = DAO.getConn(); //获取数据库链接
           
            String sql = "select * from product_info where id="+id+";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                p.setId(rs.getInt(1));
                p.setCode(rs.getString(2));
                p.setName(rs.getString(3));
                p.setType(rs.getString(4));
                p.setBrand(rs.getString(5));
                p.setPic(rs.getString(6));
                p.setNum(rs.getInt(7));
                p.setPrice(rs.getInt(8));
                p.setSale(rs.getInt(9));
                p.setIntro(rs.getString(10));
                p.setStatus(rs.getString(11));
                System.out.println(rs.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return  p;
    }

    public Boolean addProduct(Product p) {
        int row = 0;
        try {
                conn = DAO.getConn(); //获取数据库链接
    
                String sql = "INSERT INTO product_info(code,name,type,brand,pic,num,price,sale,intro) VALUES(?,?,?,?,?,?,?,?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,Integer.parseInt(p.getCode()));
                ps.setString(2,p.getName());
                ps.setString(3,p.getType());
                ps.setString(4,p.getBrand());
                ps.setString(5,p.getPic());
                 ps.setInt(6,p.getNum());
                ps.setInt(7,p.getPrice());
                ps.setInt(8,p.getSale());
                ps.setString(9,p.getIntro());
              row =ps.executeUpdate();
                
        } catch (SQLException e) {
            e.printStackTrace();
        }

            return  row>0?true:false;

    }
    public boolean deleteProduct( int id){
        int row = 0;
        conn = DAO.getConn(); //获取数据库链接
            try {
            String sql = "DELETE FROM product_info WHERE id= "+id;
            PreparedStatement ps = conn.prepareStatement(sql);
            row= ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return row>0?true:false;
    }
    public boolean update(Product p,int id) {
        int row = 0;
       String sql = "update product_info set code=?,name=?,type=?,brand=?,pic=?,num=?,price=?,sale=?,intro=? where id="+id;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getCode());
            ps.setString(2, p.getName());
            ps.setString(3, p.getType());
            ps.setString(4, p.getBrand());
            ps.setString(5, p.getPic());
            ps.setInt(6, p.getNum());
            ps.setDouble(7, p.getPrice());
            ps.setDouble(8, p.getSale());
            ps.setString(9, p.getIntro());
            ps.setInt(10, p.getId());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return row>0?true:false;

    }

}
