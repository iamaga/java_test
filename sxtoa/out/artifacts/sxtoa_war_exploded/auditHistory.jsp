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
		<script>
			$(function () {
				$("#back").click(function () {
					window.history.back();
                })
            })
		</script>

	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">查看审核记录</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>审核记录</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>审核人<i class="sort"><img src="images/px.gif" /></i></th>
						<th>审核结果</th>
						<th>审核意见</th>
						<th>审核时间</th>
					</tr>
				</thead>
				<tbody>

				<c:forEach items="${auditings}" var="au">
					<tr>
						<td>
							<input name="" type="checkbox" value="" />
						</td>
						<td>${au.realname}</td>

						<td>
							<c:choose>
								<c:when test="${au.result eq 2}">
									通过
								</c:when>
								<c:when test="${au.result eq 3}">
									驳回
								</c:when>
								<c:when test="${au.result eq 4}">
									打回
								</c:when>
								<c:when test="${au.result eq 5}">
									通过，已打款
								</c:when>
								<c:otherwise>
									审核处理异常
								</c:otherwise>
							</c:choose>
						</td>
						<td>${au.auditdesc}</td>
						<td>
							<fmt:formatDate value="${au.time}"	pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
	
					</tr>
				</c:forEach>
				</tbody>
			</table>

		</div>
		<input name="" type="button" id="back" class="btn" value="返回" />
		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');

		</script>
		
	</body>

</html>