package com.zhiyou;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 除了包括java4大注解以外，还包括以下：
 * @SpringBootConfiguration:修饰在类上，可以代替xml配置，用来表示这个类是一个xml配置类，一般与@bean结合使用
 * @bean:用来修饰方法，该方法的返回值将会被注册到spring容器中
 * @EnableAutoConfigruation:自动配置spring上下文,可猜测和配置我们想要的bean类型
 * @ComponentScan:会自动扫描指定包下的component,Controller 等注解，并自动注入到ioc容器中，
 * 					如果不指定路径，默认扫描自己所在包路径及所有子包
 * 
 * 
 */
//用来标识启动类
//@ComponentScan("com.zhiyou")
@MapperScan("com.zhiyou.mapper")//自动扫描该路径下所有接口
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
