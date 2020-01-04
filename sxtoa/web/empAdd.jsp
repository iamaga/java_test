<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function(e) {
		    $(".select1").uedSelect({
				width : 345			  
			});
			
		});
	</script>
	<script type="text/javascript">
		KE.show({id:"ecp",width:"800px",height:"300px"});
	</script>
		<script>
			$(function () {
				$.ajax({
					type:"get",
					url:"deptController",
					data:"method=findAllDeptJson",
					dataType:"json",
					success:function (datas) {
						for (var i in datas){
						    $("#dept").append('' +
								'<option value="'+datas[i].deptno+'">'+datas[i].deptname+'</option>'
							)
						}
                    }
				})	
            })
			$.ajax({
				type:"get",
				url:"positionController",
				data:"method=findAllPostojson",
				dataType:"json",
				success:function (datas) {
					for(var i in datas){
					    $("#position").append('<option value="'+datas[i].posid+'">'+datas[i].pname+'</option>')
					}
                }
			})
            $.ajax({
                type:"get",
                url:"employeeController",
                data:"method=findAllmgr",
                dataType:"json",
                success:function (datas) {
                    for(var i in datas){
                        $("#mgr").append('<option value="'+datas[i].empid+'">'+datas[i].realname+'</option>')
                    }
                }
            })
			
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">人事管理</a></li>
				<li><a href="#">添加员工</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>
		<form action="employeeController?method=addEmployee" method="post">
			<ul class="forminfo">
				<li>
					<label>用户名</label>
					<input name="empid" type="text" class="dfinput" /></li>
				<li>
				<li>
					<label>密码</label>
					<input name="password" type="text" class="dfinput" /></li>
				<li>
					<li>
						<label>真实姓名</label>
						<input name="realname" type="text" class="dfinput" /><i></i></li>
					<li>
						<label>性别</label><cite>
						<input name="sex" type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="sex" type="radio" value="0" />女<i>也可以根据身份证号自动获取</i></cite>
						
					</li>
					<li>
						<label>出生日期</label>
						<input name="birthdate" type="text" class="dfinput" onfocus="WdatePicker({skin:'whyGreen',lang:'en'})" /><i>也可以根据身份证号自动获取</i></li>
					<li>
					<li>
						<label>入职时间</label>
						<input name="hiredate" type="text" class="dfinput" onfocus="WdatePicker()"/><i></i></li>
					
					<li>
						<label>离职时间</label>
						<input name="leavedate" type="text" class="dfinput" onfocus="WdatePicker()"/><i></i></li>
					<li>
						<label>是否在职</label><cite>
						<input name="onduty" type="radio" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="onduty" type="radio" value="0" />否</cite>
					</li>
					<li>
						<label>员工类型</label><cite>
						<input name="emptype" type="radio" value="1" checked="checked" />基层员工&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="emptype" type="radio" value="2" />各级管理人员</cite>
					</li>
					<li>
						<label>所属部门<b>*</b></label>
						<div class="vocation">
							<select class="select1" id="dept" name="deptno">
								<option value="">请选择</option>
								<%--<option value="1">总裁办</option>--%>
								<%--<option value="2">教学部</option>--%>
								<%--<option value="3">咨询部</option>--%>
								<%--<option value="4">教务部</option>--%>
							</select>
						</div>

					</li>
					<li>
						<label>从事岗位<b>*</b></label>
						<div class="vocation" >
							<select class="select1"  id="position" name="posid" id="">
								<option value="">-请选择-</option>
								<%--<option value="2">教学经理</option>--%>
								<%--<option value="3">咨询经理</option>--%>
								<%--<option value="4">咨询师</option>--%>
								<%--<option value="5">讲师</option>--%>
							</select>
						</div>

					</li>
					<li>
						<label>直接上级<b>*</b></label>						
						<div class="vocation">
							<select class="select1" id="mgr" name="mgrid">
								<option value="">-请选择-</option>
								<%--<option value="liukl">刘凯立</option>--%>
							</select>							
						</div>
					&nbsp;&nbsp;<input name="" type="text" class="dfinput"  placeholder="也可以在此输入首字母帮助显示"/></li>
					</li>
					<li>
						<label>联系方式</label>
						<input name="phone" type="text" class="dfinput" />
					</li>
					<li>
						<label>QQ号</label>
						<input name="qq" type="text" class="dfinput" />
					</li>
					<li>
						<label>紧急联系人信息</label>
						<textarea name="emercontactperson" cols="" rows="" id="ecp" class="textinput"></textarea>
					</li>
					<li>
						<label>身份证号</label>
						<input name="idcard" type="text" class="dfinput" />
					</li>
					<li>
						<label>&nbsp;</label>
						<input name="" type="submit" class="btn" value="确认保存" />
					</li>
			</ul>
		</form>
		</div>

	</body>

</html>