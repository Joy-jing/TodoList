<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2019/12/28
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
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
    <!-- 分页插件 -->
<%--    <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap-table/bootstrap-table.min.css">--%>
    <link href="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table.min.js"></script>
<%--    <script type="text/javascript" src="<%=basePath%>plugs/bootstrap-table/bootstrap-table.min.js"></script>--%>
<%--    <script type="text/javascript" src="<%=basePath%>plugs/bootstrap-table/bootstrap-table-locale-all.min.js"></script>--%>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table-locale-all.min.js"></script>
    <style>
        .text{text-align:center;}
    </style>
    <script>
        $(document).ready(function(){
            $("#add").click(function () {
                let title = $("#title").val();
                $.post("/todo/addTask",{title:title},function (response) {
                    console.log(response);
                    if(response.err_code == 2){
                        $("#err").html(response.err_msg);
                    }else{
                        var time = new Date();
                        // time1 = time.toLocaleString( );
                        $("#task:last").append("<tr>\n" +
                            "<th>"+title+"</th>\n" +
                            "<th>"+time.toLocaleString()+"</th>\n" +
                            "<th>结束时间</th>\n" +
                            "<th>null</th>\n" +
                            "<th>修改</th>\n" +
                            "<th>删除</th>\n" +
                            "<th>今日&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"glyphicon glyphicon-calendar\" aria-hidden=\"true\"></span></th>\n" +
                            "<th>重要&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"glyphicon glyphicon-star\" aria-hidden=\"true\"></span></th>\n" +
                            "</tr>");
                    }
                })
            });
            $("#addType").click(function () {
                let type = $("#type").val();
                $.post("/todo/addType",{type:type},function (response) {
                    console.log(response);
                    if (response.err_code==0){
                        $("#content:last").append("<li class=\"list-group-item\">"+type+"&nbsp;&nbsp;" +
                            "&nbsp;<a href=\"/todo/updateType\" id=\"updateType\"><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>&nbsp;&nbsp;</a>\n" +
                            "<a href=\"/todo/deleteType\" id=\"deleteType\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a>\n" +
                            "</li>");
                    }else{
                        alert(response.err_msg);
                    }
                });
            });
            //删除任务类型
            function dele(obj,id){
                alert("执行了吗");
                alert(id);
                var r=confirm("是否确认删除？");
                alert("确认删除嘛");
                if(r==true){
                    //确定执行删除
                    var id = id;
                    $.get("todo/deleteType?id="+id,function(data){});
                    return true;
                }
            }

            $("#updateType").click(function () {
                alert("可以修改了");
                let type = $("#content").val();
                $.post("/todo/updateType",function (response) {
                    alert("修改成功 ");
                })
            });

            $("#findType").click(function () {
                $.get("/todo/findType",function (response) {
                    console.log(response);
                    $("#content li").html("");
                    for(var i = 0;i<response.length;i++){
                        var p = response[i];
                        var id = p["typeId"];
                        var name = p["typeName"];
                        $("#content").append("<li class=\"list-group-item\">"+name+"<a href=\"/todo/updateType\" id=\"updateType\">" +
                            "<span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>&nbsp;&nbsp;</a>\n" +
                            "<a href=\"/todo/deleteType\" id=\"deleteType\" onclick='dele(p,id)'>" +
                            "<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></li>");

                    }
                });
            });
            $("#findAll").click(function () {
                $.get("/todo/findAll",function (response) {
                    console.log(response);
                    for(var i = 0;i<response.length;i++){
                        var task = response[i];
                        var id = task["taskId"];
                        var name = task["taskName"];
                        var startTime = task["startTime"];
                        var endTime = task["endTime"];
                        var remark = task["remark"];
                        // var taskMajor = task.taskMajor();
                        // var taskFinish = task.taskFinish();
                        // var typeId = task.typeId();
                        $("#task:last").append("<tr>\n" +
                            "<th>"+id+"</th>\n" +
                            "<th>"+name+"</th>\n" +
                            "<th>"+startTime+"</th>\n" +
                            "<th>"+endTime+"</th>\n" +
                            "<th>"+remark+"</th>\n" +
                            "<th><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span></th>"+
                            "<th><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></th>"+
                            "<th></th>"+
                            "<th></th>"+
                            "</tr>");
                    }
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
<%--                        <li></li>--%>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8"><button type="button" id="findAll">任务列表</button>
            <table id = "task"  class="table table-bordered" style="text-align:center">
                <tr>
                    <th>任务id</th>
                    <th>任务名称</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>备注</th>
                    <th>修改</th>
                    <th>删除</th>
                    <th>今日&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></th>
                    <th>重要&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span></th>
                </tr>
            </table>
            <!--分页-->
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <!--第一页-->
                    <li>
                        <c:choose>
                        <c:when test="${pageUtil.pageIndex - 1 > 0}">
                        <a href="/todo/findAll?pageIndex=1" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                        </c:when>
                        <c:otherwise>
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    </c:otherwise>
                    </c:choose>
                    </li>
                    <!--页数-->
                    <c:forEach var = "i" begin="1" end="${pageUtil.pageCount}" step="1">
                        <c:choose>
                            <c:when test="${pageUtil.pageIndex==i}">
                                <li class="active">
                                    <a href="/todo/findAll?pageIndex=${i}">${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/todo/findAll?pageIndex=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <!--尾页-->
                    <li>
                        <c:choose>
                        <c:when test="${pageUtil.pageIndex  < pageUtil.pageCount}">
                        <a href="/todo/findAll?pageIndex=${pageUtil.pageCount}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                        </c:when>
                        <c:otherwise>
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    </c:otherwise>
                    </c:choose>
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
