package com.zhiyou.service;

import com.zhiyou.model.Speaker;

import java.util.List;

/**
 * @author
 * @date 2019/6/18
 */
public interface SpeakerService {
    void add(Speaker speaker);
    void delete(int id);
    void update(Speaker speaker);
    int selectNums();
    List<Speaker> selectByPage(int num);//num:从第几条开始
    Speaker selectById(int id);
    List<Speaker> selectAll();
}

