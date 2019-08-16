<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href=".">
<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, user-scalable=no">

<meta name="renderer" content="webkit">

<link rel="stylesheet" href="static/z/base.css">
<link rel="stylesheet" href="static/z/css.css">
<title>找回密码</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>

<body>
	<div id="reg">
		<div class="mask_content">
			<div class="mask_content_header">
				<img src="static/z/logo.png" alt="" class="ma">
			</div>
			<div class="mask_content_body">
				<form id="loginF" method="post"
					action="http://localhost:8080/video/NupdatePassword.do">
					<h3>找回密码</h3>
					<input placeholder="请输入邮箱" id="accounts" name="email" type="email"
						onblur="user_accounts_reg()"> <span id="emailMsg"></span>
					<button id="btnn" onclick="n()" type="button">
						获取验证码 <span id="time">60</span>
					</button>
					<input id="in" type="text" placeholder="请输入验证码" name="num" onblur="m()"> <i id="it"></i> 
					<input placeholder="请输入新密码" id="p1" name="password" type="password" onblur="checkPass()"> 
						<input
						placeholder="请确认新密码" id="p2" name="psw_again" type="password"
						onblur="checkPass()"> <i id="ii"></i> <input
						placeholder="提交修改" type="submit" id="submitReg">
				</form>
			</div>
		</div>
	</div>

	<script src="static/z/jquery-1.js"></script>
	<script src="static/z/gVerify.js"></script>
	<script src="static/z/index.js"></script>
	<script type="text/javascript" src="static/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		function user_accounts_reg() {
			$.ajax({
				type : "post",
				url : "http://localhost:8080/video/userRePass.do",
				data : {
					accountsCheck : $("#accounts").val()
				},
				success : function(data) {
					if (data == 1) {
						//如果已经注册，禁止提交
						$("#submitReg").attr("disabled", true);
						$("#emailMsg").text("该邮箱存在").css("color", "green");
					} else if (data == 2) {
						$("#submitReg").attr("disabled", false);
						$("#emailMsg").text("邮箱不能为空").css("color", "red");
					} else {
						$("#submitReg").attr("disabled", false);
						$("#emailMsg").text("该邮箱不存在").css("color", "red");
					}
				}
			})
		}
		//倒计时
		function n() {
			$.ajax({
				type : "post",
				url : "http://localhost:8080/video/VC.do",
				data : {
					name : $("#accounts").val()
				},

			})

			var setTime;
			$(document)
					.ready(
							function() {
								var time = parseInt($("#time").text());
								setTime = setInterval(
										function() {
											if (time <= 0) {
												document.getElementById("time").style.display = "none";
												$("#btnn").attr("disabled",
														false);
												$
														.post({
															url : "http://localhost:8080/video/removeSession.do",

														})
												return;
											} else {
												$("#btnn").attr("disabled",
														true);
											}
											time--;
											$("#time").text(time);
										}, 1000);
							});

		}

		function m() {
			$.ajax({
				type : "post",
				url : "http://localhost:8080/video/checkVC.do",
				data : {
					name : $("#in").val()
				},
				success : function(data) {
					if (data == 1) {
						$("#it").text("验证失败");
						$("#submitReg").attr("disabled", true);
					} else {
						$("#it").text("验证成功");
						$("#submitReg").attr("disabled", false);
					}

				},

			})
		}

		function checkPass() {
			var p1 = $("#p1").val();
			var p2 = $("#p2").val();
			if(p1==""|p2==""){
				$("#ii").text("密码不能为空");
			}else{
			if (p1 == p2) {
				$("#ii").text("两次密码一致");
			} else {
				$("#ii").text("两次密码不一致");
			}
		}
		}
	</script>
</body>
</html>