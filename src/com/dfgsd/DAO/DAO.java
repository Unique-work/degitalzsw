package com.dfgsd.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private	 static DAO dao=new DAO();
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }


    }
    public static Connection getConn() {
        Connection Conn=null;
        try {
            Conn=  DriverManager.getConnection("jdbc:mysql:"
                    + "//127.0.0.1:3306/digital?useUnicode=true&characterEncoding=UTF-8", "root", "19805062401");
            System.out.println("链接成功");
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return Conn;
    }

}
