package com.zhiyou.service.impl;

import com.zhiyou.mapper.AdminDao;
import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;
import com.zhiyou.util.VideoResult;

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

	@Override
	public void addAdmin(Admin admin) {
		if (admin != null) {
			dao.addAdmin(admin);
		}
	}

	@Override
	public void banAdmin(int id) {
		dao.banAdmin(id);
	}

	@Override
	public void recoverAdmin(int id) {
		dao.recoverAdmin(id);
	}

	@Override
	public VideoResult delAdminById(int id) {
		dao.delAdminById(id);
		return VideoResult.ok("删除成功！");
	}

	@Override
	public List<Admin> selectAllAdmin() {
		return dao.selectAllAdmin();
	}
}
