<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>zeyu.ren</title>

<!-- 标签 -->
<link rel="stylesheet" type="text/css" href="./css/jquery.tagsinput.css" />
<link rel="stylesheet" type="text/css" href="./css/ManualCenter.css">
 <script type="text/javascript" src="./dist/js/lib/jquery-2.2.1.js"></script> 
<script type="text/javascript" src="./js/jquery.tagsinput.js"></script>
<!-- 
 <link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/start/jquery-ui.css" />   -->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css"
	href="./dist/css/wangEditor.min.css">

<!--引入jquery和wangEditor.js-->
<!--注意：javascript必须放在body最后，否则可能会出现问题-->

<script type="text/javascript" src="./dist/js/wangEditor.min.js"></script>

<!-- 自动补全 -->
 <link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/sticky-footer.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link rel="icon" href="image/favicon.png">
<link href="css/carousel.css" rel="stylesheet">
<script src="js/zeyu.js"></script>
<script src="./bootstrap/js/mybootstrap.js"></script>
</head>
<body>
	<header>
		<div class="navbar-wrapper">

			<div class="container">

				<nav class="navbar navbar-inverse navbar-static-top">
					<div class="container">
						<div class="navbar-header navbar-header-style">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#lg-navbar-collapse"
								aria-expanded="false">
								<span class="sr-only">Exception</span> <span class="icon-bar"></span>
								<span class="icon-bar"></span> <span class="icon-bar"></span>
							</button>
							<a class="navbar-brand navbar-brand-style" style="color: white;"
								href="home.action">Exception</a>
						</div>

						<form class="navbar-form navbar-left navbar-form-search hidden-xs"
							role="search"
							action="${pageContext.request.contextPath}/search.action"
							method="get">
							<div class="input-group">
								<input type="hidden" name="flag" value="1" /> <input
									type="hidden" name="page" value="1" /> <input type="text"
									class="form-control " name="searchContent" id="search"
									placeholder="搜索异常或错误..."> <span class="input-group-btn">
									<button class="btn btn-default btn-search" type="submit">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									</button>
								</span>

							</div>
						</form>
						<!-- 导航 -->
						<div class="collapse navbar-collapse" id="lg-navbar-collapse">
							<ul class="nav navbar-nav navbar-left">
								<li><c:choose>
										<c:when test="${user!=null}">
											<a href="javascript:openModel();">
										</c:when>
										<c:otherwise>
											<a
												href="${pageContext.request.contextPath }/user/account.jsp">
										</c:otherwise>
									</c:choose> <span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>提问</a></li>
									
									
									<li><c:choose>
										<c:when test="${user!=null}">
											<a href="${pageContext.request.contextPath }/write.jsp"">
										</c:when>
										<c:otherwise>
											<a
												href="${pageContext.request.contextPath }/user/account.jsp">
										</c:otherwise>
									</c:choose> <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>写文章</a></li>
									
									<li><a
									href="${pageContext.request.contextPath}/allArticles.action"><span
										class="glyphicon glyphicon-book"></span>文章列表</a></li>
								<li><a href="${pageContext.request.contextPath}/display.action"><span class="glyphicon glyphicon-flash"></span>快速手册</a></li>
								<li><a
									href="${pageContext.request.contextPath}/exception.action"><span
										class="glyphicon glyphicon-info-sign"></span>常见异常</a></li>
								<li><a
									href="${pageContext.request.contextPath}/feedback.jsp"><span
										class="glyphicon glyphicon-wrench"></span>用户反馈</a></li>
										
							</ul>
														<ul class="nav navbar-nav navbar-right">

								<c:choose>
									<c:when test="${user!=null}">
										<li><a href="user/settings_check.action" style="color: white;"><span
												class="glyphicon glyphicon-user" style="color: white;"
												aria-hidden="true"></span> ${user.user_name } </a></li>

									</c:when>
									<c:otherwise>
										<li><a href="user/account.jsp" style="color: white;"><span
												class="glyphicon glyphicon-user" style="color: white;"
												aria-hidden="true"></span> 登录 </a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</nav>

			</div>
		</div>

	</header>
	<!-- 内容 -->

	<div class="container">
		<!-- 提问模态框 -->
		<div class="modal fade bs-example-modal-lg" id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<form action="${pageContext.request.contextPath}/ask.action"
						method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">
								<span class="glyphicon glyphicon-question-sign"></span>一句话描述您的疑问
							</h4>
						</div>
						<div class="modal-body">
							<textarea class="form-control" style="resize: none;" rows="2"
								name="comment" id="commentarea"
								onKeyDown="LimitTextArea(this,50)"
								onKeyUp="LimitTextArea(this,50)"
								onkeypress="LimitTextArea(this,50)"
								placeholder="请在这里描述您的问题(50字内)" required="required"></textarea>
							<h5>问题补充(选填)</h5>
							<textarea class="form-control" style="height: 280px;" rows="10"
								name="commentAddition" id="commentareaAddition"
								onKeyDown="LimitTextArea(this,200)"
								onKeyUp="LimitTextArea(this,200)"
								onkeypress="LimitTextArea(this,200)"
								placeholder="请在这里描述您的问题(50字内)" required="required"></textarea>
							<h5>请输入标签</h5>
							<textarea id="tags_1" class="form-control" style="resize: none;" rows="1"
								name="label"  onKeyDown="LimitTextArea(this,50)"
								onKeyUp="LimitTextArea(this,50)"
								onkeypress="LimitTextArea(this,50)"></textarea>

						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">提交问题</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	
	<div class="center">
	<div class="title">
	<h3>常见异常</h3>
	</div>
	<div class="containers">
	<div class="containers_left" >
	<ul style="padding-left: 0px;">
		<li class="q1"><div><span>后台开发</span><i class="glyphicon glyphicon-chevron-right"></i></div></li>
		<li class="q2"><div><span>前端开发</span><i class="glyphicon glyphicon-chevron-right"></i></div></li>
		<li class="q3"><div><span>移动端开发</span><i class="glyphicon glyphicon-chevron-right"></i></div></li>
		<li class="q4"><div><span>数据库</span><i class="glyphicon glyphicon-chevron-right"></i></div></li>
		<li class="q5"><div><span>服务器</span><i class="glyphicon glyphicon-chevron-right"></i></div></li>
		<li class="q6"><div><span>测试&运维</span><i class="glyphicon glyphicon-chevron-right"></i></div></li>
	</ul>
	</div>
	<div class="ct_right">

	
		<div id="r2" class="containers_right2 ${requestFlag1.activeHot }"style="background: url('${background}');background-size:100% 100%;">
	<div class="right_top">
		<div class="rt_title">
		<span>分类目录</span>
		</div>
		<div class="rt_content">
			<span>/   &nbsp;&nbsp;Java &nbsp;&nbsp;   /&nbsp;&nbsp;    PHP &nbsp;&nbsp;   /&nbsp;&nbsp;    Ruby &nbsp;&nbsp;   /&nbsp;&nbsp;    C &nbsp;&nbsp;   /&nbsp;&nbsp;   C++  &nbsp;&nbsp;  /&nbsp;&nbsp;    C#&nbsp;&nbsp;    / &nbsp;&nbsp;   Python</span>
		
		</div>
	</div>
	<div class="right_bottom">
	<span>异常列表</span>
	<ul style="padding-left: 0px;;">
	<c:forEach items="${list}" var="list">
		<li><a href="${pageContext.request.contextPath}${list.exception_url }?exceptionarticle_id=${list.exception_id}">${list.exception_name}</a></li>
		</c:forEach>
	
	</ul>
			<div class="fy">
						<div class="pageout">
			<c:forEach items="${Pages1}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/exception.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
			</c:forEach>
			</div>
			</div>
	
	</div>
	
	</div>
	
		<div id="r3" class="containers_right3 ${requestFlag2.activeHot }" style="background: url('${background1}');background-size:100% 100%;">
	<div class="right_top">
		<div class="rt_title">
		<span>分类目录</span>
		</div>
		<div class="rt_content">
			<span>/ &nbsp;&nbsp;   HTML &nbsp;&nbsp;   / &nbsp;&nbsp;   CSS &nbsp;&nbsp;   /&nbsp;&nbsp;    JQuery&nbsp;&nbsp;    /&nbsp;&nbsp;    JavaScript</span>
		
		</div>
	</div>
	<div class="right_bottom">
	<span>异常列表</span>
	<ul style="padding-left: 0px;;">
	<c:forEach items="${list1}" var="list">
		<li><a href="${pageContext.request.contextPath}${list.exception_url }?exceptionarticle_id=${list.exception_id}">${list.exception_name}</a></li>
		</c:forEach>
	
	</ul>
			<div class="fy">
						<div class="pageout">
			<c:forEach items="${Pages2}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/exception.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
			</c:forEach>
			</div>
			</div>
	
	</div>
	
	</div>
	
		<div id="r4" class="containers_right4  ${requestFlag3.activeHot }" style="background: url('${background2}');background-size:100% 100%;">
	<div class="right_top">
		<div class="rt_title">
		<span>分类目录</span>
		</div>
		<div class="rt_content">
		<span>/   &nbsp;&nbsp; Android&nbsp;&nbsp;    /&nbsp;&nbsp;  IOS</span>
		
		</div>
	</div>
	<div class="right_bottom">
	<span>异常列表</span>
	<ul style="padding-left: 0px;;">
	<c:forEach items="${list2}" var="list">
		<li><a href="${pageContext.request.contextPath}${list.exception_url }?exceptionarticle_id=${list.exception_id}">${list.exception_name}</a></li>
		</c:forEach>
	
	</ul>
			<div class="fy">
						<div class="pageout">
			<c:forEach items="${Pages3}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/exception.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
			</c:forEach>
			</div>
			</div>
	
	</div>
	
	</div>
	
		<div id="r5" class="containers_right5 ${requestFlag4.activeHot }" style="background: url('${background3}');background-size:100% 100%;" >
	<div class="right_top">
		<div class="rt_title">
		<span>分类目录</span>
		</div>
		<div class="rt_content">
			<span>/    &nbsp;&nbsp;Mysql&nbsp;&nbsp;    /&nbsp;&nbsp;    SqlServer &nbsp;&nbsp;   / &nbsp;&nbsp;   MongoDB</span>
		
		</div>
	</div>
	<div class="right_bottom">
	<span>异常列表</span>
	<ul style="padding-left: 0px;;">
	<c:forEach items="${list3}" var="list">
		<li><a href="${pageContext.request.contextPath}${list.exception_url }?exceptionarticle_id=${list.exception_id}">${list.exception_name}</a></li>
		</c:forEach>
	
	</ul>
			<div class="fy">
						<div class="pageout">
			<c:forEach items="${Pages4}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/exception.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
			</c:forEach>
			</div>
			</div>
	
	</div>
	
	</div>
	
		<div id="r6" class="containers_right6 ${requestFlag5.activeHot }" style="background: url('${background4}');background-size:100% 100%;" >
	<div class="right_top">
		<div class="rt_title">
		<span>分类目录</span>
		</div>
		<div class="rt_content">
		<span>/  &nbsp;&nbsp;  大数据 &nbsp;&nbsp;   / &nbsp;&nbsp;   云计算</span>
		
		</div>
	</div>
	<div class="right_bottom">
	<span>异常列表</span>
	<ul style="padding-left: 0px;;">
	<c:forEach items="${list4}" var="list">
		<li><a href="${pageContext.request.contextPath}${list.exception_url }?exceptionarticle_id=${list.exception_id}">${list.exception_name}</a></li>
		</c:forEach>
	
	</ul>
			<div class="fy">
						<div class="pageout">
			<c:forEach items="${Pages5}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/exception.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
			</c:forEach>
			</div>
			</div>
	</div>
	
	</div>
	
	
		
		<div id="r7" class="containers_right7 ${requestFlag6.activeHot }" style="background: url('${background5}');background-size:100% 100%;">
	<div class="right_top">
		<div class="rt_title">
		<span>分类目录</span>
		</div>
		<div class="rt_content">
		<span>/  &nbsp;&nbsp;  测试 &nbsp;&nbsp;   / &nbsp;&nbsp;   Linux</span>
		
		</div>
	</div>
	<div class="right_bottom">
	<span>异常列表</span>
	<ul style="padding-left: 0px;;">
	<c:forEach items="${list5}" var="list">
		<li><a href="${pageContext.request.contextPath}${list.exception_url }?exceptionarticle_id=${list.exception_id}">${list.exception_name}</a></li>
		</c:forEach>
	
	</ul>
		<div class="fy">
						<div class="pageout">
			<c:forEach items="${Pages6}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/exception.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
			</c:forEach>
			</div>
			</div>
	
	</div>
	
	</div>
	
	</div>
	
	
	</div>
	</div>

	</div>

	
	
	<!-- 页脚 -->
	<footer class="footer">
		<iframe src="foot.html" frameborder="0" scrolling="no"></iframe>
	</footer>

