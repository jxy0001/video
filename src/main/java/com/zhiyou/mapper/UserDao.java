package com.zhiyou.mapper;

import com.zhiyou.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2019/6/17
 */
public interface UserDao {
    void add(User user);
    void delete(int id);
    void update(User user);
    List<User> selectByAccount(String account);
    List<User> selectById(int id);
    void updatePassword(@Param("id") int id, @Param("password") String password);
    void updateHeadLogo(@Param("id") int id, @Param("imgurl") String imgurl);
    

}
