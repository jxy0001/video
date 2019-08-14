package com.zhiyou.controller;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2019/6/18
 */
@Controller
public class VideoController {
    @Autowired
    VideoService service;
    @Autowired
    SpeakerService speakerService;
    @Autowired
    CourseService courseService;


    @RequestMapping("selectVideoPage")
    @ResponseBody
    public ModelAndView selectVideoPage( String page, String title, String speakerId, String courseId,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        int p =0;
        if (page!=null){
            p = Integer.parseInt(page);
        }
        Map<String,Object> map = new HashMap<String,Object>();
        if (page==null){
            map.put("num",0);
        }else {
            map.put("num",p*5);
        }

        map.put("title",title);
        map.put("speakerId",speakerId);
        map.put("courseId",courseId);

        int count = service.selectNumsByPage(map);
        int maxPage =0;//最大页码
        if (count%5!=0){
            maxPage = count/5+1;
        }else {
            maxPage = count/5;
        }
        mv.addObject("maxPage",maxPage);
        mv.addObject("page",p);
        mv.addObject("list",service.selectByPage(map));
        mv.addObject("course",courseService.selectAll());
        mv.addObject("speaker",speakerService.selectAll());
        mv.setViewName("video");

        return mv;
    }

    @RequestMapping("updateVideoData")
    public ModelAndView updateVideoData(int id){
        ModelAndView mv = new ModelAndView();
        System.out.println("video======="+id);
        System.out.println("service.selectById(id)"+service.selectById(id).toString());
        mv.setViewName("videoUpdate");
        mv.addObject("course",courseService.selectAll());
        mv.addObject("video", service.selectById(id));
        mv.addObject("speaker",speakerService.selectAll());
        mv.addObject("videoId",id);
        return mv;
    }

    @RequestMapping("updateVideo")
    public String update(Video video){
        service.update(video);
        return "redirect:selectVideoPage?page=0";
    }

    @RequestMapping("addVideoData")
    public ModelAndView addData(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("videoAdd");
        mv.addObject("course",courseService.selectAll());
        mv.addObject("speaker",speakerService.selectAll());
        return mv;
    }

    @RequestMapping("addVideo")
    public String addVideo(Video video,HttpServletRequest request){
        service.add(video);
        System.out.println("video======"+video.toString());
        System.out.println("speakId===="+request.getParameter("speakerId"));
        return "redirect:selectVideoPage?page=0";
    }

    @RequestMapping("deleteVideo")
    @ResponseBody
    public String delete(int id){
        service.delete(id);
        return "success";
    }

    @RequestMapping("deleteVideoAll")
    public String deleteAll(String str){
        String[] strings = str.split(",");
        for (int i = 0; i < strings.length; i++) {
            service.delete(Integer.parseInt(strings[i]));
        }
        return "redirect:selectVideoPage?page=0";
    }

    @RequestMapping("selectVideos")
    public ModelAndView selectVideos(int subjectId){
        List<Video> VideoList =  service.selectVideos(subjectId);
        List<Course> courseList = courseService.selectBySubjectId(subjectId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courseShow");
        mv.addObject("VideoList",VideoList);
        mv.addObject("courseList",courseList);
        return mv;
    }

    @RequestMapping("videoPlay")
    public ModelAndView videoPlay(int videoId,int speakerId,int courseId){
        ModelAndView mv = new ModelAndView();
        Speaker speaker = speakerService.selectById(speakerId);
        Video video = service.selectById(videoId);
        Course course = courseService.selectById(courseId);
        List<Video> list = service.selectByCourseId(courseId);
        System.out.println(list.toString());
        mv.setViewName("videoPlay");
        mv.addObject("speaker",speaker);
        mv.addObject("course",course);
        mv.addObject("video",video);
        mv.addObject("list",list);
        return mv;
    }
}
