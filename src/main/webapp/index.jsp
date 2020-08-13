<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/20
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="${pageContext.request.contextPath}/IndexServlet">
    行数:<input type="text" name="hangshu" >
    <input type="submit" value="提交"><br>
    10,9,9<br>
    40,16,16<br>
    99,16,30<br>
  </form>
  </body>
</html>
