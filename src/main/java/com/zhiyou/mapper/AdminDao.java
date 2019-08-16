package com.zhiyou.mapper;

import com.zhiyou.model.Admin;

import java.util.List;

/**
 * @author
 * @date 2019/6/24
 */
public interface AdminDao {
    List<Admin> selectAdmin(String accounts);
    
    List<Admin> selectAllAdmin();
    
    void addAdmin(Admin admin);
    
    void banAdmin(int id);
    
    void recoverAdmin(int id);
    
    void delAdminById(int id);
    
}
