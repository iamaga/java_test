<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<%--		<script>--%>
<%--			$(function () {--%>
<%--				selectDeptno();--%>
<%--				selectPosid();--%>
<%--				selectMgrid();--%>
<%--			})--%>
<%--			function selectDeptno() {--%>
<%--				$.ajax({--%>
<%--							type:"get",--%>
<%--							url:"deptController",--%>
<%--							data:"method=selectDeptno",--%>
<%--							dataType:"json",--%>
<%--							success:function (datas) {--%>
<%--								document.getElementById("deptno").innerHTML="";--%>
<%--								var a= ${employee.deptno}--%>

<%--								for (var i in datas){--%>


<%--									if (a==datas[i].deptno){--%>
<%--										console.log("相等了")--%>
<%--										window.document.getElementById("deptno").innerHTML += "<option selected value="+datas[i].deptno+">"+datas[i].deptname+"</option>"--%>

<%--									}else {--%>
<%--										window.document.getElementById("deptno").innerHTML += "<option value="+datas[i].deptno+">"+datas[i].deptname+"</option>"--%>
<%--									}--%>
<%--								}--%>
<%--								$("#deptno").val(datas[i].deptno);--%>
<%--							}--%>
<%--						}--%>
<%--				)--%>
<%--			}--%>

<%--			function selectPosid() {--%>
<%--				$.ajax({--%>
<%--							type:"get",--%>
<%--							url:"positionController",--%>
<%--							data:"method=selectPosid",--%>
<%--							dataType:"json",--%>
<%--							success:function (datas) {--%>
<%--								document.getElementById("posid").innerHTML="";--%>
<%--								var a= ${employee.posid}--%>
<%--								for (var i in datas){--%>
<%--									if (a==datas[i].posid){--%>
<%--										console.log("相等了22")--%>
<%--										document.getElementById("posid").innerHTML += "<option selected value="+datas[i].posid+">"+datas[i].pname+"</option>"--%>
<%--									}else {--%>
<%--										document.getElementById("posid").innerHTML += "<option value=" +datas[i].posid+">" + datas[i].pname + "</option>"--%>
<%--									}--%>
<%--								}--%>
<%--							}--%>
<%--						}--%>
<%--				)--%>
<%--			}--%>

<%--			function selectMgrid(){--%>
<%--				$.ajax({--%>
<%--							type:"get",--%>
<%--							url:"employeeController",--%>
<%--							data:"method=selectMgrid",--%>
<%--							dataType:"json",--%>
<%--							success:function (datas) {--%>
<%--								document.getElementById("mgrid").innerHTML="";--%>
<%--								var a= "${employee.mgrid}"--%>
<%--								for (var i in datas){--%>

<%--									if (a==datas[i].empid){--%>
<%--										console.log("相等了33")--%>
<%--										document.getElementById("mgrid").innerHTML += "<option selected value="+datas[i].empid+">"+datas[i].realname+"</option>"--%>

<%--									}else {--%>
<%--										document.getElementById("mgrid").innerHTML += "<option value="+datas[i].empid+">"+datas[i].realname+"</option>"--%>
<%--									}--%>


<%--								}--%>
<%--							}--%>
<%--						}--%>
<%--				)--%>
<%--			}--%>


<%--		</script>--%>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">人事管理</a></li>
				<li><a href="#">修改员工信息</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>

			<form action="employeeController?method=updateEmployee" method="post">
			<ul class="forminfo">
				<li>
					<label>用户名</label>
					<input name="empid" type="text" class="dfinput" value="${employee.empid}" /></li>
				<li>
				<li>
					<label>密码</label>
					<input name="password" type="text" class="dfinput" value="${employee.password}" /></li>
				<li>
					<li>
						<label>真实姓名</label>
						<input name="realname" type="text" class="dfinput" value="${employee.realname}"/><i></i></li>
					<li>
						<label>性别</label>
						<input name="sex" type="radio" value="1"  <c:if test="${employee.sex==1}">checked</c:if>/>男&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="sex" type="radio" value="0" <c:if test="${employee.sex==0}">checked</c:if>/>女

					</li>
					<li>
						<label>出生日期</label>
						<input name="birthdate" type="text" class="dfinput" onfocus="WdatePicker()" value='<fmt:formatDate value="${employee.birthdate}" pattern="yyyy-MM-dd"/>'/></li>
					<li>
					<li>
						<label>入职时间</label>
						<input name="hiredate" type="text" class="dfinput"onfocus="WdatePicker()" value='<fmt:formatDate value="${employee.hiredate}" pattern="yyyy-MM-dd"/>'/><i></i></li>
					
					<li>
						<label>离职时间</label>
						<input name="leavedate" type="text" class="dfinput"  onfocus="WdatePicker()" value='<fmt:formatDate value="${employee.leavedate}" pattern="yyyy-MM-dd"/>'/><i></i></li>
					<li>
						<label>是否在职</label>
						<input name="onduty" type="radio" value="1" <c:if test="${employee.onduty==1}">checked</c:if>/>是&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="onduty" type="radio" value="0" <c:if test="${employee.onduty==0}">checked</c:if>/>否
					</li>
					<li>
						<label>所属部门<b>*</b></label>
						<div class="vocation">
							<select class="select1" name="deptno"  id="deptno" >
								<c:forEach items="${depts}" var="dept">
									<option  value="${dept.deptno}" <c:if test="${dept.deptno==employee.deptno}">selected</c:if>>${dept.deptname}</option>
								</c:forEach>
							</select>
						</div>

					</li>
				<li>
					<label>员工岗位<b>*</b></label>
					<div class="vocation">
						<select class="select1" name="posid"  id="posid" >
							<c:forEach items="${positions}" var="pos">
								<option  value="${pos.posid}" <c:if test="${pos.posid==employee.posid}">selected</c:if>>${pos.pname}</option>
							</c:forEach>
						</select>
					</div>

				</li>

				<li>
					<label>员工类型<b>*</b></label>
					<input name="emptype" type="radio" value="1" <c:if test="${employee.emptype==1}">checked</c:if>/>基层人员
					<input name="emptype" type="radio" value="2" <c:if test="${employee.emptype==2}">checked</c:if>/>管理人员
					<input name="emptype" type="radio" value="3" <c:if test="${employee.emptype==3}">checked</c:if>/>网站维护
				</li>
					<li>
						<label>直接上级<b>*</b></label>						
						<div class="vocation">
							<select class="select1" name="mgrid" id="mgrid">

								<c:forEach items="${empmgr}" var="mgr">
									<option  value="${mgr.empid}" <c:if test="${mgr.empid==employee.mgrid}">selected</c:if>>${mgr.realname}</option>
								</c:forEach>
							</select>							
						</div>
					&nbsp;&nbsp;<input name="" type="text" class="dfinput"  placeholder="也可以在此输入首字母帮助显示"/></li>
					</li>
					<li>
						<label>联系方式</label>
						<input name="phone" type="text" class="dfinput"  value="${employee.phone}"/>
					</li>
					<li>
						<label>QQ号</label>
						<input name="qq" type="text" class="dfinput"value="${employee.qq}" />
					</li>
					<li>
						<label>紧急联系人信息</label>
						<textarea name="emercontactperson" cols="" rows="" class="textinput" id="ecp" >
							${employee.getEmercontactperson()}
						</textarea>

					</li>
					<li>
						<label>身份证号</label>
						<input name="idcard" type="text" class="dfinput" value="${employee.idcard}" />
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