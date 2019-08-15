package com.zhiyou.service;

import com.zhiyou.model.Video;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
    
    List<Video> selectShow(List course_ids);
    Video selectConnectId(int video_id);
    List<Video> selectCatalog(@Param("course_id") int course_id,@Param("video_id")int video_id);
}

