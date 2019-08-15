package com.zhiyou.controller;

import com.zhiyou.model.Course;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @date 2019/6/18
 */
@Controller
public class CourseController {
    @Autowired
    CourseService service;
    @Autowired
    SubjectService subjectService;

    @RequestMapping("selectByPage")
    @ResponseBody
    public ModelAndView selectByPage(@RequestParam(value = "page",defaultValue = "0") int page){
        ModelAndView mv = new ModelAndView();
        int count = service.selectNums();
        int maxPage =0;//最大页码
        if (count%5!=0){
            maxPage = count/5+1;
        }else {
            maxPage = count/5;
        }
        mv.addObject("maxPage",maxPage);
        mv.addObject("page",page);
        mv.addObject("list",service.selectByPage(page*5));
        mv.setViewName("managerMain");

        return mv;

    }
    @RequestMapping("updateData")
    public ModelAndView updateData(int id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courseUpdate");
        mv.addObject("subject",subjectService.selectAll());
        mv.addObject("course", service.selectById(id));
        return mv;
    }

    @RequestMapping("updateCourse")
    public String update(Course course){
        service.update(course);
        return "forward:selectByPage";
    }

    @RequestMapping("addData")
    public ModelAndView addData(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courseAdd");
        mv.addObject("subject",subjectService.selectAll());
        return mv;
    }

    @RequestMapping("addCourse")
    public String addCourse(Course course,HttpServletRequest request){
        service.add(course);
        return "forward:selectByPage";
    }

    @RequestMapping("deleteCourse")
    @ResponseBody
    public String delete(int id){
        service.delete(id);
        return "success";
    }

    @RequestMapping("deleteAll")
    public String deleteAll(String str){
        String[] strings = str.split(",");
        for (int i = 0; i < strings.length; i++) {
            service.delete(Integer.parseInt(strings[i]));
        }
        return "forward:selectByPage";
    }

}
