<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${scope==0}">
<div class="tab-pane fade in active" id="home">
				<table class="table table-striped">
						<thead>
						<tr>
							<th>编号</th>
							<th>题库名字</th>
							<th>科目</th>
							<th>试题类型</th>
							<th>题库类型</th>
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
							<th>题库类型</th>
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
							<th>题库类型</th>
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
  </c:when>
  <c:when test="${scope==1}">
<div class="tab-pane fade" id="home">
				<table class="table table-striped">
						<thead>
						<tr>
							<th>编号</th>
							<th>题库名字</th>
							<th>科目</th>
							<th>试题类型</th>
							<th>题库类型</th>
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

  <div class="tab-pane fade in active" id="profile">
			<table class="table table-striped">
						<thead>
						<tr>
							<th>编号</th>
							<th>题库名字</th>
							<th>科目</th>
							<th>试题类型</th>
							<th>题库类型</th>
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
							<th>题库类型</th>
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
  </c:when>
  <c:when test="${scope==2}">
<div class="tab-pane fade" id="home">
				<table class="table table-striped">
						<thead>
						<tr>
							<th>编号</th>
							<th>题库名字</th>
							<th>科目</th>
							<th>试题类型</th>
							<th>题库类型</th>
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
							<th>题库类型</th>
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
  <div class="tab-pane fade  in active" id="messages">
  			<table class="table table-striped">
						<thead>
						<tr>
							<th>编号</th>
							<th>题库名字</th>
							<th>科目</th>
							<th>试题类型</th>
							<th>题库类型</th>
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
  </c:when>
  </c:choose>
<!--   <div class="tab-pane fade" id="settings">4...</div> -->
<script type="text/javascript">
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


</script>
</body>
</html>