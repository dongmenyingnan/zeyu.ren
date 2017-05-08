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
<link href=" bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href=" bootstrap/css/sticky-footer.css" rel="stylesheet">
<link href=" css/programme.css" rel="stylesheet">
<link rel="icon" href=" image/favicon.png">
<link href=" css/carousel.css" rel="stylesheet">
<link href="css/aboutus.css" rel="stylesheet">
<!-- 标签 -->
<link rel="stylesheet" type="text/css" href="./css/jquery.tagsinput.css" />
<!-- <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
 <script type="text/javascript" src="./dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./js/jquery.tagsinput.js"></script>

<!-- <link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/start/jquery-ui.css" /> -->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css"
	href="./dist/css/wangEditor.min.css">

<!--引入jquery和wangEditor.js-->
<!--注意：javascript必须放在body最后，否则可能会出现问题-->
<!-- -->
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
								<input type="hidden" name="flag" value="2" /> <input
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
										<li><a href="user/settings.jsp" style="color: white;"><span
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
		<!-- <div 
			style="color: white; background: url(image/aboutusimg.jpg); margin-top: 80px;">
			<h1>关于 Exception</h1>
			<p class="lead">Exception致力于帮助人们查找问题，分析问题，解决问题</p>
		</div> -->
	</header>

	<!-- 内容 -->
	<br />
	<br />
	<br />
	<br />
	<br />
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
							<textarea id="tags_1" class="form-control" style="resize: none;"
								rows="1" name="label" id="commentarea"
								onKeyDown="LimitTextArea(this,50)"
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
		<!-- 页面 -->
		<!-- Nav tabs -->
		<header class="profile__heading" style="padding-bottom: 3%;">
			<div class="container"></div>
		</header>
		<div class="row row-offcanvas row-offcanvas-left">
			<div class="col-md-2 sidebar-offcanvas hidden-xs hidden-sm"
				id="sidebar">
				<div class="list-group">
					<a href="aboutus.jsp" class="list-group-item ">关于我们</a> <a
						href="duty.jsp" class="list-group-item list-group-item-success">服务条款</a> <a
						href="feedback.jsp" class="list-group-item">建议反馈</a>
				</div>
			</div>
			<div class="col-md-9">
				<article class="post page">
					<section class="post-content">
						<span id="toc0"></span>
						<h2 id="-">知识产权声明</h2>
						<p>Exception --
							拥有本网站内所有资料的版权，各分频道权利声明有特殊规定的，从其规定。任何被授权的浏览、复制、打印和传播属于本网站内的资料必须符合以下条件：


						
						<blockquote style="border-left: 5px solid #C7C7C7;">
							<p>
								所有的资料和图象均以获得信息为目的； <br>所有的资料和图象均不得用于商业目的； <br>所有的资料、图象及其任何部分都必须包括此版权声明；
							</p>
						</blockquote>
					</section>
				</article>
			</div>
		</div>
	</div>
	<!-- 页脚 -->
	<footer class="footer">
		<iframe src="foot.html" frameborder="0" scrolling="no"></iframe>
	</footer>
</body>

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
/* 	$(function() {
		$('#tags_1').tagsInput({
			width : 'auto'
		});
		aoTuList("a");
		document.getElementById('search').oninput = function() {
			var str = document.getElementById("search").value;
			if (!$.trim(str).length <= 0)
				aoTuList(str);
		}
	}); */
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