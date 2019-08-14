package com.zhiyou.mapper;

import com.zhiyou.model.Admin;

import java.util.List;

/**
 * @author
 * @date 2019/6/24
 */
public interface AdminDao {
    List<Admin> selectAdmin(String accounts);
    
}
