package com.zhiyou.model;

import java.io.Serializable;

/**
 * @author
 * @date 2019/6/17
 */
public class Admin implements Serializable{

    private int adminId;
    private String accounts;
    private String password;
    private String adminRemark;

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", accounts='" + accounts + '\'' +
                ", password='" + password + '\'' +
                ", adminRemark='" + adminRemark + '\'' +
                '}';
    }

    public Admin() {
    }

    public Admin(int adminId, String accounts, String password, String adminRemark) {
        this.adminId = adminId;
        this.accounts = accounts;
        this.password = password;
        this.adminRemark = adminRemark;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminRemark() {
        return adminRemark;
    }

    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark;
    }
}
