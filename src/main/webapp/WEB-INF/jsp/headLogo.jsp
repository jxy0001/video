<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0041)http://localhost:8080/Voids/user/chart.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- base href="http://localhost:8080/video/" -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">


    <!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <script type="text/javascript" src="http://localhost:8080/videoPlayer/static/jquery-3.2.1.min.js"></script>
    <script src="http://localhost:8080/videoPlayer/static/bootstrap.js"></script>
    <link rel="stylesheet" href="http://localhost:8080/videoPlayer/static/base.css">
    <link rel="stylesheet" href="http://localhost:8080/videoPlayer/static/bootstrap.css">
    <link rel="stylesheet" href="http://localhost:8080/videoPlayer/static/profile.css">
    <link rel="stylesheet" href="http://localhost:8080/videoPlayer/static/jquery.css">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>

<body class="w100">


<header>
    <div class="container top_bar clearfix">
        <img src="http://localhost:8080/videoPlayer/static/z/logo.png" alt="智游">
        <div id="tele">
            <span>4006-371-555</span>
            <span>0371-88888598</span>
        </div>
    </div>
    <menu>
        <div class="container clearfix">
            <ul class="clearfix f_left">
                <li><a href="http://localhost:8080/videoPlayer/jsp/main.jsp">首页</a></li>

                <li class="menu_active"><a href="http://localhost:8080/videoPlayer/jsp/personalCenter.jsp">个人中心</a></li>
            </ul>

            <div id="user_bar">
                <a>

                    <img id="avatar" src="${user.imgurl}" alt="">




                </a>
                <a href="http://localhost:8080/videoPlayer/exit.do">退出</a>
            </div>
        </div>
    </menu>
</header>

<main>
    <div class="container">
        <h2>我的资料</h2>
        <div id="profile_tab">
            <ul class="profile_tab_header f_left clearfix">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a href="http://localhost:8080/videoPlayer/jsp/userUpdate.jsp">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="http://localhost:8080/videoPlayer/jsp/headLogo.jsp">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="http://localhost:8080/videoPlayer/jsp/passwordUpdate.jsp">密码安全</a></li>
                </ul>
            </ul>
            <div class="proflle_tab_body">
                <div class="proflle_tab_workplace clearfix">
                    <div class="profile_avatar_area">

                        <img src="${user.imgurl}">





                        <p style="text-align: center;">当前头像</p>
                    </div>
                    <div class="profile_ifo_area">
                        <form id="upload_form" action="http://localhost:8080/videoPlayer/updateHeadLogo.do" enctype="multipart/form-data" method="post">
                            <!-- hidden crop params -->
                            <input name="id" type="hidden" value="${user.id}">


                            <p>第一步：请选择图像文件</p>
                            <div><input class="btn btn-default btn-lg" name="headImg" id="image_file" onchange="fileSelectHandler()" type="file"></div>

                            <div class="error"></div>

                            <div class="step2">
                                <p>第二步：请确定,然后按上传</p>


                                <input value=" 上 传 " type="submit" class="btn btn-default btn-lg">
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
            <li><img src="http://localhost:8080/videoPlayer/static/z/footer_logo.png" alt="" id="foot_logo"></li>
            <li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
            <li><img src="http://localhost:8080/videoPlayer/static/z/a.png" alt="" id="wxgzh"></li>
        </ul>
    </div>
</footer>


<script src="http://localhost:8080/videoPlayer/static/jquery-1.js"></script>
<script src="http://localhost:8080/videoPlayer/static/gVerify.js"></script>
<script src="http://localhost:8080/videoPlayer/static/index.js"></script>

<script src="http://localhost:8080/videoPlayer/static/jquery.js"></script>
<script src="http://localhost:8080/videoPlayer/static/Jcrop_upload.js"></script>
</body></html>