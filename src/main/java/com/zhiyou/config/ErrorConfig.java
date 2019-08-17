package com.zhiyou.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zhiyou.interceptors.ErrorPageInterceptor;

@Configuration
public class ErrorConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	ErrorPageInterceptor errorPageInterceptor;
	
 @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(errorPageInterceptor);//.addPathPatterns("/action/**", "/mine/**");默认所有
        super.addInterceptors(registry);
    }
}
