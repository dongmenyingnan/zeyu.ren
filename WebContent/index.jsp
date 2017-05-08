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
		<!-- 最新与热门问题列表 -->
		<!-- Nav tabs -->
		<br />
		<br />
		<br />
		<br />
		<br />
		<ul id="navTabs" class="" role="tablist">
			<li role="presentation" ${requestFlag.mostHot }><a class="black"
				href="${pageContext.request.contextPath}/home.action"
				aria-controls="now" role="tab" data-toggle="tab">最新</a></li>
			<li role="presentation" ${requestFlag.mostNew }><a class="black"
				href="${pageContext.request.contextPath}/homeHotQuestions.action"
				aria-controls="hot" role="tab" data-toggle="tab">热门</a></li>
			<c:if test="${user!=null }">
				<li role="presentation" ${requestFlag.myQuestion }><a
					class="black"
					href="${pageContext.request.contextPath}/homeMyQuestions.action"
					aria-controls="myQuestion" role="tab" data-toggle="tab">我的提问</a></li>
				<li role="presentation" ${requestFlag.myAnswer }><a
					class="black"
					href="${pageContext.request.contextPath}/homeMyAnsQuestions.action"
					aria-controls="myAnswer" role="tab" data-toggle="tab">我的回答</a></li>
			</c:if>
		</ul>
		<!-- Tab panes -->
		
		
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane ${requestFlag.activeNew }"
				id="now">

				<div class="problem">

					<c:forEach items="${questionsNew}" var="questionNew">

						<div class="list-group-item box">
							<div id="label" class="ib fl bgBlack">
								<span class="block center white">${questionNew.answer_number}</span>
								<span class="block center white">回 答</span>
							</div>
							<div id="label" class="ib fl bgWhite">
								<span class="block center black">${questionNew.question.hits}</span>
								<span class="block center black">浏 览</span>
							</div>
							<div id="label" class="ib fl bgWhite">
								<span class="block center black">${questionNew.answer_number }</span> <a
									href="answers.action?question_id=${questionNew.question.question_id}">
									关 注</a>
							</div>
							<div class="label">
								<!-- 标签 -->
								<c:forEach items="${questionNew.labels }" var="labels">
								
								
								<span class="label label-pill label-info"><a
									style="color: white;"
									href="answers.action?question_id=${questionNew.question.question_id}">${labels}</a></span>
								</c:forEach>
								<div>
									<a class="ib fl"
										href="answers.action?question_id=${questionNew.question.question_id}">
										<h4>${questionNew.question.question_comment}</h4>
									</a>
								</div>
							</div>
							<!-- 提问时间 -->
							<div class="nav navbar-nav navbar-right">
								<%-- <span >${fn:substringBefore(list.question.create_time, ".0")}</span> --%>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" type="both"
									value="${questionNew.question.create_time}" />
								&nbsp&nbsp
								</p>
							</div>
						</div>
					</c:forEach>

					<!-- 分页 -->
					<div class="fy">
						<div class="pageout">
							<c:if test="${searchContent!=null }">
								<c:forEach items="${PagesNew}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/homeHotQuestions.action?page=${pagesNew.pageNum}&&searchContent=${searchContent}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
								</c:forEach>
							</c:if>
							<c:if test="${searchContent==null }">
								<c:forEach items="${PagesNew}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/homeHotQuestions.action?page=${pagesNew.pageNum}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
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
				id="hot">
				<div class="problem">
					<c:forEach items="${questions}" var="list">
						<div class="list-group-item box">
							<div id="label" class="ib fl bgBlack">
								<span class="block center white">${list.answer_number}</span> <a
									href="answers.action?question_id=${list.question.question_id}">
									<span class="block center white">回 答</span>
								</a>
							</div>
							<div id="label" class="ib fl bgWhite">
								<span class="block center black">${list.question.hits }</span> <a
									href="answers.action?question_id=${list.question.question_id}">
									浏 览</a>
							</div>
							<div id="label" class="ib fl bgWhite">
								<span class="block center black">${list.answer_number }</span> <a
									href="answers.action?question_id=${list.question.question_id}">
									关 注</a>
							</div>
							<div class="label">
								<!-- 标签 -->
								<c:forEach items="${list.labels }" var="labels">
								
								
								<span class="label label-pill label-info"><a
									style="color: white;"
									href="answers.action?question_id=${list.question.question_id}">${labels}</a></span>
								</c:forEach>
								<div>
									<a class="ib fl"
										href="answers.action?question_id=${list.question.question_id}">
										<h4>${list.question.question_comment}</h4>
									</a>
								</div>
							</div>
							<!-- 提问时间 -->
							<div class="nav navbar-nav navbar-right">
								<%-- <span >${fn:substringBefore(list.question.create_time, ".0")}</span> --%>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" type="both"
									value="${list.question.create_time}" />
								&nbsp&nbsp
								</p>
							</div>
						</div>
					</c:forEach>


					<!-- 分页 -->
					<div class="fy">
						<div class="pageout">
							<c:if test="${searchContent!=null }">
								<c:forEach items="${Pages  }" var="Page">
									<a ${Page.style }
										href="${pageContext.request.contextPath}/search.action?page=${Page.pageNum}&&searchContent=${searchContent}&&flag=${Page.flag}">${Page.content }</a>
								</c:forEach>
							</c:if>
							<c:if test="${searchContent==null }">
								<c:forEach items="${Pages  }" var="Page">
									<a ${Page.style }
										href="${pageContext.request.contextPath}/home.action?page=${Page.pageNum}&&flag=${Page.flag}">${Page.content }</a>
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
			<div role="tabpanel"
				class="tab-pane ${requestFlag.activeMyQuestion }" id="myQuestion">

				<div class="problem">

					<c:forEach items="${MyQuestions}" var="myQuestion">

						<div class="list-group-item box">
							<div id="label" class="ib fl bgBlack">
								<span class="block center white">${myQuestion.answer_number}</span>
								<span class="block center white">回 答</span>
							</div>
							<div id="label" class="ib fl bgWhite">
								<span class="block center black">${myQuestion.question.hits}</span>
								<span class="block center black">浏 览</span>
							</div>
							<div id="label" class="ib fl bgWhite">
								<span class="block center black">${myQuestion.answer_number }</span> <a
									href="answers.action?question_id=${myQuestion.question.question_id}">
									关 注</a>
							</div>
							<div class="label">
								<!-- 标签 -->
								<c:forEach items="${myQuestion.labels }" var="labels">
								
								
								<span class="label label-pill label-info"><a
									style="color: white;"
									href="answers.action?question_id=${myQuestion.question.question_id}">${labels}</a></span>
								</c:forEach>
								<div>
									<a class="ib fl"
										href="answers.action?question_id=${myQuestion.question.question_id}">
										<h4>${myQuestion.question.question_comment}</h4>
									</a>
								</div>
							</div>
							<!-- 提问时间 -->
							<div class="nav navbar-nav navbar-right">
								<%-- <span >${fn:substringBefore(list.question.create_time, ".0")}</span> --%>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" type="both"
									value="${myQuestion.question.create_time}" />
								&nbsp&nbsp
								</p>
							</div>
						</div>
					</c:forEach>

					<!-- 分页 -->
					<div class="fy">
						<div class="pageout">
							<c:if test="${searchContent!=null }">
								<c:forEach items="${PagesMyQuestion}" var="pagesMyQuestion">
									<a ${pagesMyAnsQuestion.style }
										href="${pageContext.request.contextPath}/homeMyQuestions.action?page=${pagesMyQuestion.pageNum}&&searchContent=${searchContent}">${pagesMyQuestion.content }</a>
								</c:forEach>
							</c:if>
							<c:if test="${searchContent==null }">
								<c:forEach items="${PagesMyQuestion}" var="pagesMyQuestion">
									<a ${pagesMyQuestion.style }
										href="${pageContext.request.contextPath}/homeMyQuestions.action?page=${pagesMyQuestion.pageNum}">${pagesMyQuestion.content }</a>
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
			<div role="tabpanel" class="tab-pane ${requestFlag.activeMyAnswer }"
				id="myAnswer">
				
				<div class="problem">
	
					<c:forEach items="${MyAnsQuestions}" var="myAnsQuestion">

						<div class="list-group-item box">
							<div id="label" class="ib fl bgBlack">
								<span class="block center white">${myAnsQuestion.answer_number}</span>
								<span class="block center white">回 答</span>
							</div>
							<div id="label" class="ib fl bgWhite">
								<span class="block center black">${myAnsQuestion.question.hits}</span>
								<span class="block center black">浏 览</span>
							</div>
							<div id="label" class="ib fl bgWhite">
								<span class="block center black">${myAnsQuestion.answer_number }</span> <a
									href="answers.action?question_id=${myAnsQuestion.question.question_id}">
									关 注</a>
							</div>
							<div class="label">
								<!-- 标签 -->
								<c:forEach items="${myAnsQuestion.labels }" var="labels">
								
								
								<span class="label label-pill label-info"><a
									style="color: white;"
									href="answers.action?question_id=${myAnsQuestion.question.question_id}">${labels}</a></span>
								</c:forEach>
								<div>
									<a class="ib fl"
										href="answers.action?question_id=${myAnsQuestion.question.question_id}">
										<h4>${myAnsQuestion.question.question_comment}</h4>
									</a>
								</div>
							</div>
							<!-- 提问时间 -->
							<div class="nav navbar-nav navbar-right">
								<%-- <span >${fn:substringBefore(list.question.create_time, ".0")}</span> --%>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" type="both"
									value="${myAnsQuestion.question.create_time}" />
								&nbsp&nbsp
								</p>
							</div>
						</div>
					</c:forEach>

					<!-- 分页 -->
					<div class="fy">
						<div class="pageout">
							<c:if test="${searchContent!=null }">
								<c:forEach items="${PagesMyAnsQuestion}"
									var="pagesMyAnsQuestion">
									<a ${pagesMyAnsQuestion.style }
										href="${pageContext.request.contextPath}/homeMyAnsQuestions.action?page=${pagesMyAnsQuestion.pageNum}&&searchContent=${searchContent}">${pagesMyAnsQuestion.content }</a>
								</c:forEach>
							</c:if>
							<c:if test="${searchContent==null }">
								<c:forEach items="${PagesMyAnsQuestion}"
									var="pagesMyAnsQuestion">
									<a ${pagesMyAnsQuestion.style }
										href="${pageContext.request.contextPath}/homeMyAnsQuestions.action?page=${pagesMyAnsQuestion.pageNum}">${pagesMyAnsQuestion.content }</a>
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