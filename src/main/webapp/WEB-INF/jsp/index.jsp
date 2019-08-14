<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0038)http://localhost:8080/Voids/user/go.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<base href="http://localhost:8080/Voids/">--><base href=".">
 

    <!-- base href="http://localhost:8080/video/" -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    
<link rel="stylesheet" href="static/z/base.css">
<link rel="stylesheet" href="static/z/css.css">
<link rel="icon" href="http://localhost:8080/Voids/static/z/favicon.png" type="image/png">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>

<body class="w100" style="padding-top: 0px">

<header>
	<div class="container">
		<span>欢迎来到IT培训的黄埔军校——智游教育！</span>
			<div id="userBlock" style="float:right">
				<a id="loginu_open">登录</a>
				<a id="reg_open">注册</a>
				<a id="tc" href="exit.do" style="display: none">退出</a>
				<a id="tx" href="userShow.do" style="display: none">${e}</a>
			</div>

		<a onclick="JavaScript:addFavorite2()"><img src="static/z/sc.png" draggable="false">加入收藏</a>
		<a id="logina_open"><img src="static/z/we.png" draggable="false">后台管理</a>
		<a class="color_e4"><img src="static/z/phone.png" draggable="false"> 0371-88888598　　4006-371-555</a>

	</div>
</header>



    <!--banner图-->
    <div class="banner index-banner">
	<img alt="" src="static/z/banner-2.jpg">
	</div>
	
	
    <!--模块化课程-->
    <div class="course">
        <div class="container">
            <p class="title">模块化课程，从入门到精通，大神并不遥远</p>
            <div class="course-info">
                <table cellspacing="10">
                    <tbody><tr>
                        <td colspan="2">
                            <a href="CourseList.do?subject_id=1">
                                <img src="static/z/html5.jpg" alt="" class="image scale" draggable="false">
                                <div class="headline">
                                    <span>Web前端教程</span>
                                    <img src="static/z/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                        <td>
                            <!--上线时修改id-->
                            <a href="CourseList.do?subject_id=6">
                                <img src="static/z/ui.jpg" alt="" class="image scale" draggable="false">
                                <div class="headline">
                                    <span>UI设计教程</span>
                                    <img src="static/z/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                        <td rowspan="2" class="one_three">
                            <a  class="opacity5">
                                <img src="static/z/java.jpg" alt="" class="image" draggable="false">
                                <div class="headline">
                                    <span>Java教程</span>
                                    <img src="static/z/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a  class="opacity5">
                                <img src="static/z/bigdata.jpg" alt="" class="image" draggable="false">
                                <div class="headline">
                                    <span>大数据教程</span>
                                    <img src="static/z/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                        <td colspan="2">
                            <a href="CourseList.do?subject_id=10">
                                <img src="static/z/python.jpg" alt="" class="image scale" draggable="false">
                                <div class="headline">
                                    <span>Python教程</span>
                                    <img src="static/z/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="CourseList.do?subject_id=11">
                                <img src="static/z/php.jpg" alt="" class="image scale" draggable="false">
                                <div class="headline">
                                    <span>PHP教程</span>
                                    <img src="static/z/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                        <td colspan="2" class="three_two">
                            <img src="static/z/qidai.jpg" alt="" class="image" draggable="false">
                            <div class="headline">
                                更多课程，敬请期待...
                            </div>
                        </td>
                    </tr>
                </tbody></table>
                <!--马上试听-->
                <a onclick="pyRegisterCvt()" target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=2580094677&amp;site=qq&amp;menu=yes">
                    <div class="audition">高级课程</div>
                </a>
            </div>
        </div>
    </div>


    <!--报名表单-->
    <div class="form_area">
        <div class="container">
            <p class="title"><b>这个世界上可以选择的很多，可以改变命运的选择很少<br>你现在准备好向梦想出发了吗？</b></p>
            <form id="iform" action="http://localhost:8080/090/plus/dmail.php" enctype="multipart/form-data" method="post">
                <div class="form_line1"></div>
                <div class="form_line2"></div>
                <div class="wrap">
                    <input name="action" value="post" type="hidden">
                    <input name="diyid" value="3" type="hidden">
                    <input name="do" value="2" type="hidden">
                    <input name="ip" value="" type="hidden">
                    <input name="time" value="" type="hidden">
                    <div><label for="name">姓名：</label><input name="name" id="name" class="form-control" type="text"></div>
                    <div><label for="tel">手机号：</label><input name="tel" id="tel" class="form-control" type="text"></div>
                    <div><label for="qq">QQ：</label><input name="qq" id="qq" class="form-control" type="text"></div>
                </div>
                <input class="button" value="立即报名" type="submit">
            </form>
        </div>
    </div>

    
