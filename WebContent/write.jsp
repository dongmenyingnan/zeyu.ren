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
	
	<script type="text/javascript" src="./dist/js/lib/jquery-2.2.1.js"></script>
	<script type="text/javascript" src="./js/jquery.tagsinput.js"></script>


<!-- <link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/start/jquery-ui.css" /> -->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css"
	href="./dist/css/wangEditor.min.css">

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

		<!-- 页面 -->
		<!-- Nav tabs -->
		<header class="profile__heading" style="padding-bottom: 3%;">
			<div class="container"></div>
		</header>

		<div>
			<form action="${pageContext.request.contextPath}/user/write.action"
				method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">
						<span class="glyphicon glyphicon-question-sign"></span>题目
					</h4>
				</div>
				<div class="modal-body">
					<textarea class="form-control" style="resize: none;" rows="2"
						name="article_name" id="article_name" onKeyDown="LimitTextArea(this,50)"
						onKeyUp="LimitTextArea(this,50)"
						onkeypress="LimitTextArea(this,50)" placeholder="请在这里描述您的问题(50字内)"
						required="required"></textarea>
					<h5>内容</h5>
					<textarea class="form-control" style="height: 280px;" rows="10"
						name="article_content" id="article_content"
						onKeyDown="LimitTextArea(this,200)"
						onKeyUp="LimitTextArea(this,200)"
						onkeypress="LimitTextArea(this,200)"
						placeholder="请在这里描述您的问题(50字内)" required="required"></textarea>
					<h5>请输入标签</h5>
					<textarea id="tags_1" class="form-control" style="resize: none;"
						rows="1" name="article_tag" 
						onKeyDown="LimitTextArea(this,50)"
						onKeyUp="LimitTextArea(this,50)"
						onkeypress="LimitTextArea(this,50)"></textarea>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">提交文章</button>
				</div>
			</form>
		</div>


		</div>
		<!-- 页脚 -->
		<footer class="footer">
			<iframe src="foot.html" frameborder="0" scrolling="no"></iframe>
		</footer>
</body>

<!--这里引用jquery和wangEditor.js-->
<script type="text/javascript">
	var editor = new wangEditor('article_content');

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
			url : "./test/test.action",
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
	
			
			var str = $("#search").value;
			if (!$.trim(str).length <= 0)
				aoTuList(str);
		
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