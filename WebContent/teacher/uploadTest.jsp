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
<link href="../css/banneralert.css" rel="stylesheet">
<link href="../css/programme.css" rel="stylesheet">
<link rel="icon" href="../image/favicon.png">
<link href="../css/carousel.css" rel="stylesheet">

<!-- 标签 -->
<link rel="stylesheet" type="text/css" href="../css/jquery.tagsinput.css" />


		
	
	<script type="text/javascript" src="../dist/js/lib/jquery-2.2.1.js"></script>
	<script type="text/javascript" src="../js/jquery.tagsinput.js"></script>
		<script type="text/javascript" src="../js/ajaxfileupload.js"></script>

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
<script src="../js/banneralert.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
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
										<li><a
									href="${pageContext.request.contextPath}/teather/uploadTest.jsp" style="border-bottom: 3px solid white;"><span
										class="glyphicon glyphicon-open"></span>题库管理</a></li>
								
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

	<div class="que_manager_center">
	<div style="width: 70%; float: left;">
	
	<ul id="nav-tabs" class="nav nav-tabs">
  <li class="active"><a href="#home" data-toggle="tab">按知识点分类题库</a></li>
  <li><a href="#profile" data-toggle="tab">按章节分类题库</a></li>
  <li><a href="#messages" data-toggle="tab">按科目分类题库</a></li>
  <!-- <li><a href="#settings" data-toggle="tab">按课堂分类题库</a></li> -->
</ul>	
<div class="tab-content">
  <div class="tab-pane fade in active" id="home">
				<table class="table table-striped">
						<thead>
						<tr>
							<th>编号</th>
							<th>题库名字</th>
							<th>科目</th>
							<th>试题类型</th>
							<th>题库范围</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

														
									<c:forEach items="${questionsNew0}" var="questionsNew">

							<tr>
								<th scope="row">${questionsNew.questionbank_qid }</th>
								<td><a href="#">${questionsNew.questionbank_name }</a></td>
								<td>${questionsNew.questionbank_course }</td>
								<c:choose>
								<c:when test="${questionsNew.questionbank_type==0}">
									<td>单选</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==1}">
									<td>多选</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==2}">
									<td>简答</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==3}">
									<td>编程</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==4}">
									<td>填空</td>
								</c:when>
								</c:choose>
								
								
								<c:choose>
								<c:when test="${questionsNew.questionbank_scope==0}">
								<td>知识点</td>
								<input class="scope" type="hidden" value="0" />
								</c:when>
								<c:when test="${questionsNew.questionbank_scope==1}">
								<td>章节</td>
								<input  class="scope" type="hidden" value="1" />
								</c:when>
								<c:when test="${questionsNew.questionbank_scope==2}">
								<td>题目</td>
								<input  class="scope" type="hidden" value="2" />
								</c:when>
								</c:choose>
								<td style="width: 200px">	<button type="button" class="btn btn-success">查看</button>
								<button type="button" class="btn btn-warning">修改</button>
								<button type="button" class="btn btn-danger">删除</button></td>
							</tr>
			
					
						</c:forEach>
									

					</tbody>
					
				</table>
				<!--/row-->


			<div class="fy" >
						<div class="pageout">
								<c:forEach items="${PagesNew0}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/homeHotQuestions.action?page=${pagesNew.pageNum}&&searchContent=${searchContent}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
								</c:forEach>
							
						</div>
						<!--分页 end -->
						<input type="hidden" value="1" id="curPage">
					</div>


