package com.dfgsd.impl;

import com.dfgsd.DAO.DAO;
import com.dfgsd.model.Order;
import com.dfgsd.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Orderimpl {
    int row = 0;
    DAO dao = new DAO();
    static Connection conn = null;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
 public ArrayList<> (){



    }
    public boolean insert(Order o) {
        sql = "inster into order_info(userId,status,odertime) values(?,?,?) ";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, o.getId());
            ps.setString(2, o.getStatus());
            ps.setString(3, o.getOrdertime());
            row = ps.executeUpdate();
            if (row < 1) {
                return false;
            }
            sql = "SELECT id FROM order_info ORDER BY ordertime DESC LIMIT 1;";
            PreparedStatement ps2 = conn.prepareStatement(sql);
            rs = ps2.executeQuery();
            if (rs.next()) {
                o.setId(rs.getInt("id"));
                sql = "insert into order_detail(o_id,p_id,mum) values(?,?,?)";
                PreparedStatement ps3 = conn.prepareStatement(sql);
                ps3.setInt(1, o.getId());
                for (OrderDetail od : o.getDetalist()) {
                    ps3.setInt(2, od.getPid());
                    ps3.setInt(3, od.getNum());
                    ps3.addBatch();
                }
                int row2[] = ps3.executeBatch();
                for (int i : row2) {
                    if (i < 1) {
                        return false;
                    }
                }
                conn.commit();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (rs == null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}