</body>
<script type="text/javascript">
$(".containers_left > ul > li").hover(function(){
	
	$(this).css("border-right-color","#f1f1f1");
 	$(this).css("background-color","#838B8B");
   	display($(this).attr("class"));  
	  $(".containers_left > ul > li").not(this).each(function() { 
		  $(this).stop().animate({"border-right-color":"red"},0);
		   $(this).css("background","transparent");
	  
      });

},function(){
/* 	$(this).css("border-right-color"," red");*/
 })

 function display(flag){
	if(flag=="q1"){
		$("#r2").addClass("active");
		 $(".ct_right > div").not("#r2").each(function() { 
			$(this).removeClass("active")
			
		}) 
	}else if(flag=="q2"){
		$("#r3").addClass("active");
		 $(".ct_right > div").not("#r3").each(function() { 
			$(this).removeClass("active")
			
		}) 
	}else if(flag=="q3"){
		$("#r4").addClass("active");
		 $(".ct_right > div").not("#r4").each(function() { 
			$(this).removeClass("active")
			
		}) 
	}else if(flag =="q4"){
		$("#r5").addClass("active");
		 $(".ct_right > div").not("#r5").each(function() { 
			$(this).removeClass("active")
			
		}) 
		}else if(flag =="q5"){
			$("#r6").addClass("active");
			 $(".ct_right > div").not("#r6").each(function() { 
				$(this).removeClass("active")
				
			}) 
		}else {
			$("#r7").addClass("active");
			 $(".ct_right > div").not("#r7").each(function() { 
				$(this).removeClass("active")
				
			}) 
	
	}


 
}
window.onload = function() { 
	var flag= GetQueryString("flag");
	if(flag=="1"){
		
		$('.containers_left > ul').children().eq(0).css("border-right-color","#f1f1f1");
		$('.containers_left > ul').children().eq(0).css("background-color","#838B8B");
	}else if(flag=="2"){

		$('.containers_left > ul').children().eq(1).css("border-right-color","#f1f1f1");
		$('.containers_left > ul').children().eq(1).css("background-color","#838B8B");
	}else if(flag=="3"){
	
		$('.containers_left > ul').children().eq(2).css("border-right-color","#f1f1f1");
		$('.containers_left > ul').children().eq(2).css("background-color","#838B8B");
		}else if(flag=="4"){
	
			$('.containers_left > ul').children().eq(3).css("border-right-color","#f1f1f1");
			$('.containers_left > ul').children().eq(3).css("background-color","#838B8B");
		}else if(flag=="5"){
		
			$('.containers_left > ul').children().eq(4).css("border-right-color","#f1f1f1");
			$('.containers_left > ul').children().eq(4).css("background-color","#838B8B");
		}else if(flag=="6"){
		
			$('.containers_left > ul').children().eq(5).css("border-right-color","#f1f1f1");
			$('.containers_left > ul').children().eq(5).css("background-color","#838B8B");
		}else{
			$('.containers_left > ul').children().eq(0).css("border-right-color","#f1f1f1");
			$('.containers_left > ul').children().eq(0).css("background-color","#838B8B");
		}
	
	
	
}
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

