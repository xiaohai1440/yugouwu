﻿

<!-- 这个是主页的页面 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            index
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
    </head>
    <body>
        <div class="layui-layout layui-layout-admin">
            <div class="layui-header header header-demo">
                <div class="layui-main">
                    <a class="logo" href="./index.jsp">
                   <img src="images/banner2.png"></img>
                    </a>
                    <ul class="layui-nav" lay-filter="">
                      <li class="layui-nav-item"><img src="images/0.jpg" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
                      <li class="layui-nav-item">
                        <a href="javascript:;">admin</a>
                        <dl class="layui-nav-child"> <!-- 二级菜单 -->
                          <dd><a href="#">个人信息</a></dd>
                          <dd><a href="#">切换帐号</a></dd>
                          <dd><a href="./login.jsp">退出</a></dd>
                        </dl>
                      </li>
                      <!-- <li class="layui-nav-item">
                        <a href="" title="消息">
                            <i class="layui-icon" style="top: 1px;">&#xe63a;</i>
                        </a>
                        </li> -->
                      <li class="layui-nav-item x-index"><a href="../网页/index.jsp">前台首页</a></li>
                    </ul>
                </div>
            </div>
            <div class="layui-side layui-bg-black x-side">
                <div class="layui-side-scroll">
                    <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
                    <!--数据管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="main.jsp">
                               <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>数据管理</cite>
                            </a>
                      <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="Warning_management.jsp">
                                           <cite>预警信息管理</cite>
                                        </a>
                              </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="Data_management.jsp">
                                            <cite>数据管理</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="shujutongji.jsp">
                                            <cite>数据统计</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
                        <!--用户管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="User_management.jsp">
                                <i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>用户管理</cite>
                            </a>
                        </li>
                        <!--角色管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="Role_management.jsp">
                                <i class="layui-icon" style="top: 3px;">&#xe612;</i><cite>角色管理</cite>
                            </a>
                        </li>
                        <!--网站信息管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>网站信息管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="Home.jsp">
                                            <i class="layui-icon"></i><cite>首页</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="About_us.jsp">
                                            <i class="layui-icon"></i><cite>关于我们</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="../NewsServlet?method=getAllNews">
                                            <i class="layui-icon"></i><cite>新闻大爆料</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="Download.jsp">
                                            <i class="layui-icon"></i><cite>资源下载</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </div>

            </div>
            <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
                <div class="x-slide_left"></div>
                <ul class="layui-tab-title">
                    <li class="layui-this">
                        数据管理
                        <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
                    </li>
                </ul>
                <div class="layui-tab-content site-demo site-demo-body">
                    <div class="layui-tab-item layui-show">
                        <iframe frameborder="0" src="main.jsp" class="x-iframe"></iframe>
                    </div>
                </div>
            </div>
            <div class="site-mobile-shade">
            </div>
        </div>
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script src="./js/x-admin.js"></script>
        <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>
</html>