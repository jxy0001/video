package com.zhiyou.mapper;

import com.zhiyou.model.Subject;

import java.util.List;

/**
 * @author
 * @date 2019/6/18
 */
public interface SubjectDao {
    List<Subject> selectAll();
}
