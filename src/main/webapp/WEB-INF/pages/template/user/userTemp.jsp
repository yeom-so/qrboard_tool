<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
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
<html lang="ko">
    <head>
        <script type="text/javascript">
            var contextPath = '${contextPath}';
            ${allMessages}
        </script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">

        <!-- full screen -->
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="mobile-web-app-capable" content="yes">

        <!-- clip icon -->
        <link rel="apple-touch-icon" href="${contextPath}/resources/img/clips/180x180.png" />
        <link rel="shortcut icon" href="${contextPath}/resources/img/clips/180x180.png" /><!-- android icon 72x72 -->

        <!-- scripts -->
        <script type="text/javascript" src="${contextPath}/resources/js/lib/jquery-1.10.1.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/lib/jquery.form.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/lib/jquery-ui.min.js"></script>

        <title>QR보드 관리툴</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="sidebar" data-color="blue">
                <tiles:insertAttribute name="left" />
            </div>
            <div id="panel" class="main-panel">
                <div class="navbar navbar-default navbar-fixed">
                    <tiles:insertAttribute name="header" />
                </div>
                <div class="content">
                    <tiles:insertAttribute name="body" />
                </div>
            </div>
        </div>
    </body>
</html>
