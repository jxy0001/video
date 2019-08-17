package com.zhiyou.service.impl;

import com.zhiyou.mapper.VideoDao;
import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2019/6/18
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoDao dao;

    @Override
    public void add(Video video) {
        if (video != null) {
            dao.add(video);
        }
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Video video) {
        if (video != null) {
            dao.update(video);
        }
    }

    @Override
    public int selectNums() {
        return dao.selectNums();
    }

    @Override
    public List<Video> selectByPage(Map<String,Object> map) {
        return dao.selectByPage(map);
    }

    @Override
    public int selectNumsByPage(Map<String, Object> map) {
        return dao.selectNumsByPage(map);
    }

    @Override
    public Video selectById(int id) {
        List<Video> list = dao.selectById(id);
        if (list!= null) {
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Video> selectVideos(int subjectId) {
        return dao.selectVideos(subjectId);
    }

    @Override
    public List<Video> selectByCourseId(int courseId) {
        return dao.selectByCourseId(courseId);
    }

	@Override
	@Cacheable("vShow")
	public List<Video> selectShow(List course_ids) {
		
		return dao.selectShow(course_ids);
	}

	@Override
	public Video selectConnectId(int video_id) {
		
		return dao.selectConnectId(video_id);
	}

	@Override
	@Cacheable("Catalog")
	public List<Video> selectCatalog(int course_id, int video_id) {
		
		return dao.selectCatalog(course_id, video_id);
	}
}
