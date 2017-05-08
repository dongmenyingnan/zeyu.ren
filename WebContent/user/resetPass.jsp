<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录 - Exception</title>
<link rel="icon" href="../image/favicon.png" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/magic.css" rel="styleshees" />
<link rel="stylesheet" href="../css/carousel.css" />
<link href="../css/account.css" rel="stylesheet" />
</head>

<body class="account-body">
	<div id="bg">
		<img src="../image/index.jpg" width="100%" height="100%" alt="">
	</div>
	<div class="header-style"></div>

	<div class="container">
		<div class="text-center">
			<a class="btn btn-link" style="text-decoration: none; color: #333;"
				href="../index.jsp"><h1 style="font-size: 50px;" class="white">Exception</h1></a>
			<p class="text-muted white">在这里，寻找属于你的解决方案</p>
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form
					action="${pageContext.request.contextPath}/user/resetPass.action"
					method="post" class="form-signin">
					<input type="password" placeholder="请输入密码" name="user_pass"
						class="form-control">
						<input type="password" placeholder="请输入确认密码" name="user_pass_con"
						class="form-control">
						 <input type="hidden" value="${user_id }" name="user_id" >
					<button class="btn text-muted text-center btn-primary"
						type="submit">点击重置密码</button>
				</form>
			</div>


		</div>

	</div>
	<!-- 页脚 -->
	<footer class="footer">
		<iframe src="../foot2.html" frameborder="0" scrolling="no"></iframe>
	</footer>


	<script src="../js/jquery-2.0.3.min.js"></script>
	<script src="../bootstrap/js/bootstrap.js"></script>
	<script>
		$(function() {

			$('.list-inline li > a').click(function() {
				var activeForm = $(this).attr('href') + ' > form';
				//console.log(activeForm);
				$(activeForm).addClass('magictime swap');
				//set timer to 1 seconds, after that, unload the magic animation
				setTimeout(function() {
					$(activeForm).removeClass('magictime swap');
				}, 1000);
			});
		});
	</script>
</body>

</html>