<!--页脚-->
<footer>
	<ul>
		<li>
			<img src="static/z/footer_logo.png" alt="" draggable="false">
		</li>
		<li class="mt25">
			<h3>各校区地址</h3>
			<ul>
				<li>总部地址<br>中国-郑州经济技术开发区河南省通信产业园六层</li>
				<li>郑州校区一<br>中国-郑州经济技术开发区第一大街与经北一路</li>
				<li>郑州校区二<br>中国-郑州经济技术开发区第四大街经开人才市场七楼</li>
				<li>郑州校区三<br>中国-郑州经济技术开发区第八大街河南省留学生创业园九层、十层</li>
				<li>西安分校<br>中国-西安莲湖区　联系人：梁老师 13201570801</li>
			</ul>
		</li>
		<li class="mt25">
			<h3>联系我们</h3>
			<ul id="foo_icon">
				<li>中国-郑州经济技术开发区经北三路河南通信产业园六层</li>
				<li>e-mail:zy@zhiyou100.com</li>
				<li>电话:4006-371-555 0371-88888598</li>
				<li class="erwei">
					<br>
					<div>
						<img class="weixin" src="static/z/a_002.png" alt="" draggable="false">
						<img class="weibo" src="static/z/a.png" alt="" draggable="false">
					</div>
				</li>
			</ul>
		</li>
	</ul>
	<div class="record">智游教育 © 豫ICP备17000832号-1 　河南智游臻龙教育科技有限公司</div>
</footer>


<!--admin登录弹出框-->
<div class="mask hidden" id="logina">
	<div class="mask_content">
		<div class="mask_content_header">
			<img src="static/z/logo.png" alt="" class="ma">
		</div>
		<div class="mask_content_body">
			<form id="loginForm" method="post" action="checkPassword.do">
				<h3>后台登录</h3>
				<input id="loginEmail" placeholder="请输入邮箱" name="email" type="email" onblur="m()">
				<input id="loginPassword" placeholder="请输入密码" name="password" type="password">
				<i id="i"></i>
				<div id="forget">
					<a href="http://localhost:8080/video/front/user/forgetPassword.action">忘记密码？</a>
				</div>
				<input value="登　录" type="submit" id="sub">
			</form>
		</div>
		<div class="mask_content_footer">
			<span id="logina_close">关　闭</span>
		</div>
	</div>
</div>

<!--user登录弹出框-->
<div class="mask hidden" id="loginu">
	<div class="mask_content">
		<div class="mask_content_header">
			<img src="static/z/logo.png" alt="" class="ma">
		</div>
		<div class="mask_content_body">
			<form id="loginF" method="post" action="checkP.do">
				<h3>用户登录</h3>
				<input id="le" placeholder="请输入邮箱" name="email" type="email" onblur="n()">
				<input id="lp" placeholder="请输入密码" name="password" type="password">
				<i id="ii"></i>
				<div id="forget">
					<a href="http://localhost:8080/video/front/user/forgetPassword.action">忘记密码？</a>
				</div>
				<input value="登　录" type="submit" id="btn">
			</form>
		</div>
		<div class="mask_content_footer">
			<span id="loginu_close">关　闭</span>
		</div>
	</div>
</div>

<div class="mask hidden" id="reg">
	<div class="mask_content">
		<div class="mask_content_header">
			<img src="static/z/logo.png" alt="" class="ma">
		</div>
		<div class="mask_content_body">
			<form action="insertUser.do" method="post">
					<h3>新用户注册</h3>
					<input placeholder="请输入邮箱" name="accounts" type="email" id="accounts" onblur="user_accounts_reg()"> 
						<span id="emailMsg"></span> 
					<input placeholder="请输入密码" name="password" type="password"> 
					<input placeholder="请再次输入密码" name="psw_again" type="password"> 
						<span id="passMsg"></span>
					<input value="注　册" type="submit" id="submitReg">
				</form>
		</div>
		<div class="mask_content_footer">
			<span id="reg_close">关　闭</span>
		</div>
	</div>
</div>

<c:if test="${msg!=null}">
		<script type="text/javascript">
			alert('${msg}');
		</script>
	</c:if>

<c:if test="${e!=null}">

<script type="text/javascript">
document.getElementById("loginu_open").style.display = "none"; 
document.getElementById("reg_open").style.display = "none";
document.getElementById("tx").style.display = "inline";
document.getElementById("tc").style.display = "inline";
</script>
</c:if>
    
<script src="static/z/jquery-1.js"></script>
<script src="static/z/gVerify.js"></script>
<script src="static/z/index.js"></script>
<script type="text/javascript" src="static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" >
	function m() {
		$.post({
    		url:"http://localhost:8080/video/checkEmail.do",
    		data:{
    			name:$("#loginEmail").val()
    		},
    		success:function(data){
    			if(data==1){
   				$("#i").text("用户名错误");
   				$("#sub").attr("disabled",true);
   			}else{
   				$("#i").text("用户名正确");
   				$("#sub").attr("disabled",false);
   			}	
    		},
    	})
        }
	
	function n() {
		$.post({
    		url:"http://localhost:8080/video/checkE.do",
    		data:{
    			name:$("#le").val()
    		},
    		success:function(data){
    			if(data==1){
   				$("#ii").text("用户名错误");
   				$("#btn").attr("disabled",true);
   			}else{
   				$("#ii").text("用户名正确");
   				$("#btn").attr("disabled",false);
   			}	
    		},
    	})
        }
	
	//注册验证
	function user_accounts_reg() {
		$.post({
				url : "http://localhost:8080/video/user_accounts_reg.do",
				data : {
					accountsCheck : $("#accounts").val(),
				},
				success : function(data) {
				if (data == "success") {
					//如果已经注册，禁止提交
					$("#submitReg").attr("disabled", true);
					$("#emailMsg").text("该邮箱已注册，请直接登录").css( "color", "red");
				} else {
					$("#submitReg").attr("disabled", false);
					$("#emailMsg").text("该邮箱可用").css("color", "green");
				}
			}
		})
	}
	</script>	
</body>
</html>