package com.zhiyou.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.util.MD5Util;
import com.zhiyou.util.MainUtil2;

@Controller
public class GetPassController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("forgetPassword.do")
    public String index() {
    	return "getPassword";
    }
	
	@RequestMapping("userRePass.do")
	protected void user_accounts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1.检测是否存在
		String accounts = req.getParameter("accountsCheck");
		User user = userService.selectByEmail(accounts);
		//2.通知页面到底有没有
		if(accounts=="") {
			resp.getWriter().write("2");
		}else{

		if(user!=null){
			resp.getWriter().write("1");
		}else{
			resp.getWriter().write("0");
		}
	}
	}
	
	@RequestMapping("/VC.do")
	public void VC(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb=new StringBuilder(4);
		for(int i=0;i<4;i++)
		{
		     char ch=str.charAt(new Random().nextInt(str.length()));
		     sb.append(ch);
		}
		String c = ""+sb;
		req.getSession().setAttribute("c",c);
		String email = req.getParameter("name");
		MainUtil2.setMain(email, c);
	}
	
	@RequestMapping("/checkVC.do")
	public void checkVC(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("name");
		String c = (String) req.getSession().getAttribute("c");
		if(!(email.equals(c))) {
			resp.getWriter().write("1");
		}else {
			resp.getWriter().write("0");
		}		
	}
	
	@RequestMapping("/NupdatePassword.do")
	public String NupdatePassword(String email,String password,HttpServletRequest req, HttpServletResponse resp){
		
		User user = userService.selectByEmail(email);
		String md5Pass= MD5Util.md5(password);
		user.setPassword(md5Pass);
		userService.update(user);
		req.getSession().setAttribute("inf", "密码已重置，请登录");
		return "index";	
	}

}
