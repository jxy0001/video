package com.zhiyou.service;

import com.zhiyou.model.Subject;

import java.util.List;

/**
 * @author
 * @date 2019/6/18
 */
public interface SubjectService {
    List<Subject> selectAll();
    
    Subject selectOne(int id);
}
