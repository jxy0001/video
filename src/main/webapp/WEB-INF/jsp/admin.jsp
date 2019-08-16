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
                <li><a href="http://localhost:8080/video/selectByPage?page=0">课程管理</a></li>
                <c:if test="${admin.adminRemark=='2' }">
                	<li class="active"><a href="http://localhost:8080/video/adminSkip">管理员管理</a></li>
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
        <h2>管理员管理  </h2>
    </div>
</div>

<form action="">
    <div class="container">
        <a href="http://localhost:8080/video/addAdminSkip" type="button" class="btn btn-info">
            添加
        </a>
    </div>

    <div class="container" style="margin-top: 20px;">
        <table class="table table-bordered table-hover" style="text-align: center;table-layout:fixed;">
            <thead>
	            <tr class="active">
	                <th>编号</th>
	                <th style="width:40%">账号</th>
	                <th>状态</th>
	                <th>编辑</th>
	                <th>操作</th>
	            </tr>
            </thead>
            <tbody>
         
            <c:forEach items="${list}" var="list">
				<c:if test="${list.adminRemark=='1' }">
	                <tr>
	                    <td>${list.adminId}</td>
	                    <td style="overflow:hidden;white-space:nowrap;">${list.accounts}</td>
	                    <c:if test="${list.status=='1' }">
	                    	<td style="color: green">正常</td>
	                    	<td><a href="http://localhost:8080/video/banAdmin?id=${list.adminId}">禁用</a></td>
	                    	<td><a class="btn btn-xs" disabled="disabled" type="button" style="color: #ccc">删除</a></td>
	                    </c:if>
	                     <c:if test="${list.status=='2' }">
	                     	<td style="color: red">禁用</td>
	                    	<td><a href="http://localhost:8080/video/recoverAdmin?id=${list.adminId}">恢复</a></td>
	                    	<td><a class="btn btn-warning btn-xs" type="button" onclick="delAdminById(${list.adminId})" >删除</a></td>
	                    </c:if>
	                </tr>
				</c:if>
            </c:forEach>
            
            </tbody>
        </table>

    </div>
</form>




<script type="text/javascript">
	function  reload(){
		location.reload(true);
	}

    function delAdminById(id){
        Confirm.show('温馨提示：', '确定删除么？', {
            'Delete': {
                'primary': true,
                'callback': function() {
                    var param={"id":id};
                    $.ajax({ 
                    	url:"http://localhost:8080/video/deleteAdmin",
                    	data:param,
                    	success:function(data){
                    		Confirm.show('温馨提示：', data.data);
                    	}
                    })
                }
            }
        })
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

