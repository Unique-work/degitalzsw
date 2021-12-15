package com.dfgsd.impl;

import com.dfgsd.model.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Userdo {
    com.dfgsd.DAO.DAO DAO = null;
    static Connection conn = null;

    public static ArrayList<User> userlogin() {
        ArrayList<User> list = new ArrayList<User>();
        try {

            conn = com.dfgsd.DAO.DAO.getConn(); //获取数据库链接
            PreparedStatement ps = conn.prepareStatement("select * from user_info");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                u.setUserName(rs.getString("userName"));
                u.setPassword(rs.getString("password"));
                list.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public static void insertUser(User user) {
        Connection conn = null;
        try {
            String username = user.getUserName();
            String pwd = user.getPassword();
            if (username == null || username.trim().equals("") || pwd == null
                    || pwd.trim().equals("") ) {// 如果账号密码有空的
                JOptionPane.showMessageDialog(null, "用户名或密码不能为空。");

            }
            conn = com.dfgsd.DAO.DAO.getConn(); //获取数据库链接
            // 创建PreparedStatement对象，并传递SQL语句
            PreparedStatement ps = conn.prepareStatement("insert into user_info (userName,password)  values(?,?)");
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            int flag = ps.executeUpdate();// 执行sql
            if (flag > 0) {// 如果被影响行数大于0

            } else {
                JOptionPane.showMessageDialog(null, "添加失败。");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}

