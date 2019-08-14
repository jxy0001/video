package com.zhiyou.config;

import java.util.Properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootConfiguration
public class MybatisConfig {

	/*
	 * 配置类
	 */
	@Bean
	public PageHelper pageHelper(){
		PageHelper p = new PageHelper();
		//创建一个属性文件对象，把实例化pageHelper需要的参数传进去
		Properties per = new Properties();
		//设置页码
		per.setProperty("offsetAspageNum", "true");
		//分页时进行count查询，查询总数
		per.setProperty("rowBoundsWithCount", "true");
		//分页参数合理化
		per.setProperty("reasonable", "true");
		p.setProperties(per);
		return p;
		
	}
}

