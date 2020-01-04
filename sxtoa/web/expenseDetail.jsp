<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                show()
            })
            function show() {

				var id = ${param.expid};
                console.log("expid:"+id)
				$.ajax({
                    type:"get",
                    url:"expenseController",
                    data:"method=findExpenseitems&expid="+id,
                    dataType:"json",
                    success:function (datas) {

                        console.log(datas)
						for(var i in datas){
                            typeof (datas[i].itemid == undefined)?2:3
						$("#itembody").append('<tr>\n' +
                            '\t\t\t\t\t\t<td><input name="" type="checkbox" value="" /></td>\n' +
                            '\t\t\t\t\t\t<td>'+datas[i].itemid+'</td>\n' +
                            '\t\t\t\t\t\t<td>'+datas[i].type+'</td>\n' +
                            '\t\t\t\t\t\t<td>'+datas[i].amount+'</td>\n' +
                            '\t\t\t\t\t\t<td>'+datas[i].itemdesc+'</td>\n' +
                            '\t\t\t\t\t</tr>');
                    }
                    }
                })
            }
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">查看具体报销项</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>具体报销项</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>报销项编号<i class="sort"><img src="images/px.gif" /></i></th>
						<th>报销项类型</th>
						<th>报销项金额</th>
						<th>报销项说明</th>
					</tr>
				</thead>
				<tbody id="itembody">
					<%--<tr>--%>
						<%--<td><input name="" type="checkbox" value="" /></td>--%>
						<%--<td>001</td>--%>
						<%--<td>通信费用</td>--%>
						<%--<td>200</td>--%>
						<%--<td>无</td>--%>
					<%--</tr>--%>

				</tbody>
			</table>
			<%-- 获取html带过来的数据<c:out value="${param.expid}"></c:out>--%>
		</div>
		<input name="" type="button" class="btn" value="返回" id="btnBack"/>
		<script type="text/javascript">
			$('#btnBack').click(function () {
				window.history.back()
            })
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
		
	</body>

</html>