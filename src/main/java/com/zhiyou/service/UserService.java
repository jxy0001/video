package com.zhiyou.service;

import com.zhiyou.model.User;

/**
 * @author
 * @date 2019/6/17
 */
public interface UserService {
    void add(User user);
    void delete(int id);
    void update(User user);
    User selectByAccount(String account);
    User selectById(int id);
    void updatePassword(int id,String password);
    void updateHeadLogo(int id,String imgurl);
   
}
