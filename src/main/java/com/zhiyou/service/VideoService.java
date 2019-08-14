package com.zhiyou.service;

import com.zhiyou.model.Video;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2019/6/18
 */
public interface VideoService {
    void add(Video video);
    void delete(int videoId);
    void update(Video video);
    int selectNums();
    List<Video> selectByPage(Map<String,Object> map);
    int selectNumsByPage(Map<String,Object> map);
    Video selectById(int id);
    List<Video> selectVideos(int subjectId);
    List<Video> selectByCourseId(int courseId);
}

