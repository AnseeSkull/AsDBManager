<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <form action="todb.do" method="post">
    	ip<input name="dbip" /><br><br>
    	库名<input name="dbname" /><br><br>
    	用户名<input name="username"/><br><br>
    	密码<input name="password"/><br><br>
    	<input type="submit" value="提交"/>
    </form>
    <c:forEach items="${tableName}" var="table">
    	<h6>${table}</h6>
    </c:forEach>
  </body>
</html>
