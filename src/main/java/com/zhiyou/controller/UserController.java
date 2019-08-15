package com.zhiyou.controller;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author
 * @date 2019/6/17
 */
@Controller
public class UserController {

    @Autowired
    UserService service;

/*    @RequestMapping("login")
    @ResponseBody
    public String login(User u,HttpServletRequest request){
        String accounts = u.getAccounts();
        String password = u.getPassword();
        System.out.println(accounts+"========="+password);
        User user = service.selectByAccount(accounts);
        if (user == null) {
            return "1";
        }else{
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user",user);
                return "2";
            }else {
                return "1";
            }
        }
    }*/

  /*  @RequestMapping("exit")
    public String exit(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:jsp/main.jsp";
    }*/

 /*   @RequestMapping("register")
    @ResponseBody
    public String register(User user,HttpServletRequest request,HttpServletResponse response){
        service.add(user);
        return "1";
    }*/


    @RequestMapping("updateUser")
    public String update(User u,HttpServletRequest request){

        String prov = request.getParameter("prov");
        String city =  request.getParameter("city");
        String address = prov+city;
        u.setAddress(address);
        service.update(u);
        request.getSession().setAttribute("user",service.selectByAccount(u.getAccounts()));
        return "jsp/personalCenter.jsp";
    }

    @RequestMapping("select")
    @ResponseBody
    public String select(User user,HttpServletRequest request,HttpServletResponse response){
        return "1";
    }
    
    //个人中心的跳转
    @RequestMapping("personalCenterSkip")
    public String personalCenterSkip(String e){
        return "personalCenter";
    }
    
    //个人中心的跳转
    @RequestMapping("userUpdateSkip")
    public String userUpdateSkip(String e){
    	return "userUpdate";
    }

    @RequestMapping("updatePassword")
    public String updatePassword(int id, @RequestParam("password") String password,HttpServletRequest request){
        service.updatePassword(id,password);
        request.getSession().setAttribute("user",service.selectById(id));
        return "redirect:exit.do";
    }

    @RequestMapping("updateHeadLogo")
    public String updateHeadLogo(MultipartFile headImg,int id,HttpServletRequest request) throws IOException {
        String lastName ="/upload/"+System.currentTimeMillis()+headImg.getOriginalFilename();
        String wholeName = "E:/imgs"+ lastName;
        headImg.transferTo(new File(wholeName));
        service.updateHeadLogo(id,lastName);
        request.getSession().setAttribute("user",service.selectById(id));
        return "jsp/personalCenter.jsp";
    }


}
