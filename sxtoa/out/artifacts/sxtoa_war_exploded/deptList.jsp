
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>


<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">部门管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
      
   <div class="formtitle1"><span>部门列表</span></div>
   
    <table class="tablelist" >
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>部门名称</th>
        <th>办公地点</th>
        <th>操作</th>
        </tr>
        </thead>
        
        <tbody>
     <c:forEach items="${depts}" var="dept">
        

        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>${dept.deptno}</td>
        <td>${dept.deptname}</td>
        <td>${dept.location}</td>
        <td>  <a href="javascript:void(0)" class="tablelink" onclick="update(${dept.deptno})">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;   <a href="javascript:void(0)" class="tablelink click" onclick="deleteConfim1(${dept.deptno})"> 删除</a></td>
        </tr>
     </c:forEach>
        </tbody>
    </table>
    
       
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" onclick="remove()" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消"  />
        </div>
    
    </div>

    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	    var dno;
	function deleteConfim1(deptno) {
        dno = deptno;
	    
    }
    function remove() {
        window.location.href="deptController?method=deleteDept&deptno="+dno;
    }
    function update(deptno) {

        window.location.href="deptController?method=findBydeptno&deptno="+deptno;
    }
	</script>

</body>

</html>
