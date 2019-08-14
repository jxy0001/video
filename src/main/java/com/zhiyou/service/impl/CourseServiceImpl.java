package com.zhiyou.service.impl;

import com.zhiyou.mapper.CourseDao;
import com.zhiyou.model.Course;
import com.zhiyou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019/6/18
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao dao;

    @Override
    public void add(Course course) {
        if (course != null) {
            dao.add(course);
        }
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Course course) {
        if (course != null) {
            dao.update(course);
        }
    }

    @Override
    public int selectNums() {
        return dao.selectNums();
    }

    @Override
    public List<Course> selectByPage(int num) {
        return dao.selectByPage(num);
    }

    @Override
    public Course selectById(int id) {
        List<Course> list = dao.selectById(id);
        if (list!= null) {
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Course> selectAll() {
        return dao.selectAll();
    }

    @Override
    public List<Course> selectBySubjectId(int subjectId) {
        return dao.selectBySubjectId(subjectId);
    }
}
