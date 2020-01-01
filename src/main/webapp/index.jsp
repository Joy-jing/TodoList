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
    <script>
        $(document).ready(function(){
            $("#add").click(function () {
                // alert("我被电击了");
                let title = $("#title").val();
                // alert(title);
                $.post("/todo/addTask",{title:title},function (response) {
                    alert("到这里了吗");
                    if(response.err_code == 1){
                        alert(response.err_msg);
                        $("#err").html(response.err_msg);
                    }else{
                        $("#task").html("<tr>\n" +
                            "                    <th>title</th>\n" +
                            "                    <th>开始时间</th>\n" +
                            "                    <th>结束时间</th>\n" +
                            "                    <th>备注</th>\n" +
                            "                    <th>修改</th>\n" +
                            "                    <th>删除</th>\n" +
                            "                    <th>今日&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"glyphicon glyphicon-calendar\" aria-hidden=\"true\"></span></th>\n" +
                            "                    <th>重要&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"glyphicon glyphicon-star\" aria-hidden=\"true\"></span></th>\n" +
                            "                </tr>");
                    }
                })
            });
            $("#addType").click(function () {
                let type = $("#type").val();
                $.post("/todo/addType",{type:type},function (response) {
                    console.log(response);

                    if (response.err_code=1){
                        $("#content:last").append("<li class=\"list-group-item\">response.data&nbsp;&nbsp;\n" +
                            "                            &nbsp;<a href=\"/todo/updateType\" id=\"updateType\"><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>&nbsp;&nbsp;</a>\n" +
                            "                            <a href=\"/todo/deleteType\" id=\"deleteType\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a>\n" +
                            "                        </li>");
                    }else{
                        alert(response.err_msg);
                    }
                });
            });

            $("#updateType").click(function () {
                alert("可以修改了");
                let type = $("#content").val();
                $.post("/todo/updateType",function (response) {
                    alert("修改成功 ");
                })
            });

            $("#findType").click(function () {
                // alert("可以查询了");
                $.get("/todo/findType",function (response) {
                    let list = response.data.list;
                    // $.each(list,function () {
                    //
                    // })
                    alert("查询成功");
                });
            });
        });


    </script>
</head>
<body class="text">
<br/>
<div class = "row">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">Todo</label>
                <div class="col-sm-6">
                    <input type="text" id="title" class="form-control" name="title" placeholder="添加ToDo任务" required="required" autocomplete="off">
                </div>
                <div class="col-sm-1">
                    <button type="button" class="btn btn-info" id = "add">确定</button>
                </div>
                <label class="col-sm-2 control-label" id="err"></label>
            </div>
        </form>
</div>
<hr/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <form class="form-horizontal">
                <input type="text" id="type" class="form-control" name="title" placeholder="添加任务类型" required="required" autocomplete="off">
<%--                <a href="/todo/addType" id="addType">确定</a>--%>
                <button type="button" class="btn btn-info" id="addType">确定</button>
            </form>
            <div class="row">
                <div class="col-md-3">
                </div>
                <div class="col-md-6">
                    <div class="list-group" id = "content">
                        <button type="button" class="list-group-item" id="findType">
                            查询任务类型
                        </button>
                        <li class="list-group-item">学习&nbsp;&nbsp;
                            &nbsp;<a href="/todo/updateType" id="updateType"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;&nbsp;</a>
                            <a href="/todo/deleteType" id="deleteType"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                        </li>
                        <li  class="list-group-item"  >学习</li>
                        <li  class="list-group-item">学习</li>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8">任务列表
            <table id = "task"  class="table table-bordered" style="text-align:center">
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
