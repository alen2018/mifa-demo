<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryPayForm.jsp' starting page</title>
    <meta http-equive="content-type"content="text/html;charset=utf-8"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="/QueryOrderServlet" method="post">
    	<div class="form">
    		<div class="trow">
    			<label>商户订单号：</label>
    			<input type="text" name="mchOrderNo">
    		</div>
    		<div class="trow">
    			<label>平台订单号：</label>
    			<input type="text" name="payOrderId">
    		</div>
    		<div class="trow">
    			<input type="submit" value="提交"> 
    		</div>
    	</div>
    </form>
  </body>
</html>
