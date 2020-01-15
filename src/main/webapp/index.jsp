<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2019/12/28
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- 分页插件 -->
    <link href="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table-locale-all.min.js"></script>
    <style>
        .text {
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function deleteTask(obj) {
            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            $.post("todo/deleteTask/" + id, function (response) {
                console.log(response);
                if (response.err_code == 1) {
                    $(obj).parent().parent().remove();
                } else {
                    alert("删除失败");
                }
            });
        }
        function deleteType(obj) {
            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            $.post("todo/deleteType/" + id, function (response) {
                console.log(response);
                if (response.err_code == 1) {
                    $(obj).parent().parent().remove();
                } else {
                    alert("删除失败");
                }
            });
        }
        function updateType(obj) {
            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            $("#type_update_btn").click(function () {
                let typeName = $("#type_update").val();
                $("#typeUpdateModal").modal('hide');
                $.post("/todo/updateType/" + id,{typeName:typeName}, function (response) {
                    console.log(response);
                    if (response.err_code == 1) {
                        $(obj).parent("th").parent("tr").find("th:nth-child(2)").empty();
                        $(obj).parent("th").parent("tr").find("th:nth-child(2)").html(typeName);
                    } else {
                        alert("更新失败");
                    }
                });
            });
        }
        function updateTask(obj) {
            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            $("#task_update_btn").click(function () {
                let taskName = $("#task_update").val();
                let remark = $("#remark_update").val();
                $("#taskUpdateModal").modal('hide');
                $.post("/todo/updateTask/" + id,{taskName:taskName,remark:remark}, function (response) {
                    console.log(response);
                    if (response.err_code == 1) {
                        $(obj).parent("th").parent("tr").find("th:nth-child(2)").empty();
                        $(obj).parent("th").parent("tr").find("th:nth-child(2)").html(taskName);
                        $(obj).parent("th").parent("tr").find("th:nth-child(5)").empty();
                        $(obj).parent("th").parent("tr").find("th:nth-child(5)").html(remark);
                    } else {
                        alert("更新失败");
                    }
                });
            });

        }

        function addMajor(obj){
            $(obj).attr('disabled','disabled');
            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            var taskName="";
            taskName += $(obj).parent("th").parent("tr").find("th:nth-child(2)").text();
            $("#major").append("<tr>\n" +
                "<th>"+id+"</th>\n" +
                "<th>"+taskName+"</th></tr>");
        }
        function delMajor(obj) {
            $("#b1").removeAttr('disabled','disabled');
            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            $("#major tr").each(function(){
                var text = $(this).children("th:first").text();
                if(id==text){
                    $(this).remove();
                }
            })
        }
        function addToday(obj){
            $(obj).attr('disabled','disabled');
            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            var taskName="";
            taskName += $(obj).parent("th").parent("tr").find("th:nth-child(2)").text();
            $("#today").append("<tr>\n" +
                "<th>"+id+"</th>\n" +
                "<th>"+taskName+"</th></tr>");
        }
        function delToday(obj) {
            $("#").removeAttr('disabled','disabled');

            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            $("#today tr").each(function(){
                var text = $(this).children("th:first").text();
                if(id==text){
                    $(this).remove();
                }
            })
        }
        function selectTaskType(obj){
            var id = "";
            id += $(obj).parent("th").parent("tr").find("th:first-child").text();
            $.get("/todo/findTaskType/" + id, function (response) {
                console.log(response);
                alert("...");
                $("#task tr").not(':eq(0)').empty();
                for (var i = 0; i < response.length; i++) {
                    var task = response[i];
                    var id = task["taskId"];
                    var name = task["taskName"];
                    var startTime = task["startTime"];
                    var endTime = task["endTime"];
                    var remark = task["remark"];
                    $("#task").append("<tr>\n" +
                        "<th id='id'>" + id + "</th>\n" +
                        "<th>" + name + "</th>\n" +
                        "<th>" + startTime + "</th>\n" +
                        "<th>" + endTime + "</th>\n" +
                        "<th>" + remark + "</th>\n" +
                        "<th><a class='btn btn-default' onclick='updateTask(this)' data-toggle=\"modal\" data-target='#taskUpdateModal'><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></a></span></th>" +
                        "<th><a class='btn btn-default' onclick='deleteTask(this)'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
                        "<th><a class='btn btn-default' onclick='addToday(this)' id='b3'><span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span></a>" +
                        "<a class='btn btn-default' onclick='delToday(this)' id='b4'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
                        "<th><a class='btn btn-default' onclick='addMajor(this)' id='b1'><span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span></a>" +
                        "<a class='btn btn-default' onclick='delMajor(this)' id='b2'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
                        "</tr>");
                }
            });
        }
        $(document).ready(function () {
            $("#add").click(function () {
                let title = $("#title").val();
                $.post("/todo/addTask", {title: title}, function (response) {
                    console.log(response);
                    if (response.err_code == 2) {
                        $("#err").html(response.err_msg);
                    } else {
                        var time = new Date();
                        $("#task:last").append("<tr>\n" +
                            "<th>" + id + "</th>\n" +
                            "<th>" + title + "</th>\n" +
                            "<th>" + time.toLocaleString() + "</th>\n" +
                            "<th>结束时间</th>\n" +
                            "<th>null</th>\n" +
                            "<th><a class='btn btn-default' onclick='updateTask(this)' data-toggle=\"modal\" data-target='#taskUpdateModal'><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></a></span></th>" +
                            "<th><a class='btn btn-default' onclick='deleteTask(this)'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
                            "<th>今日&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"glyphicon glyphicon-calendar\" aria-hidden=\"true\"></span></th>\n" +
                            "<th>重要&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"glyphicon glyphicon-star\" aria-hidden=\"true\"></span></th>\n" +
                            "</tr>");
                    }
                })
            });
            $("#addType").click(function () {
                let type = $("#type").val();
                $.post("/todo/addType", {type: type}, function (response) {
                    console.log(response);
                    if (response.err_code == 0) {
                        $("#t1:last").append("<tr>\n" +
                            "<th>"+1+"</th>\n" +
                            "<th>"+type+"</th>" +
                            "<th><a class='btn btn-default' onclick='updateType(this)' data-toggle=\"modal\" data-target='#typeUpdateModal'>" +
                            "<span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>&nbsp;&nbsp;</a>\n</th>"+
                            "<th><a class='btn btn-default' onclick='deleteType(this)'>" +
                            "<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>&nbsp;&nbsp;</a>\n</th>"+
                            "</tr>");
                    } else {
                        alert(response.err_msg);
                    }
                });
            });
            $("#findType").click(function () {
                $.get("/todo/findType", function (response) {
                    console.log(response);
                    $("#t1 tr").not(':eq(0)').empty();
                    for (var i = 0; i < response.length; i++) {
                        var p = response[i];
                        var id = p["typeId"];
                        var name = p["typeName"];
                        $("#t1").append("<tr>\n" +
                            "<th>"+id+"</th>\n" +
                            "<th><a onclick='selectTaskType(this)'</a>"+name+"</th>" +
                            "<th><a class='btn btn-default' onclick='updateType(this)' data-toggle=\"modal\" data-target='#typeUpdateModal'>" +
                            "<span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>&nbsp;</a>\n</th>"+
                            "<th><a class='btn btn-default' onclick='deleteType(this)'>" +
                            "<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>&nbsp;</a>\n</th>"+
                            "</tr>");
                    }
                });
            });
            // $("#findAll").click(function () {
            //     $.get("/todo/findAll", function (response) {
            //         console.log(response);
            //         for (var i = 0; i < response.length; i++) {
            //             var task = response[i];
            //             var id = task["taskId"];
            //             var name = task["taskName"];
            //             var startTime = task["startTime"];
            //             var endTime = task["endTime"];
            //             var remark = task["remark"];
            //             $("#task:last").append("<tr>\n" +
            //                 "<th id='id'>" + id + "</th>\n" +
            //                 "<th>" + name + "</th>\n" +
            //                 "<th>" + startTime + "</th>\n" +
            //                 "<th>" + endTime + "</th>\n" +
            //                 "<th>" + remark + "</th>\n" +
            //                 "<th><a class='btn btn-default' onclick='updateTask(this)' data-toggle=\"modal\" data-target='#taskUpdateModal'><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></a></span></th>" +
            //                 "<th><a class='btn btn-default' onclick='deleteTask(this)'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
            //                 "<th><a class='btn btn-default' onclick='addToday(this)' id='b3'><span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span></a>" +
            //                 "<a class='btn btn-default' onclick='delToday(this)' id='b4'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
            //                 "<th><a class='btn btn-default' onclick='addMajor(this)' id='b1'><span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span></a>" +
            //                 "<a class='btn btn-default' onclick='delMajor(this)' id='b2'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
            //                 "</tr>");
            //         }
            //     });
            // });
            $("#findAll").click(function () {
                $.get("/todo/findPage", function (response) {
                    console.log(response);
                    $("#task tr").not(':eq(0)').empty();
                    for (var i = 0; i < response.length; i++) {
                        var task = response[i];
                        var id = task["taskId"];
                        var name = task["taskName"];
                        var startTime = task["startTime"];
                        var endTime = task["endTime"];
                        var remark = task["remark"];
                        $("#task:last").append("<tr>\n" +
                            "<th id='id'>" + id + "</th>\n" +
                            "<th>" + name + "</th>\n" +
                            "<th>" + startTime + "</th>\n" +
                            "<th>" + endTime + "</th>\n" +
                            "<th>" + remark + "</th>\n" +
                            "<th><a class='btn btn-default' onclick='updateTask(this)' data-toggle=\"modal\" data-target='#taskUpdateModal'><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></a></span></th>" +
                            "<th><a class='btn btn-default' onclick='deleteTask(this)'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
                            "<th><a class='btn btn-default' onclick='addToday(this)' id='b3'><span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span></a>" +
                            "<a class='btn btn-default' onclick='delToday(this)' id='b4'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
                            "<th><a class='btn btn-default' onclick='addMajor(this)' id='b1'><span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span></a>" +
                            "<a class='btn btn-default' onclick='delMajor(this)' id='b2'><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></th>" +
                            "</tr>");
                    }
                });
            });

        });
    </script>
</head>
<body class="text">
<div class="modal fade" id="typeUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title">修改任务类型</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">taskName</label>
                        <div class="col-sm-10">
                            <input type="text" name="task_update" class="form-control" id="type_update"
                                   placeholder="任务名称">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="type_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<br/>
<div class="modal fade" id="taskUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title">修改任务</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">taskName</label>
                        <div class="col-sm-10">
                            <input type="text" name="task_update" class="form-control" id="task_update"
                                   placeholder="任务名称">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">remark</label>
                        <div class="col-sm-10">
                            <input type="text" name="remark" class="form-control" id="remark_update" placeholder="备注信息">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="task_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">Todo</label>
            <div class="col-sm-6">
                <input type="text" id="title" class="form-control" name="title" placeholder="添加ToDo任务"
                       required="required" autocomplete="off">
            </div>
            <div class="col-sm-1">
                <button type="button" class="btn btn-info" id="add">确定</button>
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
                <input type="text" id="type" class="form-control" name="title" placeholder="添加任务类型" required="required"
                       autocomplete="off">
                <button type="button" class="btn btn-info" id="addType">确定</button>
            </form>
            <div class="row">
                <div class="col-md-3">
                </div>
                <div class="col-md-6">
                    <ul class="list-group" id="content">
                        <button type="button" class="list-group-item" id="findType">
                            查询任务类型
                        </button>
                        <table id="t1" class="table table-bordered">

                        </table>

                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <button type="button" class="btn btn-default" id="findAll">任务列表</button>
            <table id="task" class="table table-bordered" style="text-align:center">
                <tr>
                    <th>任务id</th>
                    <th>任务名称</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>备注</th>
                    <th>修改</th>
                    <th>删除</th>
                    <th>今日&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                    </th>
                    <th>重要&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span></th>
                </tr>
            </table>
            <!--分页-->
            <!--分页-->
            <jsp:useBean id="pageUtil" scope="request" class="cn.neu.jing.util.Page"/>
            <nav aria-label="Page navigation pull right">
                <ul class="pagination">
                    <!--第一页-->
                    <li>
                        <c:choose>
                        <c:when test="${pageUtil.pageIndex - 1 > 0}">
                        <a href="/todo?pageIndex=1" aria-label="Previous">
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
                                    <a href="todo?pageIndex=${i}">${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="todo?pageIndex=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <!--尾页-->
                    <li>
                        <c:choose>
                        <c:when test="${pageUtil.pageIndex  < pageUtil.pageCount}">
                        <a href="todo?pageIndex=${pageUtil.pageCount}" aria-label="Next">
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
        <div class="col-md-5">
            <ul class="list-group" >
                <li class="list-group-item">今日任务</li>
                <span class="help-block"></span>
                <table class="table table-bordered" style="text-align:center" id="today">
                </table>
            </ul>
        </div>
        <div class="col-md-1">
        </div>
        <div class="col-md-5">
            <ul class="list-group">
                <li class="list-group-item">重要任务</li>
                <span class="help-block"></span>
                <table class="table table-bordered" style="text-align:center" id="major">

                </table>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
