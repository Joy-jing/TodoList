<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2019/12/28
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ToDoList-待办事项列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .text{text-align:center;}
    </style>
</head>
<body  class="text">
<h2>Todo&nbsp;&nbsp;<input type="text" id="title" name="title" placeholder="添加ToDo任务类型" required="required" autocomplete="off">
    <button type="button" class="btn btn-info">确定</button>
</h2>
<hr/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            任务类型
            <div class="row">
                <div class="col-md-3">

                </div>
                <div class="col-md-6">
                    <div class="list-group">
                        <a href="#" class="list-group-item disabled">
                            游戏
                        </a>
                        <a href="#" class="list-group-item">学习</a>
                        <a href="#" class="list-group-item">学习</a>
                        <a href="#" class="list-group-item">学习</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-9">任务列表
            <table class="table table-bordered" style="text-align:center">
                <tr>
                    <th>任务名称</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>备注</th>
                    <th>修改</th>
                    <th>删除</th>
                    <th>今日&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></th>
                    <th>重要&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span></th>
                </tr>
                <tr>
                    <th>任务名称</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>备注</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span></th>
                </tr>
                <tr>
                    <th>任务名称</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>备注</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span></th>
                </tr>
            </table>
            <nav aria-label="Page navigation" >
                <ul class="pagination pull-right">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<hr/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <div class="row">
                <div class="col-md-3">

                </div>
                <div class="col-md-6">
                    <div class="list-group">
                        <a href="#" class="list-group-item disabled">
                            今日任务
                        </a>
                        <a href="#" class="list-group-item disabled">
                            重要任务
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
