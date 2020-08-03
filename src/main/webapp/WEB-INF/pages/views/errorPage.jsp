<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("returnURI", request.getRequestURI());
	response.setContentType("text/html; charset=UTF-8");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="${contextPath}/resources/js/lib/jquery-1.10.1.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/common.js"></script>
	<title>SMARTFLAT</title>
</head>
<body>
<script>
	var contextPath = '${contextPath}';
	jQuery(document).ready(function($) {
		var code     = '${errorResultEntity.code}';
		var redirect = '${errorResultEntity.redirect}';
		if      (code) alert(CommonUtils.brToN('${errorResultEntity.message}'));
		if      (redirect == 'back')  history.back();
		else if (redirect == 'login') location.href = contextPath + '${errorResultEntity.url}';
	});
</script>
</body>
</html>
