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
				$.ajax({
					type:"get",
					url:"auditingController",
					data:"method=findMyAuditByEmpid",
					dataType:"json",
					success:function (datas) {
						for(var i in datas){
						    $("#auditBody").append('<tr>\n' +
                                '\t\t\t\t\t\t<td>\n' +
                                '\t\t\t\t\t\t\t<input name="" type="checkbox" value="" />\n' +
                                '\t\t\t\t\t\t</td>\n' +
                                '\t\t\t\t\t\t<td>'+datas[i].realname+'</td>\n' +
                                '\t\t\t\t\t\t<td>'+datas[i].totalamount+'</td>\n' +
                                '\t\t\t\t\t\t<td>'+datas[i].exptime+'</td>\n' +
                                '\t\t\t\t\t\t<td>'+datas[i].time+'</td>\n' +
                                '\t\t\t\t\t\t<td>'+datas[i].expdesc+'</td>\n' +
                                '\t\t\t\t\t\t<td><a href="expenseDetail.jsp?expid='+datas[i].expid+'" class="tablelink"> 查看具体报销项</a></td>\n' +
                                '\t\t\t\t\t\t<td> <a href="expenseImg.html" class="tablelink">查看所附图片</a></td>\n' +
                                '\t\t\t\t\t\t<td>'+datas[i].result+'</td>\n' +
                                '\t\t\t\t\t\t<td><a href="#" class="tablelink">删除</a> <a href="auditingController?method=auditHistory&expid='+datas[i].expid+'" class="tablelink">查看审核记录</a>  </td>\n' +
                                '\t\t\t\t\t</tr>')
						}
                    }
				})
            })
		</script>

	</head>

	<body>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">我的审核历史</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>我的审核</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>报销人<i class="sort"><img src="images/px.gif" /></i></th>
						<th>报销总额</th>
						<th>报销时间</th>
						<th>审核时间</th>
						<th>总备注信息</th>
						<th>查看具体报销项</th>
						<th>查看所附图片</th>
						<th>审核结果</th>
						<th>查看审核历史</th>
					</tr>
				</thead>
				<tbody id="auditBody">
				</tbody>
			</table>

		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>