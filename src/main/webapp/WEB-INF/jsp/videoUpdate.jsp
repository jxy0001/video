<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0047)http://localhost:8080/Voids/Course/addCourse -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!--<base href="http://localhost:8080/Voids/">--><base href=".">


    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>智游教育</title>

    <link href="http://localhost:8080/video/static/bootstrap.css" rel="stylesheet">

    <style type="text/css">
        .col-md-1 {
            padding-top: 20px;
        }

        .a1 {
            color: gray;
        }

        b {
            float: right;
        }
    </style>



</head>

<body>






<nav class="navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand">视频管理系统</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li class="active"><a href="http://localhost:8080/video/selectVideoPage?page=0">视频管理</a></li>
                <li><a href="http://localhost:8080/video/selectSpeakerPage?page=0">主讲人管理</a></li>
                <li><a href="http://localhost:8080/video/selectByPage?page=0">课程管理</a></li>
            </ul>
            <p class="navbar-text navbar-right">
                <span>${admin.accounts}</span> <i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a class="navbar-link">退出</a>
            </p>
        </div>

    </div>

</nav>



<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
    <div class="container">


        <h2>添加视频信息</h2>


    </div>
</div>



<div class="container" style="margin-top: 20px;">

    <form id="infoForm" class="form-horizontal"  method="post" action="http://localhost:8080/video/updateVideo">

        <input value="${videoId}" name="videoId" type="hidden">

        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">视频标题</label>
            <div class="col-sm-10">
                <input class="form-control" name="title" id="title" value="${video.title}" type="text">
            </div>
        </div>

        <div class="form-group">
            <label for="subjectId" class="col-sm-2 control-label">主讲人</label>
            <div class="col-sm-10">
            <select name="speakerId" id="speakerId" class="form-control">
                <option value="0" selected="selected">请选择讲师</option>
                <c:forEach items="${speaker}" var="sp">
                    <c:if test="${video.speakerId==sp.id}">
                        <option value="${sp.id}" selected="selected">${sp.speakerName}</option>
                    </c:if>
                    <c:if test="${video.speakerId!=sp.id}">
                        <option value="${sp.id}">${sp.speakerName}</option>
                    </c:if>
                </c:forEach>
            </select>
            </div>
        </div>
        <div class="form-group">
            <label for="subjectId" class="col-sm-2 control-label">所属课程</label>
            <div class="col-sm-10">
                <select name="subjectId" id="subjectId" class="form-control">
                    <option value="0" selected="selected">请选择所属学科</option>

                    <c:forEach items="${course}" var="course">
                        <c:if test="${video.courseId==course.id}">
                            <option value="${course.id}" selected="selected">${course.courseTitle}</option>
                        </c:if>
                        <c:if test="${video.courseId!=course.id}">
                            <option value="${course.id}">${course.courseTitle}</option>
                        </c:if>

                    </c:forEach>

                </select>
            </div>
        </div>


        <div class="form-group">
            <label for="time" class="col-sm-2 control-label">视频时长</label>
            <div class="col-sm-10">
                <input class="form-control" name="time" id="time" value="${video.time}" type="text">
            </div>
        </div>


        <div class="form-group">
            <label for="imageUrl" class="col-sm-2 control-label">封面图片地址</label>
            <div class="col-sm-10">
                <input class="form-control" name="imageUrl" id="imageUrl" value="${video.imageUrl}" type="text">
            </div>
        </div>
        <div class="form-group">
            <label for="videoUrl" class="col-sm-2 control-label">视频播放地址</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="videoUrl" name="videoUrl" rows="3">${video.videoUrl}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="detail" class="col-sm-2 control-label">备注</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="detail" name="detail" rows="3">${video.detail}</textarea>
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">保存</button>
            </div>
        </div>
    </form>
</div>
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="http://localhost:8080/video/static/jquery-1.js"></script>
<script src="http://localhost:8080/video/static/bootstrap.js"></script>
<script src="http://localhost:8080/video/static/confirm.js"></script>
<script src="http://localhost:8080/video/static/jquery.js"></script>
<script src="http://localhost:8080/video/static/message_cn.js"></script>






<div id="modal-background2" class=""></div><div id="confirm-modal" class="modal fade role=" dialog"="" tabindex="-1"><div class="modal-dialog modal-undefined"><div class="modal-content"><div class="modal-header"><button id="modal-upper-close" class="close modal-close" aria-label="Close" type="button"><span aria-hidden="true">×</span></button><h4 id="modal-title" class="modal-title">Modal Title</h4></div><div id="modal-body" class="modal-body"> Modal Message </div><div id="modal-footer" class="modal-footer"></div></div></div></div><div id="modal-background" class=""></div></body></html>