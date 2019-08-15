package com.zhiyou.controller;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.util.MD5Util;
import com.zhiyou.util.UploadUtils;
import com.zhiyou.util.VideoResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
        System.out.println(service.selectByAccount(u.getAccounts()).getImgurl());
        return "redirect:personalCenterSkip";
    }

    @RequestMapping("select")
    @ResponseBody
    public String select(User user,HttpServletRequest request,HttpServletResponse response){
        return "1";
    }
    //==========================页面跳转===========================
    //个人中心的跳转
    @RequestMapping("personalCenterSkip")
    public String personalCenterSkip(){
        return "personalCenter";
    }
    
    //修改资料的跳转
    @RequestMapping("userUpdateSkip")
    public String userUpdateSkip(){
    	return "userUpdate";
    }
    
    //修改密码的跳转
    @RequestMapping("passwordUpdateSkip")
    public String passwordUpdateSkip(){
    	return "passwordUpdate";
    }
    
    //修改头像的跳转
    @RequestMapping("headLogoSkip")
    public String headLogoSkip(){
    	return "headLogo";
    }
    
    //===========================================================
    
    @RequestMapping("updatePassword")
    @ResponseBody
    public String updatePassword(int id, @RequestParam("oldPassword") String oldPassword,
    		@RequestParam("password") String password) throws ServletException, IOException{
    	String status ;
    	if (!MD5Util.md5(oldPassword).equals(service.selectById(id).getPassword())) {
    		status = "500";
			return status;
		}else{
			service.updatePassword(id,MD5Util.md5(password));
			status = "200";
			System.out.println(200);
			return status;
		}
    }

    @RequestMapping("updateHeadLogo")
    public String updateHeadLogo(MultipartFile uploadFile,int id,HttpServletRequest request) throws IOException {
    	InputStream inputStream = null;
		inputStream = uploadFile.getInputStream();
		String name = UploadUtils.getImgName()+uploadFile.getOriginalFilename();
		UploadUtils.uploadImgs(inputStream, name);
		service.updateHeadLogo(id, "http://192.168.221.128/"+name);
		request.getSession().setAttribute("user", service.selectById(id));
    	return "redirect:personalCenterSkip";
    }


}