</script>
<!--这里引用jquery和wangEditor.js-->
<script type="text/javascript">
	var editor = new wangEditor('commentareaAddition');

	// 仅仅想移除某几个菜单，例如想移除『插入代码』和『全屏』菜单：
	// 其中的 wangEditor.config.menus 可获取默认情况下的菜单配置
	editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
		if (item === 'table') {
			return null;
		}
		if (item === 'emotion') {
			return null;
		}
		if (item === '|') {
			return null;
		}
		if (item === 'img') {
			return null;
		}
		if (item === 'video') {
			return null;
		}
		if (item === 'location') {
			return null;
		}
		return item;
	});

	editor.create();
</script>

<script type="text/javascript">
	function aoTuList(str) {
		$.ajax({
			url : "./auToList.action",
			type : "GET",
			data : "str=" + str,
			dataType : "text",
			async : false,
			success : function(result) {
				//alert("请求成功");
				initData(result);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				//收集异常数据存数据库
				alert(XMLHttpRequest);
				alert(textStatus);
				alert(errorThrown);
			}
		})
	}
	var availableTags;
	function initData(result) {
		var availableTags = eval(result);
		$("#search").autocomplete({
			source : availableTags
		
		});
	
	}
	$(function() {
		$('#tags_1').tagsInput({
			width : 'auto'
		});
		aoTuList("a"); 
		
		document.getElementById('search').oninput = function() {
			
			var str = document.getElementById("search").value;
			
			if(str.indexOf("'")>=0){
				
			}else{
				if (!$.trim(str).length <= 0)
					
					aoTuList(str);
			}
			
				
		}
		
	});
	function LimitTextArea(field, maxLen) {
		maxlimit = maxLen;
		if (field.value.length > maxlimit)
			field.value = field.value.substring(0, maxlimit);
	}
	function openModel() {
		$('#myModal').modal('show');
	}
	function refresh() {
		location.reload(true);
	}
</script>
</html>