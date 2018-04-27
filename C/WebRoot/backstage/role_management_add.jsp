
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            角色管理-添加
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
    </head>
    
    <body>
        <div class="x-body">
            <form action="" method="post" class="layui-form layui-form-pane">
                <div class="layui-form-item">
                    <label for="name" class="layui-form-label">
                        <span class="x-red">*</span>用户名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="name" required lay-verify="required"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="name" class="layui-form-label">
                        <span class="x-red">*</span>角色职称
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="name" required lay-verify="required"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">
                        拥有权限
                    </label>
                    <table  class="layui-table layui-input-block">
                        <tbody>
                            <tr>
                                <td width="10%">
                                    用户管理
                                </td>
                                <td width="81%">
                                    <div class="layui-input-block">
                                        <input name="id[]" type="checkbox" value="2"> 用户停用
                                        <input name="id[]" type="checkbox" value="2"> 用户删除
                                        <input name="id[]" type="checkbox" value="2"> 用户修改
                                        <input name="id[]" type="checkbox" value="2"> 用户改密
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    文章管理
                                </td>
                                <td>
                                    <div class="layui-input-block">
                                        <input name="id[]" type="checkbox" value="2"> 
                                        添加
                                        <input name="id[]" type="checkbox" value="2"> 
                                        删除
                                        <input name="id[]" type="checkbox" value="2"> 
                                        修改
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>后台登录</td>
                                <td>
                                    <div class="layui-input-block">
                                        <input name="id[]" type="checkbox" value="2"> 
                                        登录
                                        
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>人格测试</td>
                                <td>
                                    <div class="layui-input-block">
                                        <input name="id[]" type="checkbox" value="2"> 
                                        保存
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    数据管理
                                </td>
                                <td>
                                    <div class="layui-input-block">
                                        <input name="id[]" type="checkbox" value="2"> 
                                        编辑
                                        <input name="id[]" type="checkbox" value="2"> 
                                        删除
                                        <input name="id[]" type="checkbox" value="2"> 
                                        批量删除
                                        <input name="id[]" type="checkbox" value="2"> 
                                        批量导出
                                        <input name="id[]" type="checkbox" value="2"> 
                                        导出
                                        <input name="id[]" type="checkbox" value="2"> 
                                        搜素
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    用户管理
                                </td>
                                <td>
                                    <div class="layui-input-block">
                                        <input name="id[]" type="checkbox" value="2"> 
                                        刷新
                                        <input name="id[]" type="checkbox" value="2"> 
                                        删除
                                        <input name="id[]" type="checkbox" value="2"> 
                                        编辑
                                        <input name="id[]" type="checkbox" value="2"> 
                                        添加
                                        <input name="id[]" type="checkbox" value="2"> 
                                        修改密码
                                        <input name="id[]" type="checkbox" value="2"> 
                                        下载用户模板
                                        <input name="id[]" type="checkbox" value="2"> 
                                        导出用户模板
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    网站信息管理
                                </td>
                                <td>
                                    <div class="layui-input-block">
                                        <input name="id[]" type="checkbox" value="2"> 
                                        首页
                                        <input name="id[]" type="checkbox" value="2"> 
                                        关于我们
                                        <input name="id[]" type="checkbox" value="2"> 
                                        心里新闻
                                        <input name="id[]" type="checkbox" value="2"> 
                                        资源下载
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label for="desc" class="layui-form-label">
                        备注
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" id="desc" name="desc" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="save">保存</button>
                <button class="layui-btn" lay-submit="" lay-filter="cancel">取消</button>
              </div>
            </form>
        </div>
        <script src="./lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="./js/x-layui.js" charset="utf-8">
        </script>
        <script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;

              //监听提交
              form.on('submit(save)', function(data){
                console.log(data);
                //发异步，把数据提交给php
                layer.alert("保存成功", {icon: 6},function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                });
                return false;
              });
            });
			
        </script>
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