<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<!-- 标签 -->
<link rel="stylesheet" type="text/css" href="./css/jquery.tagsinput.css" />
<!-- <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>


<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/start/jquery-ui.css" /> -->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css"
	href="./dist/css/wangEditor.min.css">

<!--引入jquery和wangEditor.js-->
<!--注意：javascript必须放在body最后，否则可能会出现问题-->
	

	 <script type="text/javascript" src="./dist/js/lib/jquery-1.10.2.min.js"></script> 
	 <script type="text/javascript" src="./js/jquery.tagsinput.js"></script> 
	 <script type="text/javascript" src="./dist/js/wangEditor.min.js"></script>

<!-- 自动补全 -->
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>zeyu.ren</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/sticky-footer.css" rel="stylesheet">
<link href="css/answers.css" rel="stylesheet">
<link rel="icon" href="image/favicon.png">
<link href="css/carousel.css" rel="stylesheet">
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
										
							</ul>							<ul class="nav navbar-nav navbar-right">

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
	</header>
	<!-- 内容 -->
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
	<br />
	<br />
	<br />
	<br />
	<br />
	<div>
		<div id="top">
			<div id="topleft">
				<div>
					<i class="i-status-being mr-10 quesIcon"></i>
					<h3>${answerVo.question.question_comment}</h3>
				</div>
				<div style="margin-top: 10px;">
					<a class="black fs-16 ml-40" href="#">${answerVo.user_name}</a> <span
						class="fs-14" style="margin-left: 20px;">${answerVo.question_time }
						提问</span>
				</div>
			</div>
			<div id="topright">
				<div>
					<form
						action="${pageContext.request.contextPath}/user/addAttention.action?question_id=${answerVo.question.question_id}"
						method="post">
						<button id="btnFollow" class="myBtn">关注</button>
						<span><b>${answerVo.question.attentions }</b> 关注</span>
					</form>

				</div>
				<div style="margin-top: 10px;">
					<button id="btnCollect" class="myBtn">浏览</button>
					<span><b>${answerVo.question.hits}</b> 浏览 </span>&nbsp;&nbsp;&nbsp;

				</div>
			</div>
		</div>
		<div id="center">
			<div id="leftpart">
				<div id="qbody">
					<p>${answerVo.question.comment_addition}</p>
					<br> <%-- <span class="mr-10">${answerVo.question_time }提问</span> --%>
				</div>
				<div id="abody">
					<h4>
						<i class="i-status-being mr-10 answerIcon"></i> <span>${fn:length(answerVo.answerGathers)}</span>个回答
					</h4>
					<!-- 分割线-->
					<c:forEach items="${answerVo.answerGathers}" var="list">
						<div style="width: 900px; border-top: solid 2px #aaa"></div>
						<div class="box">
							<div>
								<a href=""> <img class="headicon mr-10"
									src="image/user-64.png" alt="" />
								</a> <a href="">${list.username }(${list.usertype })</a>
							</div>
							<div class="mt-10">
								<p>${list.answer.answer_content}</p>
								<br>  <span class="mr-10">${list.answer_time}回答</span>  <a
									href="javascript:addVotes(${list.answer.answer_id });"> <img
									class="headicon mr-10" src="image/good.jpg" />
								</a>
							</div>
						</div>
					</c:forEach>
					<!-- 分割线-->

					<div style="width: 100%; border-top: solid 1px #aaa"></div>
				</div>
				<div id="answerPart">
					<h4>撰写答案</h4>
					<form
						action="${pageContext.request.contextPath}/reply.action?question_id=${answerVo.question.question_id}"
						method="post">
						<textarea style="height: 200px;" rows="6" name="answer_content"
							id="answer_content"></textarea>
						<button id="answerBtn" type="submit" class="myBtn">提交回答</button>
					</form>
				</div>
			</div>
		</div>

	</div>

	<!-- 页脚 -->
	<footer class="footer">
		<iframe src="foot.html" frameborder="0" scrolling="no"></iframe>
	</footer>
	<script src="js/zeyu.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	

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
	var etr = new wangEditor('answer_content');

	// 仅仅想移除某几个菜单，例如想移除『插入代码』和『全屏』菜单：
	// 其中的 wangEditor.config.menus 可获取默认情况下的菜单配置
	etr.config.menus = $.map(wangEditor.config.menus, function(item, key) {
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
		if (item === 'unlink') {
			return null;
		}
		if (item === 'bgcolor') {
			return null;
		}
		if (item === 'forecolor') {
			return null;
		}
		return item;
	});

	etr.create();
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
	function addVotes(answer_id) {
		$.ajax({
			url : "./addVotes.action",
			type : "GET",
			dataType : "text",
			data : "answer_id=" + answer_id,
			async : false,
			success : function(result) {

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				//收集异常数据存数据库
				alert("请求失败");
			}
		})
	}
	function openModel() {
		$('#myModal').modal('show');
	}
</script>
</html>