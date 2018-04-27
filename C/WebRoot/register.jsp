<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<title>登录.云购物商城</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<head>


<link rel="shortcut icon" type="image/x-icon"
	href="img/icon/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/home.css">

<style>
/* 表示提示字的颜色 */
.error {

  /*   display:block;
    border:1px; */

	color: red;
	
	
	
}
</style>


<script src="js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript" src="js/login.js"></script>


</head>
<body>

	<header id="pc-header">
		<div class="center">
			<div class="pc-fl-logo">
				<h1>
					<a href="index.html"></a>
				</h1>
			</div>
		</div>
	</header>
	<section>
		<div class="pc-login-bj">
			<div class="center clearfix">
				<div class="fl"></div>
				<div class="fr pc-login-box">

					<div class="pc-login-title">
						<h2>用户注册</h2>
					</div>

					<!-- 使用到jquery.validate.js框架  myForm 看login.js  -->
					<form action="UserServlet?method=add" method="post" id="myForm">
						<div class="pc-sign">
							<input name="userName" placeholder="请输入用户名"><br />
						</div>

						<div class="pc-sign">
							<input id="pwd" name="passWord" type="password"
								placeholder="请输入密码"><br />
						</div>

						<div class="pc-sign">
							<input name="rePwd" type="password" placeholder="请再输入密码"><br />
						</div>

						<div class="pc-sign">
							<input name="email" placeholder="请再输入邮箱"><br />
						</div>

						<div class="pc-sign">
							<input name="phone" placeholder="请再输入手机"><br />
						</div>

						是否同意协议：<input name="context" type="checkbox"><br />

						<!-- <button type="submit">立即注册</button> -->

						<div class="pc-submit-ss">
							<input type="submit" value="立即注册">
						</div>

					</form>










					<!-- <form action="" method="post" id="myForm">
						<div class="pc-sign">
							<input name="userName" placeholder="邮箱/手机号">
						</div>
						<div class="pc-sign">
							<input name="password" placeholder="请输入您的密码">
						</div>
						<div class="pc-sign">
							<input name="password" placeholder="请确认您的密码">
						</div>
						<div class="pc-sign">
							<input type="password" placeholder="请输入您的验证码">
						</div>
						<div class="pc-submit-ss">
							<input type="submit" value="立即注册" placeholder="">
							<button type="submit">立即注册</button>
						</div> -->

					<div class="pc-item-san clearfix">
						<a href="#"><img src="img/icon/weixin.png" alt="">微信登录</a> <a
							href="#"><img src="img/icon/weibo.png" alt="">微博登录</a> <a
							href="#" style="margin-right:0"><img
							src="img/icon/tengxun.png" alt="">QQ登录</a>
					</div>
					<div class="pc-reg">

						<a href="login.jsp" class="red">如已有账号 请登录</a>



					</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<div class="center">
			<div class="pc-footer-login">
				<p>关于我们 招聘信息 联系我们 商家入驻 商家后台 商家社区 ©2017 Yungouwu.com 北京云购物网络有限公司</p>
				<p style="color:#999">营业执照注册号：990106000129004 |
					网络文化经营许可证：北网文（2016）0349-219号 | 增值电信业务经营许可证：京2-20110349 | 安全责任书 |
					京公网安备 99010602002329号</p>
			</div>
		</div>
	</footer>

</body>
</html>