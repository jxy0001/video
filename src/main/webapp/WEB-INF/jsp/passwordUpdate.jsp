<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/Voids/user/password.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- base href="http://localhost:8080/video/" -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">


    <!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <script type="text/javascript" src="http://localhost:8080/video/static/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="http://localhost:8080/video/static/base.css">
    <link rel="stylesheet" href="http://localhost:8080/video/static/profile.css">
    <link rel="icon" href="http://localhost:8080/Voids/static/z/favicon.png" type="image/png">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">




<header>
    <div class="container top_bar clearfix">
        <img src="http://localhost:8080/video/static/z/logo.png" alt="智游">
        <div id="tele">
            <span>4006-371-555</span>
            <span>0371-88888598</span>
        </div>
    </div>
    <menu>
        <div class="container clearfix">
            <ul class="clearfix f_left">
                <li><a href="index">首页</a></li>

                <li class="menu_active"><a href="personalCenterSkip">个人中心</a></li>
            </ul>

            <div id="user_bar">
                <a>

                    <img id="avatar2" src="${user.imgurl}" alt="">




                </a>
                <a href="http://localhost:8080/video/exit.do">退出</a>
            </div>
        </div>
    </menu>
</header>

<main>
    <div class="container">
        <h2>我的资料</h2>
        <div id="profile_tab">
            <ul class="profile_tab_header f_left clearfix">
                <li><a href="userUpdateSkip">更改资料</a></li>
                <li class="profile_tab_line">|</li>
                <li><a href="headLogoSkip">更改头像</a></li>
                <li class="profile_tab_line">|</li>
                <li><a href="passwordUpdateSkip">密码安全</a></li>
            </ul>
            <div class="proflle_tab_body">
                <div class="proflle_tab_workplace clearfix">
                    <div class="profile_avatar_area">


                        <img id="avatar" width="200px;" src="${user.imgurl}" alt="">




                    </div>
                    <div class="profile_ifo_area">
                        <form action="" method="post" id="pwdForm">

                            <input name="id" value="${user.id}" type="hidden">
                            <div class="form_group">
                                <span class="dd">旧　密　码：</span>
                                <input name="oldPassword" type="password" id="old" required="true"><span id="oldMsg"></span>
                            </div>
                            <div class="form_group">
                                <span class="dd">新　密　码：</span>
                                <input id="newPwd1" type="password" required="true">
                            </div>
                            <div class="form_group">
                                <span class="dd">确认新密码：</span>
                                <input name="password" type="password" id="newPwd2" required="true"><span id="passMsg"></span>
                            </div>
                            <div class="form_submit dd">
                                <input id="postBtn" value="保　存" type="button">
                                <a href="personalCenterSkip">取消</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>



<footer>
    <div class="container">
        <ul>
            <li><img src="http://localhost:8080/video/static/z/footer_logo.png" alt="" id="foot_logo"></li>
            <li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
            <li><img src="http://localhost:8080/video/static/z/a.png" alt="" id="wxgzh"></li>
        </ul>
    </div>
</footer>

<script type="text/javascript">
    	$("#postBtn").click(function(){
    		if ($("#newPwd1").val()!=$("#newPwd2").val()) {
				$("#passMsg").text("两次密码输入不一致！");
				return;
			}else{
		       $.ajax({
		    	   type:"post",
		       	   url:"http://localhost:8080/video/updatePassword",
		       	   data:$("#pwdForm").serialize(),
		       	   
		       	   datatype:"text",
		       	   success:function(data){
			    	   if(data=="500"){
			    		  $("#oldMsg").text("原密码不正确！");
			    		  return;
			    	   }else{
			    		   alert("修改成功！请重新登录！");
			    		   location.href="exit.do";
			    	   }
		       	   }
		       });
			}
    	
    	})


</script>


</body></html>
