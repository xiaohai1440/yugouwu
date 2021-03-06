<%@page import="com.xh.util.Memcached"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%
		//MemcachedClient in = Memcached.getIn();
		
		
		//Memcached.getIn().set("user", 0,"小海");
		
		out.println(Memcached.getIn().get("user")+"xiaohai");
		
		/*Memcached.getIn().get("user");  */
		
		
	
		
		
		
		
	%>
	
	
	
	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>地址管理</title>

<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="../css/personal.css" rel="stylesheet" type="text/css">
<link href="../css/addstyle.css" rel="stylesheet" type="text/css">
<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"
	type="text/javascript"></script>
<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>

</head>

<body>
	<!--头 -->
	<header>
		<article>
			<div class="mt-logo">
				<!--顶部导航条 -->
				<div class="am-container header">
					<ul class="message-l">
						<div class="topMessage">
							<div class="menu-hd">
								<span>补充信息吧==>&nbsp;${sessionScope.user.loginName}</span> <input
									type="hidden" value="${sessionScope.user.loginName}"
									id="hiddenName"> <input type="hidden"
									value="${sessionScope.user.mobile}" id="hiddenMo">
							</div>
						</div>
					</ul>
					<ul class="message-r">
						<div class="topMessage home">
							<div class="menu-hd">
								<a href="#" target="_top" class="h">商城首页</a>
							</div>
						</div>
						<div class="topMessage my-shangcheng">
							<div class="menu-hd MyShangcheng">
								<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
							</div>
						</div>
						<div class="topMessage mini-cart">
							<div class="menu-hd">
								<a id="mc-menu-hd" href="#" target="_top"><i
									class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
									id="J_MiniCartNum" class="h">0</strong> </a>
							</div>
						</div>
						<div class="topMessage favorite">
							<div class="menu-hd">
								<a href="#" target="_top"><i
									class="am-icon-heart am-icon-fw"></i><span>收藏夹</span> </a>
							</div>
					</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logoBig">
						<li><img src="../images/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form>
							<input id="searchInput" name="index_none_header_sysc" type="text"
								placeholder="搜索" autocomplete="off"> <input
								id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
								type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			</div>
		</article>
	</header>

	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="#">首页</a></li>
				<li class="qc"><a href="#">闪购</a></li>
				<li class="qc"><a href="#">限时抢</a></li>
				<li class="qc"><a href="#">团购</a></li>
				<li class="qc last"><a href="#">大包装</a></li>
			</ul>
			<div class="nav-extra">
				<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利 <i
					class="am-icon-angle-right" style="padding-left: 10px;"></i>
			</div>
		</div>
	</div>
	<b class="line"></b>

	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="user-address">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small>
						</div>
					</div>
					<hr />

					<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails" id="AJAXaddress">




						<!--<li class="user-addresslist"><span class="new-option-r"><i
								class="am-icon-check-circle"></i>设为默认</span>
							<p class="new-tit new-p-re">
								<span class="new-txt">小叮当</span> <span class="new-txt-rd2">159****1622</span>
							</p>
							<div class="new-mu_l2a new-p-re">
								<p class="new-mu_l2cw">
									<span class="title">地址：</span> <span class="province"></span>
								</p>
							</div>
							<div class="new-addr-btn">
								<a href="#"><i class="am-icon-edit"></i>编辑</a> <span
									class="new-addr-bar">|</span> <a href="javascript:void(0);"
									onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>
							</div></li>
						 <li class="user-addresslist"><span class="new-option-r"><i
								class="am-icon-check-circle"></i>设为默认</span>
							<p class="new-tit new-p-re">
								<span class="new-txt">小叮当</span> <span class="new-txt-rd2">159****1622</span>
							</p>
							<div class="new-mu_l2a new-p-re">
								<p class="new-mu_l2cw">
									<span class="title">地址：</span> <span class="province">湖北</span>省
									<span class="city">武汉</span>市 <span class="dist">洪山</span>区 <span
										class="street">雄楚大道666号(中南财经政法大学)</span>
								</p>
							</div>
							<div class="new-addr-btn">
								<a href="#"><i class="am-icon-edit"></i>编辑</a> <span
									class="new-addr-bar">|</span> <a href="javascript:void(0);"
									onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>
							</div></li> -->
					</ul>

					
					<div class="clear"></div>
					<a class="new-abtn-type"
						data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加新地址</a>
					<!--例子-->
					<div class="am-modal am-modal-no-btn" id="doc-modal-1">

						<div class="add-dress">

							<!--标题 -->
							<div class="am-cf am-padding">
								<div class="am-fl am-cf">
									<strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small>
								</div>
							</div>
							<hr />

							<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
								<form class="am-form am-form-horizontal">

									<!-- <div class="am-form-group">
										<label for="user-name" class="am-form-label">收货人</label>
										<div class="am-form-content">
											<input type="text" id="user-name" placeholder="收货人">
										</div>
									</div>-->

									<!-- data-am-selected="{maxHeight: 300}" -->
									
									
									<div class="am-form-group">
										<label for="user-address" class="am-form-label">所在地</label>
										<div class="am-form-content address">
											<select id="opened1" onchange="openeds(this.value)">

											</select> <select id="opened2" onchange="openedss(this.value)">

											</select> <select id="opened3">

											</select>
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-intro" class="am-form-label">详细地址</label>
										<div class="am-form-content">
											<textarea class="" rows="3" id="user-intro"
												placeholder="输入详细地址"></textarea>
											<small>100字以内写出你的详细地址...</small>
										</div>
									</div>
									<div class="am-form-group">
										<label for="user-phone" class="am-form-label">备注信息</label>
										<div class="am-form-content">
											<input id="user-phone" placeholder="做个记号吧" type="email">
										</div>
									</div>

									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<a class="am-btn am-btn-danger">保存</a> <a
												href="javascript: void(0)"
												class="am-close am-btn am-btn-danger" data-am-modal-close>取消</a>
										</div>
									</div>
								</form>
							</div>

						</div>

					</div>

				</div>

				<script type="text/javascript">
					$(document).ready(
							function() {
								$(".new-option-r").click(
										function() {
											$(this).parent('.user-addresslist')
													.addClass("defaultAddr")
													.siblings().removeClass(
															"defaultAddr");
										});

								var $ww = $(window).width();
								if ($ww > 640) {
									$("#doc-modal-1").removeClass(
											"am-modal am-modal-no-btn");
								}

							});
				</script>

				<div class="clear"></div>

			</div>
			<!--底部-->
			<div class="footer">
				<div class="footer-hd">
					<p>
						<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
							href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
					</p>
				</div>
				<div class="footer-bd">
					<p>
						<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
							href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a
							href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
							- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
							target="_blank">网页模板</a> </em>
					</p>
				</div>
			</div>
		</div>

		<aside class="menu">
			<ul>
				<li class="person active"><a href="index.html"><i
						class="am-icon-user"></i>个人中心</a>
				</li>
				<li class="person">
					<p>
						<i class="am-icon-newspaper-o"></i>个人资料
					</p>
					<ul>
						<li><a href="information.html">个人信息</a></li>
						<li><a href="safety.html">安全设置</a></li>
						<li><a href="address.html">地址管理</a></li>
						<li><a href="cardlist.html">快捷支付</a></li>
					</ul>
				</li>
				<li class="person">
					<p>
						<i class="am-icon-balance-scale"></i>我的交易
					</p>
					<ul>
						<li><a href="order.html">订单管理</a></li>
						<li><a href="change.html">退款售后</a></li>
						<li><a href="comment.html">评价商品</a></li>
					</ul>
				</li>
				<li class="person">
					<p>
						<i class="am-icon-dollar"></i>我的资产
					</p>
					<ul>
						<li><a href="points.html">我的积分</a></li>
						<li><a href="coupon.html">优惠券 </a></li>
						<li><a href="bonus.html">红包</a></li>
						<li><a href="walletlist.html">账户余额</a></li>
						<li><a href="bill.html">账单明细</a></li>
					</ul>
				</li>

				<li class="person">
					<p>
						<i class="am-icon-tags"></i>我的收藏
					</p>
					<ul>
						<li><a href="collection.html">收藏</a></li>
						<li><a href="foot.html">足迹</a></li>
					</ul>
				</li>

				<li class="person">
					<p>
						<i class="am-icon-qq"></i>在线客服
					</p>
					<ul>
						<li><a href="consultation.html">商品咨询</a></li>
						<li><a href="suggest.html">意见反馈</a></li>

						<li><a href="news.html">我的消息</a></li>
					</ul>
				</li>
			</ul>

		</aside>
	</div>
	
	
	<script type="text/javascript">
		$(function() {// 初始化内容
				
			loadaddr();
			opened1();

		});
		function opened1() {
			var num = 0;
			$.ajax({
				url : "../pay",
				type : "post",
				data : {
					method : "downup",
					opened : "1"
				},
				success : function(data) {
					$("#opened1").html("");
					var data = $.parseJSON(data);
					$.each(data, function(i, addre) {
						$("#opened1").append(
								"<option value="+addre.provinceid+">"
										+ addre.province + "</option>");
										if(num==0){
										num = addre.provinceid;
										}
										
					});
					openeds(num);
				}
			
			});

		}
		function openeds(asd) {
		var num = 0;
			$.ajax({
				url : "../pay",
				type : "post",
				data : {
					method : "downup",
					opened : "2",
					num : asd
				},
				success : function(data) {
					$("#opened2").html("");
					var data = $.parseJSON(data);
					$.each(data, function(i, addre) {
						$("#opened2").append(
								"<option value="+addre.cityid+">" + addre.city
										+ "</option>");
										if(num==0){
										num = addre.cityid;
										}

					});
					if(data==null){
					openedss(num);
					}
					
				}

			});

		}
		function openedss(asd) {

			$.ajax({
				url : "../pay",
				type : "post",
				data : {
					method : "downup",
					opened : "3",
					num : asd
				},
				success : function(data) {
					$("#opened3").html("");
					var data = $.parseJSON(data);
					$.each(data, function(i, addre) {
						$("#opened3").append(
								"<option value="+addre.areaid+">" + addre.area
										+ "</option>");

					});

				}

			});
		}
		function loadaddr() {

			var num = 0;

			$
					.ajax({
						url : "../pay",
						type : "post",
						data : {
							method : "queryAddress"
						},
						success : function(data) {

							var data = $.parseJSON(data);

							$
									.each(
											data,
											function(i, addr) {
												var str = "";
												if (num == 0) {
													str += "<li class='user-addresslist defaultAddr'>";

												} else {
													str += "<li class='user-addresslist'>";
												}
												num++;
												$("#AJAXaddress")
														.append(
																str
																		+ "<span                                    "
																		+"class='new-option-r'><i class='am-icon-check-circle'></i>默认地址</span>                 "
																		+ "<p class='new-tit new-p-re' >                                                        "
																		+ "<span class='new-txt'>"
																		+ $(
																				"#hiddenName")
																				.val()
																		+ "</span> <span class='new-txt-rd2'>"
																		+ $(
																				"#hiddenMo")
																				.val()
																		+ "</span>        "
																		+ "</p>                                                                                 "
																		+ "<div class='new-mu_l2a new-p-re'>                                                    "
																		+ "<p class='new-mu_l2cw'>                                                              "
																		+ "<span class='title'>地址：</span> <span class='province'>"
																		+ addr.address
																		+ "</span>                                             "
																		+ "</p>                                                                                 "
																		+ "<p class='new-mu_l2cw'>                                                              "
																		+ "<span class='title'>备注：</span> <span class='province'>"
																		+ addr.remark
																		+ "</span>                                             "
																		+ "</p>                                                                                 "
																		+ "</div>                                                                               "
																		+ "<div class='new-addr-btn'>                                                           "
																		+ "<a href='#'><i class='am-icon-edit'></i>编辑</a> <span                                 "
																		+"class='new-addr-bar'>|</span> <a href='javascript:void(0);'                          "
																		+ "onclick='delClick(this);'><i class='am-icon-trash'></i>删除</a>                        "
																		+ "</div></li>                                                                          "

														);

											});
						},
						
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							alert(XMLHttpRequest.status);
							alert(XMLHttpRequest.readyState);
							alert(textStatus);
						}

					});
		}
	</script>
</body>

</html>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
