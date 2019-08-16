package com.zhiyou.service.impl;

import com.zhiyou.mapper.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author
 * @date 2019/6/17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public void add(User user) {
        if (user != null) {
            dao.add(user);
        }
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(User user) {
        if (user != null) {
            dao.update(user);
        }
    }

    @Override
    public User selectByAccount(String account) {
        if (dao.selectByAccount(account)!=null)
        return dao.selectByAccount(account).get(0);
        else return null;
    }

    @Override
    public User selectById(int id) {
        if (dao.selectById(id)!=null)
            return dao.selectById(id).get(0);
        else return null;
    }

    @Override
    public void updatePassword(int id, String password) {
        dao.updatePassword(id,password);
    }

    @Override
    public void updateHeadLogo(int id, String imgurl) {
        dao.updateHeadLogo(id,imgurl);
    }

	@Override
	public User selectByEmail(String email) {
		
		return dao.selectByEmail(email);
	}
}
