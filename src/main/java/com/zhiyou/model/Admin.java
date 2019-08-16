package com.zhiyou.model;

/**
 * @author
 * @date 2019/6/17
 */
public class Admin {

    private int adminId;
    private String accounts;
    private String password;
    private String adminRemark;
    private String status;
    
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Admin(int adminId, String accounts, String password, String adminRemark, String status) {
		super();
		this.adminId = adminId;
		this.accounts = accounts;
		this.password = password;
		this.adminRemark = adminRemark;
		this.status = status;
	}
	public Admin() {
		super();
	}
    

}
