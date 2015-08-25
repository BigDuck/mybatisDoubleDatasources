<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--
  ~ Copyright (c) 2015 / 8 / 11 10 :29 :57
  ~ BY:wupeiji
  ~ QQ:757671834
  ~
  --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>签到效果实现</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sign.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.layerModel.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/layerModel.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/layerModel.plugin.css"/>
<script type="text/javascript">
var ctx = "${pageContext.request.contextPath}";
/*签到模块日期捕捉：*/
function week(){
	var objDate= new Date();
	var week = objDate.getDay();
	switch(week)
		{
			case 0:
			week="周日";
			break;
			case 1:
			week="周一";
			break;
			case 2:
			week="周二";
			break;
			case 3:
			week="周三";
			break;
			case 4:
			week="周四";
			break;
			case 5:
			week="周五";
			break;
			case 6:
			week="周六";
			break;
		}
	$("#sing_for_number").html( week );
}
$(function(){
	week();
	var current = new Date();
	$(".singer_r_img").click(function(){
		$(this).addClass("current");
		calUtil.doSign("${pageContext.request.contextPath}/sign/doSign",current.getFullYear(),current.getMonth() + 1);
	});
});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.layerModel.plugin.js"></script>
</head>

<body>
		<a class="singer_r_img" href="###">		
			<span id="sing_for_number">签到</span>
		</a>
</body>
</html>
