package com.zhiyou.mapper;

import com.zhiyou.model.Video;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2019/6/19
 */
public interface VideoDao {
    void add(Video video);
    void delete(int videoId);
    void update(Video video);
    int selectNums();
    List<Video> selectByPage(Map<String,Object> map);
    int selectNumsByPage(Map<String,Object> map);
    List<Video> selectById(int id);
    List<Video> selectVideos(int subjectId);
    List<Video> selectByCourseId(int courseId);

}
