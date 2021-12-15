package com.dfgsd.model;

import java.util.ArrayList;

public class Order {
    int id;
    int userid;
    String username;
    String address;
    String status;
    String ordertime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public ArrayList<OrderDetail> getDetalist() {
        return detalist;
    }

    public void setDetalist(ArrayList<OrderDetail> detalist) {
        this.detalist = detalist;
    }

    ArrayList<OrderDetail> detalist=new ArrayList<OrderDetail>();


}
