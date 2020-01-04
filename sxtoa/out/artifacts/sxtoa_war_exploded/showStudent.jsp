<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/18
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            width: 60%;
            border: 1px solid seagreen;
            margin: 0px auto;
        }
        th,td{
            border: 1px solid salmon;
            text-align: center;
        }
        a {
            text-decoration: none;
        }
    </style>
    <script src="js/jquery.min.js"></script>
    <script>

    </script>
</head>
<body>
    <div style="margin-top:50px;font-size: 20px" align="center">
        姓名：<input type="text" id="stuname" value="${stuname}">
        年龄：<input type="text" id="stuage" value="${stuage}">
        <input type="button" value="查询" onclick="pagechange(1)">
    </div>
    <table cellspacing="0" cellpadding="0" style="margin-top: 20px">
        <tr>
            <th>学生编号</th>
            <th>学生姓名</th>
            <th>学生年龄</th>
            <th>学生性别</th>
            <th>照片</th>
            <th>照片类型</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${bean.list}" var="student">
        <tr>
            <td>${student.stuid}</td>
            <td>${student.stuname}</td>
            <td>${student.stuage}</td>
            <td>${student.stugender}</td>
            <td><img style="width: 50px ; height: 40px" src="upload/${student.filename}"></td>
            <td>${student.filetype}</td>
            <td><a href="fileDownload?filename=${student.filename}&filetype=${student.filetype}">下载</a></td>
        </tr>
        </c:forEach>
        <tr>
            <td style="text-align: center" colspan="7">
                <a href="javascript:void(0)" onclick="pagechange(${bean.currentpage-1})">上一页</a>
                <c:forEach begin="1" end="${bean.totalpage}" var="i">
                    <c:choose>
                        <c:when test="${bean.currentpage==i}">
                            <a href="javascript:void(0)" onclick="pagechange(${i})">[${i}]</a>
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:void(0)" onclick="pagechange(${i})">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <a href="javascript:void(0)" onclick="pagechange(${bean.currentpage+1})">下一页</a>
                &nbsp;&nbsp;
                一页显示<input type="text" style="width: 20px" id="size" value="${bean.size}">条
                &nbsp;&nbsp;
                总共${bean.totalpage}页
                &nbsp;&nbsp;
                总共${bean.totalsize}条
            </td>
        </tr>
    </table>
<script>
    function pagechange(currentpage) {
        alert(currentpage)
        if (currentpage>${bean.totalpage}){
            alert("已经是最后一页！")
            return;
        }
        if (currentpage<0){
            alert("已经是第一页！")
            return;
        }
        window.location.href="pageBeanController?currentpage="+currentpage+"&size="+$("#size").val()+"&stuname="+$("#stuname").val()+"&stuage="+$("#stuage").val();

    }
</script>
</body>
</html>
