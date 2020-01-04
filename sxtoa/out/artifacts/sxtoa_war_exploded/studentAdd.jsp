<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/19
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="fileuploadController" METHOD="post" enctype="multipart/form-data">
        姓名：<input type="text" name="stuname"><br/>
        年龄：<input type="text" name="stuage"><br/>
        性别：<input type="text" name="stugender"><br/>
        图片：<input type="file" name="file"><br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
