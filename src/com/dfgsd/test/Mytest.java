package com.dfgsd.test;

import com.dfgsd.impl.Userdo;
import com.dfgsd.model.User;

public class Mytest {
    public static void main(String[] args) {

        User u=new User("stu5","123");
        Userdo.insertUser(u);

    }
}
