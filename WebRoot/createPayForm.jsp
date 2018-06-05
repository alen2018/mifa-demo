<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'startPayForm.jsp' starting page</title>
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
    <form action="/CreateOrderServlet" method="post">
    	<div class="form">
    		<div class="trow">
    			<label>商户号：</label>
    			<input type="text" name="mchId" value="${item.mchId}">
    		</div>
    		<div class="trow">
    			<label>	商户订单号：</label>
    			<input type="text" name="mchOrderNo" value="${item.mchOrderNo}">
    		</div>
    		<div class="trow">
    			<label>	渠道编号：</label>
    			<input type="text" name="channelCode" value="ALIPAY_WAP">
    		</div>
    		<div class="trow">
    			<label>	金额（单位分）：</label>
    			<input type="text" name="amount" value="1000">
    		</div>
    		<div class="trow">
    			<label>	币种：</label>
    			<input type="text" name="currency" value="CNY">
    		</div>
    		<div class="trow">
    			<label>	客户端IP：</label>
    			<input type="text" name="clientIp" value="${item.clientIp}">
    		</div>
    		<div class="trow">
    			<label>	设备：</label>
    			<input type="text" name="device" value="WEB">
    		</div>
    		<div class="trow">
    			<label>	额外参数：</label>
    			<input type="text" name="extra" value="">
    		</div>
    		<div class="trow">
    			<label>	回调URL：</label>
    			<input type="text" name="notifyUrl" value="${item.notifyUrl}">
    		</div>
    		<div class="trow">
    			<label>	商品主题：</label>
    			<input type="text" name="subject" value="测试支付">
    		</div>
    		<div class="trow">
    			<label>	商品描述：</label>
    			<input type="text" name="body" value="测试支付描述">
    		</div>
    		<div class="trow">
    			<input type="submit" value="提交"> 
    		</div>
    	</div>
    </form>
  </body>
</html>
