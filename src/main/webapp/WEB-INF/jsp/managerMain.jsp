<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0052)http://localhost:8080/Voids/controller/courseShow.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>智游教育</title>

    <link href="http://localhost:8080/video/static/bootstrap.css" rel="stylesheet">

    <script src="http://localhost:8080/video/static/jquery-1.js"></script>
    <script src="http://localhost:8080/video/static/bootstrap.js"></script>
    <script src="http://localhost:8080/video/static/confirm.js"></script>
    <script src="http://localhost:8080/video/static/jquery.js"></script>
    <script src="http://localhost:8080/video/static/message_cn.js"></script>

    <style type="text/css">
        th {
            text-align: center;
        }
    </style>
</head>

<body>
<nav class="navbar-inverse">
    <div class="container">

        <div class="navbar-header">
            <a class="navbar-brand">视频管理系统</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li><a href="http://localhost:8080/video/selectVideoPage?page=0">视频管理</a></li>
                <li><a href="http://localhost:8080/video/selectSpeakerPage?page=0">主讲人管理</a></li>
                <li class="active"><a href="http://localhost:8080/video/selectByPage?page=0">课程管理</a></li>
                <c:if test="${admin.adminRemark=='2' }">
                	<li><a href="http://localhost:8080/video/adminSkip">管理员管理</a></li>
                </c:if> 
            </ul>
            <p class="navbar-text navbar-right">
                <span>${email}</span> <i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a href="http://localhost:8080/video/exit.do" class="navbar-link">退出</a>
            </p>
        </div>
        <!-- /.navbar-collapse -->


    </div>
    <!-- /.container-fluid -->
</nav>





<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
    <div class="container">
        <h2>课程管理</h2>
    </div>
</div>

<form action="">
    <div class="container">
        <a href="http://localhost:8080/video/addData" type="button" class="btn btn-info">
            添加
        </a>

        <button onclick="deleteAll()" type="button" id="btn" class="btn btn-info dropdown-toggle">
            批量删除
        </button>
    </div>

    <div class="container" style="margin-top: 20px;">

        <table class="table table-bordered table-hover" style="text-align: center;table-layout:fixed;">
            <thead>
            <tr class="active">
                <th><input type="checkbox" id="all"></th>
                <th>序号</th>
                <th style="width:16%">标题</th>
                <th style="width:60%">简介</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="list">

                <tr>
                    <td><input type="checkbox" value="${list.id}" name="check"></td>
                    <td>${list.id}</td>
                    <td>${list.courseTitle}</td>
                    <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${list.courseDesc}</td>
                    <td><a href="http://localhost:8080/video/updateData?id=${list.id}">✎</a></td>
                    <td><a onclick="delCourseById(${list.id})" >X</a></td>
                </tr>
            </c:forEach>
            <tr><td colspan="6">
                <c:if test="${empty page || page==0}">
                    <a type="button" class="btn btn-default btn-lg" disabled="disabled">已是首页</a>
                </c:if>
                <c:if test="${page>0}">
                    <a type="button" class="btn btn-default btn-lg" href="http://localhost:8080/video/selectByPage?page=${page-1}">上一页</a>
                </c:if>


                <B>总共${maxPage}页,当前第${page+1}页</B>

                <c:if test="${page==maxPage-1}">
                    <a type="button" class="btn btn-default btn-lg" disabled="disabled">已是尾页</a>
                </c:if>
                <c:if test="${page<maxPage-1}">
                    <a type="button" class="btn btn-default btn-lg" href="http://localhost:8080/video/selectByPage?page=${page+1}">下一页</a>
                </c:if>

            </td></tr>
            </tbody>
        </table>

    </div>
</form>




<script type="text/javascript">

    function deleteAll(){
        var str="";
        $("input[name='check']:checkbox").each(function(){
            if($(this).prop("checked")==true){
                str=str+$(this).val()+",";
            }
        });
        if (str==""){
            Confirm.show("温馨提示：","您未选择数据！");
            return;
        }
        window.location.href= "http://localhost:8080/video/deleteAll?str="+str;
    }


    function delCourseById(id){

        Confirm.show('温馨提示：', '确定要删除么？', {
            'Delete': {
                'primary': true,
                'callback': function() {
                    var param={"id":id};
                    $.post("http://localhost:8080/video/deleteCourse",param,function(data){
                        if(data=='success'){
                            Confirm.show('温馨提示：', '删除成功');
                            location.reload(false);
                        }else{
                            Confirm.show('温馨提示：', '操作失败');
                        }
                    });
                }
            }
        });
    }
</script>


<div id="modal-background" class="">

</div>
<div id="confirm-modal" class="modal fade role="dialog="" tabindex="-1">
    <div class="modal-dialog modal-undefined">
        <div class="modal-content">
            <div class="modal-header">
                <button id="modal-upper-close" class="close modal-close" aria-label="Close" type="button">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 id="modal-title" class="modal-title">Modal Title</h4>
            </div><div id="modal-body" class="modal-body"> Modal Message </div>
            <div id="modal-footer" class="modal-footer">

            </div>
        </div>
    </div>
</div>
<div id="modal-background2" class=""></div></body></html>

