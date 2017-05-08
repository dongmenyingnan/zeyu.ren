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
<!-- <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>


<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/start/jquery-ui.css" /> -->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css"
	href="./dist/css/wangEditor.min.css">
<script type="text/javascript" src="./dist/js/lib/jquery-2.2.1.js"></script>
	<script type="text/javascript" src="./js/jquery.tagsinput.js"></script>
<!--引入jquery和wangEditor.js-->
<!--注意：javascript必须放在body最后，否则可能会出现问题-->
<!-- <script type="text/javascript" src="./dist/js/lib/jquery-1.10.2.min.js"></script> -->
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
							action="${pageContext.request.contextPath}/searchArticles.action"
							method="get">
							<div class="input-group">
								<input type="hidden" name="flag" value="1" /> <input
									type="hidden" name="page" value="1" /> <input type="text"
									class="form-control " name="keyword" id="search"
									placeholder="搜索文章..."> <span class="input-group-btn">
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
									</c:choose> <span class="glyphicon glyphicon-question-sign"
									aria-hidden="true"></span>提问</a></li>


								<li><c:choose>
										<c:when test="${user!=null}">
											<a href="${pageContext.request.contextPath }/write.jsp"">
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath }/user/account.jsp">
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
							<textarea id="tags_1" class="form-control" style="resize: none;"
								rows="1" name="label" onKeyDown="LimitTextArea(this,50)"
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
		<!-- 最新与热门问题列表 -->
		<!-- Nav tabs -->
		<br /> <br /> <br /> <br /> <br />
		<ul id="navTabs" class="" role="tablist">
			<li role="presentation" ${requestFlag.mostNew }><a class="black"
				href="${pageContext.request.contextPath}/allArticles.action"
				aria-controls="new" role="tab" data-toggle="tab">最新</a></li>
			<li role="presentation" ${requestFlag.mostHot }><a class="black"
				href="${pageContext.request.contextPath}/showArticlesByUserKind.action"
				aria-controls="grade" role="tab" data-toggle="tab">身份</a></li>
		</ul>
		<!-- Tab panes -->

		<div class="tab-content">
			<div role="tabpanel" class="tab-pane ${requestFlag.activeNew }"
				id="new">

				<div class="problem">

					<c:forEach items="${articles}" var="articles">

						<div class="list-group-item box">

							<div class="label">
								<!-- 标签 -->
								<c:forEach items="${articles.article.article_tag }" var="labels">

									<span class="label label-pill label-info"><a
										style="color: white;" href="article.action?article_id=${articles.article.article_id}">${labels}</a></span>
								</c:forEach>
								<div>
									<a class="ib fl" href="article.action?article_id=${articles.article.article_id}">
										<h4>${articles.article.article_name }</h4>
									</a>
								</div>
							</div>
							<!-- 提问时间 -->
							<div class="nav navbar-nav navbar-right">
								<%-- <span >${fn:substringBefore(list.question.create_time, ".0")}</span> --%>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" type="both"
									value="${articles.article.article_time}" />
								&nbsp&nbsp
								</p>
							</div>
						</div>
					</c:forEach>

					<!-- 分页 -->
					<div class="fy">
						<div class="pageout">
							<c:if test="${keyword!=null }">
								<c:forEach items="${PagesNew}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/allArticles.action?page=${pagesNew.pageNum}&&keyword=${keyword}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
								</c:forEach>
							</c:if>
							<c:if test="${keyword==null }">
								<c:forEach items="${PagesNew}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/allArticles.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
								</c:forEach>
							</c:if>
						</div>
						<!--分页 end -->
						<input type="hidden" value="1" id="curPage">
					</div>
				</div>
			</div>
		</div>

		<div class="tab-content">
			<div role="tabpanel" class="tab-pane ${requestFlag.activeHot }"
				id="grade">

				<div class="problem">

					<c:forEach items="${articlesGrade}" var="articleGrade">

						<div class="list-group-item box">

							<div class="label">
								<!-- 标签 -->
								<c:forEach items="${articleGrade.article_tag }" var="labels">

									<span class="label label-pill label-info"><a
										style="color: white;" href="#">${labels}</a></span>
								</c:forEach>
								<div>
									<a class="ib fl" href="#">
										<h4>${articleGrade.article_name }</h4>
									</a>
								</div>
							</div>
							<!-- 提问时间 -->
							<div class="nav navbar-nav navbar-right">
								<%-- <span >${fn:substringBefore(list.question.create_time, ".0")}</span> --%>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" type="both"
									value="${articleGrade.article_time}" />
								&nbsp&nbsp
								</p>
							</div>
						</div>
					</c:forEach>

					<!-- 分页 -->
					<div class="fy">
						<div class="pageout">
							<c:if test="${keyword!=null }">
								<c:forEach items="${PagesNew}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/allArticles.action?page=${pagesNew.pageNum}&&keyword=${keyword}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
								</c:forEach>
							</c:if>
							<c:if test="${keyword==null }">
								<c:forEach items="${PagesNew}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/allArticles.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
								</c:forEach>
							</c:if>
						</div>
						<!--分页 end -->
						<input type="hidden" value="1" id="curPage">
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
			url : "./auToListArticles.action",
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