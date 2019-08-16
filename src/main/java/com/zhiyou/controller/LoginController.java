package com.zhiyou.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Admin;
import com.zhiyou.model.User;
import com.zhiyou.service.AdminService;
import com.zhiyou.service.UserService;
import com.zhiyou.util.MD5Util;
import com.zhiyou.util.MainUtil2;


@Controller
public class LoginController {
	
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	
	@RequestMapping("index")
    public String index() {
    	return "index";
    }
	//admin登录
	@RequestMapping("checkEmail.do")
	public void checkEmail(HttpSession session,HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String accounts = req.getParameter("name");
		Admin admin = adminService.selectAdmin(accounts);
		if(admin==null) {
			resp.getWriter().write("1");
		}else {
			resp.getWriter().write("0");
		}
		
	}
	
	@RequestMapping("checkPassword")
	public String checkPassword(HttpSession session,HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String md5Pass = MD5Util.md5(password);
		Admin admin = adminService.selectAdmin(email);
		if((admin.getPassword()).equals(md5Pass)) {
			session.setAttribute("email", email);
			return "forward:selectByPage";
		}else {
			req.setAttribute("msg","密码错误");
			return "index";
		}
		
	}
	
	//user登录
	@RequestMapping("checkE.do")
	public void checkE(HttpSession session,HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String accounts = req.getParameter("name");
		User user = userService.selectByEmail(accounts);
		if(user==null) {
			resp.getWriter().write("1");
		}else {
			resp.getWriter().write("0");
		}
		
	}
	
	@RequestMapping("checkP.do")
	@Cacheable("userLogin")
	public String checkP(HttpSession session,HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String md5Pass = MD5Util.md5(password);
		User user = userService.selectByEmail(email);
		if((user.getPassword()).equals(md5Pass)) {
			session.setAttribute("e", email);
			session.setAttribute("user", user);
			return "index";
		}else {
			req.setAttribute("msg","密码错误");
			return "index";
		}
		
	}
	
	@RequestMapping("/num.do")
	public void num(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb=new StringBuilder(4);
		for(int i=0;i<4;i++)
		{
		     char ch=str.charAt(new Random().nextInt(str.length()));
		     sb.append(ch);
		}
		String b = ""+sb;
		req.getSession().setAttribute("b",b);
		String email = req.getParameter("name");
		MainUtil2.setMain(email, b);
	}
	
	@RequestMapping("/verification.do")
	public void verification(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("name");
		String b = (String) req.getSession().getAttribute("b");
		if(!(email.equals(b))) {
			resp.getWriter().write("1");
		}else {
			resp.getWriter().write("0");
		}
		
	}
	
	@RequestMapping("removeSession.do")
	public void removeSession(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		req.getSession().invalidate();
	}
	
	@RequestMapping("exit.do")
	public void exit(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		req.getSession().invalidate();
		resp.sendRedirect("index");
	}


}