</div>
  <div class="tab-pane fade" id="profile">
			<table class="table table-striped">
						<thead>
						<tr>
							<th>编号</th>
							<th>题库名字</th>
							<th>科目</th>
							<th>试题类型</th>
							<th>题库范围</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

														
									<c:forEach items="${questionsNew1}" var="questionsNew">

							<tr>
								<th scope="row">${questionsNew.questionbank_qid }</th>
								<td><a href="#">${questionsNew.questionbank_name }</a></td>
								<td>${questionsNew.questionbank_course }</td>
								<c:choose>
								<c:when test="${questionsNew.questionbank_type==0}">
									<td>单选</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==1}">
									<td>多选</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==2}">
									<td>简答</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==3}">
									<td>编程</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==4}">
									<td>填空</td>
								</c:when>
								</c:choose>
								
								
								<c:choose>
								<c:when test="${questionsNew.questionbank_scope==0}">
								<td>知识点</td>
								<input class="scope" type="hidden" value="0" />
								</c:when>
								<c:when test="${questionsNew.questionbank_scope==1}">
								<td>章节</td>
								<input  class="scope" type="hidden" value="1" />
								</c:when>
								<c:when test="${questionsNew.questionbank_scope==2}">
								<td>题目</td>
								<input  class="scope" type="hidden" value="2" />
								</c:when>
								</c:choose>
								<td style="width: 200px">	<button type="button" class="btn btn-success">查看</button>
								<button type="button" class="btn btn-warning">修改</button>
								<button type="button" class="btn btn-danger">删除</button></td>
							</tr>
			
					
						</c:forEach>
									

					</tbody>
					
				</table>
				<!--/row-->


			<div class="fy" >
						<div class="pageout">
								<c:forEach items="${PagesNew1}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/homeHotQuestions.action?page=${pagesNew.pageNum}&&searchContent=${searchContent}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
								</c:forEach>
							
						</div>
						<!--分页 end -->
						<input type="hidden" value="1" id="curPage">
					</div>





</div>
  <div class="tab-pane fade" id="messages">
  			<table class="table table-striped">
						<thead>
						<tr>
							<th>编号</th>
							<th>题库名字</th>
							<th>科目</th>
							<th>试题类型</th>
							<th>题库范围</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

														
									<c:forEach items="${questionsNew2}" var="questionsNew">

							<tr>
								<th scope="row">${questionsNew.questionbank_qid }</th>
								<td><a href="#">${questionsNew.questionbank_name }</a></td>
								<td>${questionsNew.questionbank_course }</td>
				<c:choose>
								<c:when test="${questionsNew.questionbank_type==0}">
									<td>单选</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==1}">
									<td>多选</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==2}">
									<td>简答</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==3}">
									<td>编程</td>
								</c:when>
								<c:when test="${questionsNew.questionbank_type==4}">
									<td>填空</td>
								</c:when>
								</c:choose>
								
								
								<c:choose>
								<c:when test="${questionsNew.questionbank_scope==0}">
								<td>知识点</td>
								<input class="scope" type="hidden" value="0" />
								</c:when>
								<c:when test="${questionsNew.questionbank_scope==1}">
								<td>章节</td>
								<input  class="scope" type="hidden" value="1" />
								</c:when>
								<c:when test="${questionsNew.questionbank_scope==2}">
								<td>题目</td>
								<input  class="scope" type="hidden" value="2" />
								</c:when>
								</c:choose>
								<td style="width: 200px">	<button type="button" class="btn btn-success">查看</button>
								<button type="button" class="btn btn-warning">修改</button>
								<button type="button" class="btn btn-danger">删除</button></td>
							</tr>
			
					
						</c:forEach>
									

					</tbody>
					
				</table>
				<!--/row-->


			<div class="fy" >
						<div class="pageout">
								<c:forEach items="${PagesNew2}" var="pagesNew">
									<a ${pagesNew.style }
										href="${pageContext.request.contextPath}/homeHotQuestions.action?page=${pagesNew.pageNum}&&searchContent=${searchContent}&&flag=${pagesNew.flag}">${pagesNew.content }</a>
								</c:forEach>
							
						</div>
						<!--分页 end -->
						<input type="hidden" value="1" id="curPage">
					</div>
  
  
  
  </div>
