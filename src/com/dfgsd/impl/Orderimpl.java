package com.dfgsd.impl;

import com.dfgsd.DAO.DAO;
import com.dfgsd.model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Orderimpl {
    DAO dao=new DAO();
    private PreparedStatement ps;
    private ResultSet rs;
    String sql;
    public  boolean insert(Order order){

        return false;
    }

}

