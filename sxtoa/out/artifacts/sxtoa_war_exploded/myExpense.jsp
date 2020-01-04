<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				$(".click").click(function() {
					$(".tip").fadeIn(200);
				});
				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});
				$(".sure").click(function() {
					$(".tip").fadeOut(100);
				});
				$(".cancel").click(function() {
					$(".tip").fadeOut(100);
				});
			});
		</script>

	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">我的报销</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>我的报销</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>编号</th>
						<th>报销总额</th>
						<th>报销时间</th>
						<th>总备注信息</th>
						<th>查看具体报销项</th>
						<th>查看所附图片</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="x" value="0"></c:set>
				<c:forEach items="${expenses}" var="ex">



					<tr>
						<td>
							<input name="" type="checkbox" value="" />
						</td>
						<td><c:out value="${x=x+1}"></c:out></td>
						<td>${ex.totalamount}</td>
						<td><fmt:formatDate value="${ex.exptime}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate> </td>
						<td>${ex.expdesc}</td>
						<td><a href="expenseDetail.jsp?expid=${ex.expid}" class="tablelink"> 查看具体报销项</a></td>
						<td> <a href="expenseImg.html" class="tablelink">查看所附图片</a></td>
						<td>${ex.lastResult}</td>
						<td><a href="#" class="tablelink">删除</a> <a href="auditingController?method=auditHistory&expid=${ex.expid}" class="tablelink">查看审核记录</a>  </td>

					</tr>
				</c:forEach>
				</tbody>
			</table>
 			<div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>