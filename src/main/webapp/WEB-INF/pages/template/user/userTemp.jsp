<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>QRBOARD</title>

        <!-- css -->
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/jquery-ui.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css"/>

        <!-- scripts -->
        <script type="text/javascript" src="${contextPath}/resources/js/lib/jquery-1.10.1.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/lib/jquery.form.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/lib/jquery-ui.min.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/commons.js"></script>

        <!-- import -->
        <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
        <script>
            var IMP = window.IMP; // 생략가능
            IMP.init('imp76171189'); // 부여받은 "가맹점 식별코드"를 사용
        </script>

        <script type="text/javascript">
            var contextPath = '${contextPath}';
        </script>
    </head>
    <body>
        <div id="wrap">
            <section id="ads" class="page temp">
                <tiles:insertAttribute name="top" />
                <tiles:insertAttribute name="body" />
            </section>
        </div>
    </body>
</html>
