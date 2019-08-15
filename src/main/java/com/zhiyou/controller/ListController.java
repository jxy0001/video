package com.zhiyou.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SubjectService;
import com.zhiyou.service.VideoService;

@Controller
public class ListController {
	
	@Autowired
	VideoService videoService;
	@Autowired
	CourseService courseService;
	@Autowired
	SubjectService subjectService;
	
	@RequestMapping("CourseList.do")
	public String videoPlayList(int subject_id,HttpServletRequest req){
		List<Course> CourseList = courseService.selectBySubjectId(subject_id);
		if(CourseList.size()==0) {
			return "index";
		}
		Iterator<Course> it = CourseList.iterator();
		List i = new ArrayList();
		while(it.hasNext()){
		   Course c = it.next();
		   i.add(c.getId());
		  }
        List<Video> vd = videoService.selectShow(i);
        req.setAttribute("vd", vd);
		req.setAttribute("CL", CourseList);
		Subject sb = subjectService.selectOne(subject_id);
		req.setAttribute("sb", sb);
		return "CourseList";
	}
	
	@RequestMapping("videoPlay.do")
	public String videoPlay(int video_id,int course_id,HttpServletRequest req){
		Video v = videoService.selectConnectId(video_id);
		v.setPlayNum(v.getPlayNum()+1);
		videoService.update(v);
		req.setAttribute("v", v);
		List<Video> vs = videoService.selectCatalog(course_id,video_id);
		req.setAttribute("vs", vs);
		return "videoPlayList";
	}

}