<!--   <div class="tab-pane fade" id="settings">4...</div> -->
</div>

	</div>
	<div class="upload_que">
	<form role="form">
	<%-- ${pageContext.request.contextPath}/ask.action --%>
  <div class="form-group">
    <label for="exampleInputEmail1">题库范围</label>
    <div class="radio">
   <label class="checkbox-inline">
      <input type="radio" name="optionsRadiosinline" id="optionsRadios1" 
         value="0" > 知识点
   </label>
   <label class="checkbox-inline">
      <input type="radio" name="optionsRadiosinline" id="optionsRadios2" 
         value="1"> 章节
   </label>
   <label class="checkbox-inline">
      <input type="radio" name="optionsRadiosinline" id="optionsRadios3" 
         value="2">题目
   </label>
  </div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">题库题型</label>
       <div class="radio">
	    <label class="checkbox-inline">
	      <input type="radio" name="ques_type" id="optionsRadios3" 
	         value="0">单选
	   </label>
	   <label class="checkbox-inline">
	      <input type="radio" name="ques_type" id="optionsRadios4" 
	         value="1"> 多选
	   </label>
	   <label class="checkbox-inline">
	      <input type="radio" name="ques_type" id="optionsRadios5" 
	         value="2"> 简答
	   </label>
	       <label class="checkbox-inline" style="margin-left: 8px;">
	      <input type="radio" name="ques_type" id="optionsRadios3" 
	         value="3" > 编程
	   </label>
	   <label class="checkbox-inline" style="margin-left: 0px;margin-top: 10px;">
	      <input type="radio" name="ques_type" id="optionsRadios4" 
	         value="4"> 填空
	   </label>

  </div>
  </div>
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input  type="file" name="file" id="exampleInputFile">
    <p class="help-block">Example block-level help text here.</p>
  </div>

  <button type="button" class="btn btn-default" id="examUpload" onclick="ajaxFileUpload()">上传</button>
</form>	

	</div>
	</div>
	<script>

	//异步上传
	function ajaxFileUpload(){
		var val_scrope = $('input[name="optionsRadiosinline"]:checked ').val();
		var val_ques_type = $('input[name="ques_type"]:checked ').val();
		var val_file = $("#exampleInputFile").val();
		if(val_scrope==null){
			alert("请选择题库范围");
		}else if(val_ques_type==null){
			alert("请选择题型");
		}else if(val_file==""){
			alert("请选择上传的文件");
		}else{
		
	$.ajaxFileUpload({
		//处理文件上传操作的服务器端地址
		url: "../teacher/upload.action",
		secureuri:false,                       //是否启用安全提交,默认为false 
		data:{
			scrope:val_scrope,
			type:val_ques_type
		},
		fileElementId:'exampleInputFile',           //文件选择框的id属性
		dataType:'text',                       //服务器返回的格式,可以是json或xml等
		success:function(data, status){ //服务器响应成功时的处理函数
			ajaxTabCantent(val_scrope);
			setTimeout(
					function(){
						if(val_scrope==0){
							$("#nav-tabs").children().eq(0).attr("class","active");
							$("#nav-tabs").children().eq(1).attr("class","");
							$("#nav-tabs").children().eq(2).attr("class","");
						}else if(val_scrope==1){
							$("#nav-tabs").children().eq(1).attr("class","active");
							$("#nav-tabs").children().eq(0).attr("class","");
							$("#nav-tabs").children().eq(2).attr("class","");
						}else{
							$("#nav-tabs").children().eq(2).attr("class","active");
							$("#nav-tabs").children().eq(1).attr("class","");
							$("#nav-tabs").children().eq(0).attr("class","");	
						}
						$("body").showbanner({

							title : "jq22.com",

							icon : "images/icon.png",

							content : "底部横幅演示",

							position : "bottom"

						});
						
					},300)
	
			
				
		},
		error:function(data, status, e){
			//服务器响应失败时的处理函数
	
		}
	});
		}
	}
	$(".btn-danger").click(function(){
		var id = $(this).parent().parent().find("th").html();
		var scope=$(this).parent().parent().find(".scope").val();
		$.ajax({
			url:"../teacher/delete.action",
			type:"GET",
			cache:false,
			dataType:'text',  
			data:{
				qid:id,				
			},
			success:function(){
				ajaxTabCantent(scope);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
	             alert(XMLHttpRequest.status);
	             alert(XMLHttpRequest.readyState);
	             alert(textStatus);
	         }
			
		})
	})
	//异步刷新上传信息
	function ajaxTabCantent(scope){
		$.ajax({
			url:"../user/ajaxupload.action",
			type : "GET",
			cache:false,
			data:{
				scope:scope
			},
			success:function(msg){
				$(".tab-content").html(msg);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
	             alert(XMLHttpRequest.status);
	             alert(XMLHttpRequest.readyState);
	             alert(textStatus);
	         }
			
		});
		
	}
	
	
	
  $('#myTab a').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
  e.target // activated tab
  e.relatedTarget // previous tab
})
</script>
	
	
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