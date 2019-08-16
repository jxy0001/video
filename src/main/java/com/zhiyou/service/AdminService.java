package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Admin;
import com.zhiyou.util.VideoResult;

/**
 * @author
 * @date 2019/6/24
 */
public interface AdminService {
	
    Admin selectAdmin(String accounts);
    
    List<Admin> selectAllAdmin();
    
    void addAdmin(Admin admin);
    
    void banAdmin(int id);
    
    void recoverAdmin(int id);
    
    VideoResult delAdminById(int id);
}
