<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0046)http://localhost:8080/Voids/user/userUpdate.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">

    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <script src="http://localhost:8080/video/static/bootstrap.js"></script>
    <link href="http://localhost:8080/video/static/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="http://localhost:8080/video/static/base.css">
    <link rel="stylesheet" href="http://localhost:8080/video/static/profile.css">
    <link rel="icon" href="http://localhost:8080/video/static/z/favicon.png" type="image/png">
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
                <li><a href="http://localhost:8080/video/jsp/main.jsp">首页</a></li>

                <li class="menu_active"><a href="personalCenterSkip">个人中心</a></li>
            </ul>

            <div id="user_bar">
                <a>

                    <img id="avatar" src="${user.imgurl}" alt="" >




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

                        <img src="${user.imgurl}" width="200px;">



                    </div>
                    <div class="profile_ifo_area">
                        <form action="http://localhost:8080/video/updateUser" method="post">
                            <input type="hidden" name="imgUrl" value="${user.imgurl}">
                            <input name="id" value="${user.id}" type="hidden">
                            <input name="accounts" value="${user.accounts}" type="hidden">
                            <div class="form_group">
                                <span class="dd">昵　称：</span><input name="nickname" type="text" value="${user.nickname}">

                            </div>
                            <div class="form_group">
                                <span class="dd">性　别：</span>

                                <c:if test="${user.sex=='man'}">
                                    <input id="man"  name="sex" type="radio" checked="checked" value="man"><label for="man">男</label>
                                    <input id="woman"  name="sex" type="radio" value="woman"><label for="woman">女</label>
                                </c:if>
                                <c:if test="${user.sex=='woman'}">
                                    <input id="man"  name="sex" type="radio" value="man"><label for="man">男</label>
                                    <input id="woman"  name="sex" type="radio" checked="checked" value="woman"><label for="woman">女</label>
                                </c:if>
                                <c:if test="${empty user.sex}">
                                    <input id="man"  name="sex" type="radio" value="man"><label for="man">男</label>
                                    <input id="woman"  name="sex" type="radio" value="woman"><label for="woman">女</label>
                                </c:if>




                            </div>
                            <div class="form_group">
                                <span class="dd">生　日：</span>  <!-- 1990-10-04 -->
                                <input name="birthday" type="text" value="${user.birthday}">
                            </div>
                            <div class="form_group">
                                <span class="dd" name="accounts">邮　箱：</span>
                                <span>${user.accounts}</span>
                            </div>
                            <div class="form_group">
                                <span class="dd">所在地：</span>
                                <div id="city">
                                    <select class="prov" name="prov"><option value="">北京</option><option value="天津">天津</option><option value="河北">河北</option><option value="山西">山西</option><option value="内蒙古">内蒙古</option><option value="辽宁">辽宁</option><option value="吉林">吉林</option><option value="黑龙江">黑龙江</option><option value="上海">上海</option><option value="江苏">江苏</option><option value="浙江">浙江</option><option value="安徽">安徽</option><option value="福建">福建</option><option value="江西">江西</option><option value="山东">山东</option><option value="河南" selected="selected">河南</option><option value="湖北">湖北</option><option value="湖南">湖南</option><option value="广东">广东</option><option value="广西">广西</option><option value="海南">海南</option><option value="重庆">重庆</option><option value="四川">四川</option><option value="贵州">贵州</option><option value="云南">云南</option><option value="西藏">西藏</option><option value="陕西">陕西</option><option value="甘肃">甘肃</option><option value="青海">青海</option><option value="宁夏">宁夏</option><option value="新疆">新疆</option><option value="香港">香港</option><option value="澳门">澳门</option><option value="台湾">台湾</option><option value="国外">国外</option></select>
                                    <select class="city" name="city"><option value="" selected="selected">郑州</option><option value="开封">开封</option><option value="洛阳">洛阳</option><option value="平顶山">平顶山</option><option value="安阳">安阳</option><option value="鹤壁">鹤壁</option><option value="新乡">新乡</option><option value="焦作">焦作</option><option value="濮阳">濮阳</option><option value="许昌">许昌</option><option value="漯河">漯河</option><option value="三门峡">三门峡</option><option value="南阳">南阳</option><option value="商丘">商丘</option><option value="信阳">信阳</option><option value="周口">周口</option><option value="驻马店">驻马店</option><option value="济源">济源</option></select>
                                </div>
                                <input name="address" id="address" type="hidden">
                            </div>
                            <div class="form_submit dd">
                                <input value="保　存" type="submit">
                                <input type="reset" class="btn-default btn btn-warning">
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


<script src="http://localhost:8080/video/static/jquery-1.js"></script>
<script src="http://localhost:8080/video/static/gVerify.js"></script>
<script src="http://localhost:8080/video/static/index.js"></script>

<script src="http://localhost:8080/video/static/jquery.js"></script>
<script type="text/javascript">

    $(function(){

        var sex = '';
        $("input[name='sex']").each(function(i,obj){
            //obj是dom对象     不是jquery对象
            //alert(obj+","+i);
            //alert(obj.value+","+sex);
            if($(obj).val()==sex){
                // obj.checked=true;
                $(obj).attr("checked",true);
            }
        });

        var address =''; //""  河南-郑州

        if(null!=address && address!=""){
            var arr=address.split("-");

            $("#city").citySelect({
                prov: arr[0],  //默认省份
                city: arr[1],  //默认城市
                nodata: "none"
            });
        }else{
            $("#city").citySelect({
                prov: "河南",  //默认省份
                city: "郑州",  //默认城市
                nodata: "none"
            });
        }

    });

    function commitForm(){

        var address= $(".prov").val()+"-"+$(".city").val();

        $("#address").val(address);

        // $("form").commit();
        return true;
    }
</script>


</body></html>