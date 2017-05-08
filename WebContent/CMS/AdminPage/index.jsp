<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./bootstrap.min.css">
<link rel="stylesheet" href="./adminPage.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.main-sidebar{
	position: absolute;
	top: 0;
	left: 0;
	height: 100%;
	min-height: 100%;
	width: 230px;
	z-index: 810;
	background-color: #222d32;
 }
</style>

</head>
<body>
<aside class="main-sidebar">
<section  class="sidebar">
	<ul class="sidebar-menu">
	  <li class="header">主导航</li>
	  <li class="treeview">
		<a href="#">
		  <i class="fa fa-dashboard"></i> <span>仪表盘</span> <i class="fa fa-angle-right pull-right"></i>
		</a>
		<ul class="treeview-menu">
		  <li><a href="#"><i class="fa fa-circle-o"></i> 仪表盘 v1</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 仪表盘 v2</a></li>
		</ul>
	  </li>
	  <li class="treeview">
		<a href="#">
		  <i class="fa fa-files-o"></i>
		  <span>布局选项</span>
		  <span class="label label-primary pull-right">4</span>
		</a>
		<ul class="treeview-menu" style="display: none;">
		  <li><a href="#"><i class="fa fa-circle-o"></i> 顶部导航</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 盒子布局</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 固定布局</a></li>
		  <li class=""><a href="#"><i class="fa fa-circle-o"></i> 折叠侧边栏</a>
		  </li>
		</ul>
	  </li>
	  <li>
		<a href="#">
		  <i class="fa fa-th"></i> <span>窗口小部件</span>
		  <small class="label pull-right label-info">新的</small>
		</a>
	  </li>
	  <li class="treeview">
		<a href="#">
		  <i class="fa fa-pie-chart"></i>
		  <span>图表</span>
		  <i class="fa fa-angle-right pull-right"></i>
		</a>
		<ul class="treeview-menu">
		  <li><a href="#"><i class="fa fa-circle-o"></i> ChartJS</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> Morris</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> Flot</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> Inline charts</a></li>
		</ul>
	  </li>
	  <li class="treeview">
		<a href="#">
		  <i class="fa fa-laptop"></i>
		  <span>UI 元素</span>
		  <i class="fa fa-angle-right pull-right"></i>
		</a>
		<ul class="treeview-menu">
		  <li><a href="#"><i class="fa fa-circle-o"></i> 一般</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> Icons图标</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 按钮</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 滑块</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 时间表</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 模态框</a></li>
		</ul>
	  </li>
	  <li class="treeview">
		<a href="#">
		  <i class="fa fa-edit"></i> <span>表单</span>
		  <i class="fa fa-angle-right pull-right"></i>
		</a>
		<ul class="treeview-menu">
		  <li><a href="#"><i class="fa fa-circle-o"></i> 一般表单</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 高级表单</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 可编辑表单</a></li>
		</ul>
	  </li>
	  <li class="treeview">
		<a href="#">
		  <i class="fa fa-table"></i> <span>表格</span>
		  <i class="fa fa-angle-right pull-right"></i>
		</a>
		<ul class="treeview-menu">
		  <li><a href="#"><i class="fa fa-circle-o"></i> 简单表格</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 时间表格</a></li>
		</ul>
	  </li>
	  <li>
		<a href="#">
		  <i class="fa fa-calendar"></i> <span>日历</span>
		  <small class="label pull-right label-danger">3</small>
		</a>
	  </li>
	  <li>
		<a href="#">
		  <i class="fa fa-envelope"></i> <span>邮箱</span>
		  <small class="label pull-right label-warning">12</small>
		</a>
	  </li>
	  <li class="treeview">
		<a href="#">
		  <i class="fa fa-folder"></i> <span>实例</span>
		  <i class="fa fa-angle-right pull-right"></i>
		</a>
		<ul class="treeview-menu">
		  <li><a href="#"><i class="fa fa-circle-o"></i> 清单</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 简况</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 登录</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 注册</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 锁频</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 404 错误</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 500 错误</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 空白页面</a></li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 自适应页面</a></li>
		</ul>
	  </li>
	  <li class="treeview">
		<a href="#">
		  <i class="fa fa-share"></i> <span>多级</span>
		  <i class="fa fa-angle-right pull-right"></i>
		</a>
		<ul class="treeview-menu">
		  <li><a href="#"><i class="fa fa-circle-o"></i> 一级</a></li>
		  <li>
			<a href="#"><i class="fa fa-circle-o"></i> 一级 <i class="fa fa-angle-right pull-right"></i></a>
			<ul class="treeview-menu">
			  <li><a href="#"><i class="fa fa-circle-o"></i> 二级</a></li>
			  <li>
				<a href="#"><i class="fa fa-circle-o"></i> 二级 <i class="fa fa-angle-right pull-right"></i></a>
				<ul class="treeview-menu">
				  <li><a href="#"><i class="fa fa-circle-o"></i> 三级</a></li>
				  <li><a href="#"><i class="fa fa-circle-o"></i> 三级</a></li>
				</ul>
			  </li>
			</ul>
		  </li>
		  <li><a href="#"><i class="fa fa-circle-o"></i> 一级</a></li>
		</ul>
	  </li>
	  <li><a href="#"><i class="fa fa-book"></i> <span>文档</span></a></li>
	  <li class="header">标签</li>
	  <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>重要</span></a></li>
	  <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>警告</span></a></li>
	  <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>通知</span></a></li>
	</ul>
  </section>
 </aside>




<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
<script src="./adminpage.js"></script>
<script>
$.sidebarMenu($('.sidebar-menu'))
</script>






</body>
</html>