package com.zhiyou.mapper;

import com.zhiyou.model.Course;
import java.util.List;

/**
 * @author
 * @date 2019/6/18
 */
public interface CourseDao {
    void add(Course course);
    void delete(int id);
    void update(Course course);
    int selectNums();
    List<Course> selectByPage(int num);//num:从第几条开始
    List<Course> selectById(int id);
    List<Course> selectAll();
    List<Course> selectBySubjectId(int subjectId);
}
