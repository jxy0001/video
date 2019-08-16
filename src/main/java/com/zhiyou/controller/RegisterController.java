package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.util.MD5Util;

@Controller
public class RegisterController {
	
	@Autowired
	UserService us;
	
	//注册验证
		@RequestMapping("user_accounts_reg.do")
		protected void user_accounts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			//1.检测是否存在
			String accounts = req.getParameter("accountsCheck");
			User user = us.selectByEmail(accounts);
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
		@RequestMapping("insertUser.do")
		public String insertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			req.setCharacterEncoding("utf-8");
			
			String accounts = req.getParameter("accounts");
			String password = req.getParameter("password");
			System.out.println(accounts+password);
			String md5 = MD5Util.md5(password);
			User user = new User();
			user.setAccounts(accounts);
			user.setPassword(md5);
			us.add(user);
			return "index";
		}


}
