package com.zhiyou.controller;

import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;
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
public class SpeakerController {
    @Autowired
    SpeakerService service;

    @RequestMapping("selectSpeakerPage")
    @ResponseBody
    public ModelAndView selectSpeakerPage(@RequestParam(value = "page",defaultValue = "0") int page){
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
        mv.setViewName("jsp/Speaker.jsp");

        return mv;

    }
    @RequestMapping("updateSpeakerData")
    public ModelAndView updateSpeakerData(int id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jsp/speakerUpdate.jsp");
        mv.addObject("speaker", service.selectById(id));
        System.out.println(service.selectById(id).toString());
        return mv;
    }

    @RequestMapping("updateSpeaker")
    public String updateSpeaker(Speaker speaker){
        System.out.println(speaker.toString());
        service.update(speaker);
        return "forward:selectSpeakerPage.do";
    }


    @RequestMapping("addSpeaker")
    public String addSpeaker(Speaker speaker,HttpServletRequest request){
        service.add(speaker);
        return "forward:selectSpeakerPage.do";
    }

    @RequestMapping("deleteSpeaker")
    @ResponseBody
    public String deleteSpeaker(int id){
        service.delete(id);
        return "success";
    }

    @RequestMapping("deleteAllSpeaker")
    public String deleteAllSpeaker(String str){
        String[] strings = str.split(",");
        for (int i = 0; i < strings.length; i++) {
            service.delete(Integer.parseInt(strings[i]));
        }
        return "forward:selectSpeakerPage.do";
    }

}
