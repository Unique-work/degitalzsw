package com.dfgsd.tool;

public class SaveUserStateTool {
    private static String username=null;
    private static String  password=null;
    public static  String getUsername() {
        return username;
    }
    public static void setUsername(String username) {
        SaveUserStateTool.username = username;
    }
    public static  String getPassword() {
        return password;
    }
    public static void setPassword(String password) {
        SaveUserStateTool.password = password;
    }

}
