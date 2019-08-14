package com.zhiyou.service.impl;

import com.zhiyou.mapper.AdminDao;
import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019/6/24
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao dao;

    @Override
    public Admin selectAdmin(String accounts) {
        List<Admin> admins = dao.selectAdmin(accounts);
        if (admins!=null){
            return admins.get(0);
        }else {
            return null;
        }

    }
}
