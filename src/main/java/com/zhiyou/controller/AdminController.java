package com.zhiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;
import com.zhiyou.util.MD5Util;
import com.zhiyou.util.VideoResult;

@Controller
public class AdminController {

	
	@Autowired
	private AdminService service;
	
	//=========================页面跳转==========================
	@RequestMapping("addAdminSkip")
	public String addAdminSkip(){
		return "adminAdd";
	}
	
	@RequestMapping("adminSkip")
	public ModelAndView AdminSkip(){
		ModelAndView mv = new ModelAndView();
		List<Admin> list = service.selectAllAdmin();
		mv.addObject("list", list);
		mv.setViewName("admin");
		return mv;
	}
	
	//=========================================================
	
	
	@RequestMapping("addAdmin")
	public String addAdmin(Admin admin){
		admin.setPassword(MD5Util.md5(admin.getPassword()));
		service.addAdmin(admin);
		return "redirect:adminSkip";
	}
	
	@RequestMapping("banAdmin")
	public String banAdmin(int id){
		service.banAdmin(id);
		return "redirect:adminSkip";
	}
	
	@RequestMapping("recoverAdmin")
	public String recoverAdmin(int id){
		service.recoverAdmin(id);
		return "redirect:adminSkip";
	}
	
	@RequestMapping("deleteAdmin")
	@ResponseBody
	public VideoResult deleteAdmin(int id){
		VideoResult result = service.delAdminById(id);
		return result;
	}
	
	
	
	
	
	
}
