<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>审核报销单</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.min.js">
		</script>
		<script type="text/javascript">
			function submitForm(){
                console.log($("#form").serialize())
				$.ajax({
					type:"get",
					url:"auditingController?method=addAudit",
					data:$("#form").serialize(),
					dataType:"json",
					success:function (datas) {
						if(datas>0){
						    alert("审核完成！")
						}
						window.close();
                    }
				})

			}
			
		</script>
	</head>

	<body>

		<div class="formtitle"><span>审核报销单</span></div>
		<form action="#"  id="form" name="form" onsubmit="return submitForm()">
			<ul class="forminfo">
				<li>

					编号:<input name="expid" type="text" value="${param.expid}" readonly />
				</li>
				<li>
					<label>审核结果</label>
					<input name="result" type="radio" value="2"/>通过
					<input name="result" type="radio" value="3"/>拒绝
					<input name="result" type="radio"value="4"/>打回
				</li>
				<li>
					<label>审核意见</label>
					<input name="auditdesc" type="text" class="dfinput" />
				</li>
				<li>
					<label>&nbsp;</label>
					<input name="" onclick="submitForm()" type="button" class="btn" value="确认保存" />
				</li>
			</ul>
		</form>
	</body>

</html>

