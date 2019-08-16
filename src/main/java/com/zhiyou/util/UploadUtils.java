package com.zhiyou.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class UploadUtils {
	
	public static String getImgName(){
		//取当前毫秒数
		long millis = System.currentTimeMillis();
		Random random = new Random();
		int end = random.nextInt(999);
		String str = millis+String.format("%03d", end);
		return str;
	}
	
	
	public static void uploadImgs(InputStream inputStream,String name) throws IOException{
		//1.实例化ftpclient
		FTPClient client = new FTPClient();
		//2.连接服务器
		client.connect("192.168.221.128",21);
		//3.登陆服务器  输入账号密码
		client.login("jxy", "root");
		//4.设置文件的类型
		client.setFileType(FTP.BINARY_FILE_TYPE);
        //设置上传路径
        //client.changeWorkingDirectory("/home/jxy");
        //上传文件，第一个参数：上传至服务端的文件名，第二个参数上传文件的inputStream
        boolean storeFile = client.storeFile(name, inputStream);
	      System.out.println("==========="+storeFile);  
        //关闭连接，退出
        client.logout();
	}
	
	
}
