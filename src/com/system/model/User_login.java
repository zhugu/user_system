package com.system.model;
/**
 * @author 邓益聪
 */
public class User_login {
    private String account;
    private String password;

    public User_login(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User_login() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User_login{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
