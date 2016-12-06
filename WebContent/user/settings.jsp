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
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/sticky-footer.css" rel="stylesheet">
<link href="../css/programme.css" rel="stylesheet">
<link rel="icon" href="../image/favicon.png">
<link href="../css/carousel.css" rel="stylesheet">

<!-- 标签 -->
<link rel="stylesheet" type="text/css" href="../css/jquery.tagsinput.css" />


	
	<script type="text/javascript" src="../dist/js/lib/jquery-2.2.1.js"></script>
	<script type="text/javascript" src="../js/jquery.tagsinput.js"></script>

<!-- <link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/start/jquery-ui.css" /> -->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css"
	href="../dist/css/wangEditor.min.css">

<!--引入jquery和wangEditor.js-->
<!--注意：javascript必须放在body最后，否则可能会出现问题-->
<script type="text/javascript" src="../dist/js/wangEditor.min.js"></script>

<!-- 自动补全 -->
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/sticky-footer.css" rel="stylesheet">
<link href="../css/index.css" rel="stylesheet">
<link rel="icon" href="image/favicon.png">
<link href="../css/carousel.css" rel="stylesheet">
<script src="../js/zeyu.js"></script>
<script src="../bootstrap/js/mybootstrap.js"></script>
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
								href="../home.action">Exception</a>
						</div>

						<form class="navbar-form navbar-left navbar-form-search hidden-xs"
							role="search"
							action="${pageContext.request.contextPath}/search.action"
							method="get">
							<div class="input-group">
								<input type="hidden" name="flag" value="1" /> 
								<input type="hidden" name="page" value="1" /> 
								<input type="text" class="form-control " name="searchContent" id="search"
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
											<a href="${pageContext.request.contextPath }/user/account.jsp">
										</c:otherwise>
									</c:choose> <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>提问</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-flash"></span>快速手册</a></li>
								<li><a
									href="${pageContext.request.contextPath}/feedback.jsp"><span
										class="glyphicon glyphicon-wrench"></span>用户反馈</a></li>
										
									<c:choose>
									<c:when test="${uploadfage!=null}">
										<li><a
									href="${pageContext.request.contextPath}/user/uploadTest.action"><span
										class="glyphicon glyphicon-open"></span>题库管理</a></li>
										</c:when>
										
									</c:choose>
							</ul>
							<ul class="nav navbar-nav navbar-right">

								<c:choose>
									<c:when test="${user!=null}">
										<li><a href="${pageContext.request.contextPath }/user/settings.action" style="color: white;"><span
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
					<a href="settings.jsp" class="list-group-item current">个人资料</a> 
					<a href=" ${pageContext.request.contextPath }/user/mySearchRecords.action" class="list-group-item">我的搜索记录</a> 
					<a href="${pageContext.request.contextPath }/user/showMyCollection.action" class="list-group-item">我的收藏的文章</a>
					<a href=" ${pageContext.request.contextPath }/user/showMyAttention.action" class="list-group-item">我关注的问题</a>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-9">

				<div id="main" class="settings col-md-10 form-horizontal">
					<div class="row mt30">
						<div class="col-md-3 col-md-push-9">
							<img class="avatar-128"
								src="https://sf-static.b0.upaiyun.com/v-570cb5f2/global/img/user-256.png"
								alt="头像" style="width: 50%">
							<div class="change-avatar">
								<input type="file" id="avatarFile" name="avatar"
									class="file hide">
								<button type="button" id="avatarBtn"
									class="btn btn-default btn-sm mt10">修改头像</button>
								<p class="text-muted mt10">从电脑中选择图片上传, 图像大小不要超过 2 MB，长宽不要超过
									3000 px</p>
							</div>
							<div class="change-avatar loading hidden">上传中</div>
						</div>
						<div class="col-md-8 col-md-pull-3">
							<form
								action="${pageContext.request.contextPath}/user/settings.action"
								method="post">
								<div class="form-group">
									<label for="name" class="required control-label col-sm-3">用户名</label>
									<div class="col-sm-9">
										<input name="user_name" type="text" maxlength="32"
											placeholder="用户名唯一" class="form-control" value="好好先生_leo"
											required=""><span class="help-block mb0">用户名
											90 天内只能修改一次</span>
									</div>
								</div>
								<div class="form-group">
									<label for="setting-slug" name="user_cha_web"
										class="required control-label col-sm-3">个性网址</label>
									<div class="col-sm-9">
										<input name="slug" type="text" maxlength="32"
											id="setting-slug" placeholder="缩略名" data-do="checkUserSlug"
											class="form-control setting-slug" value="haohaoxiansheng_leo"
											required=""> <span class="error--slug ml10 hide">已存在</span><span
											class="help-block mb0">个性网址 90 天内只能修改一次</span>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3">性别</label>
									<div class="col-sm-9">
										<label class="radio-inline"><input name="gender"
											type="radio" id="sex-none" value="0"> 保密</label><label
											class="radio-inline"><input name="gender"
											type="radio" id="sex-male" value="1" checked=""> 男</label><label
											class="radio-inline"><input name="gender"
											type="radio" id="sex-female" name="user_sex" value="2">
											女</label>
									</div>
								</div>
								<div class="form-group">
									<label for="setting-birthday" class="control-label col-sm-3">生日</label>
									<div class="col-sm-9">
										<input name="user_birth" id="setting-birthday" type="text"
											placeholder="格式 YYYY-MM-DD" value="0000-00-00"
											class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label for="setting-city" class="control-label col-sm-3">现居城市</label>
									<div class="col-sm-9">
										<input type="text" class="form-control hidden" data-cities=""
											id="setting-city" placeholder="如：杭州，国外城市可填 “海外”">
										<div class="sf-typeHelper">
											<input type="text" data-role="sf_typeHelper-input"
												class="sf-typeHelper-input" placeholder="如：杭州，国外城市可填 “海外”"
												style="width: 16em;">
											<ul class="sf-typeHelper-list dropdown-menu"
												style="display: none;"></ul>
										</div>
										<input type="hidden" name="city" value="">
									</div>
								</div>
								<div class="form-group">
									<label for="setting-address" class="control-label col-sm-3">通讯地址</label>
									<div class="col-sm-9">
										<input name="address" id="setting-address" type="text"
											maxlength="32" placeholder="详细通讯地址" class="form-control"
											value=""><span class="help-block">此地址将用于寄送纪念品以及活动报名使用，不会公开给第三方</span>
									</div>
								</div>
								<div class="form-group">
									<label for="setting-homepage" class="control-label col-sm-3">个人网站</label>
									<div class="col-sm-9">
										<input name="homepage" id="setting-homepage" type="text"
											placeholder="http://example.com" value=""
											class="form-control mono">
									</div>
								</div>
								<div class="form-group">
									<label for="setting-description" class="control-label col-sm-3">自我简介</label>
									<div class="col-sm-9">
										<textarea name="description" id="setting-description"
											class="form-control mono" rows="6"></textarea>
									</div>
								</div>
								<div class="form-action row">
									<div class="col-sm-offset-3 col-sm-9">
										<button class="btn btn-xl btn-primary profile-sub"
											type="submit">提交</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!--/row-->
			</div>
			<!--/.col-xs-12.col-sm-9-->

			<!--/.sidebar-offcanvas-->
		</div>
	</div>
	<!-- 页脚 -->
	<footer class="footer">
		<iframe src="../foot.html" frameborder="0" scrolling="no"></iframe>
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
			url : "../auToList.action",
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