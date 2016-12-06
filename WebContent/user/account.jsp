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
<style type="text/css">
.btn-primary{
margin-left: 100px;
}
</style>
</head>

<body class="account-body">
	<div id="bg">
		<img src="../image/index.jpg" width="100%" height="100%" alt="">
	</div>
	<div class="header-style"></div>

	<div class="container">
		<div class="text-center">
			<a class="btn btn-link" style="text-decoration: none; color: #333;"
				href="../home.action"><h1 style="font-size: 50px;" class="white">Exception</h1></a>
			<p class="text-muted white">在这里，寻找属于你的解决方案</p>
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form action="${pageContext.request.contextPath}/user/login.action"
					method="post" class="form-signin">
					<input type="text" placeholder="用户名" name="user_name"
						class="form-control"> <input type="password"
						placeholder="密码" name="user_pass" class="form-control">
					<button class="btn text-muted text-center btn-primary"
						type="submit">会员登录</button>
				<!-- 	<a class="btn text-muted text-center btn-success"
						href="#phoneLogin" data-toggle="tab">手机登录</a> -->
				</form>
			</div>
			<div id="phoneLogin" class="tab-pane">
				<div class="form-signin">
					<input type="text" placeholder="手机号" class="form-control"
						name="user_tele" id="userphone" onblur="checkUserphone()" required>
					<button class="btn text-muted text-center btn-warning"
						onclick="sms_send()" type="submit"
						style="margin-top: 10px; width: 300px;">发送验证码</button>
					<input type="text" id="inputnum" placeholder="请输入收到的验证码"
						name="authCode" class="form-control">
					<div style="margin-top: 10px;">
						<button class="btn text-muted text-center btn-primary"
							type="submit" onclick="check_sms()">手机登录</button>
						<a class="btn text-muted text-center btn-success" href="#login"
							data-toggle="tab">会员登录</a>
					</div>
				</div>
			</div>
			<div id="forgot" class="tab-pane">
				<form
					action="${pageContext.request.contextPath}/user/fogertPass.action"
					method="post" class="form-signin">
					<input type="email" required="required" name="user_email"
						placeholder="请输入您注册时使用的邮箱..." class="form-control"> <br>
					<button class="btn text-muted text-center btn-danger" type="submit">重置密码</button>
				</form>
			</div>
			<div id="signup" class="tab-pane">
				<form
					action="${pageContext.request.contextPath}/user/register.action"
					method="post" class="form-signin">
					<input type="text" placeholder="用户名" name="user_name"
						class="form-control"> <input type="email" placeholder="邮箱"
						name="user_email" class="form-control"> <input
						type="password" placeholder="密码" name="user_pass"
						class="form-control"> <input type="password"
						placeholder="重复密码" name="user_pass_con" class="form-control">
					<button class="btn text-muted text-center btn-success"
						type="submit">注册</button>
				</form>
			</div>
		</div>
		<div class="text-center">
			<ul class="list-inline">
				<li class="active"><a class="text-muted" href="#login"
					data-toggle="tab">登录</a></li>
				<li class=""><a class="text-muted" href="#forgot"
					data-toggle="tab">忘记密码</a></li>
				<li class=""><a class="text-muted" href="#signup"
					data-toggle="tab">注册</a></li>
			</ul>
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
	<script type="text/javascript">
		smschar = '';
		function getRandomString(len) {
			len = len || 32;
			var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678'; // 默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1  
			var maxPos = $chars.length;
			var pwd = '';
			for (i = 0; i < len; i++) {
				pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
			}
			return pwd;
		}

		function trim(str) {
			var strnew = str.replace(/^\s*|\s*$/g, "");
			return strnew;
		}
		function sms_send() {
			var jbPhone = document.getElementById("userphone").value;
			smschar = getRandomString(6);
			if (checkUserphone()) {
				var para = document.createElement("a");
				para.target = "no-frame";
				para.href = "http://service.winic.org/sys_port/gateway/?id=mango4&pwd=x259779&time=1&to="
						+ jbPhone + "&content=" + smschar;
				para.click();
				alert("发送成功");
			}
			}

		function check_sms() {
			var inputnum = document.getElementById("inputnum").value
					.toLowerCase();
			var s = smschar.toLowerCase();
			if(s==""){
				alert("请点击按钮获取验证码");
			}else{
				
			
			if (s == inputnum) {
				$.ajax({
					url : "phoneLogin.action",
					data : "user_tele="
							+ document.getElementById("userphone").value,
					type : "POST",
					datatype : "text",
					
					success : function(result) {
						window.location.href = "../home.action";
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert(XMLHttpRequest.status);
						alert(XMLHttpRequest.readyState);
						alert(textStatus);
					}
				})
			} else {
				document.getElementById("wrong").style.display = "block";
			}
			}
		}

		function checkUserphone() {
			var jbPhone = document.getElementById("userphone").value;
		
			var re = /(^1[3|5|8][0-9]{9}$)/;
			if (trim(jbPhone) == "") {
				//alert(0);
				document.getElementById("userphone").setAttribute(
						"placeholder", "请输入您的手机号");
				return false;
			} else if (trim(jbPhone) != "") {
				if (!re.test(jbPhone)) {
					alert("请输入有效的手机号码");
					return false;
				}
				else {
					return true;
				}
			}
		}

		function b_hide() {
			document.getElementById("wrong").style.display = "none";
		}
	</script>
</body>

</html>

